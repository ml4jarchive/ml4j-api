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

import org.ml4j.nn.components.DirectedComponentGradient;
import org.ml4j.nn.costfunctions.CostFunctionGradient;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface TrailingActivationFunctionDirectedComponentChainActivation
		extends DefaultDirectedComponentChainActivation {

	/**
	 * @param outerGradient
	 *            The outer gradient to back propagate.
	 * @param synapsesContext
	 *            The synapses context.
	 * @return The back propagated DirectedComponentGradient.
	 */
	DirectedComponentGradient<NeuronsActivation> backPropagate(CostFunctionGradient outerGradient);
	
	
}
