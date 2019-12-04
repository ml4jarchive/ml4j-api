package org.ml4j.nn.components.builders.axons;

import org.ml4j.nn.neurons.Neurons;

public interface UncompletedAxonsBuilder<N extends Neurons, C> {

	C withConnectionToNeurons(N neurons);
	N getLeftNeurons();
}
