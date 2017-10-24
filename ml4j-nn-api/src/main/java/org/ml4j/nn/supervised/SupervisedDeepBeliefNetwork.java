package org.ml4j.nn.supervised;

import org.ml4j.nn.DeepBeliefNetworkContext;
import org.ml4j.nn.layers.RestrictedBoltzmannLayer;
import org.ml4j.nn.unsupervised.DeepBeliefNetwork;

public interface SupervisedDeepBeliefNetwork extends
    DeepBeliefNetwork<RestrictedBoltzmannLayer<?, ?>, SupervisedDeepBeliefNetwork, 
    DeepBeliefNetworkContext>,
    SupervisedNeuralNetwork<RestrictedBoltzmannLayer<?, ?>, 
    DeepBeliefNetworkContext, SupervisedDeepBeliefNetwork> {

}
