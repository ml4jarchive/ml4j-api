package org.ml4j.nn.components.onetomany;

import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.GenericOneToManyDirectedComponent;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface OneToManyDirectedComponent<A extends OneToManyDirectedComponentActivation> extends GenericOneToManyDirectedComponent<NeuronsActivation,DirectedComponentsContext, A > {

	@Override
	OneToManyDirectedComponent<A> dup();
}
