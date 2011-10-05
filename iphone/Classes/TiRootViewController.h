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
 *	setup. However, iOS presents a variety of viewController presentation
 *	methods, especially since iOS 5. When looking at things like
 *	navigationController, there's even more. So we should have something
 *	similar that wrappers the various methods. Since we have the 'window'
 *	metaphor of opening, let's use that.
 *
 *	However, for precidence reasons, and because non-TiWindowControllers
 *	do not have a modal flag, we should follow the precident of tab and
 *	navigation controllers of having one pair of methods for nonmodal
 *	presentations, and another for modal presentations.
 */

-(void)openViewController: (UIViewController *)viewController animated:(BOOL)animated;
-(void)closeViewController: (UIViewController *)viewController animated:(BOOL)animated;

/*
 *	This would have been present modal/dismiss modal, but iOS 5 changed the
 *	naming. To be forward-looking, we're going to follow iOS5's pattern.
 */

- (void)presentViewController:(UIViewController *)viewControllerToPresent animated: (BOOL)flag completion:(void (^)(void))completion;
- (void)dismissViewControllerAnimated: (BOOL)flag completion: (void (^)(void))completion;

/*
 *	iOS 5 FINALLY allows us to trigger another round of checking for desired
 *	orientations. However, since we still need to support iOS 4.x, we still
 *	need to manually override the situation. So in iOS 5, this merely calls
 *	super, but iOS 4 has our magic blend. 
 */
+ (void)attemptRotationToDeviceOrientation;

/*
 *	A means to tweak the view of the root view controller. With iOS 5, this
 *	should be done in a way that supports the 
 */
@property(nonatomic,readwrite,retain)	UIColor * backgroundColor;
@property(nonatomic,readwrite,retain)	UIImage * backgroundImage;



#pragma mark Private API:

-(void)manuallyRotateToOrientation:(UIInterfaceOrientation)newOrientation duration:(NSTimeInterval)duration;

@property(nonatomic,readonly) BOOL keyboardVisible;
@property(nonatomic,readonly) UIImageView * defaultImageView;
-(void)dismissDefaultImageView;


#pragma To remove and replace

-(UIViewController *)focusedViewController;

-(void)windowFocused:(UIViewController*)focusedViewController;
-(void)windowClosed:(UIViewController *)closedViewController;

-(CGRect)resizeView;
-(void)repositionSubviews;

-(void)manuallyRotateToOrientation:(UIInterfaceOrientation)orientation;

-(void)setOrientationModes:(NSArray *)newOrientationModes;

- (void)openWindow:(TiWindowProxy *)window withObject:(id)args;
- (void)closeWindow:(TiWindowProxy *)window withObject:(id)args;

@end
