package org.ml4j.nn.synapses;

import org.ml4j.nn.components.DirectedComponentChainActivation;
import org.ml4j.nn.components.DirectedComponentGradient;
import org.ml4j.nn.costfunctions.CostFunctionGradient;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedSynapsesChainActivation
		extends DirectedComponentChainActivation<NeuronsActivation, DirectedSynapsesActivation> {

	/**
	 * @param outerGradient
	 *            The outer gradient to back propagate.
	 * @param synapsesContext
	 *            The synapses context.
	 * @return The back propagated DirectedComponentGradient.
	 */
	public DirectedComponentGradient<NeuronsActivation> backPropagate(CostFunctionGradient outerGradient);
}
