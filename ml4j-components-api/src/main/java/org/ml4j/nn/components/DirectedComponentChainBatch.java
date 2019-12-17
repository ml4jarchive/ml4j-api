package org.ml4j.nn.components;

public interface DirectedComponentChainBatch<I, L extends DirectedComponentChain<I, ?, ? , T>, T extends DirectedComponentChainActivation<I, ? >, Y extends DirectedComponentBatchActivation<I, T>> extends DirectedComponentBatch<I, L, Y, T, DirectedComponentsContext, DirectedComponentsContext> {

	
	@Override
	DirectedComponentChainBatch<I, L, T, Y> dup();
}
