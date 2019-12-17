package org.ml4j.nn.components;

public interface DirectedComponentBipoleGraph<I, C, Z extends DirectedComponentBipoleGraphActivation<I>, B extends DirectedComponentBatch<I, ? , ?, ?, ?, ?>> extends ChainableDirectedComponent<I, Z, C> {

	public B getEdges();
	
	
	@Override
	DirectedComponentBipoleGraph<I, C, Z, B> dup();
}
