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
package org.ml4j.nn.components.onetomany;

import org.ml4j.nn.components.DirectedComponent;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Interface for a directed component which takes a single NeuronsActivation
 * instance as input and maps to many NeuronsActivation instances as output.
 * 
 * Used within component graphs where the flow through the NeuralNetwork is
 * split into paths, eg. for skip-connections in ResNets or inception modules.
 * 
 * @author Michael Lavelle
 *
 * @param <A> The type of activation produced by this component on
 *            forward-propagation.
 */
public interface OneToManyDirectedComponent<A extends OneToManyDirectedComponentActivation>
		extends DirectedComponent<NeuronsActivation, A, DirectedComponentsContext> {

	@Override
	OneToManyDirectedComponent<A> dup();
}
