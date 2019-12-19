package org.ml4j.nn.components.onetone;

import java.util.List;

import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultChainableDirectedComponentActivation extends ChainableDirectedComponentActivation<NeuronsActivation> {

	public List<? extends DefaultChainableDirectedComponentActivation> decompose();

}
