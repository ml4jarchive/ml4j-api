package org.ml4j.nn.components.axons;

import org.ml4j.nn.components.generic.DirectedComponentChain;
import org.ml4j.nn.components.generic.DirectedComponentChainActivation;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedAxonsComponentChain<L extends Neurons, R extends Neurons> extends DirectedComponentChain<NeuronsActivation, DirectedAxonsComponent<L,R, ?>, DirectedAxonsComponentActivation, DirectedComponentChainActivation<NeuronsActivation, DirectedAxonsComponentActivation>> {

	  @Override
	  DirectedAxonsComponentChain<L, R> dup();
}
