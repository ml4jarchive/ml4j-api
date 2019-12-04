package org.ml4j.nn.components;

import java.util.List;

public interface DirectedComponentChain<I, L extends ChainableDirectedComponent<I, ? extends A, ?>, A extends ChainableDirectedComponentActivation<I>, B extends DirectedComponentChainActivation<I, A>>
		extends DirectedComponent<I, B, DirectedComponentsContext>, ChainableDirectedComponent<I, B, DirectedComponentsContext>{

	public List<L> getComponents();
}
