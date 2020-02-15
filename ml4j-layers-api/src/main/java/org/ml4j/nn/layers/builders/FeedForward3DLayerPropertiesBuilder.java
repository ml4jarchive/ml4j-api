package org.ml4j.nn.layers.builders;

import java.util.function.Consumer;

import org.ml4j.nn.axons.Axons3DConfigBuilderBase;
import org.ml4j.nn.neurons.Neurons3D;

/**
 * Interface for the non-initial and non-final steps of builder logic for a feed forward layer
 *
 */
public interface FeedForward3DLayerPropertiesBuilder<C, B extends Axons3DConfigBuilderBase<?, ?>> {

	 C withOutputNeurons(Neurons3D endNeurons);
	 
	 C withConfig(Consumer<B> config);

}
