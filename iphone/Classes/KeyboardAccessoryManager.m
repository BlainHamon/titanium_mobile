//
//  KeyboardAccessoryManager.m
//  Titanium
//
//  Created by Blain Hamon on 8/19/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "KeyboardAccessoryManager.h"


@implementation KeyboardAccessoryManager

-(id)init
{
	if([super init] != nil)
	{
		NSNotificationCenter * nc = [NSNotificationCenter defaultCenter];
		[nc addObserver:self selector:@selector(keyboardDidHide:) name:UIKeyboardDidHideNotification object:nil];
		[nc addObserver:self selector:@selector(keyboardDidShow:) name:UIKeyboardDidShowNotification object:nil];
		[nc addObserver:self selector:@selector(keyboardWillHide:) name:UIKeyboardWillHideNotification object:nil];
		[nc addObserver:self selector:@selector(keyboardWillShow:) name:UIKeyboardWillShowNotification object:nil];
		leaveCurve = UIViewAnimationCurveEaseIn;
		enterCurve = UIViewAnimationCurveEaseIn;
		leaveDuration = 0.3;
		enterDuration = 0.3;
	}
	return self;
}

-(void)repositionAccessory
{
	if(keyboardVisible || updatingAccessoryView)
	{
		return;
	}
	//Set endFrame's origin and width to what you'd imagine the keyboard placed.
	CGRect ourBounds = [[self viewForKeyboardAccessory] bounds];
	endFrame.origin.x = ourBounds.origin.x;
	endFrame.origin.y = ourBounds.origin.y + ourBounds.size.height;
	endFrame.size.width = ourBounds.size.width;
	
	updatingAccessoryView = YES;
	[self performSelector:@selector(handleNewKeyboardStatus) withObject:nil afterDelay:0.0];
}

-(UIView *)viewForKeyboardAccessory
{
	return [[appWindow subviews] lastObject];
}

-(void)extractKeyboardInfo:(NSDictionary *)userInfo
{
	CGRect endingFrame = [[userInfo valueForKey:UIKeyboardFrameEndUserInfoKey]
						  CGRectValue];

	CGRect startingFrame = [[userInfo valueForKey:UIKeyboardFrameBeginUserInfoKey]
							CGRectValue];
	UIView * ourView = [self viewForKeyboardAccessory];

	startFrame = [ourView convertRect:startingFrame fromView:nil];
	endFrame = [ourView convertRect:endingFrame fromView:nil];
}

-(void) placeView:(UIView *)targetView nearTopOfRect:(CGRect)targetRect aboveTop:(BOOL)aboveTop
{
	CGRect viewFrame;
	viewFrame.size = [targetView frame].size;
	viewFrame.origin.x = targetRect.origin.x;
	if(aboveTop)
	{
		viewFrame.origin.y = targetRect.origin.y - viewFrame.size.height;
	}
	else
	{
		viewFrame.origin.y = targetRect.origin.y;
	}
	[targetView setFrame:viewFrame];
}

