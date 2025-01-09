/*
 * Copyright Terracotta, Inc.
 * Copyright IBM Corp. 2024, 2025
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.corestorage.bigmemory.serializers;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.terracotta.corestorage.Serializer;

/**
 *
 * @author cdennis
 */
public class ByteArraySerializer extends Serializer<byte[]> {
  
  public static final Serializer<byte[]> INSTANCE = new ByteArraySerializer();

  private ByteArraySerializer() {
    //hidden
  }
  
  @Override
  public byte[] recover(ByteBuffer buffer) throws IOException {
    byte[] data = new byte[buffer.remaining()];
    buffer.get(data);
    return data;
  }

  @Override
  public ByteBuffer transform(byte[] original) throws IOException {
    return ByteBuffer.wrap(original);
  }

  @Override
  public boolean equals(byte[] left, ByteBuffer right) throws IOException {
    return right.equals(ByteBuffer.wrap(left));
  }
  
}
