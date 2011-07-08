/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import <Foundation/Foundation.h>
#import "TiDimension.h"
#import "KrollException.h"

typedef enum
{
	KrollArgumentNone,		//Value does not exist
	KrollArgumentPrimative,	//Int, float, char, etc.
	KrollArgumentTiValue,	//TiJSCore's TiValueRef
	KrollArgumentNSObject,	//iOS's NSObject
	
}
KrollArgumentType;

int					KrollArgumentsGetCount(void * args, KrollException * error);
KrollArgumentType	KrollArgumentsTypeAtIndex(void * args, int index);

bool		KrollArgumentsGetBoolAtIndex(void * args, int index, KrollException * error);
int			KrollArgumentsGetIntAtIndex(void * args, int index, KrollException * error);
float		KrollArgumentsGetFloatAtIndex(void * args, int index, KrollException * error);
double		KrollArgumentsGetDoubleAtIndex(void * args, int index, KrollException * error);

TiObjectRef KrollArgumentsGetTiObjectAtIndex(void *args, int index, KrollException * error);

//To put in TiDimension's header file
TiDimension KrollArgumentsGetDimensionAtIndex(void * args, int index, KrollException * error);
TiDimension TiValueToTiDimension(TiContextRef * jsContext, TiValueRef value);
//TiValueRef TiValue