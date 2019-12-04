package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.neurons.Neurons3D;

public interface Components3DGraphBuilderFactory {

	InitialComponents3DGraphBuilder createInitialComponents3DGraphBuilder(Neurons3D initialNeurons);
}
