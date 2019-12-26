package org.ml4j.nn.components.manytomany;

import java.util.List;

import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.components.onetone.DefaultDirectedComponentChainActivation;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentChainBatchActivation
extends ChainableDirectedComponentActivation<List<NeuronsActivation>> {
	
	public List<DefaultDirectedComponentChainActivation> getActivations();
	
	List<NeuronsActivation> getOutput();
}
