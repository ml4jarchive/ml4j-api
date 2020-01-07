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

import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Interface for an activation from a DefaultChainableDirectedComponent.
 * 
 * Encapsulates the activations from a forward propagation through a DefaultChainableDirectedComponent including the
 * output NeuronsActivation from the RHS of the DefaultChainableDirectedComponent
 * 
 * @author Michael Lavelle
 *
 */
public interface DefaultChainableDirectedComponentActivation extends ChainableDirectedComponentActivation<NeuronsActivation> {

	/**
	 * @return Decompose this activation into a list of the smallest atomic DefaultChainableDirectedComponentActivation
	 * that can be chained together to form this activation.
	 */
	public List<? extends DefaultChainableDirectedComponentActivation> decompose();

}
