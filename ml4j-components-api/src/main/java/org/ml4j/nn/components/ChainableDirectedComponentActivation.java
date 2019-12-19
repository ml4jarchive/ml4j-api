package org.ml4j.nn.components;

import java.util.List;

public interface ChainableDirectedComponentActivation<I> extends DirectedComponentActivation<I, I> {

	/**
	 * @return Decompose this activation into a list of the smallest atomic ChainableDirectedComponentActivations
	 * that can be chained together to form this activation.
	 */
	public List<? extends ChainableDirectedComponentActivation<I>> decompose();

}
