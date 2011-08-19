//
//  KeyboardAccessoryManager.h
//  Titanium
//
//  Created by Blain Hamon on 8/19/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

//TODO: Factor out and make a seperate entity.
#import "TiViewProxy.h"

@interface KeyboardAccessoryManager : NSObject {
	UIWindow * appWindow;
	
	BOOL updatingAccessoryView;
	UIView * enteringAccessoryView;	//View that will enter.
	UIView * accessoryView;			//View that is onscreen.
	UIView * leavingAccessoryView;	//View that is leaving the screen.
	TiViewProxy<TiKeyboardFocusableView> * keyboardFocusedProxy; //View whose becoming key affects things.
	
	CGRect startFrame;		//Where the keyboard was before the handling
	CGRect targetedFrame;	//The keyboard place relative to where the accessoryView is moving;
	CGRect endFrame;		//Where the keyboard will be after the handling
	BOOL keyboardVisible;	//If false, use enterCurve. If true, use leaveCurve.
	UIViewAnimationCurve enterCurve;
	CGFloat enterDuration;
	UIViewAnimationCurve leaveCurve;
	CGFloat leaveDuration;
}

-(UIView *)viewForKeyboardAccessory;
-(UIView *)keyboardAccessoryViewForProxy:(TiViewProxy<TiKeyboardFocusableView> *)visibleProxy withView:(UIView **)proxyView;


@end
