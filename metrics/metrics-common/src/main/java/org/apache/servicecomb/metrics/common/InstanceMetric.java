/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.metrics.common;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstanceMetric {
  private final SystemMetric systemMetric;

  private final ConsumerInvocationMetric consumerMetric;

  private final ProducerInvocationMetric producerMetric;

  public SystemMetric getSystemMetric() {
    return systemMetric;
  }

  public ConsumerInvocationMetric getConsumerMetric() {
    return consumerMetric;
  }

  public ProducerInvocationMetric getProducerMetric() {
    return producerMetric;
  }

  public InstanceMetric(@JsonProperty("systemMetric") SystemMetric systemMetric,
      @JsonProperty("consumerMetric") ConsumerInvocationMetric consumerMetric,
      @JsonProperty("producerMetric") ProducerInvocationMetric producerMetric) {
    this.systemMetric = systemMetric;
    this.consumerMetric = consumerMetric;
    this.producerMetric = producerMetric;
  }

  public Map<String, Number> toMap() {
    Map<String, Number> metrics = new HashMap<>();
    metrics.putAll(systemMetric.toMap());
    metrics.putAll(consumerMetric.toMap());
    metrics.putAll(producerMetric.toMap());
    return metrics;
  }
}
