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
 * Interface for an activation from a DirectedComponent.
 * 
 * Encapsulates the activations from a forward propagation through a
 * DirectedComponent
 * 
 * @author Michael Lavelle
 *
 * @param <I> The type of the input applied to the LHS of the DirectedComponent
 * @param <O> The type of the output from the RHS of the DirectedComponent
 */
public interface DirectedComponentActivation<I, O> {

	/**
	 * Back propagate the gradient from the outer layer through the component that
	 * produced this activation.
	 * 
	 * 
	 * @param outerGradient The outer gradient to back propagate.
	 * @return The back propagated DirectedComponentGradient.
	 */
	DirectedComponentGradient<I> backPropagate(DirectedComponentGradient<O> outerGradient);

	/**
	 * @return The activation output on the RHS of the forward propagation.
	 */
	O getOutput();
}
