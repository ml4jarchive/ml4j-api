package org.ml4j.nn.components;

public interface GenericOneToManyDirectedComponent<I, C, A extends GenericOneToManyDirectedComponentActivation<I>> extends DirectedComponent<I, A, C> {

	@Override
	GenericOneToManyDirectedComponent<I, C, A> dup();
}
