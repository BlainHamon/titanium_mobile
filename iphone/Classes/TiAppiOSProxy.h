/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */
#import "TiProxy.h"

#ifdef USE_TI_APPIOS

#if __IPHONE_OS_VERSION_MAX_ALLOWED >= __IPHONE_4_0

#import "TiAppiOSBackgroundServiceProxy.h"

@interface TiAppiOSProxy : TiProxy {
@private
}

@end

#endif
#endif
