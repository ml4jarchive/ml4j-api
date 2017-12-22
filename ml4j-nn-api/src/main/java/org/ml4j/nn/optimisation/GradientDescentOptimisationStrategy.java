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

package org.ml4j.nn.optimisation;

import org.ml4j.Matrix;
import org.ml4j.nn.DirectedNeuralNetworkContext;

import java.io.Serializable;

/**
 * Encapsulates a strategy for adjusting the gradient to optimise gradient descent.
 * 
 * @author Michael Lavelle
 */
public interface GradientDescentOptimisationStrategy extends Serializable {

  /**
   * Allows an optimisation strategy such as Momentum, RMSProp, Adam to adjust the axons gradient
   * before it is used for weight updates.
   * 
   * @param axonsGradient The pre-adjusted AxonsGradient.
   * @param axonsIndex The index of these Axons in the NeuralNetwork.
   * @param trainingContext The training context.
   * @param epochIndex The epoch index.
   * @param batchIndex The batch index within this epoch.
   * @param iterationIndex The iteration index.
   * @return The adjusted axons gradient
   */
  Matrix getAdjustedAxonsGradient(Matrix axonsGradient, int axonsIndex,
       DirectedNeuralNetworkContext trainingContext, 
       int epochIndex, int batchIndex, int iterationIndex);

}