-(void) handleNewKeyboardStatus
{
	updatingAccessoryView = NO;

	//Sanity check. Look at our focused proxy, and see if we mismarked it as leaving.
	TiUIView * scrolledView;	//We check at the update anyways.

	UIView * focusedToolbar = [self keyboardAccessoryViewForProxy:keyboardFocusedProxy withView:&scrolledView];
	CGRect focusedToolbarBounds = CGRectMake(0, 0, endFrame.size.width, [keyboardFocusedProxy keyboardAccessoryHeight]);
	[focusedToolbar setBounds:focusedToolbarBounds];

	if(scrolledView != nil)	//If this isn't IN the toolbar, then we update the scrollviews to compensate.
	{
		CGFloat keyboardHeight = endFrame.origin.y;
		if(focusedToolbar != nil){
			keyboardHeight -= focusedToolbarBounds.size.height;
		}
		UIView * possibleScrollView = [scrolledView superview];
		NSMutableArray * confirmedScrollViews = nil;
		
		while (possibleScrollView != nil)
		{
			if ([possibleScrollView conformsToProtocol:@protocol(TiUIScrollView)])
			{
				if(confirmedScrollViews == nil)
				{
					confirmedScrollViews = [NSMutableArray arrayWithObject:possibleScrollView];
				}
				else
				{
					[confirmedScrollViews insertObject:possibleScrollView atIndex:0];
				}
			}
			possibleScrollView = [possibleScrollView superview];
		}

		[(UIView<TiUIScrollView> *)[confirmedScrollViews objectAtIndex:0] keyboardDidShowAtHeight:keyboardHeight];
		for (UIView<TiUIScrollView> * confirmedScrollView in confirmedScrollViews)
		{
			[confirmedScrollView scrollToShowView:scrolledView withKeyboardHeight:keyboardHeight];
		}
	}

	//This is if the keyboard is hiding or showing due to hardware.
	if ((accessoryView != nil) && !CGRectEqualToRect(targetedFrame, endFrame))
	{
		targetedFrame = endFrame;
		[UIView beginAnimations:@"update" context:accessoryView];
		if (keyboardVisible)
		{
			[UIView setAnimationDuration:enterDuration];
			[UIView setAnimationCurve:enterCurve];		
		}
		else
		{
			[UIView setAnimationDuration:leaveDuration];
			[UIView setAnimationCurve:leaveCurve];		
		}

		[UIView setAnimationDelegate:self];
		[self placeView:accessoryView nearTopOfRect:endFrame aboveTop:YES];
		[UIView commitAnimations];
	}



	if (enteringAccessoryView != nil)
	{
		//Start animation to put it into place.
		if([enteringAccessoryView superview] != [self viewForKeyboardAccessory])
		{
			[self placeView:enteringAccessoryView nearTopOfRect:startFrame aboveTop:NO];
			[[self viewForKeyboardAccessory] addSubview:enteringAccessoryView];
		}
		targetedFrame = endFrame;
		[UIView beginAnimations:@"enter" context:enteringAccessoryView];
		[UIView setAnimationDuration:enterDuration];
		[UIView setAnimationCurve:enterCurve];
		[UIView setAnimationDelegate:self];
		[self placeView:enteringAccessoryView nearTopOfRect:endFrame aboveTop:YES];
		[UIView commitAnimations];
		accessoryView = enteringAccessoryView;
		enteringAccessoryView = nil;
	}
	if (leavingAccessoryView != nil)
	{
		[UIView beginAnimations:@"exit" context:leavingAccessoryView];
		[UIView setAnimationDuration:leaveDuration];
		[UIView setAnimationCurve:leaveCurve];
		[UIView setAnimationDelegate:self];
		[self placeView:leavingAccessoryView nearTopOfRect:endFrame aboveTop:NO];
		[UIView commitAnimations];
	}

}

- (void)keyboardWillHide:(NSNotification*)notification 
{
	NSDictionary *userInfo = [notification userInfo];
	leaveCurve = [[userInfo valueForKey:UIKeyboardAnimationCurveUserInfoKey] intValue];
	leaveDuration = [[userInfo valueForKey:UIKeyboardAnimationDurationUserInfoKey] floatValue];
	[self extractKeyboardInfo:userInfo];
	keyboardVisible = NO;

	if(!updatingAccessoryView)
	{
		updatingAccessoryView = YES;
		[self performSelector:@selector(handleNewKeyboardStatus) withObject:nil afterDelay:0.0];
	}
}

- (void)keyboardWillShow:(NSNotification*)notification 
{
	NSDictionary *userInfo = [notification userInfo];
	enterCurve = [[userInfo valueForKey:UIKeyboardAnimationCurveUserInfoKey] intValue];
	enterDuration = [[userInfo valueForKey:UIKeyboardAnimationDurationUserInfoKey] floatValue];
	[self extractKeyboardInfo:userInfo];
	keyboardVisible = YES;

	if(!updatingAccessoryView)
	{
		updatingAccessoryView = YES;
		[self performSelector:@selector(handleNewKeyboardStatus) withObject:nil afterDelay:0.0];
	}
}

- (void)keyboardDidHide:(NSNotification*)notification 
{
	startFrame = endFrame;
}

- (void)keyboardDidShow:(NSNotification*)notification
{
	startFrame = endFrame;
}

- (UIView *)keyboardAccessoryViewForProxy:(TiViewProxy<TiKeyboardFocusableView> *)visibleProxy withView:(UIView **)proxyView
{
//If the toolbar actually contains the view, then we have to give that precidence.
	if ([visibleProxy viewInitialized])
	{
		UIView * ourView = [visibleProxy view];
		*proxyView = ourView;

		while (ourView != nil)
		{
			if ((ourView == enteringAccessoryView) || (ourView == accessoryView) || (ourView == leavingAccessoryView))
			{
				//We found a match!
				*proxyView = nil;
				return ourView;
			}
			ourView = [ourView superview];
		}
	}
	else
	{
		*proxyView = nil;
	}
	return [visibleProxy keyboardAccessoryView];
}


