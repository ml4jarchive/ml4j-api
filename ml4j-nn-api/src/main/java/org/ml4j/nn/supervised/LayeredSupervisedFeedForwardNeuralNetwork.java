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

import org.ml4j.nn.CostAndGradients;
import org.ml4j.nn.LayeredFeedForwardNeuralNetwork;
import org.ml4j.nn.LayeredFeedForwardNeuralNetworkContext;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Interface for a supervised FeedForwardNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public interface LayeredSupervisedFeedForwardNeuralNetwork extends
		SupervisedNeuralNetwork<LayeredFeedForwardNeuralNetworkContext, LayeredSupervisedFeedForwardNeuralNetwork>,
		LayeredFeedForwardNeuralNetwork<LayeredFeedForwardNeuralNetworkContext, LayeredSupervisedFeedForwardNeuralNetwork> {

	/**
	 * Trains the SupervisedNeuralNetwork.
	 * 
	 * @param trainingDataActivations  The NeuronsActivation produced by the
	 *                                 training data
	 * @param trainingLabelActivations The NeuronsActivation produced by the
	 *                                 training labels
	 * @param trainingContext          The NeuralNetworkContext used for training
	 */
	public void train(NeuronsActivation trainingDataActivations, NeuronsActivation trainingLabelActivations,
			LayeredFeedForwardNeuralNetworkContext trainingContext);

	/**
	 * Obtains the accuracy of this neural network given the inputs and desired
	 * classification activations.
	 * 
	 * @param inputActivations                 The input activations
	 * @param desiredClassificationActivations The desired classification
	 *                                         activations
	 * @param context                          The NeuralNetworkContext used for
	 *                                         classification
	 * @return The classification accuracy
	 */
	public float getClassificationAccuracy(NeuronsActivation inputActivations,
			NeuronsActivation desiredClassificationActivations, LayeredFeedForwardNeuralNetworkContext context);

	/**
	 * Obtains the cost and weight gradients calculated for the outputs of this
	 * FeedForwardNeuralNetwork
	 * 
	 * @param inputActivations         The NeuronsActivation produced by the input
	 *                                 data
	 * @param desiredOutputActivations The NeuronsActivation produced by the desired
	 *                                 output data.
	 * 
	 * @param trainingContext          The NeuralNetworkContext used for training
	 * @return The CostAndGradients for the provided parameters.
	 */
	public CostAndGradients getCostAndGradients(NeuronsActivation inputActivations,
			NeuronsActivation desiredOutputActivations, LayeredFeedForwardNeuralNetworkContext trainingContext);
}
