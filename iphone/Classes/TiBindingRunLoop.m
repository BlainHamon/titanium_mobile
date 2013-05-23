/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import "TiBindingRunLoop.h"
#import "TiBindingRunLoopInternal.h"
#import "KrollContext.h"

void TiBindingCallbackStartOperationAndRelease(TiBindingRunLoop runloop, void * payload)
{
	[(NSOperation *)payload start];
	[(id)payload release];
}

void TiBindingCallbackInvokeNSObjectAndRelease(TiBindingRunLoop runloop, void * payload)
{
	[(id)payload invoke:runloop];
	[(id)payload release];
}

void TiBindingCallbackCallBlockAndRelease(TiBindingRunLoop runloop, void * payload)
{
	((void (^)(void))payload)();
	[(void (^)(void))payload release];
}

struct TiBindingCallbackSelectorStruct
{
	id object;
	SEL selector;
	id arg1;
	id arg2;
	id arg3;
	id arg4;
};

TiBindingCallbackSelector TiBindingCallbackSelectorCreate(id object, SEL selector, id arg1, id arg2, id arg3, id arg4)
{
	TiBindingCallbackSelector result = malloc(sizeof(struct TiBindingCallbackSelectorStruct));
	result->object = [object retain];
	result->selector = selector;
	result->arg1 = [arg1 retain];
	result->arg2 = [arg2 retain];
	result->arg3 = [arg3 retain];
	result->arg4 = [arg4 retain];
	
	return result;
}

void TiBindingCallbackCallSelector(TiBindingRunLoop runloop, void * payload)
{
	TiBindingCallbackSelector payloadSelector = (TiBindingCallbackSelector)payload;
	
	IMP ourFunction = [payloadSelector->object methodForSelector:payloadSelector->selector];
	ourFunction(payloadSelector->object,
				payloadSelector->selector,
				payloadSelector->arg1,
				payloadSelector->arg2,
				payloadSelector->arg3,
				payloadSelector->arg4);
	
	[payloadSelector->object release];
	[payloadSelector->arg1 release];
	[payloadSelector->arg2 release];
	[payloadSelector->arg3 release];
	[payloadSelector->arg4 release];
	
	free(payloadSelector);
}


@interface KrollContext(TiBindingRunLoop)
-(TiCallbackPayloadNode *) callbackQueue;
@property (readonly) NSCondition *condition;
@end

@implementation KrollContext(TiBindingRunLoop)
-(TiCallbackPayloadNode *) callbackQueue
{
	return &eventQueue;
}

-(NSCondition *)condition
{
	return condition;
}
@end

void TiBindingRunLoopEnqueue(TiBindingRunLoop runLoop, TiBindingCallback callback, void * payload)
{
	TiCallbackPayloadNode newNode = TiCallbackPayloadCreate(callback, payload);
	if ([runLoop isKJSThread]) {
		//If we're on our thread, by definition we're not waiting.
		TiCallbackPayloadProduceHead([runLoop callbackQueue], newNode);
		return;
	}

	NSCondition * condition = [runLoop condition];
	
	[condition lock];
	TiCallbackPayloadProduceHead([runLoop callbackQueue], newNode);
	[condition signal];
	[condition unlock];

}

void TiBindingRunLoopEnqueueBlock(TiBindingRunLoop runLoop, void (^payload)(void))
{
	TiBindingRunLoopEnqueue(runLoop, TiBindingCallbackCallBlockAndRelease, [payload copy]);
}

TiCallbackPayloadNode RunLoopCallOnStartQueue = NULL;

void TiBindingRunLoopCallOnStart(TiBindingCallback callback, void * payload)
{
	TiCallbackPayloadAppendList(&RunLoopCallOnStartQueue, TiCallbackPayloadCreate(callback, payload));
}

void TiBindingRunLoopAnnounceStart(TiBindingRunLoop runLoop)
{
	TiCallbackPayloadNode queue = RunLoopCallOnStartQueue;
	while (queue != NULL) {
		(queue->callback)(runLoop,(queue->payload));
		queue = queue->next;
	}
}
