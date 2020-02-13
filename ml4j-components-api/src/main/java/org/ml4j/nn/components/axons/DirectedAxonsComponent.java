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
package org.ml4j.nn.components.axons;

import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.components.AxonsContextAwareNeuralComponent;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.factories.DirectedComponentFactory;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * DefaultChainableDirectedComponent adapter for an Axons instance.
 * 
 * 
 * @author Michael Lavelle
 *
 * @param <L> The type of Neurons on the LHS of this DirectedAxonsComponent.
 * @param <R> The type of Neurons on the RHS of this DirectedAxonsComponent.
 * @param <A> The specific type of Axons wrapped by this DirectedAxonsComponent.
 */
public interface DirectedAxonsComponent<L extends Neurons, R extends Neurons, A extends Axons<?, ?, ?>>
		extends DefaultChainableDirectedComponent<DirectedAxonsComponentActivation, AxonsContext>,
		AxonsContextAwareNeuralComponent<DefaultChainableDirectedComponent<?, ?>> {

	/**
	 * @return The Axons instance adapted by this DirectedAxonsComponent.
	 */
	A getAxons();

	@Override
	DirectedAxonsComponent<L, R, A> dup(DirectedComponentFactory directedComponentFactory);

	@Override
	default DirectedAxonsComponentActivation forwardPropagate(NeuronsActivation input,
			DirectedComponentsContext context) {
		return forwardPropagate(input, getContext(context));
	}
}
