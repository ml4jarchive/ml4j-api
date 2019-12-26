package org.ml4j.nn.components.manytoone;

import java.util.List;

import org.ml4j.nn.components.DirectedComponent;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface ManyToOneDirectedComponent<A extends ManyToOneDirectedComponentActivation> extends DirectedComponent<List<NeuronsActivation>, A, DirectedComponentsContext> {

	@Override
	ManyToOneDirectedComponent<A> dup();
}
