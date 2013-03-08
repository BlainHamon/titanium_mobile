/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */
package org.appcelerator.titanium;

/**
 * A comprehensive list of global Titanium events and properties constants.
 * These are sorted alphabetically.
 */
public class TiC

{
	public static final int API_LEVEL_HONEYCOMB = 11;
	public static final int API_LEVEL_ICE_CREAM_SANDWICH = 14;
	public static final int API_LEVEL_JELLY_BEAN = 16;
	public static final String ERROR_PROPERTY_CODE = "code";
	public static final String ERROR_PROPERTY_ERRORCODE = "errorcode";
	public static final String ERROR_PROPERTY_MESSAGE = "message";

	/**
	 * ERROR_CODE constants are for values of the code property in
	 * events and callback objects. When you can use a nonzero OS-provided
	 * error code, use that instead.
	 */
	public static final int ERROR_CODE_UNKNOWN = -1;
	public static final int ERROR_CODE_NO_ERROR = 0;

	/**
	 * @module.api
	 */
	public static final String EVENT_ADDED_TO_TAB = "addedtotab";

	/**
	 * @module.api
	 */
	public static final String EVENT_ANDROID_BACK = "androidback";

	/**
	 * @module.api
	 */
	public static final String EVENT_ANDROID_CAMERA = "androidcamera";

	/**
	 * @module.api
	 */
	public static final String EVENT_ANDROID_FOCUS = "androidfocus";

	/**
	 * @module.api
	 */
	public static final String EVENT_ANDROID_SEARCH = "androidsearch";

	/**
	 * @module.api
	 */
	public static final String EVENT_ANDROID_VOLDOWN = "androidvoldown";

	/**
	 * @module.api
	 */
	public static final String EVENT_ANDROID_VOLUP = "androidvolup";

	/**
	 * @module.api
	 */
	public static final String EVENT_BATTERY = "battery";

	/**
	 * @module.api
	 */
	public static final String EVENT_BLUR = "blur";

	/**
	 * @module.api
	 */
	public static final String EVENT_CANCEL = "cancel";

	/**
	 * @module.api
	 */
	public static final String EVENT_COLLAPSE = "collapse";

	/**
	 * @module.api
	 */
	public static final String EVENT_CHANGE = "change";

	/**
	 * @module.api
	 */
	public static final String EVENT_CLICK = "click";

	/**
	 * @module.api
	 */
	public static final String EVENT_CLOSE = "close";

	/**
	 * @module.api
	 */
	public static final String EVENT_COMPLETE = "complete";

	/**
	 * @module.api
	 */
	public static final String EVENT_CREATE = "create";

	/**
	 * @module.api
	 */
	public static final String EVENT_DESTROY = "destroy";

	/**
	 * @module.api
	 */
	public static final String EVENT_DOUBLE_CLICK = "dblclick";

	/**
	 * @module.api
	 */
	public static final String EVENT_DOUBLE_TAP = "doubletap";

	/**
	 * @module.api
	 */
	public static final String EVENT_DURATION_AVAILABLE = "durationavailable";

	/**
	 * @module.api
	 */
	public static final String EVENT_ERROR = "error";

	/**
	 * @module.api
	 */
	public static final String EVENT_EXPAND = "expand";

	/**
	 * @module.api
	 */
	public static final String EVENT_FOCUS = "focus";

	/**
	 * @module.api
	 */
	public static final String EVENT_FOCUSED = "focused";

	/**
	 * @module.api
	 */
	public static final String EVENT_KEY_PRESSED = "keypressed";
	/**
	 * @module.api
	 */
	public static final String EVENT_HEADING = "heading";

	/**
	 * @module.api
	 */
	public static final String EVENT_LOAD = "load";

	/**
	 * @module.api
	 */
	public static final String EVENT_LOADSTATE = "loadstate";

	/**
	 * @module.api
	 */
	public static final String EVENT_LOCATION = "location";

	/**
	 * @module.api
	 */
	public static final String EVENT_LONGCLICK = "longclick";

	/**
	 * @module.api
	 */
	public static final String EVENT_LONGPRESS = "longpress";

	/**
	 * @module.api
	 */
	public static final String EVENT_NEW_INTENT = "newintent";

	/**
	 * @module.api
	 */
	public static final String EVENT_OPEN = "open";

	/**
	 * @module.api
	 */
	public static final String EVENT_PAUSE = "pause";

	/**
	 * @module.api
	 */
	public static final String EVENT_PINCH = "pinch";	

	/**
	 * @module.api
	 */
	public static final String EVENT_PLAYBACK_STATE = "playbackstate";

	/**
	 * @module.api
	 */
	public static final String EVENT_PRELOAD = "preload";

	/**
	 * @module.api
	 */
	public static final String EVENT_POST_LAYOUT = "postlayout";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_CLICKSOURCE = "clicksource";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_CURRENT_PLAYBACK_TIME = "currentPlaybackTime";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_DETAIL = "detail";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_DIRECTION = "direction";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_ERROR = "error";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_INDEX = "index";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_INTENT = "intent";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_IS_DIALOG = "isDialog";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_IS_USER_GESTURE = "isUserGesture";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_KEYCODE = "keyCode";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_LAYOUT_NAME = "layoutName";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_LOADSTATE = "loadState";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_MENU = "menu";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_MESSAGE = "message";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_PLAYBACK_STATE = "playbackState";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_PREVIOUS_INDEX = "previousIndex";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_PREVIOUS_TAB = "previousTab";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_REASON = "reason";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_REQUEST_CODE = "requestCode";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_RESULT_CODE = "resultCode";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_ROW = "row";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_SCALE = "scale";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_SEARCH_MODE = "searchMode";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_SOURCE = "source";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_STATE = "state";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_TAB = "tab";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_THUMB_OFFSET = "thumbOffset";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_THUMB_SIZE = "thumbSize";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_TYPE = "type";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_VELOCITY = "velocity";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_X = "x";

