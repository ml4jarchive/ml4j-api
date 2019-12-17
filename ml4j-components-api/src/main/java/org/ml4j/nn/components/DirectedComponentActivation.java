package org.ml4j.nn.components;

public interface DirectedComponentActivation<I, O> {

	/**
	 * Back propagate the gradient from the outer layer through the component that produced this activation.
	 * 
	 * 
	 * @param outerGradient The outer gradient to back propagate.
	 * @return The back propagated DirectedComponentGradient.
	 */
	DirectedComponentGradient<I> backPropagate(DirectedComponentGradient<O> outerGradient);

	/**
	 * @return The activation output.
	 */
	O getOutput();
	

}
