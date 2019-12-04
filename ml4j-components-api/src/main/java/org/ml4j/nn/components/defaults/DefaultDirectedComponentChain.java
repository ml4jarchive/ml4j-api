package org.ml4j.nn.components.defaults;

import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.components.GenericDirectedComponentChain;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentChain<A extends ChainableDirectedComponentActivation<NeuronsActivation>>
		extends GenericDirectedComponentChain<NeuronsActivation, A> {

}
