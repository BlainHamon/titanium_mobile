/*
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

#ifndef STRING_TABLE_H
#define STRING_TABLE_H

#include <v8.h>

namespace titanium {
class StringTable
{
public:
	// string lookup table methods.
	static int jsStringToStringTableIndex(v8::Handle<v8::String> jsString);
	static v8::Handle<v8::Value> stringTableIndexToJsString(int index);

	static bool stringTableIndexValid(int index);
	static v8::Handle<v8::String> stringTableIndexToJsStringUnsafe(int index);
};
}

#endif

