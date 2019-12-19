package org.ml4j.nn.components.onetone;

import java.util.List;

import org.ml4j.nn.components.DirectedComponentBipoleGraphActivation;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentBipoleGraphActivation extends DirectedComponentBipoleGraphActivation<NeuronsActivation>, DefaultChainableDirectedComponentActivation {

	@Override
	List<DefaultChainableDirectedComponentActivation> decompose();
	
}
