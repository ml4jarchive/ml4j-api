package org.ml4j.nn.layers.builders;

import org.ml4j.nn.neurons.Neurons;

public interface FullyConnectedFeedForwardLayerPropertiesBuilder<C> extends FeedForwardLayerPropertiesBuilder<FullyConnectedFeedForwardLayerPropertiesBuilder<C>>,
	WeightedFeedForwardLayerPropertiesBuilder<C, FullyConnectedFeedForwardLayerPropertiesBuilder<C>, Neurons>{

}
