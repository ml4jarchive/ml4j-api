package org.ml4j.nn.components;

import java.util.List;

public interface GenericManyToOneDirectedComponent<I, C, A extends GenericManyToOneDirectedComponentActivation<I>> extends DirectedComponent<List<I>, A, C> {


	@Override
	GenericManyToOneDirectedComponent<I, C, A> dup();
}
