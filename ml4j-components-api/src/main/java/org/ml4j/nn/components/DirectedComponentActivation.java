package org.ml4j.nn.components;

public interface DirectedComponentActivation<I, O> {

	/**
	 * @param outerGradient
	 *            The outer gradient to back propagate.
	 * @param synapsesContext
	 *            The synapses context.
	 * @return The back propagated DirectedComponentGradient.
	 */
	public DirectedComponentGradient<I> backPropagate(DirectedComponentGradient<O> outerGradient);

	public O getOutput();
	

}
