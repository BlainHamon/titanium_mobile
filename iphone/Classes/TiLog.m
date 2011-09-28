/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import "TiLog.h"

char * TiLogStringForSeverity(TiLogSeverity severity)
{
	switch (severity) {
		case kTiLogSeverityAppDebug:
			return "DEBUG";			
		default:
			return "UNKNOWN";
	}
}

void TiLogCString(TiLogSeverity severity, char * message)
{
	
}

#if TARGET_OS_IPHONE
void TiLogNSString(TiLogSeverity severity, NSString * message)
{
	
	
}
#endif
