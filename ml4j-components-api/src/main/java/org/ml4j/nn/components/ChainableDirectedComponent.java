package org.ml4j.nn.components;

import java.util.List;

public interface ChainableDirectedComponent<I, A extends ChainableDirectedComponentActivation<I>, C>
		extends DirectedComponent<I, A, C> {
	
	C getContext(DirectedComponentsContext directedComponentsContext, int componentIndex);
	
	List<? extends ChainableDirectedComponent<I, ? extends ChainableDirectedComponentActivation<I>, ?>> decompose();

	@Override
	ChainableDirectedComponent<I, A, C> dup();
}
