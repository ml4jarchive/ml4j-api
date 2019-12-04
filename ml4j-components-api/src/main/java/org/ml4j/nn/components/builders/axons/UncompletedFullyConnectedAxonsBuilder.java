package org.ml4j.nn.components.builders.axons;

import java.util.function.Consumer;

import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.neurons.Neurons;

public interface UncompletedFullyConnectedAxonsBuilder<C> extends UncompletedTrainableAxonsBuilder<Neurons, C, UncompletedFullyConnectedAxonsBuilder<C>> {

	UncompletedFullyConnectedAxonsBuilder<C> withAxonsContext(DirectedComponentsContext directedComponentsContext, Consumer<AxonsContext> axonsContextConfigurer);

}
