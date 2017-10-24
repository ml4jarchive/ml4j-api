package org.ml4j.nn.unsupervised;

import org.ml4j.nn.DeepBeliefNetworkContext;
import org.ml4j.nn.layers.RestrictedBoltzmannLayer;

public interface UnsupervisedDeepBeliefNetwork
    extends
    DeepBeliefNetwork<RestrictedBoltzmannLayer<?, ?>, UnsupervisedDeepBeliefNetwork, 
        DeepBeliefNetworkContext>,
        UnsupervisedNeuralNetwork<RestrictedBoltzmannLayer<?, ?>, 
        DeepBeliefNetworkContext, UnsupervisedDeepBeliefNetwork> {

  StackedAutoEncoder createStackedAutoEncoder(); 

}
