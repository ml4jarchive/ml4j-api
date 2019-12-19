package org.ml4j.nn.components.manytomany;

import org.ml4j.nn.components.DirectedComponentBatchActivation;
import org.ml4j.nn.components.DirectedComponentChain;
import org.ml4j.nn.components.DirectedComponentChainActivation;
import org.ml4j.nn.components.DirectedComponentChainBatch;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentChainBatch<L extends DirectedComponentChain<NeuronsActivation, ?, ? , T>, T extends DirectedComponentChainActivation<NeuronsActivation, ?>> extends
		DirectedComponentChainBatch<NeuronsActivation, L, T, DirectedComponentBatchActivation<NeuronsActivation, T>> {

	  @Override
	  DefaultDirectedComponentChainBatch<L, T> dup();
}
