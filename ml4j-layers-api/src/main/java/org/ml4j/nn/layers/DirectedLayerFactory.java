/*
 * Copyright 2020 the original author or authors.
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

import org.ml4j.nn.activationfunctions.ActivationFunctionProperties;
import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.axons.BatchNormAxonsConfig;
import org.ml4j.nn.axons.BiasVector;
import org.ml4j.nn.axons.ConvolutionalAxonsConfig;
import org.ml4j.nn.axons.FullyConnectedAxonsConfig;
import org.ml4j.nn.axons.PoolingAxonsConfig;
import org.ml4j.nn.axons.WeightsMatrix;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.Neurons3D;

/**
 * 
 * @author Michael Lavelle
 */
public interface DirectedLayerFactory {

	/**
	 * Create a Fully-Connected (Dense) Feed Forward Layer.
	 * 
	 * @param name                          The name of the layer.
	 * @param axonsConfig                   The left/right neurons axons config, and optionally
	 * 										configuration of AxonsContext.
	 * @param connectionWeights             The connection weights, or null if
	 *                                      connection weights are to be defaulted.
	 * @param biases                        The biases - these will be defaulted if
	 *                                      null and if the LHS neurons have a bias
	 *                                      unit.
	 * @param activationFunctionType        The type of activation function within
	 *                                      the layer.
	 * @param activationFunctionProperties  The properties to be passed to the
	 *                                      activation function.
	 * @param batchNormAxonsConfig               The config for batch normalisation in
	 *                                      this layer, or null if no batch norm
	 * @return The fully connected layer.
	 */
	FullyConnectedFeedForwardLayer createFullyConnectedFeedForwardLayer(String name,
			FullyConnectedAxonsConfig axonsConfig, WeightsMatrix connectionWeights, BiasVector biases,
			ActivationFunctionType activationFunctionType, ActivationFunctionProperties activationFunctionProperties,
			BatchNormAxonsConfig<Neurons> batchNormAxonsConfig);

	/**
	 * Create a MaxPoolingFeedForwardLayer
	 * 
	 * @param name          The name of the max-pooling layer.
	 * @param axonsConfig The config of the layer.
	 * @param scaleOutputs  Whether to scale the outputs of the layer by the pooling
	 *                      factor - usually set to false but provided for legacy
	 *                      compatibility.
	 * @return The max-pooling layer.
	 */
	MaxPoolingFeedForwardLayer createMaxPoolingFeedForwardLayer(String name, PoolingAxonsConfig axonsConfig,
			boolean scaleOutputs);

	/**
	 * @param name          The name of the average-pooling layer.
	 * @param axonsConfig   The config of the layer.
	 * @return The average-pooling layer.
	 */
	AveragePoolingFeedForwardLayer createAveragePoolingFeedForwardLayer(String name, PoolingAxonsConfig axonsConfig);

	/**
	 * @param name                          The name of the layer.
	 * @param axonsConfig                   The config of the layer, and optionally
	 * 										configuration of the AxonsContext.
	 * @param connectionWeights             The connection weights. If the
	 *                                      connection weights are to be defaulted,
	 *                                      pass in a non-null weights matrix that
	 *                                      contains a null matrix and the format of
	 *                                      the weights.
	 * @param biases                        The biases - these will be defaulted if
	 *                                      null and if the LHS neurons have a bias
	 *                                      unit.
	 * @param activationFunctionType        The type of activation function of this
	 *                                      layer.
	 * @param activationFunctionProperties  The properties to be passed to the
	 *                                      activation function.
	 * @param batchNormAxonsConfig          The config for batch normalisation in
	 *                                      this layer, or null if no batch norms
	 * @return The convolutional feed forward layer.
	 */
	ConvolutionalFeedForwardLayer createConvolutionalFeedForwardLayer(String name, ConvolutionalAxonsConfig axonsConfig, 
			WeightsMatrix connectionWeights, BiasVector biases, ActivationFunctionType activationFunctionType,
			ActivationFunctionProperties activationFunctionProperties, BatchNormAxonsConfig<Neurons3D> batchNormAxonsConfig);

}
