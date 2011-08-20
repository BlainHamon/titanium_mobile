/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import "TiViewProxy.h"


//TODO: rename tab controller

@protocol TiController

@optional
-(id)initWithViewProxy:(TiViewProxy*)proxy;

@required
-(TiViewProxy*)proxy;

@end
