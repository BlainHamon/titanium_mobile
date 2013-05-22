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
