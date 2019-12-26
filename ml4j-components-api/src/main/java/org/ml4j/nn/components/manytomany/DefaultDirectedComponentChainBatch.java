package org.ml4j.nn.components.manytomany;

import java.util.List;

import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.onetone.DefaultDirectedComponentChain;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentChainBatch extends
		ChainableDirectedComponent<List<NeuronsActivation>, DefaultDirectedComponentChainBatchActivation, DirectedComponentsContext> {

	@Override
	DefaultDirectedComponentChainBatch dup();

	public List<DefaultDirectedComponentChain> getComponents();
}
