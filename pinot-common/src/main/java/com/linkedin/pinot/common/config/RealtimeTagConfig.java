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
package com.linkedin.pinot.common.config;

import com.linkedin.pinot.common.utils.ControllerTenantNameBuilder;
import org.apache.helix.HelixManager;


/**
 * Wrapper class over TableConfig for a realtime table
 * This class will help answer questions about what are consuming/completed tags for a table
 */
public class RealtimeTagConfig extends TagConfig {

  private String _consumingRealtimeServerTag;
  private String _completedRealtimeServerTag;

  private boolean _relocateCompletedSegments = false;

  public RealtimeTagConfig(TableConfig tableConfig, HelixManager helixManager) {
    super(tableConfig, helixManager);

    _consumingRealtimeServerTag = ControllerTenantNameBuilder.getRealtimeTenantNameForTenant(_serverTenant);
    _completedRealtimeServerTag = ControllerTenantNameBuilder.getRealtimeTenantNameForTenant(_serverTenant);
    if (!_consumingRealtimeServerTag.equals(_completedRealtimeServerTag)) {
      _relocateCompletedSegments = true;
    }
  }

  public String getConsumingServerTag() {
    return _consumingRealtimeServerTag;
  }

  public String getCompletedServerTag() {
    return _completedRealtimeServerTag;
  }

  public boolean isRelocateCompletedSegments() {
    return _relocateCompletedSegments;
  }
}

