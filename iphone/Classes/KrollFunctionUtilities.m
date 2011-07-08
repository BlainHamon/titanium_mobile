/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#include "KrollFunctionUtilities.h"
#include "KrollFunctionArguments.h"

int					KrollArgumentsGetCount(void * args, KrollException * error)
{
	id object = (id)args;
	if([object respondsToSelector:@selector(count)]){
		return [object count];
	}
	return 0;
}

KrollArgumentType	KrollArgumentsTypeAtIndex(void * args, int index)
{
	id object = (id)args;
	int count = KrollArgumentsGetCount(args, NULL);
	if(index>=count)
	{
		return KrollArgumentNone;
	}
	
	if([object isKindOfClass:[NSArray class]])
	{
		return KrollArgumentNSObject;
	}
	
	if([object isKindOfClass:[KrollFunctionArguments class]])
	{
		return KrollArgumentTiValue;
	}
}

bool		KrollArgumentsGetBoolAtIndex(void * args, int index, KrollException * error)
{
	switch(KrollArgumentsTypeAtIndex(args, index)){
			
			
			
			
	}
	
}

int			KrollArgumentsGetIntAtIndex(void * args, int index, KrollException * error);
float		KrollArgumentsGetFloatAtIndex(void * args, int index, KrollException * error);
double		KrollArgumentsGetDoubleAtIndex(void * args, int index, KrollException * error);

TiObjectRef KrollArgumentsGetTiObjectAtIndex(void *args, int index, KrollException * error);

//To put in TiDimension's header file
TiDimension KrollArgumentsGetDimensionAtIndex(void * args, int index, KrollException * error);
TiDimension TiValueToTiDimension(TiContextRef * jsContext, TiValueRef value);
