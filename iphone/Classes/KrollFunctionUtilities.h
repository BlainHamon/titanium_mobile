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

//	KrollArgumentUtilities the first: Accessing the count and type. These are
//	innoculous enough, and should be fully cross-platform.
int					KrollArgumentsGetCount(void * args, KrollException * error);
KrollArgumentType	KrollArgumentsTypeAtIndex(void * args, int index);


//	KrollArgumentUtilities the second: Platform (and interpreter)-specific
//	accessors. As such, these should be the gritty underbelly of utility code
//	and not for common usage by the app developer. Instead, the app developer
//	should use the utility functions placed below.

//	Other methods should be placed here, depending on OS, interpreter, etc.

TiValueRef KrollArgumentsGetTiValueAtIndex(void *args, int index, KrollException * error);
TiValueRef KrollArgumentsGetTiValueInPropertyAtIndex(void *args, const char * propertyName, int index, KrollException * error);
TiContextRef KrollArugmentsGetTiContext(void *args);

//	KrollArgumentUtilities the third: Convenience and wrapper methods meant to
//	hide the aforementioned gritty underbelly. They do appear to be very
//	redundant, especially compared to KrollArgumentsGetTiObjectAtIndex, but
//	(1) hide the OS-specific object contained herein, and (2) are meant to be
//	possibly wrappered (Eg, in C++ used in function overloading, or in a macro
//	that will return a default)

//	The first convenience set effectively is the same as obtaining
//	KrollArgumentsGet(TiValue/whatever)AtIndex followed by converting the object
//	manually.

bool		KrollArgumentsGetBoolAtIndex(void * args, int index, KrollException * error);
int			KrollArgumentsGetIntAtIndex(void * args, int index, KrollException * error);
float		KrollArgumentsGetFloatAtIndex(void * args, int index, KrollException * error);
double		KrollArgumentsGetDoubleAtIndex(void * args, int index, KrollException * error);

bool		KrollArgumentsGetBoolInPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);
int			KrollArgumentsGetIntInPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);
float		KrollArgumentsGetFloatInPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);
double		KrollArgumentsGetDoubleInPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);




//To put in TiDimension's header file
TiDimension KrollArgumentsGetDimensionAtIndex(void * args, int index, KrollException * error);
TiDimension KrollArgumentsGetDimensionInPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);

TiDimension TiValueToTiDimension(TiContextRef * jsContext, TiValueRef value);
TiValueRef TiValueMakeTiDimension(TiContextRef * jsContext, TiDimension value);



#define DEFINE_PUBLIC_FUNCTION(functName)	\
	-(void *) krollFunction_##functName : (id) args;

#define DEFINE_PUBLIC_SETTER(functName)	\
	-(void *) krollSetter_##functName : (id) args;

#define DEFINE_PUBLIC_GETTER(functName)	\
	-(void *) krollGetter_##functName : (id) args;

#define ARGUMENT_COUNT	KrollArgumentsGetCount(args,NULL)
#define ARGUMENT_INT_AT_INDEX(index)	KrollArgumentsGetIntAtIndex(args,index,NULL);
