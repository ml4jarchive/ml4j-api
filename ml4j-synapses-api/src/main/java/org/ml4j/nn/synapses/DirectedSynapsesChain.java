package org.ml4j.nn.synapses;

import java.util.List;

import org.ml4j.nn.components.DefaultChainableDirectedComponent;
import org.ml4j.nn.components.DirectedComponentChain;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedSynapsesChain<S extends DirectedSynapses<?, ?>> extends DirectedComponentChain<NeuronsActivation, S, DirectedSynapsesActivation, DirectedSynapsesChainActivation> {

	  @Override
	List<DefaultChainableDirectedComponent<?, ?>> decompose();


	@Override
	  DirectedSynapsesChain<S> dup();
}
