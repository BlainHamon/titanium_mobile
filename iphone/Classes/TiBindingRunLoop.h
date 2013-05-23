/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#ifndef Titanium_TiBindingRunLoop_h
#define Titanium_TiBindingRunLoop_h

#if TARGET_OS_IPHONE
@class KrollContext;
typedef KrollContext * TiBindingRunLoop;

#else
typedef void * TiBindingRunLoop;
#endif

typedef void (*TiBindingCallback)(TiBindingRunLoop runLoop, void * payload);

/*	Convenience TiBindingCallbacks provided as they can be often used. The methods
 *	provided do clear up the payload (IE, free or release them as needed)
 */

#if TARGET_OS_IPHONE
//Payload should be a NSOperation object. It will release after running start.
void TiBindingCallbackStartOperationAndRelease(TiBindingRunLoop runloop, void * payload);

//Paylod should be an NSObject that implements an 'invoke:' method, taking the runloop
//as the argument. After invoking, the object will be released.
void TiBindingCallbackInvokeNSObjectAndRelease(TiBindingRunLoop runloop, void * payload);

//Payload should be a block that takes no arguments and returns no value. It will be
//released at the end of the call.
void TiBindingCallbackCallBlockAndRelease(TiBindingRunLoop runloop, void * payload);

typedef struct TiBindingCallbackSelectorStruct *TiBindingCallbackSelector;
TiBindingCallbackSelector TiBindingCallbackSelectorCreate(id object, SEL selector, id arg1, id arg2, id arg3, id arg4);
void TiBindingCallbackCallSelector(TiBindingRunLoop runloop, void * payload);

#endif



/*	TiBindingRunLoop's Enqueue will add a callback that will be run once
 *	during the run loop's idle. This is for things like events, callbacks,
 *	and other invocations from native into Javascript.
 */
void TiBindingRunLoopEnqueue(TiBindingRunLoop runLoop, TiBindingCallback callback, void * payload);

/*	TiBindingRunLoop's CallOnStart will add a callback that will be run
 *	every time a run loop is started, before the file is executed. Because
 *	the file the run loop uses is not parsed or run yet, there won't be a
 *	path, but this lets you enqeue methods to run immediately after the
 *	parsing, or set up changes to the runtime environment. The Titanium
 *	and other globals WILL be set during the callback's execution.
 *
 *	These callbacks are invoked before:
 *		app.js is started
 *		A background service is started
 *		A window with an url property is being opened
 */
void TiBindingRunLoopCallOnStart(TiBindingCallback callback, void * payload);

typedef struct TiCallbackPayloadStruct *TiCallbackPayloadNode;
#endif
