package org.ml4j.nn.layers.builders;

import org.ml4j.nn.neurons.Neurons;

public interface FeedForwardLayerPropertiesBuilder<C> {

	 C withOutputNeurons(Neurons endNeurons);
	 
}
