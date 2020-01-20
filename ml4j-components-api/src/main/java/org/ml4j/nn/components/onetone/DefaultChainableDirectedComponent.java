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
package org.ml4j.nn.components.onetone;

import java.util.List;

import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.NeuralComponentType;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * A default chainable component within a DirectedNeuralNetwork where an input
 * NeuronsActivation flows in a left-to-right direction through forward
 * propagation.
 * 
 * Error information in the form of a gradient NeuronsActivation is then flowed
 * right-to-left through the resulting DirectedComponentActivation instances via
 * back propagation.
 * 
 * DefaultChainableDirectedComponent instances can be composed together in a
 * sequential chain, as the type of input and output are both single
 * NeuronsActivation instances.
 * 
 * @author Michael Lavelle
 *
 * @param <A> The type of activation produced by the
 *            DefaultChainableDirectedComponent on forward propagation
 * @param <C> The context provided to the DefaultChainableDirectedComponent on
 *            forward propagation.
 */
public interface DefaultChainableDirectedComponent<A extends DefaultChainableDirectedComponentActivation, C>
		extends ChainableDirectedComponent<NeuronsActivation, A, C>, NeuralComponent {

	/**
	 * @return A deep copy of this component.
	 */
	@Override
	DefaultChainableDirectedComponent<A, C> dup();

	/**
	 * @return Decompose this component into a list of the smallest atomic
	 *         ChainableDirectedComponents that can be chained together to form this
	 *         component.
	 */
	@Override
	List<DefaultChainableDirectedComponent<?, ?>> decompose();

	/**
	 * @return The neurons on the LHS of this component to which input data
	 *         activations are applied.
	 */
	Neurons getInputNeurons();

	/**
	 * @return The neurons on the RHS of this component from which output data
	 *         activations are generated.
	 */
	Neurons getOutputNeurons();

	@Override
	NeuralComponentType<? extends DefaultChainableDirectedComponent<?, ?>> getComponentType();

}
