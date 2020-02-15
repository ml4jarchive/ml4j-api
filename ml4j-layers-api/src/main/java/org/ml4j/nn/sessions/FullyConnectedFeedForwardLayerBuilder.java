package org.ml4j.nn.sessions;

import org.ml4j.nn.neurons.Neurons;

/**
 * Interface for the final step of builder logic for a feed forward layer
 *
 */
public interface FullyConnectedFeedForwardLayerBuilder<C> {

	 C withOutputNeurons(Neurons endNeurons);
		
}