	/**
	 * @module.api
	 */
	public static final String EVENT_PROPERTY_Y = "y";

	/**
	 * @module.api
	 */
	public static final String EVENT_REGION_CHANGED = "regionchanged";

	/**
	 * @module.api
	 */
	public static final String EVENT_RESTART = "restart";

	/**
	 * @module.api
	 */
	public static final String EVENT_RESUME = "resume";

	/**
	 * @module.api
	 */
	public static final String EVENT_SCROLL = "scroll";

	/**
	 * @module.api
	 */
	public static final String EVENT_SCROLLEND = "scrollend";

	/**
	 * @module.api
	 */
	public static final String EVENT_DRAGEND = "dragend";

	/**
	 * @module.api
	 */
	public static final String EVENT_SINGLE_TAP = "singletap";

	/**
	 * @module.api
	 */
	public static final String EVENT_START = "start";

	/**
	 * @module.api
	 */
	public static final String EVENT_STOP = "stop";
	
	/**
	 * @module.api
	 */
	public static final String EVENT_SUBMIT = "submit";

	/**
	 * @module.api
	 */
	public static final String EVENT_SWIPE = "swipe";

	/**
	 * @module.api
	 */
	public static final String EVENT_TOUCH_CANCEL = "touchcancel";

	/**
	 * @module.api
	 */
	public static final String EVENT_TOUCH_END = "touchend";

	/**
	 * @module.api
	 */
	public static final String EVENT_TOUCH_MOVE = "touchmove";

	/**
	 * @module.api
	 */
	public static final String EVENT_TOUCH_START = "touchstart";

	/**
	 * @module.api
	 */
	public static final String EVENT_TWOFINGERTAP = "twofingertap";

	/**
	 * @module.api
	 */
	public static final String EVENT_UNFOCUSED = "unfocused";
	public static final String INTENT_PROPERTY_ENTER_ANIMATION = "enterAnimation";
	public static final String INTENT_PROPERTY_EXIT_ANIMATION = "exitAnimation";
	public static final String INTENT_PROPERTY_FINISH_ROOT = "finishRoot";
	public static final String INTENT_PROPERTY_IS_TAB = "isTab";
	public static final String INTENT_PROPERTY_LAYOUT = "layout";
	public static final String INTENT_PROPERTY_MESSENGER = "messenger";
	public static final String INTENT_PROPERTY_MSG_ACTIVITY_CREATED_ID = "msgActivityCreatedId";
	public static final String INTENT_PROPERTY_MSG_ID = "messageId";
	public static final String INTENT_PROPERTY_START_MODE = "startMode";
	public static final String INTENT_PROPERTY_USE_ACTIVITY_WINDOW = "useActivityWindow";
	public static final String INTENT_PROPERTY_WINDOW_ID = "windowId";
	public static final String LAYOUT_FILL = "fill";
	public static final String LAYOUT_HORIZONTAL = "horizontal";
	public static final String LAYOUT_SIZE = "size";
	public static final String LAYOUT_VERTICAL = "vertical";
	public static final String MSG_PROPERTY_EVENT_NAME = "eventName";
	public static final String MSG_PROPERTY_FILENAME = "filename";
	public static final String MSG_PROPERTY_SRC = "src";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACCURACY = "accuracy";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SCROLLING_ENABLED = "scrollingEnabled";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACCESSIBILITY_HIDDEN = "accessibilityHidden";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACCESSIBILITY_HINT = "accessibilityHint";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACCESSIBILITY_LABEL = "accessibilityLabel";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACCESSIBILITY_VALUE = "accessibilityValue";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACTION = "action";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACTION_VIEW = "actionView";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACTIVE_TAB = "activeTab";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACTIVE_TAB_BACKGROUND_COLOR = "activeTabBackgroundColor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACTIVITY = "activity";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACTIVITY_ENTER_ANIMATION = "activityEnterAnimation";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ACTIVITY_EXIT_ANIMATION = "activityExitAnimation";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ADDRESS = "address";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ALLOW_BACKGROUND = "allowBackground";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ALTITUDE = "altitude";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ALTITUDE_ACCURACY = "altitudeAccuracy";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ANCHOR_POINT = "anchorPoint";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ANDROID_VIEW = "androidView";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ANIMATE = "animate";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ANIMATED = "animated";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_ANNIVERSARY = "anniversary";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ANNOTATION = "annotation";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ANNOTATIONS = "annotations";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_ASSISTANT = "assistant";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_AUDIO_STREAM_TYPE = "audioStreamType";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_AUTO_LINK = "autoLink";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_AUTOCAPITALIZATION = "autocapitalization";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_AUTOCORRECT = "autocorrect";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_AUTOPLAY = "autoplay";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_AUTOREVERSE = "autoreverse";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_AUTOROTATE = "autorotate";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_COLOR = "backgroundColor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_DISABLED_COLOR = "backgroundDisabledColor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_DISABLED_IMAGE = "backgroundDisabledImage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_FOCUSED_COLOR = "backgroundFocusedColor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_FOCUSED_IMAGE = "backgroundFocusedImage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_GRADIENT = "backgroundGradient";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_IMAGE = "backgroundImage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_PADDING = "backgroundPadding";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_PREFIX = "background";

