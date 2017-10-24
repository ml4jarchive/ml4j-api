package org.ml4j.nn;

import org.ml4j.nn.NeuralNetwork;
import org.ml4j.nn.layers.RestrictedBoltzmannLayer;

public interface DeepBeliefNetwork<L extends RestrictedBoltzmannLayer<?, ?>, 
    N extends DeepBeliefNetwork<L, N, C>, C extends NeuralNetworkContext>
    extends NeuralNetwork<L, C, N> {

}
