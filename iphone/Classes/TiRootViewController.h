/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import "TiRootController.h"
#import "TiWindowProxy.h"

/*
 *	Like TiApp, the internals of TiRootViewController will be moved out of the
 *	public API's view. So the start is NOT public API.
 */

@interface TiRootViewController : UIViewController<UIApplicationDelegate,TiRootController,TiOrientationController> {
@private
//Presentation: background image and color.
	UIColor * backgroundColor;
	UIImage * backgroundImage;

//View Controller stack:
	/*
	 *	Due to historical reasons, there are three arrays that track views/
	 *	windows/viewcontrollers that are 'opened' on the rootViewController.
	 *	For best results, this should be realigned with a traditional container-
	 *	style view controller, perhaps even something proxy-agnostic in the
	 *	future. TODO: Refactor viewController arrays.
	 */
	NSMutableArray *windowViewControllers;	
	NSMutableArray * viewControllerStack;
	NSMutableArray * windowProxies;

//While no windows are onscreen, present default.png
	UIImageView * defaultImageView;
	
//Orientation handling:
	TiOrientationFlags	allowedOrientations;
	UIInterfaceOrientation orientationHistory[4];

	UIInterfaceOrientation lastOrientation;
	UIInterfaceOrientation windowOrientation;

	BOOL isCurrentlyVisible;

//Keyboard handling -- This can probably be done in a better way.
}

#pragma mark Public API:

/*
 *	Public APIs are going to get an overhaul to more closely resemble an iOS
 *	
 */


#pragma mark Unsorted API:




@property(nonatomic,readonly) BOOL keyboardVisible;
@property(nonatomic,readonly) UIImageView * defaultImageView;
-(void)dismissDefaultImageView;

@property(nonatomic,readwrite,retain)	UIColor * backgroundColor;
@property(nonatomic,readwrite,retain)	UIImage * backgroundImage;

-(UIViewController *)focusedViewController;

-(void)windowFocused:(UIViewController*)focusedViewController;
-(void)windowClosed:(UIViewController *)closedViewController;

-(CGRect)resizeView;
-(void)repositionSubviews;

-(void)manuallyRotateToOrientation:(UIInterfaceOrientation)orientation;
-(void)manuallyRotateToOrientation:(UIInterfaceOrientation)newOrientation duration:(NSTimeInterval)duration;

-(void)setOrientationModes:(NSArray *)newOrientationModes;

- (void)openWindow:(TiWindowProxy *)window withObject:(id)args;
- (void)closeWindow:(TiWindowProxy *)window withObject:(id)args;

@end
