/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#ifndef Titanium_TiBindingRunLoopInternal_h
#define Titanium_TiBindingRunLoopInternal_h

struct TiCallbackPayloadStruct{
	TiBindingCallback callback;
	void * payload;
	TiCallbackPayloadNode next;
};

TiCallbackPayloadNode TiCallbackPayloadCreate(TiBindingCallback callback, void * payload);

/*
 *	Append List: Threadsafe appending. Not designed for removing elements.
 */
void TiCallbackPayloadAppendList(TiCallbackPayloadNode * queue, TiCallbackPayloadNode newPair);

/*
 *	Producer/consumer, designed for single consumer, multiple producers. In order
 *	to avoid race conditions with memory, only the tail is consumed.
 */


void TiCallbackPayloadProduceHead(TiCallbackPayloadNode * queue, TiCallbackPayloadNode newPair);
TiCallbackPayloadNode TiCallbackPayloadConsumeTail(TiCallbackPayloadNode * queue);


#endif
