package org.ml4j.nn.layers.builders;

import org.ml4j.nn.neurons.Neurons3D;

/**
 * Interface for any additional steps of builder logic for a convolutional layer
 *
 */
public interface ConvolutionalFeedForwardLayerPropertiesBuilder<C> extends FeedForward3DLayerPropertiesBuilder<ConvolutionalFeedForwardLayerPropertiesBuilder<C>, ConvolutionalLayerConfigBuilder>,
WeightedFeedForwardLayerPropertiesBuilder<C, ConvolutionalFeedForwardLayerPropertiesBuilder<C>, Neurons3D>{

	ConvolutionalFeedForwardLayerPropertiesBuilder<C> withInputNeurons(Neurons3D neurons);

}
