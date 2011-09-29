/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#import "TiRootViewController.h"
#import "TiUtils.h"
#import "TiViewProxy.h"
#import "TiWindowProxy.h"
#import "TiTab.h"
#import "TiApp.h"
#import <MessageUI/MessageUI.h>

#import "KeyboardAccessoryManager.h"

@interface TiRootView : UIView
@end

@implementation TiRootView

- (void)motionEnded:(UIEventSubtype)motion withEvent:(UIEvent *)event
{
	if (event.type == UIEventTypeMotion && event.subtype == UIEventSubtypeMotionShake) 
	{
        [[NSNotificationCenter defaultCenter] postNotificationName:kTiGestureShakeNotification object:event];
    }
}

- (BOOL)canBecomeFirstResponder
{ 
	return YES; 
}

@end


@implementation TiRootViewController
@synthesize backgroundColor, backgroundImage, defaultImageView, keyboardVisible;

- (UIImage*)defaultImageForOrientation:(UIDeviceOrientation) orientation resultingOrientation:(UIDeviceOrientation *)imageOrientation idiom:(UIUserInterfaceIdiom*) imageIdiom
{	
	UIImage* image;
	
	if([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPad)
	{
		*imageOrientation = orientation;
		*imageIdiom = UIUserInterfaceIdiomPad;
		// Specific orientation check
		switch (orientation) {
			case UIDeviceOrientationPortrait:
				image = [UIImage imageNamed:@"Default-Portrait.png"];
				break;
			case UIDeviceOrientationPortraitUpsideDown:
				image = [UIImage imageNamed:@"Default-PortraitUpsideDown.png"];
				break;
			case UIDeviceOrientationLandscapeLeft:
				image = [UIImage imageNamed:@"Default-LandscapeLeft.png"];
				break;
			case UIDeviceOrientationLandscapeRight:
				image = [UIImage imageNamed:@"Default-LandscapeRight.png"];
				break;
			default:
				image = nil;
		}
		if (image != nil) {
			return image;
		}
		
		// Generic orientation check
		if (UIDeviceOrientationIsPortrait(orientation)) {
			image = [UIImage imageNamed:@"Default-Portrait.png"];
		}
		else if (UIDeviceOrientationIsLandscape(orientation)) {
			image = [UIImage imageNamed:@"Default-Landscape.png"];
		}
		
		if (image != nil) {
			return image;
		}
	}
	*imageOrientation = UIDeviceOrientationPortrait;
	*imageIdiom = UIUserInterfaceIdiomPhone;
	// Default 
	return [UIImage imageNamed:@"Default.png"];
}

-(void)dismissDefaultImageView
{
	if (defaultImageView == nil)
	{
		return;
	}
	[defaultImageView removeFromSuperview];
	RELEASE_TO_NIL(defaultImageView);
}

-(void)rotateDefaultImageViewToOrientation: (UIInterfaceOrientation )newOrientation;
{
	if (defaultImageView == nil)
	{
		return;
	}
	UIDeviceOrientation imageOrientation;
	UIUserInterfaceIdiom imageIdiom;
	UIUserInterfaceIdiom deviceIdiom = [[UIDevice currentDevice] userInterfaceIdiom];
/*
 *	This code could stand for some refinement, but it is rarely called during
 *	an application's lifetime and is meant to recreate the quirks and edge cases
 *	that iOS uses during application startup, including Apple's own
 *	inconsistencies between iPad and iPhone.
 */
	
	UIImage * defaultImage = [self defaultImageForOrientation:
			(UIDeviceOrientation)newOrientation
			resultingOrientation:&imageOrientation idiom:&imageIdiom];

	CGFloat imageScale = [defaultImage scale];
	CGRect newFrame = [[self view] bounds];
	CGSize imageSize = [defaultImage size];
	UIViewContentMode contentMode = UIViewContentModeScaleToFill;
	
	if (imageOrientation == UIDeviceOrientationPortrait) {
		if (newOrientation == UIInterfaceOrientationLandscapeLeft) {
			UIImageOrientation imageOrientation;
			if (deviceIdiom == UIUserInterfaceIdiomPad)
			{
				imageOrientation = UIImageOrientationLeft;
			}
			else
			{
				imageOrientation = UIImageOrientationRight;
			}
			defaultImage = [
							UIImage imageWithCGImage:[defaultImage CGImage] scale:imageScale orientation:imageOrientation];
			imageSize = CGSizeMake(imageSize.height, imageSize.width);
			if (imageScale > 1.5) {
				contentMode = UIViewContentModeCenter;
			}
		}
		else if(newOrientation == UIInterfaceOrientationLandscapeRight)
		{
			defaultImage = [UIImage imageWithCGImage:[defaultImage CGImage] scale:imageScale orientation:UIImageOrientationLeft];
			imageSize = CGSizeMake(imageSize.height, imageSize.width);
			if (imageScale > 1.5) {
				contentMode = UIViewContentModeCenter;
			}
		}
		else if((newOrientation == UIInterfaceOrientationPortraitUpsideDown) && (deviceIdiom == UIUserInterfaceIdiomPhone))
		{
			defaultImage = [UIImage imageWithCGImage:[defaultImage CGImage] scale:imageScale orientation:UIImageOrientationDown];			
			if (imageScale > 1.5) {
				contentMode = UIViewContentModeCenter;
			}
		}
	}
		
	if(imageSize.width == newFrame.size.width)
	{
		CGFloat overheight;
		overheight = imageSize.height - newFrame.size.height;
		if (overheight > 0.0) {
			newFrame.origin.y -= overheight;
			newFrame.size.height += overheight;
		}
	}
	[defaultImageView setContentMode:contentMode];
	[defaultImageView setImage:defaultImage];
	[defaultImageView setFrame:newFrame];
}



-(void)dealloc
{
	RELEASE_TO_NIL(backgroundColor);
	RELEASE_TO_NIL(backgroundImage);

	RELEASE_TO_NIL(windowProxies);

	RELEASE_TO_NIL(windowViewControllers);
	RELEASE_TO_NIL(viewControllerStack);

	WARN_IF_BACKGROUND_THREAD;	//NSNotificationCenter is not threadsafe!
	NSNotificationCenter * nc = [NSNotificationCenter defaultCenter];
	[nc removeObserver:self];
	[super dealloc];
}

- (id) init
{
	self = [super init];
	if (self != nil)
	{
//View controller and orientation initialization
		windowProxies = [[NSMutableArray alloc] init];
		viewControllerStack = [[NSMutableArray alloc] init];
		// Set up the initial orientation modes
		[self setOrientationModes:nil];
		orientationHistory[0] = UIInterfaceOrientationPortrait;
		orientationHistory[1] = UIInterfaceOrientationLandscapeLeft;

/*
 *	Default image view -- Since this goes away after startup, it's made here and
 *	nowhere else. We don't do this during loadView because it's possible that
 *	the view will be unloaded (by, perhaps a Memory warning while a modal view
 *	controller and loaded at a later time.
 */
		defaultImageView = [[UIImageView alloc] init];
		[defaultImageView setAutoresizingMask:UIViewAutoresizingFlexibleHeight
				 | UIViewAutoresizingFlexibleWidth];
		[defaultImageView setContentMode:UIViewContentModeScaleToFill];
		
//Notifications
		WARN_IF_BACKGROUND_THREAD;	//NSNotificationCenter is not threadsafe!
		[[UIDevice currentDevice] beginGeneratingDeviceOrientationNotifications];
		NSNotificationCenter * nc = [NSNotificationCenter defaultCenter];
		[nc addObserver:self selector:@selector(didOrientNotify:) name:UIDeviceOrientationDidChangeNotification object:nil];
	}
	return self;
}

-(void)setBackgroundColor:(UIColor *)newColor
{
	if ((newColor == backgroundColor) || [backgroundColor isEqual:newColor])
	{
		return;
	}
	
	[backgroundColor release];
	backgroundColor = [newColor retain];
	
	[self performSelectorOnMainThread:@selector(updateBackground) withObject:nil
						waitUntilDone:NO modes:[NSArray arrayWithObject:NSRunLoopCommonModes]];
	//The runloopcommonmodes ensures that it'll happen even during tracking.
}

-(void)setBackgroundImage:(UIImage *)newImage
{
	if ((newImage == backgroundImage) || [backgroundImage isEqual:newImage])
	{
		return;
	}
	
	[backgroundImage release];
	backgroundImage = [newImage retain];
	
	[self performSelectorOnMainThread:@selector(updateBackground) withObject:nil
						waitUntilDone:NO modes:[NSArray arrayWithObject:NSRunLoopCommonModes]];
	//The runloopcommonmodes ensures that it'll happen even during tracking.
}

-(void)updateBackground
{
	UIView * ourView = [self view];
	UIColor * chosenColor = (backgroundColor==nil)?[UIColor blackColor]:backgroundColor;
	[ourView setBackgroundColor:chosenColor];
	[[ourView superview] setBackgroundColor:chosenColor];
	if (backgroundImage!=nil)
	{
		[[ourView layer] setContents:(id)backgroundImage.CGImage];
	}
	else
	{
		[[ourView layer] setContents:nil];
	}
}

-(void)loadView
{
	TiRootView *rootView = [[TiRootView alloc] initWithFrame:[[UIScreen mainScreen] applicationFrame]];
	self.view = rootView;
	[self updateBackground];
	if (defaultImageView != nil) {
		[self rotateDefaultImageViewToOrientation:UIInterfaceOrientationPortrait];
		[rootView addSubview:defaultImageView];
	}
	[rootView release];
}

-(void)updateOrientationIfNeeded
{
	UIInterfaceOrientation newOrientation = (UIInterfaceOrientation)
			[[UIDevice currentDevice] orientation];

	if (newOrientation == windowOrientation)
	{
		return;
	}
	//By now, we should check to see if we actually should rotate into position
	
	if (![self shouldAutorotateToInterfaceOrientation:newOrientation]) {
		return;
	}
	
	[self manuallyRotate];
	//If so, we force a rotation.
}

-(void)didOrientNotify:(NSNotification *)notification
{
	/*
	 *	The new behavior is that we give iOS a chance to do it right instead.
	 *	Then, during the callback, see if we need to manually override.
	 */
	UIInterfaceOrientation newOrientation =
			(UIInterfaceOrientation)[[UIDevice currentDevice] orientation];
	
	if (!UIDeviceOrientationIsValidInterfaceOrientation(newOrientation)) {
		return;
	}

	/*
	 *	And now, to push the orientation onto the history stack. This could be
	 *	expressed as a for loop, but the loop is so small that it might as well
	 *	be unrolled. The end result of this push is that only other orientations
	 *	are copied back, ensuring the newOrientation will be unique when it's
	 *	placed at the top of the stack.
	 */
	if (orientationHistory[2] != newOrientation) {
		orientationHistory[3] = orientationHistory[2];
	}
	if (orientationHistory[1] != newOrientation) {
		orientationHistory[2] = orientationHistory[1];
	}
	if (orientationHistory[0] != newOrientation) {
		orientationHistory[1] = orientationHistory[0];
	}
	orientationHistory[0] = newOrientation;
	
	[self performSelector:@selector(updateOrientationIfNeeded) withObject:nil afterDelay:0.0];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation 
{
	return TI_ORIENTATION_ALLOWED(allowedOrientations,interfaceOrientation) ? YES : NO;
}

- (void)willAnimateRotationToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration
{
	[super willAnimateRotationToInterfaceOrientation:toInterfaceOrientation duration:duration];

	for (TiWindowProxy * thisProxy in windowProxies)
	{
        if ([thisProxy allowsOrientation:toInterfaceOrientation]) {
            UIViewController * thisNavCon = [thisProxy navController];
            if (thisNavCon == nil)
            {
                thisNavCon = [thisProxy controller];
            }
            [thisNavCon willAnimateRotationToInterfaceOrientation:toInterfaceOrientation duration:duration];
        }
        else {
            [thisProxy ignoringRotationToOrientation:toInterfaceOrientation];
        }
	}
	[self rotateDefaultImageViewToOrientation:toInterfaceOrientation];
}

- (void)willRotateToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration;
{
	windowOrientation = toInterfaceOrientation;
	[super willRotateToInterfaceOrientation:toInterfaceOrientation duration:duration];
}

- (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation;
{
	[super didRotateFromInterfaceOrientation:fromInterfaceOrientation];
}




-(CGRect)resizeView
{
//	CGRect rect = [[UIScreen mainScreen] applicationFrame];
//	VerboseLog(@"(%f,%f),(%fx%f)",rect.origin.x,rect.origin.y,rect.size.width,rect.size.height);
//	[[self view] setFrame:rect];
	//Because of the transition in landscape orientation, TiUtils can't be used here... SetFrame compensates for it.
	return [[self view] bounds];
}

- (void)viewWillAppear:(BOOL)animated;    // Called when the view is about to made visible. Default does nothing
{
	[[viewControllerStack lastObject] viewWillAppear:animated];
}
- (void)viewWillDisappear:(BOOL)animated; // Called when the view is dismissed, covered or otherwise hidden. Default does nothing
{
	[[viewControllerStack lastObject] viewWillDisappear:animated];
}

- (void) viewDidAppear:(BOOL)animated
{
   	isCurrentlyVisible = YES;
	[self.view becomeFirstResponder];
	if (![self shouldAutorotateToInterfaceOrientation:[[UIApplication sharedApplication] statusBarOrientation]]) {
		CGFloat duration = 0.0;
		if (animated) {
			duration = [[UIApplication sharedApplication] statusBarOrientationAnimationDuration];
		}
		[self manuallyRotate];
	}
	[super viewDidAppear:animated];
	[[viewControllerStack lastObject] viewDidAppear:animated];
}

- (void) viewDidDisappear:(BOOL)animated
{
	isCurrentlyVisible = NO;
	[self.view resignFirstResponder];
    [super viewDidDisappear:animated];
	[[viewControllerStack lastObject] viewDidDisappear:animated];
}

-(void)repositionSubviews
{
	for (TiWindowProxy * thisProxy in windowProxies)
	{
		[thisProxy reposition];
	}
	//Keyboard handling injection.	
}

-(void)manuallyRotateToOrientation:(UIInterfaceOrientation)newOrientation duration:(NSTimeInterval)duration
{
	UIApplication * ourApp = [UIApplication sharedApplication];
	UIInterfaceOrientation oldOrientation = [ourApp statusBarOrientation];
	CGAffineTransform transform;

	switch (newOrientation)
	{
		case UIInterfaceOrientationPortraitUpsideDown:
			transform = CGAffineTransformMakeRotation(M_PI);
			break;
		case UIInterfaceOrientationLandscapeLeft:
			transform = CGAffineTransformMakeRotation(-M_PI_2);
			break;
		case UIInterfaceOrientationLandscapeRight:
			transform = CGAffineTransformMakeRotation(M_PI_2);
			break;
		default:
			transform = CGAffineTransformIdentity;
			break;
	}

	[self willRotateToInterfaceOrientation:newOrientation duration:duration];
	
    // Have to batch all of the animations together, so that it doesn't look funky
    if (duration > 0.0)
	{
		[UIView beginAnimations:@"orientation" context:nil];
		[UIView setAnimationDuration:duration];
	}
    
    
    if (newOrientation != oldOrientation && isCurrentlyVisible)
    {
		[[[TiApp app] accessoryManager] statusBarWillManuallyRotate];
        [ourApp setStatusBarOrientation:newOrientation animated:(duration > 0.0)];
		[[[TiApp app] accessoryManager] statusBarDidManuallyRotate];
    }

	UIView * ourView = [self view];
	CGRect viewFrame = [[UIScreen mainScreen] applicationFrame];
	[ourView setCenter:CGPointMake(viewFrame.origin.x + viewFrame.size.width/2.0, viewFrame.origin.y + viewFrame.size.height/2.0)];
	if (UIInterfaceOrientationIsLandscape(newOrientation)) {
		viewFrame.size = CGSizeMake(viewFrame.size.height, viewFrame.size.width);
	}
    [ourView setTransform:transform];
	viewFrame.origin=CGPointZero;
	[ourView setBounds:viewFrame];
	[self resizeView];

	[self willAnimateRotationToInterfaceOrientation:newOrientation duration:duration];

    //Propigate this to everyone else. This has to be done INSIDE the animation.
    [self repositionSubviews];
    
	lastOrientation = newOrientation;

	
	if (duration > 0.0)
	{
		[UIView commitAnimations];
	}
	
	[self didRotateFromInterfaceOrientation:oldOrientation];
}

-(void)manuallyRotateToOrientation:(UIInterfaceOrientation) newOrientation
{
	NSTimeInterval animation = ([self focusedViewController]==nil)?0.0:[[UIApplication sharedApplication] statusBarOrientationAnimationDuration];
	[self manuallyRotateToOrientation:newOrientation duration:animation];
}

-(void)manuallyRotate
{
	for (int i = 0; i<4; i++) {
		if ([self shouldAutorotateToInterfaceOrientation:orientationHistory[i]]) {
			[self manuallyRotateToOrientation:orientationHistory[i]];
			return;
		}
	}
}


-(TiOrientationFlags)getDefaultOrientations
{
	// Read the orientation values from the plist - if they exist.
	NSArray* orientations = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"UISupportedInterfaceOrientations"];
	TiOrientationFlags defaultFlags = TiOrientationPortrait;
	
	if ([TiUtils isIPad])
	{
		defaultFlags = TiOrientationAny;
		NSArray * ipadOrientations = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"UISupportedInterfaceOrientations~ipad"];
		if ([ipadOrientations respondsToSelector:@selector(count)] && ([ipadOrientations count] > 0))
		{
			orientations = ipadOrientations;
		}
	}

	if ([orientations respondsToSelector:@selector(count)] && ([orientations count] > 0))
	{
		defaultFlags = TiOrientationNone;
		for (NSString* orientationString in orientations)
		{
			UIInterfaceOrientation orientation = [TiUtils orientationValue:orientationString def:-1];
			if (orientation != -1) {
				TI_ORIENTATION_SET(defaultFlags, orientation);
			}
		}
	}
	
	return defaultFlags;
}

-(TiOrientationFlags)allowedOrientations
{
    return allowedOrientations;
}

-(void)setOrientationModes:(NSArray *)newOrientationModes
{
	allowedOrientations = TiOrientationNone;

	for (id mode in newOrientationModes)
	{
		UIInterfaceOrientation orientation = [TiUtils orientationValue:mode def:-1];
		switch (orientation)
		{
			case UIDeviceOrientationPortrait:
			case UIDeviceOrientationPortraitUpsideDown:
			case UIDeviceOrientationLandscapeLeft:
			case UIDeviceOrientationLandscapeRight:
				TI_ORIENTATION_SET(allowedOrientations,orientation);
				break;
			case -1:
				break;
			default:
				NSLog(@"[WARN] An invalid orientation was requested. Ignoring.");
				break;
		}
	}
	
	if (allowedOrientations == TiOrientationNone)
	{
		allowedOrientations = [self getDefaultOrientations];
	}
}



/*
Okay, Blain's sit and think about this. This is only concerning the top level of things.
That is, this is only a stack of open windows, and does not concern beyond that.
What this does mean is that any 

*/

- (void)willHideViewController:(UIViewController *)focusedViewController animated:(BOOL)animated
{
	if (!isCurrentlyVisible || (focusedViewController != [viewControllerStack lastObject]))
	{
		return;
	}
	
	[focusedViewController viewWillDisappear:animated];
	
	int previousIndex = [viewControllerStack count] - 2;	
	if (previousIndex > 0)
	{
		[[viewControllerStack objectAtIndex:previousIndex] viewWillAppear:animated];
	}
}

- (void)didHideViewController:(UIViewController *)focusedViewController animated:(BOOL)animated
{
	if (!isCurrentlyVisible || (focusedViewController != [viewControllerStack lastObject]))
	{
		if([viewControllerStack containsObject:focusedViewController]){
			[viewControllerStack removeObject:focusedViewController];
		}
		return;
	}
	
	[focusedViewController viewDidDisappear:animated];
	[viewControllerStack removeLastObject];
	
	[[viewControllerStack lastObject] viewDidAppear:animated];
}

- (void)willShowViewController:(UIViewController *)focusedViewController animated:(BOOL)animated
{
	if (!isCurrentlyVisible || [viewControllerStack containsObject:focusedViewController])
	{
		return;
	}
	
	[[viewControllerStack lastObject] viewWillDisappear:animated];
	[focusedViewController viewWillAppear:animated];
}

- (void)didShowViewController:(UIViewController *)focusedViewController animated:(BOOL)animated
{
	if (!isCurrentlyVisible || [viewControllerStack containsObject:focusedViewController])
	{
		return;
	}
	
	[[viewControllerStack lastObject] viewDidDisappear:animated];
	[viewControllerStack addObject:focusedViewController];
	[focusedViewController viewDidAppear:animated];
}

-(void)windowFocused:(UIViewController*)focusedViewController
{
	[self dismissDefaultImageView];
	if ([focusedViewController isKindOfClass:[UINavigationController class]] && ![focusedViewController isKindOfClass:[MFMailComposeViewController class]])
	{
		UIViewController * topViewController = [(UINavigationController *)focusedViewController topViewController];
		if (topViewController != nil)
		{
			focusedViewController = topViewController;
		}
	}

	TiWindowProxy * focusedProxy = nil;

	if ([focusedViewController respondsToSelector:@selector(proxy)])
	{
		focusedProxy = (TiWindowProxy *)[(id)focusedViewController proxy];
	}
	
	UIViewController * oldTopWindow = [windowViewControllers lastObject];
	[windowViewControllers removeObject:focusedViewController];
	if ((focusedViewController==nil) || [(TiWindowProxy *)focusedProxy _isChildOfTab] || ([(TiWindowProxy *)focusedProxy parent]!=nil))
	{
		return;
	}
	
	if (windowViewControllers==nil)
	{
		windowViewControllers = [[NSMutableArray alloc] initWithObjects:focusedViewController,nil];
	}
	else
	{
		[windowViewControllers addObject:focusedViewController];
	}
	
	if ((oldTopWindow != focusedViewController) && [oldTopWindow respondsToSelector:@selector(proxy)])
	{
		[(TiWindowProxy *)[(id)oldTopWindow proxy] _tabBlur];
	}
}

-(void)windowClosed:(UIViewController *)closedViewController
{
	if ([closedViewController isKindOfClass:[UINavigationController class]] && ![closedViewController isKindOfClass:[MFMailComposeViewController class]])
	{
		UIViewController * topViewController = [(UINavigationController *)closedViewController topViewController];
		if (topViewController != nil)
		{
			closedViewController = topViewController;
		}
	}

	BOOL focusChanged = [windowViewControllers lastObject] == closedViewController;
	[[closedViewController retain] autorelease];
	[windowViewControllers removeObject:closedViewController];
	if (!focusChanged)
	{
		closedViewController=nil;
		return; //Exit early. We're done here.
	}
	
	UIViewController * newTopWindow = [windowViewControllers lastObject];
	
	if ([newTopWindow respondsToSelector:@selector(proxy)])
	{
		[(TiWindowProxy *)[(id)newTopWindow proxy] _tabFocus];
	}
	
}

-(UIViewController *)focusedViewController
{
	return [windowViewControllers lastObject];
}

-(BOOL)isTopWindow:(TiWindowProxy *)window
{
    return [[windowProxies lastObject] isEqual:window];
}

#pragma mark Remote Control Notifications

#if __IPHONE_OS_VERSION_MAX_ALLOWED >= __IPHONE_4_0
- (void)remoteControlReceivedWithEvent:(UIEvent *)event 
{ 
	[[NSNotificationCenter defaultCenter] postNotificationName:kTiRemoteControlNotification object:self userInfo:[NSDictionary dictionaryWithObject:event forKey:@"event"]];
}
#endif

#pragma mark TiOrientationFlags management.
- (void)openWindow:(TiWindowProxy *)window withObject:(id)args
{
	if ([windowProxies lastObject] == window)
	{
		return;
	}

	if ([windowProxies containsObject:window])
	{
		[[window retain] autorelease];
		[windowProxies removeObject:window];
	}

	[window setParentOrientationController:self];
	[windowProxies addObject:window];
	[window parentWillShow];
	//Todo: Move all the root-attaching logic here.

	[self childOrientationControllerChangedFlags:window];
}

- (void)closeWindow:(TiWindowProxy *)window withObject:(id)args
{
	if (![windowProxies containsObject:window])
	{
		return;
	}
	
	BOOL wasTopWindow = [windowProxies lastObject] == window;

	//Todo: Move all the root-detaching logic here.

	[window setParentOrientationController:nil];
	[window parentWillHide];
	[windowProxies removeObject:window];

	if(wasTopWindow)
	{
		[self childOrientationControllerChangedFlags:[windowProxies lastObject]];
	}
}

-(void)childOrientationControllerChangedFlags:(id<TiOrientationController>) orientationController;
{
	WARN_IF_BACKGROUND_THREAD_OBJ;
	//Because a modal window might not introduce new 

	TiOrientationFlags newFlags = [self orientationFlags];
	if (newFlags == allowedOrientations)
	{
		//No change. Nothing to update. Skip.
		return;
	}

	allowedOrientations = newFlags;
	if ([self shouldAutorotateToInterfaceOrientation:[[UIApplication sharedApplication] statusBarOrientation]])
	{
		//We're still good. No need to rotate. Skip.
		return;
	}

	//Force a rotate to accomodate.
	[self manuallyRotate];
}

-(void)setParentOrientationController:(id <TiOrientationController>)newParent
{
	//Blank method since we never have a parent.
}

-(id)parentOrientationController
{
	//Blank method since we never have a parent.
	return nil;
}

-(TiOrientationFlags) orientationFlags
{
	for (TiWindowProxy * thisWindow in [windowProxies reverseObjectEnumerator])
	{
		TiOrientationFlags result = [thisWindow orientationFlags];
		if (result != TiOrientationNone)
		{
			return result;
		}
	}
	
	return [self getDefaultOrientations];
}

-(void)didKeyboardFocusOnProxy:(TiViewProxy<TiKeyboardFocusableView> *)visibleProxy;
{
	[[[TiApp app] accessoryManager] didKeyboardFocusOnProxy:visibleProxy];
}
-(void)didKeyboardBlurOnProxy:(TiViewProxy<TiKeyboardFocusableView> *)blurredProxy;
{
	[[[TiApp app] accessoryManager] didKeyboardBlurOnProxy:blurredProxy];
}

@end
