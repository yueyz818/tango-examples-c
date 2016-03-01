/*
 * Copyright 2014 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.projecttango.experiments.nativemotiontracking;

/**
 * Interfaces between native C++ code and Java code.
 */
public class TangoJNINative {
  static {
    System.loadLibrary("cpp_motion_tracking_example");
  }

  // Check that the installed version of the Tango API is up to date.
  public static native boolean checkTangoVersion(MotionTrackingActivity activity,
      int minTangoVersion);

  // Setup the configuration file of the Tango Service.
  public static native int setupConfig();

  // Connect the onPoseAvailable callback.
  public static native int connectCallbacks();

  // Connect to the Tango Service.
  // This function will start the Tango Service pipeline, in this case, it will
  // start Motion Tracking.
  public static native boolean connect();

  // Disconnect from the Tango Service, release all the resources that the app is
  // holding from the Tango Service.
  public static native void disconnect();

  // Release all resources that are allocated from the program.
  public static native void deleteResources();

  // Allocate OpenGL resources for rendering.
  public static native void initGlContent();

  // Setup the view port width and height.
  public static native void setupGraphic(int width, int height);

  // Main render loop.
  public static native void render();

  // Set screen rotation index.
  //
  // @param rotationIndex: the screen rotation index,
  //    the index is following Android screen rotation enum.
  //    see Android documentation for detail:
  //    http://developer.android.com/reference/android/view/Surface.html#ROTATION_0
  public static native void setScreenRotation(int rotationIndex);
}
