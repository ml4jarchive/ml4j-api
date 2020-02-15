package org.ml4j.nn.layers.builders;

import org.ml4j.nn.axons.Axons3DConfigBuilder;

/**
 * Interface for any additional steps of builder logic for an max pooling layer
 *
 */
public interface MaxPoolingFeedForwardLayerPropertiesBuilder<C> extends FeedForward3DLayerPropertiesBuilder<C, Axons3DConfigBuilder> {

	MaxPoolingFeedForwardLayerPropertiesBuilder<C> withScaleOutputs();
}
