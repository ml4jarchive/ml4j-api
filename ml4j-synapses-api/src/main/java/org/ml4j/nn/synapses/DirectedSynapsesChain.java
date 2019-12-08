package org.ml4j.nn.synapses;

import org.ml4j.nn.components.DirectedComponentChain;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedSynapsesChain<S extends DirectedSynapses<?, ?>> extends DirectedComponentChain<NeuronsActivation, S, DirectedSynapsesActivation, DirectedSynapsesChainActivation> {

}
