// Copyright (c) 2009 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.sdk.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.chromium.sdk.internal.tools.v8.V8Protocol;
import org.json.simple.JSONObject;

/**
 * A facility for storage and retrieval of handle objects using their "ref" IDs.
 */
public class HandleManager {

  private final Map<Long, JSONObject> refToHandle =
      Collections.synchronizedMap(new HashMap<Long, JSONObject>());

  void reset() {
    refToHandle.clear();
  }

  void putAll(Map<Long, JSONObject> map) {
    refToHandle.putAll(map);
  }

  void put(Long ref, JSONObject object) {
    refToHandle.put(ref, object);
  }

  void put(JSONObject object) {
    refToHandle.put(JsonUtil.getAsLong(object, V8Protocol.REF), object);
  }

  JSONObject getHandle(Long ref) {
    return refToHandle.get(ref);
  }
}