/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import <Foundation/Foundation.h>

/*
 *	Debugging levels of severity.
 *	The reason for so many levels is finer granularity of reporting in
 *	Titanium Studio; to filter out messages that are of no importance
 *	to them, or to give stronger importance to rarer messages.
 */


typedef enum {
	kTiLogSeverityApp = 0,
/*
 *	The first section of severity is known as App severity, and the intent
 *	and content of logs with these severity is defined by the app developer.
 *	These are the severities that are accessed by methods on the API module
 *	in Javascript.
 */
	kTiLogSeverityAppDebug,
	kTiLogSeverityAppInfo,
	kTiLogSeverityAppWarn,
	kTiLogSeverityAppError,
	kTiLogSeverityAppTrace,


	kTiLogSeverityModule = 16,
/*
 *	The next section of severity is known as Module severity, with the
 *	intent and contents of logs with these severity is defined by the
 *	module maker. Each severity serves to either notify the app developer
 *	(for, say, warning of an error on their part) that they need to fix
 *	some code, or internal to the module where the app developer need not
 *	know and has no control over.
 */

	kTiLogSeverityModuleInfo,
	kTiLogSeverityModuleWarn,
	kTiLogSeverityModuleDeprecated,
	kTiLogSeverityModuleCaughtError,
	kTiLogSeverityModuleInternalDebug,
	kTiLogSeverityModuleInternalInconsistency,

	kTiLogSeverityTitanium = 32,
/*
 *	The last section of severity, like Module severity, is twofold,
 *	but this time comes from within the Titanium engine itself.
 */

} TiLogSeverity;

char * TiLogStringForSeverity(TiLogSeverity severity);
void TiLogCString(TiLogSeverity severity, char * message);

#if TARGET_OS_IPHONE
void TiLogNSString(TiLogSeverity severity, NSString * message);
#endif


