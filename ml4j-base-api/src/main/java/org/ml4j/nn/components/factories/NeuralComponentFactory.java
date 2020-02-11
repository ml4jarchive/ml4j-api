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
package org.ml4j.nn.components.factories;

import java.util.List;

import org.ml4j.Matrix;
import org.ml4j.nn.activationfunctions.ActivationFunctionProperties;
import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.axons.Axons3DConfig;
import org.ml4j.nn.axons.BiasMatrix;
import org.ml4j.nn.axons.WeightsMatrix;
import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.NeuralComponentType;
import org.ml4j.nn.components.manytoone.PathCombinationStrategy;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.Neurons3D;

/**
 * 
 * Factory interface whose implementations are responsible for creating
 * differentiable components required by DirectedNeuralNetworks
 * 
 * @author Michael Lavelle
 *
 */
public interface NeuralComponentFactory<T extends NeuralComponent<?>> {

	T createComponent(String name, Neurons leftNeurons, Neurons rightNeurons,
			NeuralComponentType neuralComponentType);

	/**
	 * Create a fully-connected axons component, connecting leftNeurons to
	 * rightNeurons via connectionWeights.
	 * 
	 * @param name 				The name of the component.
	 * @param leftNeurons       The neurons on the left of the fully-connected axons
	 *                          component.
	 * @param rightNeurons      The neurons on the right of the fully-connected
	 *                          axons component.
	 * @param connectionWeights Optionally specify the connection weights of the
	 *                          axons - if not provided the weights will be
	 *                          initialised to defaults.
	 * @param biases            Optionally specify the left-to-right biases of the
	 *                          axons - if not provided the biases will be
	 *                          initialised to defaults if the LHS neurons have a
	 *                          bias unit.
	 * @return A fully-connected axons component, connecting leftNeurons to
	 *         rightNeurons via connectionWeights.
	 */
	T createFullyConnectedAxonsComponent(String name, Neurons leftNeurons, Neurons rightNeurons, WeightsMatrix connectionWeights,
			BiasMatrix biases);

	/**
	 * 
	 * Create a convolutional axons component.
	 * 
	 * @param name 				The name of the component.
	 * @param leftNeurons       The neurons on the left of the convolutional axons
	 *                          component.
	 * @param rightNeurons      The neurons on the right of the convolutional axons
	 *                          component.
	 * @param config            The Axons3DConfig.
	 * @param connectionWeights Optionally specify the convolutional connection
	 *                          weights of the axons - if not provided the weights
	 *                          will be initialised to defaults.
	 * @param biases            Optionally specify the left-to-right biases of the
	 *                          axons - if not provided the biases will be
	 *                          initialised to defaults if the LHS neurons have a
	 *                          bias unit.
	 * @return A fully-connected axons component, connecting leftNeurons to
	 *         rightNeurons convolutionally via convolutional connectionWeights.
	 */
	T createConvolutionalAxonsComponent(String name, Neurons3D leftNeurons, Neurons3D rightNeurons, Axons3DConfig config,
			WeightsMatrix connectionWeights, BiasMatrix biases);

	/**
	 * Create a max-pooling axons component.
	 * 
	 * @param name 		   The name of the component.
	 * @param leftNeurons  The neurons on the left of the max pooling axons
	 *                     component.
	 * @param rightNeurons The neurons on the right of the max pooling axons
	 *                     component.
	 * @param config       The Axons3DConfig.
	 * @param scaleOutputs Whether to scale the output of the max pooling axons by a
	 *                     scaling factor to compensate for the max-pooling dropout.
	 * @return A max-pooling axons component.
	 */
	T createMaxPoolingAxonsComponent(String name, Neurons3D leftNeurons, Neurons3D rightNeurons, Axons3DConfig config,
			boolean scaleOutputs);

	/**

	 * Create an average-pooling axons component.
	 * 
	 * @param name 		   The name of the component.
	 * @param leftNeurons  The neurons on the left of the average pooling axons
	 *                     component.
	 * @param rightNeurons The neurons on the right of the average pooling axons
	 *                     component.
	 * @param config       The Axons3DConfig.
	 * @return An average-pooling axons component.
	 */
	T createAveragePoolingAxonsComponent(String name, Neurons3D leftNeurons, Neurons3D rightNeurons, Axons3DConfig config);

	/**
	 * Create a batch-norm directed axons component with default initialised
	 * weights.
	 * 
	 * @param <N>          The type of neurons on the LHS/RHS of these axons.
	 * @param name 		   The name of the component.
	 * @param leftNeurons  The left neurons.
	 * @param rightNeurons The right neurons.
	 * @return A batch-norm directed axons component with default initialised
	 *         weights.
	 */
	<N extends Neurons> T createBatchNormAxonsComponent(String name, N leftNeurons, N rightNeurons);

