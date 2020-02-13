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
package org.ml4j.nn.components.generic;

import java.util.List;

import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.components.DirectedComponent;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.factories.NeuralComponentFactory;

/**
 * Encapsulates a sequential chain of ChainableDirectedComponents
 * 
 * @author Michael Lavelle
 *
 * @param <I> The type of input to the chain.
 * @param <L> THe type of each component within the chain.
 * @param <A> The type of activation of each component of the chain.
 * @param <B> The type of activation produced by this chain.
 */
public interface DirectedComponentChain<I, L extends ChainableDirectedComponent<I, ? extends A, ?, F>, A extends ChainableDirectedComponentActivation<I>, B extends DirectedComponentChainActivation<I, A>, F extends NeuralComponentFactory<?>>
		extends DirectedComponent<I, B, DirectedComponentsContext, F>,
		ChainableDirectedComponent<I, B, DirectedComponentsContext, F> {

	public List<L> getComponents();

	@Override
	DirectedComponentChain<I, L, A, B, F> dup(F neuralComponentFactory);

}
