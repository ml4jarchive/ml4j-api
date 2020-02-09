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

import java.io.Serializable;
import java.util.List;

import org.ml4j.Matrix;
import org.ml4j.nn.activationfunctions.ActivationFunctionProperties;
import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.axons.Axons3DConfig;
import org.ml4j.nn.axons.BiasMatrix;
import org.ml4j.nn.axons.WeightsMatrix;
import org.ml4j.nn.components.activationfunctions.DifferentiableActivationFunctionComponent;
import org.ml4j.nn.components.axons.BatchNormDirectedAxonsComponent;
import org.ml4j.nn.components.axons.DirectedAxonsComponent;
import org.ml4j.nn.components.manytoone.ManyToOneDirectedComponent;
import org.ml4j.nn.components.manytoone.PathCombinationStrategy;
import org.ml4j.nn.components.onetomany.OneToManyDirectedComponent;
import org.ml4j.nn.components.onetomany.SerializableIntSupplier;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.components.onetone.DefaultDirectedComponentBipoleGraph;
import org.ml4j.nn.components.onetone.DefaultDirectedComponentChain;
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
public interface DirectedComponentFactory extends NeuralComponentFactory<DefaultChainableDirectedComponent<?, ?>>, Serializable {

	/**
	 * Create a fully-connected axons component, connecting leftNeurons to
	 * rightNeurons via connectionWeights.
	 * @param name				The name of the component.
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
	@Override
	DirectedAxonsComponent<Neurons, Neurons, ?> createFullyConnectedAxonsComponent(String name, Neurons leftNeurons,
			Neurons rightNeurons, WeightsMatrix connectionWeights, BiasMatrix biases);

	/**
	 * 
	 * Create a convolutional axons component.
	 * 
	 * @param name				The name of the component.
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
	@Override
	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createConvolutionalAxonsComponent(String name, Neurons3D leftNeurons,
			Neurons3D rightNeurons, Axons3DConfig config, WeightsMatrix connectionWeights, BiasMatrix biases);

	/**
	 * Create a max-pooling axons component.
	 * 
	 * @param name		   The name of the component.
	 * @param leftNeurons  The neurons on the left of the max pooling axons
	 *                     component.
	 * @param rightNeurons The neurons on the right of the max pooling axons
	 *                     component.
	 * @param config       The Axons3DConfig.
	 * @param scaleOutputs Whether to scale the output of the max pooling axons by a
	 *                     scaling factor to compensate for the max-pooling dropout.
	 * @return A max-pooling axons component.
	 */
	@Override
	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createMaxPoolingAxonsComponent(String name, Neurons3D leftNeurons,
			Neurons3D rightNeurons, Axons3DConfig config, boolean scaleOutputs);

	/**
	 * Create an average-pooling axons component.
	 * 
	 * @param name		   The name of the component.
	 * @param leftNeurons  The neurons on the left of the average pooling axons
	 *                     component.
	 * @param rightNeurons The neurons on the right of the average pooling axons
	 *                     component.
	 * @param config       The Axons3DConfig.
	 * @return An average-pooling axons component.
	 */
	@Override
	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createAveragePoolingAxonsComponent(String name, Neurons3D leftNeurons,
			Neurons3D rightNeurons, Axons3DConfig config);

	/**
	 * Create a batch-norm directed axons component with default initialised
	 * weights.
	 * 
	 * @param <N>          The type of neurons on the LHS/RHS of these axons.
	 * @param name		   The name of the component.
	 * @param leftNeurons  The left neurons.
	 * @param rightNeurons The right neurons.
	 * @return A batch-norm directed axons component with default initialised
	 *         weights.
	 */
	@Override
	<N extends Neurons> BatchNormDirectedAxonsComponent<N, ?> createBatchNormAxonsComponent(String name, N leftNeurons,
			N rightNeurons);

	/**
	 * 
	 * @param <N>          The type of neurons on the LHS/RHS of these axons.
	 * @param name		   The name of the component.
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
	@Override
	<N extends Neurons> BatchNormDirectedAxonsComponent<N, ?> createBatchNormAxonsComponent(String name, N leftNeurons,
			N rightNeurons, WeightsMatrix gamma, BiasMatrix beta, Matrix mean, Matrix var);

	/**
	 * Create a convolutional batch-norm directed axons component with default
	 * initialised weights.
	 * 
	 * Convolutional batch-norm axon components have a single mean/variance value
	 * for each depth.
	 * 
	 * @param name		   The name of the component.
	 * @param leftNeurons  The left neurons.
	 * @param rightNeurons The right neurons.
	 * @return A convolutional batch-norm directed axons component with default
	 *         initialised weights.
	 */
	@Override
	BatchNormDirectedAxonsComponent<Neurons3D, ?> createConvolutionalBatchNormAxonsComponent(String name, Neurons3D leftNeurons,
			Neurons3D rightNeurons);

