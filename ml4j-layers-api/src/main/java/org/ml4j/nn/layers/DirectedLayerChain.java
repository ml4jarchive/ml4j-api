package org.ml4j.nn.layers;

import org.ml4j.nn.components.generic.DirectedComponentChain;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedLayerChain<L extends DirectedLayer<?, ?>> extends DirectedComponentChain<NeuronsActivation, L, DirectedLayerActivation, DirectedLayerChainActivation> {

}
