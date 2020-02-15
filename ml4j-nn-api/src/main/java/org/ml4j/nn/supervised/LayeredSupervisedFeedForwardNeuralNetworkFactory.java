package org.ml4j.nn.supervised;

import java.util.List;

import org.ml4j.nn.layers.FeedForwardLayer;

public interface LayeredSupervisedFeedForwardNeuralNetworkFactory {

	LayeredSupervisedFeedForwardNeuralNetwork createLayeredSupervisedFeedForwardNeuralNetwork(String name,
			List<FeedForwardLayer<?, ?>> layerChain);
}
