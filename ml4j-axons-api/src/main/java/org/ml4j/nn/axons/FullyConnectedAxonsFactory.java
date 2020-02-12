/*
 * Copyright 2019 the original author or authors.
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
package org.ml4j.nn.axons;

import java.io.Serializable;

import org.ml4j.nn.neurons.Neurons;

/**
 * Factory for FullyConnectedAxons instances.
 * 
 * @author Michael Lavelle
 *
 */
public interface FullyConnectedAxonsFactory extends Serializable {

	/**
	 * Construct a directed FullyConnectedAxons instance, with connection weights
	 * and left-to-right biases.
	 * 
	 * @param leftNeurons       The neurons on the LHS of the Axons.
	 * @param rightNeurons      The neurons on the RHS on the Axons.
	 * @param connectionWeights The connection weights connecting the leftNeurons to
	 *                          the rightNeurons.
	 * @param biases            The left-to-right biases for these
	 *                          FullyConnectedAxons.
	 * @return The FullyConnectedAxons instance.
	 */
	FullyConnectedAxons createFullyConnectedAxons(AxonsConfig<Neurons, Neurons> axonsConfig, WeightsMatrix connectionWeights,
	BiasMatrix biases);

	/**
	 * Construct an undirected FullyConnectedAxons instance, with connection weights
	 * and left-to-right and right-to-left biases.
	 * 
	 * @param leftNeurons       The neurons on the LHS of the Axons.
	 * @param rightNeurons      The neurons on the RHS on the Axons.
	 * @param connectionWeights The connection weights connecting the leftNeurons to
	 *                          the rightNeurons.
	 * @param leftToRightBiases The left-to-right biases for these
	 *                          FullyConnectedAxons.
	 * @param rightToLeftBiases The right-to-left biases for these
	 *                          FullyConnectedAxons.
	 * @return The FullyConnectedAxons instance.
	 */
	FullyConnectedAxons createFullyConnectedAxons(AxonsConfig<Neurons, Neurons> axonsConfig, WeightsMatrix connectionWeights,
			BiasMatrix leftToRightBiases, BiasMatrix rightToLeftBiases);

}
