package org.ml4j.nn.unsupervised;

import org.ml4j.nn.DeepBeliefNetworkContext;
import org.ml4j.nn.layers.RestrictedBoltzmannLayer;

public interface DeepBeliefNetwork<L extends RestrictedBoltzmannLayer<?, ?>, N extends 
    DeepBeliefNetwork<L, N, C>, C extends DeepBeliefNetworkContext>
    extends UnsupervisedNeuralNetwork<L, C, N> {

}
