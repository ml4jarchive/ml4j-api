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

import org.ml4j.MatrixFactory;
import org.ml4j.nn.neurons.NeuronsActivation;
import org.ml4j.nn.synapses.UndirectedSynapsesActivation;

/**
 * Encapsulates the activations of a RestrictedBoltzmannLayer.
 * 
 * @author Michael Lavelle
 *
 */
public interface RestrictedBoltzmannLayerActivation {

  /**
   * @return The activation of the UndirectedSynapses in the RestrictedBoltzmannLayer.
   */
  UndirectedSynapsesActivation getSynapsesActivation();

  /**
   * @return The activation of the visible neurons representing the probabilities.
   */
  NeuronsActivation getVisibleActivationProbablities();
  
  /**
   * @param matrixFactory The matrix factory.
   * @return A binary sample of the visible neuron activations from the visible probabilities.
   */
  NeuronsActivation getVisibleActivationBinarySample(MatrixFactory matrixFactory);

  /**
   * @return The activation of the hidden neurons representing the probabilities.
   */
  NeuronsActivation getHiddenActivationProbabilities();
  
  /**
   * @param matrixFactory The matrix factory.
   * @return A binary sample of the hidden neuron activations from the hidden probabilities.
   */
  NeuronsActivation getHiddenActivationBinarySample(MatrixFactory matrixFactory);

}
