/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#include "KrollException.h"

#pragma mark KrollArguments definition
typedef enum
{
	KrollArgumentNone,		//Value does not exist
	KrollArgumentPrimative,	//Int, float, char, etc.
	KrollArgumentTiValue,	//TiJSCore's TiValueRef
	KrollArgumentNSObject,	//iOS's NSObject
	
}
KrollArgumentType;

/*
 *	Accessing the count and type. These are innoculous enough, and
 *	should be fully cross-platform. Note that while the first pointer is called
 *	args, the actual variable passed in will probably hold the complete function
 *	invocation, including state, identity, context, etc. So while args is
 *	technically a misnomer, it is accurate and sufficient within the context
 *	that arguements are being fetched from the invocation.
 */
int					KrollArgumentsGetCount(void * args, KrollException * error);
KrollArgumentType	KrollArgumentsTypeAtIndex(void * args, int index);


#pragma mark KrollArguments low-level platform-specific accessors
/*
 *	As the title suggests, the methods availible in this section are platform-
 *	and interpreter-specific accessors. As such, these should be the gritty
 *	underbelly of utility code and not for common usage by the app developer.
 *	Instead, the app developer should use the utility functions mentioned in
 *	other sections.
 *
 *	Other methods should be placed here, depending on OS, interpreter, etc.
 */
#if TARGET_OS_IPHONE
TiValueRef KrollArgumentsGetTiValueAtIndex(void *args, int index, KrollException * error);
TiValueRef KrollArgumentsGetTiValueInPropertyAtIndex(void *args, const char * propertyName, int index, KrollException * error);
TiContextRef KrollArugmentsGetTiContext(void *args);
#endif

#pragma mark KrollArguments convenience and wrapper methods for primative types
/*
 *	KrollArgumentUtilities the third: Convenience and wrapper methods meant to
 *	hide the aforementioned gritty underbelly. They do appear to be very
 *	redundant, especially compared to KrollArgumentsGetTiObjectAtIndex, but
 *	(1) hide the OS-specific object contained herein, and (2) are meant to be
 *	possibly wrappered (Eg, in C++ used in function overloading, or in a macro
 *	that will return a default)
 *
 *	The first convenience set effectively is the same as obtaining
 *	KrollArgumentsGet(TiValue/whatever)AtIndex followed by converting the object
 *	manually.
 */

bool		KrollArgumentsGetBoolAtIndex(void * args, int index, KrollException * error);
int			KrollArgumentsGetIntAtIndex(void * args, int index, KrollException * error);
float		KrollArgumentsGetFloatAtIndex(void * args, int index, KrollException * error);
double		KrollArgumentsGetDoubleAtIndex(void * args, int index, KrollException * error);

bool		KrollArgumentsGetBoolInPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);
int			KrollArgumentsGetIntInPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);
float		KrollArgumentsGetFloatInPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);
double		KrollArgumentsGetDoubleInPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);

#pragma mark Extending KrollArguments by adding new data types
/*
 *	For each custom data type, there should be four methods: two that convert
 *	between the data type and the interpreter's format, and two that are
 *	convenience methods. For example, TiDimension would provide:
 */
#import "TiDimension.h"

TiDimension TiValueToTiDimension(TiContextRef * jsContext, TiValueRef value);
TiValueRef TiValueMakeTiDimension(TiContextRef * jsContext, TiDimension value);

TiDimension KrollArgumentsGetTiDimensionAtIndex(void * args, int index, KrollException * error);
TiDimension KrollArgumentsGetTiDimensionInPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);

/*
 *	Fortunately, there's macros that declares these methods for you. It is the
 *	data type's developer's responsibility to implement these.
 */
 
#define KROLL_ARGUMENTS_DATATYPE_FUNCTIONS(typeName, typeFormat)	\
typeFormat TiValueTo##typeName(TiContextRef * jsContext, TiValueRef value);	\
TiValueRef TiValueMake##typeName(TiContextRef * jsContext, typeFormat value);	\
	\
typeFormat KrollArgumentsGet##typeName##AtIndex(void * args, int index, KrollException * error);	\
typeFormat KrollArgumentsGet##typeName##InPropertyAtIndex(void * args, const char * propertyName, int index, KrollException * error);

#define KROLL_ARGUMENTS_STRUCT_FUNCTIONS(typeName)	KROLL_ARGUMENTS_DATATYPE_FUNCTIONS(typeName,typeName)
#define KROLL_ARGUMENTS_CLASS_FUNCTIONS(typeName)	KROLL_ARGUMENTS_DATATYPE_FUNCTIONS(typeName,typeName *)

//	In which case, KROLL_ARGUMENTS_STRUCT_FUNCTIONS(TiDimension) would
//	suffice in the header.


#pragma mark Convenience macros for accessing KrollArguments


#define KROLL_PUBLIC_FUNCTION(functName)	\
	-(void *) krollFunction_##functName : (id) args;

#define KROLL_PUBLIC_SETTER(functName)	\
	-(void *) krollSetter_##functName : (id) args;

#define KROLL_PUBLIC_GETTER(functName)	\
	-(void *) krollGetter_##functName : (id) args;

#define ARGUMENT_COUNT	KrollArgumentsGetCount(args,NULL)
#define ARGUMENT_INT_AT_INDEX(index)	KrollArgumentsGetIntAtIndex(args,index,NULL);
