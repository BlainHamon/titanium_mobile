/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import <UIKit/UIKit.h>
#import <TiCore/TiContextRef.h>

//TODO: Maybe make the app delegate just use a TiHost instead of subclassing?
#import "TiHost.h"
#ifdef USE_TI_UIWEBVIEW
#import "XHRBridge.h"
#endif

@class KrollBridge;
@class TiRootViewController;
@class KeyboardAccessoryManager;

#pragma mark Public API


#pragma mark Unsorted API

@interface TiApp : TiHost <UIApplicationDelegate> 
{
// Internal Singletons
	UIWindow *window;
	TiRootViewController *controller;
	KeyboardAccessoryManager * accessoryManager;

// Internal Javascript structures
	TiContextGroupRef contextGroup;
	KrollBridge *kjsBridge;
    
#ifdef USE_TI_UIWEBVIEW
	XHRBridge *xhrBridge;
#endif

// Should be moved to RootViewController
	BOOL handledModal;
	
	
	NSMutableDictionary *launchOptions;
	NSTimeInterval started;
	
	int networkActivityCount; //We now can use atomic increment/decrement instead. This value is 0 upon initialization anyways.
	
	NSString *userAgent;
	NSString *remoteDeviceUUID;
	
	id remoteNotificationDelegate;
	NSDictionary* remoteNotification;
	
	NSString *sessionId;
	
	UIBackgroundTaskIdentifier bgTask;
	NSMutableArray *backgroundServices;
	NSMutableArray *runningServices;
	UILocalNotification *localNotification;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, assign) id remoteNotificationDelegate;
@property (nonatomic, readonly) NSDictionary* remoteNotification;
@property (nonatomic, retain) TiRootViewController* controller;
@property (nonatomic, readonly) KeyboardAccessoryManager * accessoryManager;
@property (nonatomic, readonly) TiContextGroupRef contextGroup;


+(TiApp*)app;
//Convenience method
+(TiRootViewController*)controller;

-(void)attachXHRBridgeIfRequired;

-(NSDictionary*)launchOptions;
-(NSString*)remoteDeviceUUID;

-(void)startNetwork;
-(void)stopNetwork;

-(void)showModalError:(NSString*)message;

-(void)showModalController:(UIViewController*)controller animated:(BOOL)animated;
-(void)hideModalController:(UIViewController*)controller animated:(BOOL)animated;


-(NSString*)userAgent;
-(NSString*)sessionId;

-(KrollBridge*)krollBridge;

-(void)beginBackgrounding;
-(void)endBackgrounding;
-(void)registerBackgroundService:(TiProxy*)proxy;
-(void)unregisterBackgroundService:(TiProxy*)proxy;
-(void)stopBackgroundService:(TiProxy*)proxy;
-(UILocalNotification*)localNotification;

@end

extern BOOL applicationInMemoryPanic;

TI_INLINE void waitForMemoryPanicCleared()   //WARNING: This must never be run on main thread, or else there is a risk of deadlock!
{
    while (applicationInMemoryPanic) {
        [NSThread sleepForTimeInterval:0.01];
    }
}





