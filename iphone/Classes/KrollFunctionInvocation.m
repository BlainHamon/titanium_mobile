/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */
#import "Ti.h"

#import "KrollFunctionInvocation.h"
#import "KrollObject.h"
#import "KrollContext.h"

@implementation KrollFunctionInvocation

-(id)initWithValueRefs:(TiValueRef[])argumentValueRefs count:(int)argumentCount jsContext:(TiContextRef)argumentContext
{
    self = [super init];
    if (self) {
		valueRefs = argumentValueRefs;
		count = argumentCount;
		jsContext = argumentContext;
    }
    return self;
}

@synthesize count;
@synthesize jsContext;

-(double)doubleAtIndex:(int)index defaultValue: (double)defaultValue exception:(TiValueRef*) exception;
{
	if (index >= count) {
		if (exception != NULL) {
			//TODO: Make indexing exception
		}
		return defaultValue;
	}
	
	TiValueRef tempException = NULL;
	if (exception == NULL) {
		exception = &tempException;
	}

	TiValueRef argument = valueRefs[index];
	double result = TiValueToNumber(jsContext,argument,exception);
	if (*exception != NULL) {
		return defaultValue;
	}
	return result;
}

//Accessors that have some staying power
-(int) intAtIndex:(int)index
{
	return (int)[self doubleAtIndex:index defaultValue:-1 exception:NULL];
}

-(float) floatAtIndex:(int)index
{
	return (float)[self doubleAtIndex:index defaultValue:NAN exception:NULL];
}

-(bool) boolAtIndex:(int)index
{
	if (index >= count) {
		return FALSE;
	}
	TiValueRef argument = valueRefs[index];
	return TiValueToBoolean(jsContext,argument);
}

//Low level accessors
-(TiValueRef) valueRefAtIndex:(int)index
{
	if (index >= count) {
		return NULL;
	}
	return valueRefs[index];
}

//OS-specific
-(NSString *) stringAtIndex:(int)index
{
	if (index >= count) {
		return nil;
	}
	TiValueRef exception = NULL;
	TiStringRef resultString = TiValueToStringCopy(jsContext, valueRefs[index], &exception);
	if (exception != NULL) {
		return nil;
	}
	NSString * result = (NSString*)TiStringCopyCFString(kCFAllocatorDefault, resultString);
	TiStringRelease(resultString);
	return [result autorelease];
}

-(id) objectAtIndex:(int)index
{
	if (index >= count) {
		return nil;
	}
	TiValueRef argument = valueRefs[index];
	switch (TiValueGetType(jsContext,argument)) {
		case kTITypeNull:
			return [NSNull null];
		case kTITypeBoolean:
			return [NSNumber numberWithBool:
					[self boolAtIndex:index]];
		case kTITypeNumber:
			return [NSNumber numberWithDouble:
					[self doubleAtIndex:index defaultValue:NAN exception:NULL]];
		case kTITypeString:
			return [self stringAtIndex:index];
		case kTITypeObject:
			//TODO
		case kTITypeUndefined:
		default:
			return nil;
	}
	return nil;
}



@end
