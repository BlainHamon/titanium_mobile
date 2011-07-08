//
//  KrollException.m
//  Titanium
//
//  Created by Blain Hamon on 7/1/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "KrollException.h"


NSError * KrollExceptionGetNSError(KrollException * exception)
{
	if(exception->errorObject != nil)
	{
		return exception->errorObject;
	}
	if(exception->errorValue != NULL)
	{
		//TODO: Convert to NSError
	}
	return nil;
}

TiValueRef KrollExceptionGetTiValue(KrollException * exception)
{
	if(exception->errorValue != NULL)
	{
		return exception->errorValue;
	}
	if(exception->errorObject != nil)
	{
		//TODO: Convert to TiValueRef
	}
	return NULL;
}
