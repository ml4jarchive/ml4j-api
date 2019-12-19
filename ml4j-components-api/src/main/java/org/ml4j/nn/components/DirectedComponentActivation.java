package org.ml4j.nn.components;

/**
 * Default base class for implementations of DefaultChainableDirectedComponentActivation.
 * 
 * Encapsulates the activations from a forward propagation through a DirectedComponent
 * 
 * 
 * @author Michael Lavelle
 *
 * @param <I> The type of the input applied to the LHS of the DirectedComponent
 * @param <O> The type of the output from the RHS of the DirectedComponent
 */
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
	 * @return The activation output on the RHS of the forward propagation.
	 */
	O getOutput();
}
