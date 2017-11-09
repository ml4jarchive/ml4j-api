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

import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Encapsulates the artifacts produced when propagating NeuronsActivations
 * through a DirectedLayer.
 * 
 * @author Michael Lavelle
 */
public interface DirectedLayerActivation {

  /**
   * @return The NeuronsActivation output from a propagation 
   *        through a DirectedLayer.
   */
  NeuronsActivation getOutput();
  
  /**
   * @return The DirectedLayer that generated this DirectedLayerActivation.
   */
  DirectedLayer<?,?> getLayer();
  
  /**
   * @param outerGradient The outer gradient to back propagate.
   * @param layerContext The layer context.
   * @param outerMostLayer Whether this is the outer most Layer of a NeuralNetwork.
   * @return The back propagated DirectedLayerGradient.
   */
  DirectedLayerGradient backPropagate(NeuronsActivation outerGradient, 
      DirectedLayerContext layerContext, boolean outerMostLayer);
  
  /**
   * @param primaryAxonsRegularisationLambda The regularisation lambda for the primary axons in
   *        this DirectedLayer.
   * @return The total regularisation cost of this activation.
   */
  double getTotalRegularisationCost(double primaryAxonsRegularisationLambda);
  
  /**
   * @param primaryAxonsRegularisationLambda The regularisation lambda for the primary axons in
   *        this DirectedLayer.
   * @return The average regularisation cost of this activation.
   */
  double getAverageRegularistationCost(double primaryAxonsRegularisationLambda);
}
