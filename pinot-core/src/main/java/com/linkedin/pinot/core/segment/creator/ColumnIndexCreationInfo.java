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
package com.linkedin.pinot.core.segment.creator;

import java.util.List;
import org.apache.commons.lang.math.IntRange;
import org.apache.commons.lang3.ArrayUtils;
import com.linkedin.pinot.core.common.Constants;
import com.linkedin.pinot.core.data.partition.PartitionFunction;


public class ColumnIndexCreationInfo {
  private final boolean createDictionary;
  private final Object min;
  private final Object max;
  private final Object sortedUniqueElementsArray;
  private final ForwardIndexType forwardIndexType;
  private final InvertedIndexType invertedIndexType;
  private boolean isSorted;
  private final boolean hasNulls;
  private final int totalNumberOfEntries;
  private final int maxNumberOfMultiValueElements;
  private final int legnthOfLongestEntry;
  private final boolean isAutoGenerated;
  private final PartitionFunction partitionFunction;
  private final List<IntRange> partitionRanges;
  private final Object defaultNullValue;
  private int numPartitions;

  public ColumnIndexCreationInfo(boolean createDictionary, Object min, Object max, Object sortedUniqueElementsArray,
      ForwardIndexType forwardIndexType, InvertedIndexType invertedIndexType, boolean isSorted, boolean hasNulls,
      int totalNumberOfEntries, int maxNumberOfMultiValueElements, int legnthOfLongestEntry, boolean isAutoGenerated,
      PartitionFunction partitionFunction, int numPartitions, List<IntRange> partitionRanges, Object defaultNullValue) {
    this.createDictionary = createDictionary;
    this.min = min;
    this.max = max;
    this.sortedUniqueElementsArray = sortedUniqueElementsArray;
    this.forwardIndexType = forwardIndexType;
    this.invertedIndexType = invertedIndexType;
    this.isSorted = isSorted;
    this.hasNulls = hasNulls;
    this.totalNumberOfEntries = totalNumberOfEntries;
    this.maxNumberOfMultiValueElements = maxNumberOfMultiValueElements;
    this.legnthOfLongestEntry = legnthOfLongestEntry;
    this.isAutoGenerated = isAutoGenerated;
    this.partitionFunction = partitionFunction;
    this.numPartitions = numPartitions;
    this.partitionRanges = partitionRanges;
    this.defaultNullValue = defaultNullValue;
  }

  public boolean isCreateDictionary() {
    return createDictionary;
  }

  public Object getMin() {
    return min;
  }

  public Object getMax() {
    return max;
  }

  public Object getSortedUniqueElementsArray() {
    return sortedUniqueElementsArray;
  }

  public int getDistinctValueCount() {
    if (sortedUniqueElementsArray == null) {
      return Constants.UNKNOWN_CARDINALITY;
    }
    return ArrayUtils.getLength(sortedUniqueElementsArray);
  }

  public ForwardIndexType getForwardIndexType() {
    return forwardIndexType;
  }

  public InvertedIndexType getInvertedIndexType() {
    return invertedIndexType;
  }

  public boolean isSorted() {
    return isSorted;
  }

  public void setSorted(boolean value) {
    isSorted = value;
  }

  public boolean hasNulls() {
    return hasNulls;
  }

  public int getTotalNumberOfEntries() {
    return totalNumberOfEntries;
  }

  public int getMaxNumberOfMultiValueElements() {
    return maxNumberOfMultiValueElements;
  }

  public boolean isAutoGenerated() {
    return isAutoGenerated;
  }

  public Object getDefaultNullValue() {
    return defaultNullValue;
  }

  public int getLegnthOfLongestEntry() {
    return legnthOfLongestEntry;
  }

  public List<IntRange> getPartitionRanges() {
    return partitionRanges;
  }

  public PartitionFunction getPartitionFunction() {
    return partitionFunction;
  }

  public int getNumPartitions() {
    return numPartitions;
  }
}
