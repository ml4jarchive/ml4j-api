package org.ml4j.nn.sessions;

import org.ml4j.nn.neurons.Neurons3D;

public interface SupervisedFeedForwardNeuralNetworkBuilder<C> {

	 C endWithNeurons(Neurons3D endNeurons);
	 
}
