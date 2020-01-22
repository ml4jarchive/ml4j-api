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

import java.util.List;

/**
 * A chainable component within a DirectedNeuralNetwork where data flows in a
 * left-to-right direction through forward propagation. Error information is
 * then flowed right-to-left through the resulting DirectedComponentActivation
 * instances via back propagation.
 * 
 * ChainableDirectedComponent instances can be composed together in a sequential
 * chain, as the type of input and output is the same.
 * 
 * @author Michael Lavelle
 *
 * @param <I> The type of input and output of the ChainableDirectedComponent
 * @param <A> The type of activation produced by the ChainableDirectedComponent
 *            on forward propagation
 * @param <C> The context provided to the ChainableDirectedComponent on forward
 *            propagation.
 */
public interface ChainableDirectedComponent<I, A extends ChainableDirectedComponentActivation<I>, C>
		extends DirectedComponent<I, A, C> {

	/**
	 * Obtain the context of this ChainableDirectedComponent from the provided
	 * DirectedComponentsContext.
	 * 
	 * @param directedComponentsContext The DirectedComponentsContext
	 * @return A component-specific context for this component.
	 */
	C getContext(DirectedComponentsContext directedComponentsContext);

	/**
	 * @return Decompose this component into a list of the smallest atomic
	 *         ChainableDirectedComponents that can be chained together to form this
	 *         component.
	 */
	List<? extends ChainableDirectedComponent<I, ? extends ChainableDirectedComponentActivation<I>, ?>> decompose();

	/**
	 * @return A deep copy of this component.
	 */
	@Override
	ChainableDirectedComponent<I, A, C> dup();
}
