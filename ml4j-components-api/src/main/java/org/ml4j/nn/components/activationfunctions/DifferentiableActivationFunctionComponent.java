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
package org.ml4j.nn.components.activationfunctions;

import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.neurons.NeuronsActivation;
import org.ml4j.nn.neurons.NeuronsActivationContext;

/**
 * Component adapter for a DifferentiableActivationFunction, allowing
 * DifferentiableActivationFunctions to be used within a sequential component
 * chain.
 * 
 * @author Michael Lavelle
 */
public interface DifferentiableActivationFunctionComponent extends
		DefaultChainableDirectedComponent<DifferentiableActivationFunctionComponentActivation, NeuronsActivationContext>,
		NeuralComponent {

	/**
	 * @return The activation function type.
	 */
	ActivationFunctionType getActivationFunctionType();

	/**
	 * @return A deep copy of this component.
	 */
	@Override
	DifferentiableActivationFunctionComponent dup();

	@Override
	default DifferentiableActivationFunctionComponentActivation forwardPropagate(NeuronsActivation input,
			DirectedComponentsContext context) {
		return forwardPropagate(input, getContext(context, 0));
	}
}
