/* 
 * The contents of this file are subject to the Terracotta Public License Version
 * 2.0 (the "License"); You may not use this file except in compliance with the
 * License. You may obtain a copy of the License at 
 *
 *      http://terracotta.org/legal/terracotta-public-license.
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Covered Software is BigMemory Core Storage Implementation.
 *
 * The Initial Developer of the Covered Software is 
 *      Terracotta, Inc., a Software AG company
 */
package org.terracotta.corestorage.bigmemory;

import org.terracotta.corestorage.KeyValueStorageConfig;

/**
 *
 * @author cdennis
 */
public interface BigMemoryKeyValueStorageConfig<K, V> extends KeyValueStorageConfig<K, V> {

  int getInitialPageSize();
  
  int getMaximalPageSize();

  int getInitialTableSize();
  
  enum OffHeapMode {
    FULL, PARTIAL, KEYS_ONLY, MINIMAL;
  }
  
  OffHeapMode getOffHeapMode();
}