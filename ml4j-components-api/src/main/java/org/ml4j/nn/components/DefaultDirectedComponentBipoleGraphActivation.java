package org.ml4j.nn.components;

import java.util.List;

import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentBipoleGraphActivation extends DirectedComponentBipoleGraphActivation<NeuronsActivation>, DefaultChainableDirectedComponentActivation {

	@Override
	List<DefaultChainableDirectedComponentActivation> decompose();
	
}
