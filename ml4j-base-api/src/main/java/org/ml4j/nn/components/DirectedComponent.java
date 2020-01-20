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
package org.ml4j.nn.components;

/**
 * A component within a DirectedNeuralNetwork where data flows in a
 * left-to-right direction through forward propagation. Error information is
 * then flowed right-to-left through the resulting DirectedComponentActivation
 * instances via back propagation.
 * 
 * @author Michael Lavelle
 *
 * @param <I> The type of input on the LHS of the DirectedComponent
 * @param <A> The type of DirectedComponentActivation produced by this
 *            component.
 * @param <C> The type of context used by this component for forward
 *            propagation, and by the resulting activation for back propagation.
 * 
 */
public interface DirectedComponent<I, A extends DirectedComponentActivation<I, ?>, C> extends NeuralNetworkComponent {

	/**
	 * Forward Propagates the activations through the Synapses via the Axons and
	 * DifferentiableActivationFunction.
	 * 
	 * @param input   The input to the DirectedComponent
	 * @param context The context within which we forward propagate the activations
	 * @return A DirectedComponentActivation encapsulating the artifacts generated
	 *         by this forward propagation - including the output from the right
	 *         hand side of this DirectedComponent.
	 */
	A forwardPropagate(I input, C context);

	/**
	 * @return The type of the directed component
	 */
	NeuralComponentType<?> getComponentType();

	/**
	 * @return A deep copy of this component.
	 */
	@Override
	DirectedComponent<I, A, C> dup();

}
