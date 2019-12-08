package org.ml4j.nn.synapses;

import org.ml4j.nn.components.DirectedComponentBatch;
import org.ml4j.nn.components.DirectedComponentBatchActivation;
import org.ml4j.nn.components.DirectedComponentBipoleGraph;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedSynapsesBipoleGraph<S extends DirectedSynapses<?, ?>> extends DirectedComponentBipoleGraph<NeuronsActivation, DirectedComponentsContext, DirectedSynapsesBipoleGraphActivation, DirectedComponentBatch<NeuronsActivation, DirectedSynapsesChain<S>, DirectedComponentBatchActivation<NeuronsActivation, DirectedSynapsesChainActivation>, DirectedSynapsesChainActivation, DirectedComponentsContext, DirectedComponentsContext>> {

	
}
