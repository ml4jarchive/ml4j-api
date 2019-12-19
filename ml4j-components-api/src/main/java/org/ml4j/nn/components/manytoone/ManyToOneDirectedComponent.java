package org.ml4j.nn.components.manytoone;

import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.GenericManyToOneDirectedComponent;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface ManyToOneDirectedComponent<A extends ManyToOneDirectedComponentActivation> extends GenericManyToOneDirectedComponent<NeuronsActivation, DirectedComponentsContext, A> {

	@Override
	ManyToOneDirectedComponent<A> dup();
}
