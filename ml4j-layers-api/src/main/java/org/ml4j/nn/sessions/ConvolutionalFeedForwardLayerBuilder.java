package org.ml4j.nn.sessions;

import java.util.function.Consumer;

import org.ml4j.nn.axons.Axons3DConfigBuilder;
import org.ml4j.nn.neurons.Neurons3D;

/**
 * Interface for the final step of builder logic for a convolutional layer,
 * and also includes an intermediate config step.
 *
 */
public interface ConvolutionalFeedForwardLayerBuilder<C> {

	 C withOutputNeurons(Neurons3D endNeurons);
	 
	 C withConfig(Consumer<Axons3DConfigBuilder> config);
	
}
