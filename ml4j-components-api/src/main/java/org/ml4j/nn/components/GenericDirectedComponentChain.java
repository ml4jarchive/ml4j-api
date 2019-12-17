package org.ml4j.nn.components;

public interface GenericDirectedComponentChain<I, A extends ChainableDirectedComponentActivation<I>> extends
		DirectedComponentChain<I, ChainableDirectedComponent<I, ? extends A, ?>, A, DirectedComponentChainActivation<I, A>> {

	
	@Override
	GenericDirectedComponentChain<I, A> dup();
}