	public static final String PROPERTY_BACKGROUND_REPEAT = "backgroundRepeat";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_SELECTED_COLOR = "backgroundSelectedColor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BACKGROUND_SELECTED_IMAGE = "backgroundSelectedImage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BASE_URL = "baseUrl";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BASE_URL_WEBVIEW = "baseURL";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_BIRTHDAY = "birthday";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BORDER_COLOR = "borderColor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BORDER_PREFIX = "border";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BORDER_RADIUS = "borderRadius";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BORDER_WIDTH = "borderWidth";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BOTTOM = "bottom";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_BROTHER = "brother";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BUTTON = "button";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BUBBLES = "bubbles";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BUTTON_NAMES = "buttonNames";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_BYTE_ORDER = "byteOrder";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CAN_CANCEL_EVENTS = "canCancelEvents";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CANCEL = "cancel";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CANCELABLE = "cancelable";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CENTER = "center";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CHARSET = "charset";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CHECKABLE = "checkable";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CHECKED = "checked";
	/**
	 * @module.api
	 */
	public static final String PROPERTY_CHILD = "child";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CITY = "city";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CLASS_NAME = "className";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CLASS_NAMES = "classNames";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CLEAR_ON_EDIT = "clearOnEdit";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CODE = "code";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_COLOR = "color";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_COORDS = "coords";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CONTENT_HEIGHT = "contentHeight";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CONTENT_INTENT = "contentIntent";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CONTENT_OFFSET = "contentOffset";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CONTENT_TEXT = "contentText";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CONTENT_TITLE = "contentTitle";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CONTENT_URL = "contentURL";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CONTENT_VIEW = "contentView";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_CONTENT_WIDTH = "contentWidth";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_COUNT = "count";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_COUNTRY = "country";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_COUNTRY_CODE = "country_code";

	/**
	 * @module.api
	 */ // TIMOB-4478
	public static final String PROPERTY_CURRENT_PAGE = "currentPage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DATA = "data";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_DATE = "date";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DEFAULT_IMAGE = "defaultImage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DEFAULTS = "defaults";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DELAY = "delay";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DELETE_INTENT = "deleteIntent";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DEST = "dest";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DEST_POSITION = "destPosition";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DIRECTION = "direction";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DISPLAY_ADDRESS = "displayAddress";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_DOMAIN = "domain";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DOMESTIC_PARTNER = "domesticPartner";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_DURATION = "duration";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_EDITABLE = "editable";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ELLIPSIZE = "ellipsize";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_EMAIL = "email";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ENABLE_ZOOM_CONTROLS = "enableZoomControls";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ENABLED = "enabled";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ENABLE_RETURN_KEY = "enableReturnKey";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_END_PLAYBACK_TIME = "endPlaybackTime";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_EVENT = "event";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_EXIT_ON_CLOSE = "exitOnClose";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FATHER = "father";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_FILE = "file";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FILTER_ATTRIBUTE = "filterAttribute";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FILTER_CASE_INSENSITIVE = "filterCaseInsensitive";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_FIRSTNAME = "firstName";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FLAGS = "flags";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FOCUSABLE = "focusable";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FONT = "font";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FONT_FAMILY = "font-family";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FONT_WEIGHT = "font-weight";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FONT_SIZE = "font-size";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FOOTER = "footer";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FOOTER_TITLE = "footerTitle";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FOOTER_VIEW = "footerView";

	public static final String PROPERTY_FORWARD = "forward";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FREQUENCY = "frequency";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_FRIEND = "friend";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FROM = "from";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FULLNAME = "fullname";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_FULLSCREEN = "fullscreen";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_GROUP_ID = "groupId";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HAS_CHECK = "hasCheck";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HAS_CHILD = "hasChild";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HEADER = "header";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HEADER_TITLE = "headerTitle";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HEADER_VIEW = "headerView";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HEADING = "heading";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HEADING_FILTER = "headingFilter";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HEIGHT = "height";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HIDE_ANNOTATION_WHEN_TOUCH_MAP = "hideAnnotationWhenTouchMap";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HIGHLIGHTED_COLOR = "highlightedColor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HINT_TEXT = "hintText";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_HOME = "home";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_HOMEPAGE = "homepage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HTML = "html";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ICON = "icon";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ICON_LEVEL = "iconLevel";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_ICONIFIED = "iconified";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_ICONIFIED_BY_DEFAULT = "iconifiedByDefault";


	/**
	 * @module.api
	 */
	public static final String PROPERTY_ID = "id";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_IMAGE = "image";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_IMAGES = "images";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_INITIAL_PLAYBACK_TIME = "initialPlaybackTime";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_INSTANTMSG = "instantMessage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_INTENT = "intent";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ITEM_ID = "itemId";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_KEEP_SCREEN_ON = "keepScreenOn";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_KEYBOARD_TYPE = "keyboardType";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_LASTNAME = "lastName";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LATITUDE = "latitude";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LATITUDE_DELTA = "latitudeDelta";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LAYOUT = "layout";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LAYOUT_ID = "layoutId";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LED_ARGB = "ledARGB";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LED_OFF_MS = "ledOffMS";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LED_ON_MS = "ledOnMS";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LEFT = "left";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LEFT_BUTTON = "leftButton";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LEFT_IMAGE = "leftImage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LEFT_VIEW = "leftView";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LENGTH = "length";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LEVEL = "level";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LOCATION = "location";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LONGITUDE = "longitude";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_LONGITUDE_DELTA = "longitudeDelta";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MAGNETIC_HEADING = "magneticHeading";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_MANAGER = "manager";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MAP_TYPE = "mapType";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MAX = "max";

