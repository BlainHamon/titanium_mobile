/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import <Foundation/Foundation.h>

#ifndef Ti_h
typedef const struct OpaqueTiValue* TiValueRef;
typedef const struct OpaqueTiContext* TiContextRef;
#endif

//Sadly, we DO have to include TiCore, just for TiContextRef and TiValueRef.

/*	KrollFunctionArguments should never be retained, but only used in passing.
 *	This is because the internal jsContext and value refs are fleeting, and
 *	are only garunteed to be valid pointers during the duration of the function
 *	call.
 *
 *	If you want to artifically call a JS-facing method (namely, ones with the
 *	kroll_, krollSetter_, or krollGetter_ prefixes), the initialization methods
 *	are exposed for you. HOWEVER, the KrollFunctionArguments object MUST be
 *	disposed of after your method call.
 *
 *	KrollFunctionArguments and its methods are meant to be immutable (read-only)
 *	and may be a copy in some cases (IE, when converting a valueRef to id and
 *	vice versa.
 */
@class KrollContext;

@interface KrollFunctionArguments : NSObject
{
	TiValueRef * valueRefs;
	TiContextRef jsContext;
	int count;
}

-(id)initWithValueRefs:(TiValueRef[])argumentValueRefs count:(int)argumentCount jsContext:(TiContextRef)argumentContext;

@property(nonatomic,readonly) TiContextRef jsContext;
@property(nonatomic,readonly) int count;

//Accessors that have some staying power
-(int) intAtIndex:(int)index;
-(float) floatAtIndex:(int)index;
-(bool) boolAtIndex:(int)index;

//Low level accessors
-(TiValueRef) valueRefAtIndex:(int)index;
-(id) objectAtIndex:(int)index;


@end
