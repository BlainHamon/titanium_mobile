//
//  KrollException.h
//  Titanium
//
//  Created by Blain Hamon on 7/1/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//


#ifndef KrollException_h
#define KrollException_h

#if TARGET_OS_IPHONE

#import <Foundation/Foundation.h>
#include "Ti.h"

#else

#define NSError void
typedef void * TiValueRef;

#endif


enum {
	KrollExceptionThrown			= 1 << 0,
	KrollExceptionMissingArgument	= 1 << 1,
	KrollExceptionWrongType			= 1 << 2,
	KrollExceptionValueTooLow		= 1 << 3,
	KrollExceptionValueTooHigh		= 1 << 4,
	KrollExceptionValueOutOfRange	= KrollExceptionValueTooLow | KrollExceptionValueTooHigh,
};

typedef struct {
	UInt32	flags;
	NSError * errorObject;
	TiValueRef errorValue;
	void *	reserved2;

	void *	reserved3;
	void *	reserved4;
	void *	reserved5;
	void *	reserved6;
} KrollException;

/* KrollException is a general purpose wrapper for the various exceptions that
 * various APIs present. By having this wrapper, it's meant to reduce the cost
 * of handling thrown exceptions with try/catch, especially when some exceptions
 * are safely ignored. It's also meant to help reduce dependance on one specific
 * underlying API or another.
 *
 * KrollException is meant to be something that's tripped and reset. 
 */





extern const KrollException kKrollExceptionNoErrors;

inline BOOL KrollExceptionWasThrown(KrollException * exception)
		{return (exception->flags & KrollExceptionThrown) != 0;}

inline BOOL KrollExceptionHasMissingArgument(KrollException * exception)
		{return (exception->flags & KrollExceptionMissingArgument) != 0;}

inline BOOL KrollExceptionHasException(KrollException * exception, UInt32 exceptionFlag)
		{return (exception->flags & exceptionFlag) != 0;}

inline BOOL KrollExceptionHasNoErrors(KrollException * exception)
		{return (exception->flags==0);}


//These convert such that if a TiValue is contained an an NSError is requested, it is converted.
NSError * KrollExceptionGetNSError(KrollException * exception);
TiValueRef KrollExceptionGetTiValue(KrollException * exception);

inline void KrollExceptionSetNSError(KrollException * exception, NSError * error)
		{if((exception != NULL) && (error != NULL))
			{exception->errorObject = error; exception->flags |= KrollExceptionThrown;}}

inline void KrollExceptionSetTiValue(KrollException * exception, TiValueRef value)
		{if((exception != NULL) && (value != NULL))
			{exception->errorValue = value; exception->flags |= KrollExceptionThrown;}}

inline void KrollExceptionSetException(KrollException * exception, UInt32 exceptionFlag)
		{if(exception != NULL){exception->flags |= exceptionFlag;}}

#endif /* KrollException_h */

