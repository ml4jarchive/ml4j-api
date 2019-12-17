package org.ml4j.nn.components;

import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentBipoleGraph extends DirectedComponentBipoleGraph<NeuronsActivation, DirectedComponentsContext, DefaultDirectedComponentBipoleGraphActivation, DefaultDirectedComponentBatch<DirectedComponentsContext, DirectedComponentsContext>>,
DefaultChainableDirectedComponent<DefaultDirectedComponentBipoleGraphActivation, DirectedComponentsContext>{

	@Override
	DefaultDirectedComponentBipoleGraph dup();
	
}
