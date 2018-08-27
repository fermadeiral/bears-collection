/**
 * Copyright (C) 2014-2016 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.pinot.core.util;

public class DoubleComparisonUtil {

  private static double DEFAULT_EPSILON = 0.000001;

  public static int defaultDoubleCompare(double d1, double d2) {
    return doubleCompare(d1, d2, DEFAULT_EPSILON);
  }

  public static int doubleCompare(double d1, double d2, double epsilon) {
    if (d1 > d2) {
      if (d1 * (1 - epsilon) > d2) {
        return 1;
      } else {
        return 0;
      }
    }
    if (d2 > d1) {
      if (d2 * (1 - epsilon) > d1) {
        return -1;
      } else {
        return 0;
      }
    }
    return 0;
  }
}