-(void)didKeyboardBlurOnProxy:(TiViewProxy<TiKeyboardFocusableView> *)blurredProxy;
{
	WARN_IF_BACKGROUND_THREAD_OBJ
	if (blurredProxy != keyboardFocusedProxy)
	{
		NSLog(@"[WARN] Blurred for %@<%X>, despite %@<%X> being the focus.",blurredProxy,blurredProxy,keyboardFocusedProxy,keyboardFocusedProxy);
		return;
	}
	RELEASE_TO_NIL_AUTORELEASE(keyboardFocusedProxy);

	//Question: Ideally (IE, shouldn't happen differently) the keyboardToolbar of the focusedProxy IS the accessoryView. Should we assume this?
	//TODO: This can probably be optimized, but since how rarely this happens....
	
	TiUIView * scrolledView;	//We check at the update anyways.
	UIView * doomedView = [self keyboardAccessoryViewForProxy:blurredProxy withView:&scrolledView];

	if(doomedView != accessoryView)
	{
		NSLog(@"[WARN] Trying to blur out %@, but %@ is the one with focus.",doomedView,accessoryView);
		return;
	}

	if(scrolledView != nil)	//If this isn't IN the toolbar, then we update the scrollviews to compensate.
	{
		CGFloat keyboardHeight = endFrame.origin.y;
		UIView * possibleScrollView = [scrolledView superview];
		UIView<TiUIScrollView> * confirmedScrollView = nil;
		while (possibleScrollView != nil)
		{
			if ([possibleScrollView conformsToProtocol:@protocol(TiUIScrollView)])
			{
				confirmedScrollView = possibleScrollView;
			}
			possibleScrollView = [possibleScrollView superview];
		}
		[confirmedScrollView keyboardDidShowAtHeight:keyboardHeight];
	}

	if((doomedView == nil) || (leavingAccessoryView == doomedView)){
		//Nothing to worry about. No toolbar or it's on its way out.
		return;
	}
	
	if(leavingAccessoryView != nil)
	{
		NSLog(@"[WARN] Trying to blur out %@, but %@ is already leaving focus.",accessoryView,leavingAccessoryView);
		RELEASE_TO_NIL_AUTORELEASE(leavingAccessoryView);
	}

	leavingAccessoryView = accessoryView;
	accessoryView = nil;

	if(!updatingAccessoryView)
	{
		updatingAccessoryView = YES;
		[self performSelector:@selector(handleNewKeyboardStatus) withObject:nil afterDelay:0.0];
	}
}


-(void)didKeyboardFocusOnProxy:(TiViewProxy<TiKeyboardFocusableView> *)visibleProxy;
{
	WARN_IF_BACKGROUND_THREAD_OBJ
	if (visibleProxy == keyboardFocusedProxy)
	{
		NSLog(@"[WARN] Focused for %@<%X>, despite it already being the focus.",keyboardFocusedProxy,keyboardFocusedProxy);
		return;
	}
	if (nil != keyboardFocusedProxy)
	{
		NSLog(@"[WARN] Focused for %@<%X>, despite %@<%X> already being the focus.",visibleProxy,visibleProxy,keyboardFocusedProxy,keyboardFocusedProxy);
		[self didKeyboardBlurOnProxy:keyboardFocusedProxy];
	}
	
	keyboardFocusedProxy = [visibleProxy retain];
	
	TiUIView * unused;	//We check at the update anyways.
	UIView * newView = [self keyboardAccessoryViewForProxy:visibleProxy withView:&unused];

	if ((newView == enteringAccessoryView) || (newView == accessoryView))
	{
		//We're already up or soon will be.
		//Note that this is valid where newView can be accessoryView despite a new visibleProxy.
		//Specifically, if one proxy's view is a subview of another's toolbar.
	}
	else
	{
		if(enteringAccessoryView != nil)
		{
			NSLog(@"[WARN] Moving in view %@, despite %@ already in line to move in.",newView,enteringAccessoryView);
			[enteringAccessoryView release];
		}
		
		if (newView == leavingAccessoryView)
		{
			//Hold on, you're not leaving YET! We don't need to release you since we're going to retain right afterwards.
			enteringAccessoryView = newView;
			leavingAccessoryView = nil;
		}
		else
		{
			enteringAccessoryView = [newView retain];
		}		
	}
	
	if(!updatingAccessoryView)
	{
		updatingAccessoryView = YES;
		[self performSelector:@selector(handleNewKeyboardStatus) withObject:nil afterDelay:0.0];
	}
}

-(void)animationDidStop:(NSString *)animationID finished:(NSNumber *)finished context:(void *)context
{
	if(![finished boolValue]){
		return;
	}
	if(context == leavingAccessoryView){
		[leavingAccessoryView removeFromSuperview];
		RELEASE_TO_NIL(leavingAccessoryView);
	}
}

@end
