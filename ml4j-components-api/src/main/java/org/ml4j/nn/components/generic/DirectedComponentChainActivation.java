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

import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.components.DirectedComponentActivation;

/**
  * Encapsulates the activation from a DirectedComponentChain after forward propagation.
  * 
  * @author Michael Lavelle
 *
 * @param <I> The type of input to this DirectedComponentChain
 * @param <A> The type of activation produced by this DirectedComponentChain after forward propagation.
 */
public interface DirectedComponentChainActivation<I, A extends ChainableDirectedComponentActivation<I>>
		extends DirectedComponentActivation<I, I>, ChainableDirectedComponentActivation<I>{

	List<A> getActivations();
}
