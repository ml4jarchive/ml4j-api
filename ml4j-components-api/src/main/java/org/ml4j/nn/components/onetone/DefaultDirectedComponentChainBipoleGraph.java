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

import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.factories.DirectedComponentFactory;
import org.ml4j.nn.components.manytomany.DefaultDirectedComponentChainBatch;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * A type of DefaultChainableDirectedComponent consisting of a parallel edges (
 * DefaultDirectedComponentChainBatch ), with the paths through those parallel
 * edges all starting at the same point in the network and ending at the same
 * point in the network.
 * 
 * @author Michael Lavelle
 */
public interface DefaultDirectedComponentChainBipoleGraph extends
		DefaultChainableDirectedComponent<DefaultDirectedComponentChainBipoleGraphActivation, DirectedComponentsContext>,
		NeuralComponent<DefaultChainableDirectedComponent<?, ?>> {

	@Override
	DefaultDirectedComponentChainBipoleGraph dup(DirectedComponentFactory directedComponentFactory);

	@Override
	List<DefaultChainableDirectedComponent<?, ?>> decompose();

	/**
	 * @return The batch of edges within this graph.
	 */
	DefaultDirectedComponentChainBatch getEdges();
	
	
	@Override
	default DefaultDirectedComponentChainBipoleGraphActivation forwardPropagate(NeuronsActivation input,
			DirectedComponentsContext context) {
		return forwardPropagate(input, getContext(context));
	}
}
