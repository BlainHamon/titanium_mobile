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

/*
 *	When 5.0 is public, the internals of TiApp are going to be private, so
 *	technically, the interface portion is not public API.
 */
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

#pragma mark Public API
/*
 *	Singleton accessors. App is public. Controller is public. Accessory IS NOT.
 *	Keyboard accessory access is done through controller, but in the future,
 *	AccessoryManager may be replaced by something native.
 */
+(TiApp*)app;
+(TiRootViewController*)controller;

/*
 *	These were previously named startNetwork and stopNetwork, but was misleading
 *	as they do not actually start or stop a network. Instead, this increments
 *	and decrements a counter that controls the little spinning indicator in the
 *	status bar.
 */
-(void)didStartNetworkConnection;
-(void)didStopNetworkConnection;


-(NSDictionary*)launchOptions;
-(NSString*)remoteDeviceUUID;
-(NSString*)userAgent;
-(NSString*)sessionId;

//Only for networkModule, really.
@property (nonatomic, assign) id remoteNotificationDelegate;
@property (nonatomic, readonly) NSDictionary* remoteNotification;


#pragma mark Private API:

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) TiRootViewController* controller;
@property (nonatomic, readonly) KeyboardAccessoryManager * accessoryManager;



#pragma To factor out:
//	Things that should be moved out of TiApp:

/*
 *	ContextGroup should be a singleton within the domain of KrollContext.
 */
@property (nonatomic, readonly) TiContextGroupRef contextGroup;

/*
 *	XHR Bridge should be moved out of TiApp. It's already a singleton of its
 *	own. Given that it is tied only to TiUIWebView, perhaps in the future it
 *	will be a module of its own.
 */
-(void)attachXHRBridgeIfRequired;

/*
 *	The root view controller should have domain over all viewController actions
 */
-(void)showModalError:(NSString*)message;
-(void)showModalController:(UIViewController*)controller animated:(BOOL)animated;
-(void)hideModalController:(UIViewController*)controller animated:(BOOL)animated;

/*
 *	Not sure if these are ever used.
 */
-(KrollBridge*)krollBridge;
-(UILocalNotification*)localNotification;

/*
 *	May be refactored into another class due to notifications posted for the
 *	necessary triggers.
 */
-(void)registerBackgroundService:(TiProxy*)proxy;
-(void)unregisterBackgroundService:(TiProxy*)proxy;
-(void)stopBackgroundService:(TiProxy*)proxy;
-(void)beginBackgrounding;
-(void)endBackgrounding;

@end

#pragma More Private API

extern BOOL applicationInMemoryPanic;

TI_INLINE void waitForMemoryPanicCleared()   //WARNING: This must never be run on main thread, or else there is a risk of deadlock!
{
    while (applicationInMemoryPanic) {
        [NSThread sleepForTimeInterval:0.01];
    }
}





