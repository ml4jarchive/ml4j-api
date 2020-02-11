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

package org.ml4j.nn.components.axons;

import org.ml4j.Matrix;
import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.components.AxonsContextAwareNeuralComponent;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.neurons.Neurons;

/**
 * Batch norm DirectedAxonsComponents are responsible for normalising the
 * *output* of their primary Axons before running the activations through an
 * ActivationFunction.
 * 
 * <p>
 * BatchNormDirectedAxonsComponents have the feature mean and variance column
 * vectors as attributes. These are built up using exponentially weighted
 * averages on backpropagation and can be serialized along the with
 * DirectedAxonsComponent for use at test time.
 * 
 * @author Michael Lavelle
 *
 * @param <N> The type of Neurons on the left and right of these
 *            BatchNormDirectedAxonsComponent.
 */
public interface BatchNormDirectedAxonsComponent<N extends Neurons, A extends Axons<N, N, ?>>
		extends DirectedAxonsComponent<N, N, A>, AxonsContextAwareNeuralComponent<DefaultChainableDirectedComponent<?, ?>> {

	/**
	 * @return A column vector of the exponentially weighted average input feature
	 *         means.
	 */
	Matrix getExponentiallyWeightedAverageInputFeatureMeans();

	/**
	 * @return A column vector of the exponentially weighted average input feature
	 *         variances.
	 */
	Matrix getExponentiallyWeightedAverageInputFeatureVariances();

	/**
	 * @param meansColumnVector A column vector of the exponentially weighted
	 *                          average input feature means.
	 */
	void setExponentiallyWeightedAverageInputFeatureMeans(Matrix meansColumnVector);

	/**
	 * @param variancesColumnVector A row vector of the exponentially weighted
	 *                              average input feature variances.
	 */
	void setExponentiallyWeightedAverageInputFeatureVariances(Matrix variancesColumnVector);

	/**
	 * @return The parameter "beta" used in the calculation of the exponentially
	 *         weighted averages.
	 */
	float getBetaForExponentiallyWeightedAverages();

	@Override
	BatchNormDirectedAxonsComponent<N, A> dup();
}
