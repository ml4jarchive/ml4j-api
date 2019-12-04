package org.ml4j.nn.components;

import java.util.List;

public interface ChainableDirectedComponent<I, A extends ChainableDirectedComponentActivation<I>, C>
		extends DirectedComponent<I, A, C> {
	
	public C getContext(DirectedComponentsContext directedComponentsContext, int componentIndex);
	
	public List<ChainableDirectedComponent<I, ? extends ChainableDirectedComponentActivation<I>, ?>> decompose();

}
