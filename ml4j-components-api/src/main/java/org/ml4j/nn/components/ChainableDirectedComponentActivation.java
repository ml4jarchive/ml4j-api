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
 * Interface for an activation from a ChainableDirectedComponent.
 * 
 * Encapsulates the activations from a forward propagation through a ChainableDirectedComponent
 * 
 * @author Michael Lavelle
 *
 * @param <I> The type of the input applied to the LHS of the ChainableDirectedComponent and output from the RHS of 
 * the ChainableDirectedComponent.
 */
public interface ChainableDirectedComponentActivation<I> extends DirectedComponentActivation<I, I> {

	/**
	 * @return Decompose this activation into a list of the smallest atomic ChainableDirectedComponentActivations
	 * that can be chained together to form this activation.
	 */
	public List<? extends ChainableDirectedComponentActivation<I>> decompose();

}
