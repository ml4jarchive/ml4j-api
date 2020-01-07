/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ml4j.nn.layers;

import org.ml4j.nn.axons.PoolingAxons;

/**
 * A PoolingFeedForwardLayer is a FeedForwardLayer whose primary Axons are PoolingAxons.
 * 
 * @author Michael Lavelle
 * 
 * @param <A> The type of PoolingAxons within this PoolingFeedForwardLayer.
 * @param <L> The type of PoolingFeedForwardLayer
 */
public interface PoolingFeedForwardLayer<A extends PoolingAxons<?>, 
    L extends PoolingFeedForwardLayer<A, L>> 
    extends FeedForwardLayer<A, L> {
  
  /**
   * @return The stride.
   */
  int getStride();

  /**
   * @return THe filter width.
   */
  int getFilterWidth();

  /**
   * @return The filter height.
   */
  int getFilterHeight();
}
