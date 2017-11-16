/*
 * Copyright 2017 the original author or authors.
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

package org.ml4j.nn.axons;

import org.ml4j.nn.neurons.Neurons3D;

/**
 * Encapsulates the connections between two sets of Neurons which are 
 * convolutionally connected (ie. each Neuron on the right of the Axons 
 * is connected to locally connected region on the left )
 * 
 * @author Michael Lavelle
 *
 */
public interface ConvolutionalAxons
    extends TrainableAxons<Neurons3D, Neurons3D, ConvolutionalAxons> {

  /**
   * @return The stride.
   */
  int getStride();

  /**
   * @return The amount of zero padding.
   */
  int getZeroPadding();
  
}
