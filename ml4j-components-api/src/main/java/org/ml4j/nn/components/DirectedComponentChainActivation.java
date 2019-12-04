package org.ml4j.nn.components;

import java.util.List;

public interface DirectedComponentChainActivation<I, A extends ChainableDirectedComponentActivation<I>>
		extends DirectedComponentActivation<I, I>, ChainableDirectedComponentActivation<I>{

	List<A> getActivations();
}
