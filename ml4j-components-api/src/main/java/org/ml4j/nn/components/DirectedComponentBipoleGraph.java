package org.ml4j.nn.components;

public interface DirectedComponentBipoleGraph<I, C, Z extends DirectedComponentsBipoleGraphActivation<I>, B extends DirectedComponentBatch<I, ? , ?, ?, ?, ?>> extends ChainableDirectedComponent<I, Z, C> {

	public B getEdges();
}
