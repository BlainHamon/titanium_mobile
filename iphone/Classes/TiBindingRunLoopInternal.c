/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#include "TiBindingRunLoop.h"
#include "TiBindingRunLoopInternal.h"
#include <stdlib.h>
#include <libkern/OSAtomic.h>

TiCallbackPayloadNode TiCallbackPayloadCreate(TiBindingCallback callback, void * payload)
{
	TiCallbackPayloadNode newPair = malloc(sizeof(struct TiCallbackPayloadStruct));
	newPair->callback = callback;
	newPair->payload = payload;
	newPair->next = NULL;
	return newPair;
}

void TiCallbackPayloadAppendList(TiCallbackPayloadNode * queue, TiCallbackPayloadNode newPair)
{
	while (!OSAtomicCompareAndSwapPtrBarrier(NULL,newPair,(volatile void*)queue))
	{
		queue = &((*queue)->next);
	}
}

void TiCallbackPayloadProduceHead(TiCallbackPayloadNode * queue, TiCallbackPayloadNode newPair)
{
	do {
		newPair->next = *queue;
	} while (!OSAtomicCompareAndSwapPtrBarrier(newPair->next, newPair, (volatile void*)queue));
}

TiCallbackPayloadNode TiCallbackPayloadConsumeTail(TiCallbackPayloadNode * queue)
{
	if (*queue==NULL) {
		return NULL;
	}
	TiCallbackPayloadNode result = *queue;
	TiCallbackPayloadNode next = result->next;
	if (next == NULL) { //The only volitile element is the head
		if (OSAtomicCompareAndSwapPtrBarrier(result, NULL, (volatile void*)queue)) {
			return result;
		}
		//If we're here, that means another entry was produced.
		//Therefore, we should return to the head of the queue
		//So that the first result will always have
		result = *queue;
	}
	//Because we have only one consumer, and at this point, the
	//head cannot be the tail, we can safely trim. But since it's
	//possible that our last queue look was outdated, we need to
	//start over.
	do {
		queue = &(result->next);
		result = *queue;
	} while (result->next != NULL);
	*queue = NULL;
	return result;
}