	public static final String PROPERTY_MAX_AGE = "maxAge";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_MAX_LENGTH = "maxLength";


	/**
	 * @module.api
	 */
	public static final String PROPERTY_MEDIA_CONTROL_STYLE = "mediaControlStyle";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MENU = EVENT_PROPERTY_MENU;

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MESSAGE = "message";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MESSAGEID = "messageid";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MESSENGER = "messenger";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MESSENGER_RECEIVER = "messengerReceiver";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MIDDLENAME = "middleName";
	/**
	 * @module.api
	 */
	public static final String PROPERTY_MIMETYPE = "mimeType";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_MIN = "min";

	public static final String PROPERTY_MIN_AGE = "minAge";
	public static final String PROPERTY_MIN_UPDATE_DISTANCE = "minUpdateDistance";
	public static final String PROPERTY_MIN_UPDATE_TIME = "minUpdateTime";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MIN_ROW_HEIGHT = "minRowHeight";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MINUTE_INTERVAL = "minuteInterval";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MOBILE = "mobile";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_MODAL = "modal";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_MOTHER = "mother";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_NAME = "name";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_NAV_BAR_HIDDEN = "navBarHidden";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_NICKNAME = "nickname";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_NOTE = "note";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_NUMBER = "number";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_OK = "ok";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_OKID = "okid";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ON_CREATE_OPTIONS_MENU = "onCreateOptionsMenu";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ON_CREATE_WINDOW = "onCreateWindow";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ON_HOME_ICON_ITEM_SELECTED = "onHomeIconItemSelected";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ON_PREPARE_OPTIONS_MENU = "onPrepareOptionsMenu";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ON_RECEIVED = "onReceived";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_OPACITY = "opacity";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_OPTIONS = "options";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ORDER = "order";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_ORGANIZATION = "organization";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ORIENTATION_MODES = "orientationModes";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_OTHER = "other";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_OVER_SCROLL_MODE = "overScrollMode";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PACKAGE_NAME = "packageName";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PAGING_CONTROL_TIMEOUT = "pagingControlTimeout";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PARENT = "parent";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_PARTNER = "partner";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PASSWORD = "password";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PASSWORD_MASK = "passwordMask";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PERSISTENT = "persistent";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PHONE = "phone";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PIN_IMAGE = "pinImage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PINCOLOR = "pincolor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PLACES = "places";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PLAY = "play";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PLUGIN_STATE = "pluginState";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_POSITION = "position";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_POSTAL_CODE = "postalCode";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_POWER = "power";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PREFERRED_PROVIDER = "preferredProvider";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PLAYABLE_DURATION = "playableDuration";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_PROVIDER = "provider";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_REFERRED_BY = "referredBy";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_REGION = "region";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_REGION1 = "region1";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_REGION2 = "region2";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_REGION_FIT = "regionFit";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_RELATED_NAMES = "relatedNames";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_REPEAT = "repeat";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_REPEAT_COUNT = "repeatCount";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_RETURN_KEY_TYPE = "returnKeyType";

	public static final String PROPERTY_REVERSE = "reverse";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_RIGHT = "right";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_RIGHT_BUTTON = "rightButton";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_RIGHT_IMAGE = "rightImage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_RIGHT_VIEW = "rightView";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ROTATE = "rotate";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ROW_DATA = "rowData";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ROW_HEIGHT = "rowHeight";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SCALE = "scale";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SCALING_MODE = "scalingMode";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SCALES_PAGE_TO_FIT = "scalesPageToFit";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SCROLL_ENABLED = "scrollEnabled";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SCROLL_TYPE = "scrollType";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SEARCH = "search";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_SEARCH_AS_CHILD = "searchAsChild";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SECTION = "section";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SECTIONS = "sections";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SELECTED_BACKGROUND_COLOR = "selectedBackgroundColor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SELECTED_BACKGROUND_IMAGE = "selectedBackgroundImage";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SELECTED_INDEX = "selectedIndex";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SELECTION_INDICATOR = "selectionIndicator";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SEPARATOR_COLOR = "separatorColor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SHOW_AS_ACTION = "showAsAction";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SHOW_HORIZONTAL_SCROLL_INDICATOR = "showHorizontalScrollIndicator";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SHOW_VERTICAL_SCROLL_INDICATOR = "showVerticalScrollIndicator";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SHOW_PAGING_CONTROL = "showPagingControl";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SHOW_PROGRESS = "showProgress";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SISTER = "sister";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_SIZE = "size";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SOFT_KEYBOARD_ON_FOCUS = "softKeyboardOnFocus";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SOUND = "sound";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SPEED = "speed";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SOURCE = EVENT_PROPERTY_SOURCE;

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SOURCE_LENGTH = "sourceLength";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SOURCE_POSITION = "sourcePosition";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_SPOUSE = "spouse";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_START = "start";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_STATE = "state";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_STATUS = "status";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_STOP = "stop";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_STREET = "street";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_STREET1 = "street1";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_STYLE = "style";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SUBMIT_ENABLED = "submitEnabled";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_SUBTITLE = "subtitle";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SUBTITLEID = "subtitleid";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_SUCCESS = "success";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TABS = "tabs";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TAB_OPEN = "tabOpen";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_TABS_BACKGROUND_COLOR = "tabsBackgroundColor";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_TABS_BACKGROUND_SELECTED_COLOR = "tabsBackgroundSelectedColor";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TAG = "tag";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TEXT = "text";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TEXTID = "textid";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TEXT_ALIGN = "textAlign";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TICKER_TEXT = "tickerText";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TIME = "time";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_TIMEOUT = "timeout";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TIMESTAMP = "timestamp";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TITLE = "title";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TITLE_CONDENSED = "titleCondensed";
	/**
	 * @module.api
	 */
	public static final String PROPERTY_TITLEID = "titleid";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TITLE_ON = "titleOn";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TITLE_OFF = "titleOff";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TITLE_PROMPT = "titlePrompt";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TITLE_PROMPTID = "titlepromptid";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TO = "to";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TOP = "top";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TOUCH_ENABLED = "touchEnabled";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TRANSFORM = "transform";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TRUE_HEADING = "trueHeading";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_TYPE = "type";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_UPDATE_CURRENT_INTENT = "updateCurrentIntent";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_URI = "uri";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_URL = "url";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_USERNAME = "username";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_USER_LOCATION = "userLocation";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_VALUE = "value";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_VERTICAL_ALIGN = "verticalAlign";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_VIBRATE_PATTERN = "vibratePattern";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_VISIBLE = "visible";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_VISIBLE_ITEMS = "visibleItems";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_VIEW = "view";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_VIEWS = "views";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_VOLUME = "volume";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_WEBVIEW_IGNORE_SSL_ERROR = "ignoreSslError";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_WHEN = "when";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_WIDTH = "width";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_WINDOW = "window";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_WINDOW_PIXEL_FORMAT = "windowPixelFormat";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_WINDOW_SOFT_INPUT_MODE = "windowSoftInputMode";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_WORD_WRAP = "wordWrap";
	
