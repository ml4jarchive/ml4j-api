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

import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.synapses.Synapses;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a Layer of a NeuralNetwork.
 * 
 * @author Michael Lavelle
 *
 * @param <L> The type of Layer
 */
public interface Layer<A extends Axons<?, ?, ?>, S extends Synapses<?, ?>, 
    L extends Layer<A, S, L>> extends Serializable {

  /**
   * Duplicates this Layer.
   * 
   * @return A deep clone of this Layer
   */
  L dup();
  
  /**
   * Each Layer is associated with a primary type of Axons, after which the Layer is often named.
   * For example, Fully Connected Layers contain FullyConnectedAxons, ConvolutionalLayers contain
   * ConvolutionalAxons.
   * Layers may contain other secondary Axons they may use for pre-or-post processing of
   * activations, for example, Axons which are to be trained for batch normalisation.
   * 
   * @return The primary Axons for this Layer
   */
  A getPrimaryAxons();
  
  /**
   * @return A list of all the Synapses in this Layer.
   */
  List<S> getSynapses();
}
