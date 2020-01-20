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

import org.ml4j.nn.components.DirectedComponentGradient;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponentActivation;
import org.ml4j.nn.costfunctions.CostFunctionGradient;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * 
 * Encapsulates the activations from an activation through a
 * DifferentiableActivationFunctionComponent, and the logic required in order to
 * back propagate gradients back through the activations.
 * 
 * 
 * @author Michael Lavelle
 */
public interface DifferentiableActivationFunctionComponentActivation
		extends DefaultChainableDirectedComponentActivation {

	/**
	 * 
	 * @param da      The outer gradient.
	 * @param context The synapses context.
	 * @return The backpropagated gradient.
	 */
	DirectedComponentGradient<NeuronsActivation> backPropagate(DirectedComponentGradient<NeuronsActivation> da);

	/**
	 * 
	 * @param da      The outer gradient.
	 * @param context The synapses context.
	 * @return The backpropagated gradient.
	 */
	DirectedComponentGradient<NeuronsActivation> backPropagate(CostFunctionGradient da);

}
