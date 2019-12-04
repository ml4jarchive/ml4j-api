package org.ml4j.nn.components.builders.axons;

import java.util.function.Consumer;

import org.ml4j.Matrix;
import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.components.DirectedComponentsContext;

public interface UncompletedTrainableAxonsBuilder<N, C, B extends UncompletedTrainableAxonsBuilder<N, C, B>> {

	C withConnectionToNeurons(N neurons);
	B withConnectionWeights(Matrix connectionWeights);
	B withBiasUnit();
	B withBiases(Matrix biases);
	DirectedComponentsContext getDirectedComponentsContext();
	Consumer<AxonsContext> getAxonsContextConfigurer();

}