	/**
	 * @module.api
	 */
	public static final String PROPERTY_WORK = "work";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_HORIZONTAL_WRAP = "horizontalWrap";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_X = "x";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_Y = "y";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_Z = "z";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ZINDEX = "zIndex";

	/**
	 * @module.api
	 */
	public static final String PROPERTY_ZOOM_ENABLED = "zoomEnabled";
	public static final String SIZE_AUTO = "auto";
	public static final String URL_APP_PREFIX = "app://";
	public static final String URL_APP_SCHEME = "app";
	public static final String URL_APP_JS = "app://app.js";
	public static final String URL_ANDROID_ASSET_RESOURCES = "file:///android_asset/Resources/";

	/**
	 * STRING_LOOKUP is a lookup table of common strings (read, all in TiC.java, with duplicates
	 * removed) with a starting empty string, and sorted for use by binary search. TODO: automate this
	 * to remove chance of error.
	 */
	public static final String[] STRING_LOOKUP = {
		"", PROPERTY_ACCESSIBILITY_HIDDEN, PROPERTY_ACCESSIBILITY_HINT, PROPERTY_ACCESSIBILITY_LABEL,
		PROPERTY_ACCESSIBILITY_VALUE, PROPERTY_ACCURACY, PROPERTY_ACTION, PROPERTY_ACTION_VIEW,
		PROPERTY_ACTIVE_TAB, PROPERTY_ACTIVE_TAB_BACKGROUND_COLOR, PROPERTY_ACTIVITY, PROPERTY_ACTIVITY_ENTER_ANIMATION,
		PROPERTY_ACTIVITY_EXIT_ANIMATION, EVENT_ADDED_TO_TAB, PROPERTY_ADDRESS, PROPERTY_ALLOW_BACKGROUND,
		PROPERTY_ALTITUDE, PROPERTY_ALTITUDE_ACCURACY, PROPERTY_ANCHOR_POINT, EVENT_ANDROID_BACK,
		EVENT_ANDROID_CAMERA, EVENT_ANDROID_FOCUS, EVENT_ANDROID_SEARCH, PROPERTY_ANDROID_VIEW,
		EVENT_ANDROID_VOLDOWN, EVENT_ANDROID_VOLUP, PROPERTY_ANIMATE, PROPERTY_ANIMATED,
		PROPERTY_ANNIVERSARY, PROPERTY_ANNOTATION, PROPERTY_ANNOTATIONS, PROPERTY_ASSISTANT,
		PROPERTY_AUDIO_STREAM_TYPE, SIZE_AUTO, PROPERTY_AUTOCAPITALIZATION, PROPERTY_AUTOCORRECT,
		PROPERTY_AUTO_LINK, PROPERTY_AUTOPLAY, PROPERTY_AUTOREVERSE, PROPERTY_AUTOROTATE,
		PROPERTY_BACKGROUND_PREFIX, PROPERTY_BACKGROUND_COLOR, PROPERTY_BACKGROUND_DISABLED_COLOR, PROPERTY_BACKGROUND_DISABLED_IMAGE,
		PROPERTY_BACKGROUND_FOCUSED_COLOR, PROPERTY_BACKGROUND_FOCUSED_IMAGE, PROPERTY_BACKGROUND_GRADIENT, PROPERTY_BACKGROUND_IMAGE,
		PROPERTY_BACKGROUND_PADDING, PROPERTY_BACKGROUND_REPEAT, PROPERTY_BACKGROUND_SELECTED_COLOR, PROPERTY_BACKGROUND_SELECTED_IMAGE,
		PROPERTY_BASE_URL, PROPERTY_BASE_URL_WEBVIEW, EVENT_BATTERY, PROPERTY_BIRTHDAY,
		EVENT_BLUR, PROPERTY_BORDER_PREFIX, PROPERTY_BORDER_COLOR, PROPERTY_BORDER_RADIUS,
		PROPERTY_BORDER_WIDTH, PROPERTY_BOTTOM, PROPERTY_BROTHER, PROPERTY_BUBBLES,
		PROPERTY_BUTTON, PROPERTY_BUTTON_NAMES, PROPERTY_BYTE_ORDER, PROPERTY_CAN_CANCEL_EVENTS,
		EVENT_CANCEL, PROPERTY_CANCELABLE, PROPERTY_CAN_SCALE, PROPERTY_CENTER,
		EVENT_CHANGE, PROPERTY_CHARSET, PROPERTY_CHECKABLE, PROPERTY_CHECKED,
		PROPERTY_CHILD, PROPERTY_CITY, PROPERTY_CLASS_NAME, PROPERTY_CLASS_NAMES,
		PROPERTY_CLEAR_ON_EDIT, EVENT_CLICK, EVENT_PROPERTY_CLICKSOURCE, EVENT_CLOSE,
		PROPERTY_CODE, EVENT_COLLAPSE, PROPERTY_COLOR, EVENT_COMPLETE,
		PROPERTY_CONTENT_HEIGHT, PROPERTY_CONTENT_INTENT, PROPERTY_CONTENT_OFFSET, PROPERTY_CONTENT_TEXT,
		PROPERTY_CONTENT_TITLE, PROPERTY_CONTENT_URL, PROPERTY_CONTENT_VIEW, PROPERTY_CONTENT_WIDTH,
		PROPERTY_COORDS, PROPERTY_COUNT, PROPERTY_COUNTRY, PROPERTY_COUNTRY_CODE,
		EVENT_CREATE, PROPERTY_CURRENT_PAGE, EVENT_PROPERTY_CURRENT_PLAYBACK_TIME, PROPERTY_DATA,
		PROPERTY_DATE, EVENT_DOUBLE_CLICK, PROPERTY_DEFAULT_IMAGE, PROPERTY_DEFAULTS,
		PROPERTY_DELAY, PROPERTY_DELETE_INTENT, PROPERTY_DEST, PROPERTY_DEST_POSITION,
		EVENT_DESTROY, EVENT_PROPERTY_DETAIL, PROPERTY_DIRECTION, PROPERTY_DISPLAY_ADDRESS,
		PROPERTY_DOMAIN, PROPERTY_DOMESTIC_PARTNER, EVENT_DOUBLE_TAP, EVENT_DRAGEND,
		PROPERTY_DURATION, EVENT_DURATION_AVAILABLE, PROPERTY_EDITABLE, PROPERTY_ELLIPSIZE,
		PROPERTY_EMAIL, PROPERTY_ENABLED, PROPERTY_ENABLE_RETURN_KEY, PROPERTY_ENABLE_ZOOM_CONTROLS,
		PROPERTY_END_PLAYBACK_TIME, INTENT_PROPERTY_ENTER_ANIMATION, EVENT_ERROR, ERROR_PROPERTY_ERRORCODE,
		PROPERTY_EVENT, MSG_PROPERTY_EVENT_NAME, INTENT_PROPERTY_EXIT_ANIMATION, PROPERTY_EXIT_ON_CLOSE,
		EVENT_EXPAND, PROPERTY_FATHER, PROPERTY_FILE, MSG_PROPERTY_FILENAME,
		LAYOUT_FILL, PROPERTY_FILTER_ATTRIBUTE, PROPERTY_FILTER_CASE_INSENSITIVE, INTENT_PROPERTY_FINISH_ROOT,
		PROPERTY_FIRSTNAME, PROPERTY_FLAGS, EVENT_FOCUS, PROPERTY_FOCUSABLE,
		EVENT_FOCUSED, PROPERTY_FONT, PROPERTY_FONT_FAMILY, PROPERTY_FONT_SIZE,
		PROPERTY_FONT_WEIGHT, PROPERTY_FOOTER, PROPERTY_FOOTER_TITLE, PROPERTY_FOOTER_VIEW,
		PROPERTY_FORWARD, PROPERTY_FREQUENCY, PROPERTY_FRIEND, PROPERTY_FROM,
		PROPERTY_FULLNAME, PROPERTY_FULLSCREEN, PROPERTY_GROUP_ID, PROPERTY_HAS_CHECK,
		PROPERTY_HAS_CHILD, PROPERTY_HEADER, PROPERTY_HEADER_TITLE, PROPERTY_HEADER_VIEW,
		EVENT_HEADING, PROPERTY_HEADING_FILTER, PROPERTY_HEIGHT, PROPERTY_HIDE_ANNOTATION_WHEN_TOUCH_MAP,
		PROPERTY_HIGHLIGHTED_COLOR, PROPERTY_HINT_TEXT, PROPERTY_HOME, PROPERTY_HOMEPAGE,
		LAYOUT_HORIZONTAL, PROPERTY_HORIZONTAL_WRAP, PROPERTY_HTML, PROPERTY_ICON,
		PROPERTY_ICONIFIED, PROPERTY_ICONIFIED_BY_DEFAULT, PROPERTY_ICON_LEVEL, PROPERTY_ID,
		PROPERTY_WEBVIEW_IGNORE_SSL_ERROR, PROPERTY_IMAGE, PROPERTY_IMAGES, EVENT_PROPERTY_INDEX,
		PROPERTY_INITIAL_PLAYBACK_TIME, PROPERTY_INSTANTMSG, PROPERTY_INTENT, EVENT_PROPERTY_IS_DIALOG,
		INTENT_PROPERTY_IS_TAB, EVENT_PROPERTY_IS_USER_GESTURE, PROPERTY_ITEM_ID, PROPERTY_KEEP_SCREEN_ON,
		PROPERTY_KEYBOARD_TYPE, EVENT_PROPERTY_KEYCODE, EVENT_KEY_PRESSED, PROPERTY_LASTNAME,
		PROPERTY_LATITUDE, PROPERTY_LATITUDE_DELTA, PROPERTY_LAYOUT, PROPERTY_LAYOUT_ID,
		EVENT_PROPERTY_LAYOUT_NAME, PROPERTY_LED_ARGB, PROPERTY_LED_OFF_MS, PROPERTY_LED_ON_MS,
		PROPERTY_LEFT, PROPERTY_LEFT_BUTTON, PROPERTY_LEFT_IMAGE, PROPERTY_LEFT_VIEW,
		PROPERTY_LENGTH, PROPERTY_LEVEL, EVENT_LOAD, EVENT_LOADSTATE,
		EVENT_PROPERTY_LOADSTATE, EVENT_LOCATION, EVENT_LONGCLICK, PROPERTY_LONGITUDE,
		PROPERTY_LONGITUDE_DELTA, EVENT_LONGPRESS, PROPERTY_MAGNETIC_HEADING, PROPERTY_MANAGER,
		PROPERTY_MAP_TYPE, PROPERTY_MAX, PROPERTY_MAX_AGE, PROPERTY_MAX_LENGTH,
		PROPERTY_MEDIA_CONTROL_STYLE, EVENT_PROPERTY_MENU, PROPERTY_MESSAGE, INTENT_PROPERTY_MSG_ID,
		PROPERTY_MESSAGEID, PROPERTY_MESSENGER, PROPERTY_MESSENGER_RECEIVER, PROPERTY_MIDDLENAME,
		PROPERTY_MIMETYPE, PROPERTY_MIN, PROPERTY_MIN_AGE, PROPERTY_MIN_ROW_HEIGHT,
		PROPERTY_MIN_UPDATE_DISTANCE, PROPERTY_MIN_UPDATE_TIME, PROPERTY_MINUTE_INTERVAL, PROPERTY_MOBILE,
		PROPERTY_MODAL, PROPERTY_MOTHER, INTENT_PROPERTY_MSG_ACTIVITY_CREATED_ID, PROPERTY_NAME,
		PROPERTY_NAV_BAR_HIDDEN, EVENT_NEW_INTENT, PROPERTY_NICKNAME, PROPERTY_NOTE,
		PROPERTY_NUMBER, PROPERTY_OK, PROPERTY_OKID, PROPERTY_ON_CREATE_OPTIONS_MENU,
		PROPERTY_ON_CREATE_WINDOW, PROPERTY_ON_HOME_ICON_ITEM_SELECTED, PROPERTY_ON_PREPARE_OPTIONS_MENU, PROPERTY_ON_RECEIVED,
		PROPERTY_OPACITY, EVENT_OPEN, PROPERTY_OPTIONS, PROPERTY_ORDER,
		PROPERTY_ORGANIZATION, PROPERTY_ORIENTATION_MODES, PROPERTY_OTHER, PROPERTY_OVER_SCROLL_MODE,
		PROPERTY_PACKAGE_NAME, PROPERTY_PAGING_CONTROL_TIMEOUT, PROPERTY_PARENT, PROPERTY_PARTNER,
		PROPERTY_PASSWORD, PROPERTY_PASSWORD_MASK, EVENT_PAUSE, PROPERTY_PERSISTENT,
		PROPERTY_PHONE, EVENT_PINCH, PROPERTY_PINCOLOR, PROPERTY_PIN_IMAGE,
		PROPERTY_PLACES, PROPERTY_PLAY, PROPERTY_PLAYABLE_DURATION, EVENT_PLAYBACK_STATE,
		PROPERTY_PLUGIN_STATE, PROPERTY_POSITION, PROPERTY_POSTAL_CODE, EVENT_POST_LAYOUT,
		PROPERTY_POWER, PROPERTY_PREFERRED_PROVIDER, EVENT_PRELOAD, EVENT_PROPERTY_PREVIOUS_INDEX,
		EVENT_PROPERTY_PREVIOUS_TAB, PROPERTY_PROVIDER, EVENT_PROPERTY_REASON, PROPERTY_REFERRED_BY,
		PROPERTY_REGION, PROPERTY_REGION1, PROPERTY_REGION2, EVENT_REGION_CHANGED,
		PROPERTY_REGION_FIT, PROPERTY_RELATED_NAMES, PROPERTY_REPEAT, PROPERTY_REPEAT_COUNT,
		EVENT_PROPERTY_REQUEST_CODE, EVENT_RESTART, EVENT_PROPERTY_RESULT_CODE, EVENT_RESUME,
		PROPERTY_RETURN_KEY_TYPE, PROPERTY_REVERSE, PROPERTY_RIGHT, PROPERTY_RIGHT_BUTTON,
		PROPERTY_RIGHT_IMAGE, PROPERTY_RIGHT_VIEW, PROPERTY_ROTATE, EVENT_PROPERTY_ROW,
		PROPERTY_ROW_DATA, PROPERTY_ROW_HEIGHT, PROPERTY_SCALE, PROPERTY_SCALES_PAGE_TO_FIT,
		PROPERTY_SCALING_MODE, EVENT_SCROLL, PROPERTY_SCROLL_ENABLED, EVENT_SCROLLEND,
		PROPERTY_SCROLLING_ENABLED, PROPERTY_SCROLL_TYPE, PROPERTY_SEARCH, PROPERTY_SEARCH_AS_CHILD,
		EVENT_PROPERTY_SEARCH_MODE, PROPERTY_SECTION, PROPERTY_SELECTED_BACKGROUND_COLOR, PROPERTY_SELECTED_BACKGROUND_IMAGE,
		PROPERTY_SELECTED_INDEX, PROPERTY_SELECTION_INDICATOR, PROPERTY_SEPARATOR_COLOR, PROPERTY_SHOW_AS_ACTION,
		PROPERTY_SHOW_HORIZONTAL_SCROLL_INDICATOR, PROPERTY_SHOW_PAGING_CONTROL, PROPERTY_SHOW_PROGRESS, PROPERTY_SHOW_VERTICAL_SCROLL_INDICATOR,
		EVENT_SINGLE_TAP, PROPERTY_SISTER, PROPERTY_SIZE, PROPERTY_SOFT_KEYBOARD_ON_FOCUS,
		PROPERTY_SOUND, EVENT_PROPERTY_SOURCE, PROPERTY_SOURCE_LENGTH, PROPERTY_SOURCE_POSITION,
		PROPERTY_SPEED, PROPERTY_SPOUSE, MSG_PROPERTY_SRC, EVENT_START,
		INTENT_PROPERTY_START_MODE, PROPERTY_STATE, PROPERTY_STATUS, EVENT_STOP,
		PROPERTY_STREET, PROPERTY_STREET1, PROPERTY_STYLE, EVENT_SUBMIT,
		PROPERTY_SUBMIT_ENABLED, PROPERTY_SUBTITLE, PROPERTY_SUBTITLEID, PROPERTY_SUCCESS,
		EVENT_SWIPE, EVENT_PROPERTY_TAB, PROPERTY_TAB_OPEN, PROPERTY_TABS,
		PROPERTY_TABS_BACKGROUND_COLOR, PROPERTY_TABS_BACKGROUND_SELECTED_COLOR, PROPERTY_TAG, PROPERTY_TEXT,
		PROPERTY_TEXT_ALIGN, PROPERTY_TEXTID, EVENT_PROPERTY_THUMB_OFFSET, EVENT_PROPERTY_THUMB_SIZE,
		PROPERTY_TICKER_TEXT, PROPERTY_TIME, PROPERTY_TIMEOUT, PROPERTY_TIMESTAMP,
		PROPERTY_TITLE, PROPERTY_TITLE_CONDENSED, PROPERTY_TITLEID, PROPERTY_TITLE_OFF,
		PROPERTY_TITLE_ON, PROPERTY_TITLE_PROMPT, PROPERTY_TITLE_PROMPTID, PROPERTY_TO,
		PROPERTY_TOP, EVENT_TOUCH_CANCEL, PROPERTY_TOUCH_ENABLED, EVENT_TOUCH_END,
		EVENT_TOUCH_MOVE, EVENT_TOUCH_START, PROPERTY_TRANSFORM, PROPERTY_TRUE_HEADING,
		EVENT_TWOFINGERTAP, PROPERTY_TYPE, EVENT_UNFOCUSED, PROPERTY_UPDATE_CURRENT_INTENT,
		PROPERTY_URI, PROPERTY_URL, INTENT_PROPERTY_USE_ACTIVITY_WINDOW, PROPERTY_USER_LOCATION,
		PROPERTY_USERNAME, PROPERTY_VALUE, EVENT_PROPERTY_VELOCITY, LAYOUT_VERTICAL,
		PROPERTY_VERTICAL_ALIGN, PROPERTY_VIBRATE_PATTERN, PROPERTY_VIEW, PROPERTY_VIEWS,
		PROPERTY_VISIBLE, PROPERTY_VISIBLE_ITEMS, PROPERTY_VOLUME, PROPERTY_WHEN,
		PROPERTY_WIDTH, PROPERTY_WINDOW, INTENT_PROPERTY_WINDOW_ID, PROPERTY_WINDOW_PIXEL_FORMAT,
		PROPERTY_WINDOW_SOFT_INPUT_MODE, PROPERTY_WORD_WRAP, PROPERTY_WORK, PROPERTY_X,
		PROPERTY_Y, PROPERTY_Z, PROPERTY_ZINDEX, PROPERTY_ZOOM_ENABLED
	};

	public static final int JNI_DATATYPE_END_OF_LIST = 0;
	public static final int JNI_DATATYPE_OTHER = 1;
	public static final int JNI_DATATYPE_BOOL = 2;
	public static final int JNI_DATATYPE_CHAR = 3;
	public static final int JNI_DATATYPE_SHORT = 4;
	public static final int JNI_DATATYPE_INT = 5;
	public static final int JNI_DATATYPE_LONG = 6;
	public static final int JNI_DATATYPE_FLOAT = 7;
	public static final int JNI_DATATYPE_DOUBLE = 8;
	public static final int JNI_DATATYPE_OBJECT = 9;
	public static final int JNI_DATATYPE_STRING = 10;
	public static final int JNI_DATATYPE_DATE = 11;
	public static final int JNI_DATATYPE_ARRAY = 12;
	public static final int JNI_DATATYPE_HASH = 13;
	public static final int JNI_DATATYPE_KROLLARRAY = 14;
	public static final int JNI_DATATYPE_KROLLDICT = 15;
	public static final int JNI_DATATYPE_LONG_ARRAY = 16;
	public static final int JNI_DATATYPE_FLOAT_ARRAY = 17;
	
}
