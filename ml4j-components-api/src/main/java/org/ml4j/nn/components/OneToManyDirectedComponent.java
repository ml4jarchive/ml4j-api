package org.ml4j.nn.components;

import org.ml4j.nn.neurons.NeuronsActivation;

public interface OneToManyDirectedComponent<A extends OneToManyDirectedComponentActivation> extends GenericOneToManyDirectedComponent<NeuronsActivation,DirectedComponentsContext, A > {

	@Override
	OneToManyDirectedComponent<A> dup();
}
