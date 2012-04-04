/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */
#if defined(USE_TI_UIIPADPOPOVER) || defined(USE_TI_UIIPADSPLITWINDOW)

#import "TiUIiPadPopover.h"
#import "TiUtils.h"

@implementation TiUIiPadPopover


@end

#if __IPHONE_OS_VERSION_MAX_ALLOWED >= __IPHONE_5_0
#import <UIKit/UIPopoverBackgroundView.h>
#import "ImageLoader.h"

@interface TiPopoverBackgroundView : UIPopoverBackgroundView

@end
UIImage * borderArrowUp;
UIImage * borderArrowLeft;
UIImage * borderArrowRight;
UIImage * borderArrowDown;
UIImage * borderBackground;
UIEdgeInsets borderMargins;
CGFloat arrowHeight;
CGFloat arrowBase;

@implementation TiPopoverBackgroundView
{
	UIImageView *arrowView;
	UIImageView *imageView;
	
	UIPopoverArrowDirection direction;
	CGFloat offset;
}

+(void)initialize
{
	ImageLoader * loader = [ImageLoader sharedLoader];
	NSURL * rootUrl = [NSURL URLWithString:@"app://"];
	borderArrowUp = [[loader loadImmediateImage:[TiUtils toURL:@"/popoverUpArrow.png" relativeToURL:rootUrl]] retain];
	borderArrowLeft = [[loader loadImmediateImage:[TiUtils toURL:@"/popoverLeftArrow.png" relativeToURL:rootUrl]] retain];
	borderArrowRight = [[loader loadImmediateImage:[TiUtils toURL:@"/popoverRightArrow.png" relativeToURL:rootUrl]] retain];
	borderArrowDown = [[loader loadImmediateImage:[TiUtils toURL:@"/popoverDownArrow.png" relativeToURL:rootUrl]] retain];

	CGSize arrowSize = [borderArrowUp size];
	arrowHeight = arrowSize.height - 2;
	arrowBase = arrowSize.width;
	borderMargins = UIEdgeInsetsMake(10,10, 10, 10);
	
	borderBackground = [[loader loadImmediateStretchableImage:[TiUtils toURL:@"/popoverBackground.png" relativeToURL:rootUrl]] retain];
}

- (void)dealloc
{
	[arrowView release];
	[imageView release];
}

- (void)layoutSubviews
{
	[super layoutSubviews];	
	if (imageView == nil) {
		imageView = [[UIImageView alloc] initWithImage:borderBackground];
		[self addSubview:imageView];
	}
	if (arrowView == nil) {
		arrowView = [[UIImageView alloc] initWithImage:borderArrowUp];
		[self addSubview:arrowView];
	}
	
	CGRect imageFrame = [self bounds];
	CGRect arrowFrame = CGRectZero;
	
	switch (self.arrowDirection) {
		case UIPopoverArrowDirectionUp:
			arrowFrame.size = [borderArrowUp size];
			[arrowView setImage:borderArrowUp];
			arrowFrame.origin.y=0;
			arrowFrame.origin.x=imageFrame.size.width/2 - arrowBase/2 + offset;
			
			imageFrame.origin.y += arrowHeight;
			imageFrame.size.height -= arrowHeight;
			break;
			
		case UIPopoverArrowDirectionDown:
			arrowFrame.size = [borderArrowDown size];
			[arrowView setImage:borderArrowDown];
			arrowFrame.origin.y=imageFrame.size.height - arrowFrame.size.height;
			arrowFrame.origin.x=imageFrame.size.width/2 - arrowBase/2 + offset;
			
			imageFrame.size.height -= arrowHeight;
			break;
			
		case UIPopoverArrowDirectionLeft:
			arrowFrame.size = [borderArrowLeft size];
			[arrowView setImage:borderArrowLeft];
			arrowFrame.origin.x=0;
			arrowFrame.origin.y=imageFrame.size.height/2 - arrowBase/2 + offset;
			
			imageFrame.origin.x += arrowHeight;
			imageFrame.size.width -= arrowHeight;
			break;
			
		case UIPopoverArrowDirectionRight:
			arrowFrame.size = [borderArrowRight size];
			[arrowView setImage:borderArrowRight];
			arrowFrame.origin.x=imageFrame.size.width - arrowFrame.size.width;
			arrowFrame.origin.y=imageFrame.size.height/2 - arrowBase/2 + offset;
			
			imageFrame.size.width -= arrowHeight;
			break;
			
	}
	
	[arrowView setFrame:arrowFrame];
	[imageView setFrame:imageFrame];
}

- (CGFloat) arrowOffset {
	return offset;
}

- (void) setArrowOffset:(CGFloat)arrowOffset
{
	offset = arrowOffset;
	[self setNeedsLayout];
}

- (UIPopoverArrowDirection)arrowDirection
{
	return direction;
}

- (void)setArrowDirection:(UIPopoverArrowDirection)arrowDirection
{
	direction = arrowDirection;
	[self setNeedsLayout];
}

+ (CGFloat)arrowHeight
{
	return arrowHeight;
}

+ (CGFloat)arrowBase
{
	return arrowBase;
}

+ (UIEdgeInsets)contentViewInsets
{
	return borderMargins;
}

@end

#endif

#endif