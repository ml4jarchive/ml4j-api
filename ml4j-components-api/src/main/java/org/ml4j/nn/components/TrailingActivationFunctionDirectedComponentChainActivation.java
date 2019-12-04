package org.ml4j.nn.components;

import org.ml4j.nn.costfunctions.CostFunctionGradient;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface TrailingActivationFunctionDirectedComponentChainActivation
		extends DirectedComponentChainActivation<NeuronsActivation, ChainableDirectedComponentActivation<NeuronsActivation>> {

	/**
	 * @param outerGradient
	 *            The outer gradient to back propagate.
	 * @param synapsesContext
	 *            The synapses context.
	 * @return The back propagated DirectedComponentGradient.
	 */
	public DirectedComponentGradient<NeuronsActivation> backPropagate(CostFunctionGradient outerGradient);
}