	/**
	 * 
	 * @param <N>          The type of neurons on the LHS/RHS of these axons.
	 * 
	 * @param name 				The name of the component.
	 * @param leftNeurons  The left neurons.
	 * @param rightNeurons The right neurons.
	 * @param gamma        The initial scaling column vector with which to
	 *                     initialise the axons.
	 * @param beta         The initial shift column vector with which to initialise
	 *                     the axons.
	 * @param mean         The mean with which to initialise the component.
	 * @param var          The variance with which to initialise the component.
	 * @return The BatchNormDirectedAxonsComponent.
	 */
	<N extends Neurons> T createBatchNormAxonsComponent(String name, N leftNeurons, N rightNeurons, WeightsMatrix gamma, BiasMatrix beta,
			Matrix mean, Matrix var);

	/**
	 * Create a convolutional batch-norm directed axons component with default
	 * initialised weights.
	 * 
	 * Convolutional batch-norm axon components have a single mean/variance value
	 * for each depth.
	 * 
	 * @param name 				The name of the component.
	 * @param leftNeurons  The left neurons.
	 * @param rightNeurons The right neurons.
	 * @return A convolutional batch-norm directed axons component with default
	 *         initialised weights.
	 */
	T createConvolutionalBatchNormAxonsComponent(String name, Neurons3D leftNeurons, Neurons3D rightNeurons);

	/**
	 * Create a convolutional batch-norm directed axons component with specified
	 * weights.
	 * 
	 * Convolutional batch-norm axon components have a single mean/variance value
	 * for each depth.
	 * 
	 * @param name 		   The name of the component.
	 * @param leftNeurons  The left neurons.
	 * @param rightNeurons The right neurons
	 * @param gamma        The initial scaling column vector with which to
	 *                     initialise the axons.
	 * @param beta         The initial shift column vector with which to initialise
	 *                     the axons.
	 * @param mean         The mean with which to initialise the component.
	 * @param var          The variance with which to initialise the component.
	 * @return The BatchNormDirectedAxonsComponent.
	 */
	T createConvolutionalBatchNormAxonsComponent(String name, Neurons3D leftNeurons, Neurons3D rightNeurons, WeightsMatrix gamma,
			BiasMatrix beta, Matrix mean, Matrix var);

	/**
	 * Construct a pass-through (no-op) axons component - used within residual
	 * networks for skip-connections.
	 * 
	 * @param <N>          The type of neurons on the LHS/RHS of the pass-through
	 *                     axons.
	 *                     
	 * @param name 		   The name of the component.            
	 * @param leftNeurons  The neurons on the LHS of these pass-through axons.
	 * @param rightNeurons The neurons on the RHS of these pass-through axons.
	 * @return A pass-through (no-op) axons component
	 */
	<N extends Neurons> T createPassThroughAxonsComponent(String name, N leftNeurons, N rightNeurons);

	/**
	 * Construct a DifferentiableActivationFunctionComponent.
	 * 
	 * @param name 								The name of the component.
	 * @param neurons                          The neurons at which the
	 *                                         DifferentiableActivationFunctionComponent
	 *                                         will activate.
	 * @param differentiableActivationFunction The differentiable activation
	 *                                         function to be wrapped by this
	 *                                         component.
	 * @return A DifferentiableActivationFunctionComponent.
	 */
	T createDifferentiableActivationFunctionComponent(String name, Neurons neurons,
			DifferentiableActivationFunction differentiableActivationFunction);

	/**
	 * Construct a DifferentiableActivationFunctionComponent.
	 * 
	 * @param name 				     The name of the component.
	 * @param neurons                The neurons at which the
	 *                               DifferentiableActivationFunctionComponent will
	 *                               activate.
	 * @param activationFunctionType The activation function type.
	 * @param activationFunctionProperties The properties we wish to set on the activation function.
	 * @return A DifferentiableActivationFunctionComponent.
	 */
	T createDifferentiableActivationFunctionComponent(String name, Neurons neurons, ActivationFunctionType activationFunctionType, ActivationFunctionProperties activationFunctionProperties);

	/**
	 * Construct a DefaultDirectedComponentChain instance.
	 * 
	 * @param sequentialComponents A list of the sequential
	 *                             DefaultChainableDirectedComponents that this
	 *                             chain will contain
	 * @return The DefaultDirectedComponentChain instance
	 */
	T createDirectedComponentChain(List<T> sequentialComponents);

	/**
	 * Construct a DefaultDirectedComponentBipoleGraph instance.
	 * 
	 * @param name					  The component name.
	 * @param inputNeurons            The neurons on the LHS of the bipole graph.
	 * @param outputNeurons           The neurons on the RHS of the bipole graph.
	 * @param parallelComponents      The list of parallel components, connecting the
	 *                                input neurons to the output neurons.
	 * @param pathCombinationStrategy The strategy specifying how the outputs of the
	 *                                parallel chains are combined to produce the
	 *                                output.
	 * @return A DefaultDirectedComponentBipoleGraph instance.
	 */
	T createDirectedComponentBipoleGraph(String name, Neurons inputNeurons, Neurons outputNeurons, List<T> parallelComponents,
			PathCombinationStrategy pathCombinationStrategy);

}
