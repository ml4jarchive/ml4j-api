package org.ml4j.nn.synapses;

import org.ml4j.nn.components.DirectedComponentBatchActivation;
import org.ml4j.nn.components.DirectedComponentChainBatch;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedSynapsesChainBatch<S extends DirectedSynapses<?, ?>> extends DirectedComponentChainBatch<NeuronsActivation, DirectedSynapsesChain<S>, DirectedSynapsesChainActivation, DirectedComponentBatchActivation<NeuronsActivation, DirectedSynapsesChainActivation>> {

}
