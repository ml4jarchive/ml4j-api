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

package org.ml4j.nn.supervised;

import org.ml4j.nn.NeuralNetwork;
import org.ml4j.nn.NeuralNetworkContext;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Base interface for classes representing a SupervisedNeuralNetwork.
 *
 * @param <L> The type of Layer
 * @param <C> The type of runtime NeuralNetworkContext used with this
 *            UnsupervisedNeuralNetwork
 * @param <N> The type of SupervisedNeuralNetwork
 */
public interface SupervisedNeuralNetwork<C extends NeuralNetworkContext, N extends SupervisedNeuralNetwork<C, N>>
		extends NeuralNetwork<C, N> {

	/**
	 * Trains the SupervisedNeuralNetwork.
	 * 
	 * @param trainingDataActivations The NeuronsActivation produced by the training
	 *                                data
	 * @param labelActivations        The NeuronsActivation produced by the training
	 *                                labels
	 * @param trainingContext         The NeuralNetworkContext used for training
	 */
	public void train(NeuronsActivation trainingDataActivations, NeuronsActivation labelActivations, C trainingContext);
}
