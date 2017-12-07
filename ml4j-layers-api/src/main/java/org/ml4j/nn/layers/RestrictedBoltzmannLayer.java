/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.ml4j.nn.layers;

import org.ml4j.nn.axons.TrainableAxons;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Interface for a RestrictedBoltzmannLayer.
 * 
 * @author Michael Lavelle
 *
 * @param <A> The type of Axons within this Layer.
 */
public interface RestrictedBoltzmannLayer<A extends TrainableAxons<?, ?, ?>> 
    extends UndirectedLayer<A, RestrictedBoltzmannLayer<A>> {
  
  /**
   * Obtain the input NeuronsActivation which maximises the output
   *        of the specified output neuron.
   * 
   * @param hiddenNeuronIndex The index of the hidden neuron we wish to obtain the
   *        hidden-neuron-activation maximising visible activation for.
   * @param undirectedLayerContext The undirected layer context
   * @return The visible NeuronsActivation which maximises the output
   *        of the specified hidden neuron.
   */
  NeuronsActivation getOptimalVisibleActivationsForHiddenNeuron(int hiddenNeuronIndex, 
      UndirectedLayerContext undirectedLayerContext);
  
}
