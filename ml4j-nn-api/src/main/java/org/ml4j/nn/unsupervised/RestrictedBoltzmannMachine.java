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

package org.ml4j.nn.unsupervised;

import org.ml4j.nn.UndirectedNeuralNetwork;
import org.ml4j.nn.axons.FullyConnectedAxons;
import org.ml4j.nn.layers.RestrictedBoltzmannLayer;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Interface for a RestrictedBoltzmannMachine.
 * 
 * @author Michael Lavelle
 */
public interface RestrictedBoltzmannMachine extends UndirectedNeuralNetwork<
      RestrictedBoltzmannLayer<FullyConnectedAxons>, 
      RestrictedBoltzmannMachineContext, RestrictedBoltzmannMachine>,
      UnsupervisedNeuralNetwork<RestrictedBoltzmannLayer<FullyConnectedAxons>, 
      RestrictedBoltzmannMachineContext, RestrictedBoltzmannMachine> {
  
  /**
   * Perform cdn steps of alternating Gibbs sampling
   * 
   * @param visibleActivations The initial visible activations.
   * @param cdn The number of alternating Gibbs steps - set to 1 for cd1.
   * @param context The Context.
   * @return The sampling activation.
   */
  RestrictedBoltzmannSamplingActivation performGibbsSampling(
      NeuronsActivation visibleActivations, int cdn, 
      RestrictedBoltzmannMachineContext context);
  
  /**
   * @return An AutoEncoder initialised with the layers configurations and weights of 
   *        this RestrictedBoltzmannMachine.
   */
  AutoEncoder createAutoEncoder();

}