	/**
	 * Create a convolutional batch-norm directed axons component with specified
	 * weights.
	 * 
	 * Convolutional batch-norm axon components have a single mean/variance value
	 * for each depth.
	 * 
	 * @param name				The name of the component.
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
	@Override
	BatchNormDirectedAxonsComponent<Neurons3D, ?> createConvolutionalBatchNormAxonsComponent(String name, Neurons3D leftNeurons,
			Neurons3D rightNeurons, WeightsMatrix gamma, BiasMatrix beta, Matrix mean, Matrix var);

	/**
	 * Construct a DirectedAxonsComponent adapter for the specified Axons.
	 * 
	 * @param <L>   The type of Neurons on the LHS of this DirectedAxonsComponent
	 * @param <R>   The type of Neurons on the RHS of this DirectedAxonsComponent
	 * @param name	The name of the component.
	 * @param axons The Axons to be wrapped inside the DirectedAxonsComponent.
	 * @return DirectedAxonsComponent wrapping the specified Axons.
	 */
	<L extends Neurons, R extends Neurons> DirectedAxonsComponent<L, R, ?> createDirectedAxonsComponent(String name, 
			Axons<L, R, ?> axons);

	/**
	 * Construct a pass-through (no-op) axons component - used within residual
	 * networks for skip-connections.
	 * 
	 * @param <N>          The type of neurons on the LHS/RHS of the pass-through
	 *                     axons.
	 * @param name		   The name of the component.
	 * @param leftNeurons  The neurons on the LHS of these pass-through axons.
	 * @param rightNeurons The neurons on the RHS of these pass-through axons.
	 * @return A pass-through (no-op) axons component
	 */
	@Override
	<N extends Neurons> DirectedAxonsComponent<N, N, ?> createPassThroughAxonsComponent(String name, N leftNeurons, N rightNeurons);

	/**
	 * Construct a OneToManyDirectedComponent.
	 * 
	 * @param targetComponentsCount A supplier for the number of target components
	 *                              into which we wish to map the single input - can
	 *                              be a dynamic count.
	 * @return A OneToManyDirectedComponent
	 */
	OneToManyDirectedComponent<?> createOneToManyDirectedComponent(SerializableIntSupplier targetComponentsCount);

	/**
	 * Construct a ManyToOneDirectedComponent
	 * 
	 * @param outputNeurons. The neurons at the output of this component.
	 * @param pathCombinationStrategy The strategy used to combine multiple paths
	 *                                into a single output.
	 * @return A ManyToOneDirectedComponent for the specified
	 *         pathCombinationStrategy.
	 */

	ManyToOneDirectedComponent<?> createManyToOneDirectedComponent(Neurons outputNeurons,
			PathCombinationStrategy pathCombinationStrategy);

	/**
	 * Construct a ManyToOneDirectedComponent
	 * 
	 * @param outputNeurons. The neurons at the output of this component.
	 * @param pathCombinationStrategy The strategy used to combine multiple paths
	 *                                into a single output.
	 * @return A ManyToOneDirectedComponent for the specified
	 *         pathCombinationStrategy.
	 */
	ManyToOneDirectedComponent<?> createManyToOneDirectedComponent3D(Neurons3D outputNeurons,
			PathCombinationStrategy pathCombinationStrategy);

	/**
	 * Construct a DifferentiableActivationFunctionComponent.
	 * 
	 * @param name				               The name of the component.
	 * @param neurons                          The neurons at which the
	 *                                         DifferentiableActivationFunctionComponent
	 *                                         will activate.
	 * @param differentiableActivationFunction The differentiable activation
	 *                                         function to be wrapped by this
	 *                                         component.
	 * @return A DifferentiableActivationFunctionComponent.
	 */
	@Override
	DifferentiableActivationFunctionComponent createDifferentiableActivationFunctionComponent(String name, Neurons neurons,
			DifferentiableActivationFunction differentiableActivationFunction);

	/**
	 * Construct a DifferentiableActivationFunctionComponent.
	 * 
	 * @param name					 The name of the component.
	 * @param neurons                The neurons at which the
	 *                               DifferentiableActivationFunctionComponent will
	 *                               activate.
	 * @param activationFunctionType The differentiable activation function type to
	 *                               be wrapped by this component.
	 * @return A DifferentiableActivationFunctionComponent.
	 */
	@Override
	DifferentiableActivationFunctionComponent createDifferentiableActivationFunctionComponent(String name, Neurons neurons,
			ActivationFunctionType activationFunctionType, ActivationFunctionProperties activationFunctionProperties);

	/**
	 * Construct a DefaultDirectedComponentChain instance.
	 * 
	 * @param sequentialComponents A list of the sequential
	 *                             DefaultChainableDirectedComponents that this
	 *                             chain will contain
	 * @return The DefaultDirectedComponentChain instance
	 */
	@Override
	DefaultDirectedComponentChain createDirectedComponentChain(
			List<DefaultChainableDirectedComponent<?, ?>> sequentialComponents);

	/**
	 * Construct a DefaultDirectedComponentBipoleGraph instance.
	 * 
	 * @param inputNeurons            The neurons on the LHS of the bipole graph.
	 * @param outputNeurons           The neurons on the RHS of the bipole graph.
	 * @param batchOfParallelChains   The batch of parallel chains, connecting the
	 *                                input neurons to the output neurons.
	 * @param pathCombinationStrategy The strategy specifying how the outputs of the
	 *                                parallel chains are combined to produce the
	 *                                output.
	 * @return A DefaultDirectedComponentBipoleGraph instance.
	 */
	@Override
	DefaultDirectedComponentBipoleGraph createDirectedComponentBipoleGraph(Neurons inputNeurons, Neurons outputNeurons,
			List<DefaultChainableDirectedComponent<?, ?>> batchOfParallelChains,
			PathCombinationStrategy pathCombinationStrategy);

}
