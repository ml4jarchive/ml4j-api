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

package org.ml4j.nn.synapses;

import org.ml4j.Matrix;
import org.ml4j.nn.neurons.Neurons;

/**
 * Batch norm directed synapses are responsible for normalising the *output* of their primary 
 * Axons before running the activations through an ActivationFunction.
 * 
 * <p>These synapses have the feature mean and variance row vectors as attributes.  These
 * are built up using exponentially weighted averages on backpropagation and can be serialized
 * along the with Layer for use at test time.
 * 
 * @author Michael Lavelle
 *
 * @param <L> The type of Neurons on the left of these BatchNormDirectedSynapses.
 * @param <R> The type of Neurons on the right of these BatchNormDirectedSynapses.
 */
public interface BatchNormDirectedSynapses<L extends Neurons, R extends Neurons>
    extends DirectedSynapses<L, R> {

  /**
   * @return A row vector of the exponentially weighted average input feature means.
   */
  Matrix getExponentiallyWeightedAverageInputFeatureMeans();

  /**
   * @return A row vector of the exponentially weighted average input feature variances.
   */
  Matrix getExponentiallyWeightedAverageInputFeatureVariances();
  
  /**
   * @param meansRowVector  A row vector of the exponentially weighted average input feature means.
   */
  void setExponentiallyWeightedAverageInputFeatureMeans(Matrix meansRowVector);

  /**
   * @param variancesRowVector A row vector of the exponentially weighted average 
   *        input feature variances.
   */
  void setExponentiallyWeightedAverageInputFeatureVariances(Matrix variancesRowVector);

  /**
   * @return The parameter "beta" used in the calculation of the exponentially weighted averages.
   */
  double getBetaForExponentiallyWeightedAverages();
}
