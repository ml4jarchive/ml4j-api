package org.ml4j.nn.components.axons;

import org.ml4j.nn.components.DirectedComponentBatchActivation;
import org.ml4j.nn.components.DirectedComponentChainActivation;
import org.ml4j.nn.components.DirectedComponentChainBatch;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedAxonsComponentChainBatch<L extends Neurons, R extends Neurons> extends DirectedComponentChainBatch<NeuronsActivation, DirectedAxonsComponentChain<L, R>, DirectedComponentChainActivation<NeuronsActivation, DirectedAxonsComponentActivation>, DirectedComponentBatchActivation<NeuronsActivation, DirectedComponentChainActivation<NeuronsActivation, DirectedAxonsComponentActivation>>> {

}
