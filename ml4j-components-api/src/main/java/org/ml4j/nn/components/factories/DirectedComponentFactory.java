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

import org.ml4j.nn.activationfunctions.ActivationFunctionProperties;
import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.axons.Axons3DConfig;
import org.ml4j.nn.axons.AxonsConfig;
import org.ml4j.nn.axons.BatchNormConfig;
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

	@Override
	DirectedAxonsComponent<Neurons, Neurons, ?> createFullyConnectedAxonsComponent(String name, AxonsConfig<Neurons, Neurons> axonsConfig, WeightsMatrix connectionWeights, BiasMatrix biases);

	@Override
	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createConvolutionalAxonsComponent(String name, Axons3DConfig config, WeightsMatrix connectionWeights, BiasMatrix biases);

	@Override
	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createMaxPoolingAxonsComponent(String name, Axons3DConfig config, boolean scaleOutputs);

	@Override
	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createAveragePoolingAxonsComponent(String name, Axons3DConfig config);

	@Override
	<N extends Neurons> BatchNormDirectedAxonsComponent<N, ?> createBatchNormAxonsComponent(String name, BatchNormConfig<N> batchNormConfig);

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

	@Override
	DifferentiableActivationFunctionComponent createDifferentiableActivationFunctionComponent(String name, Neurons neurons,
			DifferentiableActivationFunction differentiableActivationFunction);
	
	@Override
	DifferentiableActivationFunctionComponent createDifferentiableActivationFunctionComponent(String name, Neurons neurons,
			ActivationFunctionType activationFunctionType, ActivationFunctionProperties activationFunctionProperties);

	@Override
	DefaultDirectedComponentChain createDirectedComponentChain(
			List<DefaultChainableDirectedComponent<?, ?>> sequentialComponents);

	@Override
	DefaultDirectedComponentBipoleGraph createDirectedComponentBipoleGraph(String name, Neurons inputNeurons, Neurons outputNeurons,
			List<DefaultChainableDirectedComponent<?, ?>> batchOfParallelChains,
			PathCombinationStrategy pathCombinationStrategy);

}
