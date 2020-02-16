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

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.ml4j.nn.CostAndGradients;
import org.ml4j.nn.FeedForwardNeuralNetwork;
import org.ml4j.nn.FeedForwardNeuralNetworkContext;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.datasets.LabeledData;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Interface for a supervised FeedForwardNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public interface SupervisedFeedForwardNeuralNetwork
		extends SupervisedNeuralNetwork<FeedForwardNeuralNetworkContext, SupervisedFeedForwardNeuralNetwork>,
		FeedForwardNeuralNetwork<FeedForwardNeuralNetworkContext, SupervisedFeedForwardNeuralNetwork> {

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
			FeedForwardNeuralNetworkContext trainingContext);

	/**
	 * Trains the SupervisedNeuralNetwork.
	 * 
	 * @param labeledTrainingDataActivations A stream of labelled NeuronsActivations produced by the
	 *                                 training data
	 * @param trainingContext          The NeuralNetworkContext used for training
	 */
	public void train(Stream<LabeledData<NeuronsActivation, NeuronsActivation>> labeledTrainingDataActivations,
			FeedForwardNeuralNetworkContext trainingContext);

	/**
	 * Trains the SupervisedNeuralNetwork.
	 * 
	 * @param labeledTrainingDataActivations A stream of labelled NeuronsActivations produced by the
	 *                                 training data
	 * @param trainingContext          The NeuralNetworkContext used for training
	 * @param onEpochAverageCostHandler A handler to be called on each epoch, passed the average cost for
	 * that epoch.
	 */
	public void train(
			Supplier<Stream<LabeledData<NeuronsActivation, NeuronsActivation>>> labeledTrainingDataActivations,
			FeedForwardNeuralNetworkContext trainingContext, Consumer<Float> onEpochAverageCostHandler);

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
			NeuronsActivation desiredClassificationActivations, FeedForwardNeuralNetworkContext context);

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
			NeuronsActivation desiredOutputActivations, FeedForwardNeuralNetworkContext trainingContext);
	
	/**
	 * @return A list of all the top level components in this SupervisedFeedForwardNeuralNetwork.  To get the expanded list of
	 * low level components, call the decompose() method.
	 */
	List<DefaultChainableDirectedComponent<?, ?>> getComponents();
}
