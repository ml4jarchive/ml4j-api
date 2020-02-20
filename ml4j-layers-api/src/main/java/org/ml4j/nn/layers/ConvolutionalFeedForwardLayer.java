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

import java.util.Optional;

import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.axons.ConvolutionalAxons;
import org.ml4j.nn.components.DirectedComponentsContext;

/**
 * A ConvolutionalFeedForwardLayer is a FeedForwardLayer which composes input neurons and output
 * neurons that are arranged in 3D volumes into directed acyclic bipartite graph in such a 
 * way that each output neurons is connected to a local region of the input volume 
 *  ( a convolution ).
 * There are no input-input connections or output-output connections, only input-output connections.
 * 
 * @author Michael Lavelle
 *
 */
public interface ConvolutionalFeedForwardLayer 
    extends FeedForwardLayer<ConvolutionalAxons, ConvolutionalFeedForwardLayer> {
  
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
  
  /**
   * @return The amount of zero padding.
   */
  int getZeroPadding();
  
  
  /**
   * @param directedComponentsContext The DirectedComponentsContext.
   * @return The AxonsContext of the primary axons of this DirectedLayer.
   */
  AxonsContext getPrimaryAxonsContext(DirectedComponentsContext directedComponentsContext);
  
  /**
   * @param directedComponentsContext The DirectedComponentsContext.
   * @return The AxonsContext of the batch norm axons of this DirectedLayer if batch norm has been configured.
   */
  Optional<AxonsContext> getBatchNormAxonsContext(DirectedComponentsContext directedComponentsContext);


}
