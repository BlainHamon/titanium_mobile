//
//  KrollException.h
//  Titanium
//
//  Created by Blain Hamon on 7/1/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Ti.h"

typedef struct {
	NSError * errorObject;
	TiValueRef errorValue;
	BOOL missingArgument;
} KrollException;

extern const KrollException kKrollExceptionNoErrors;

inline BOOL KrollExceptionWasThrown(KrollException * exception) { return (exception->errorValue != NULL) || (exception->errorObject != nil); }
inline BOOL KrollExceptionMissingArgument(KrollException * exception) {return exception->missingArgument;}

inline BOOL KrollExceptionHasNoErrors(KrollException * exception) {return !KrollExceptionMissingArgument(exception) && !KrollExceptionWasThrown(exception);}

//These convert such that if a TiValue is contained an an NSError is requested, it is converted.
NSError * KrollExceptionGetNSError(KrollException * exception);
TiValueRef KrollExceptionGetTiValue(KrollException * exception);
