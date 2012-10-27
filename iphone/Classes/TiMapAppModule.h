/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */
#import "TiModule.h"

#if !defined(__IPHONE_6_0) || __IPHONE_OS_VERSION_MAX_ALLOWED < __IPHONE_6_0
#fatal This module requires building against iOS SDK 6.0 or higher.
#endif

@interface TiMapAppModule : TiModule {
	BOOL isValid;
}

@end
