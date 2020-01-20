package org.ml4j.nn.components.builders.axons;

import org.ml4j.nn.components.builders.BaseGraphBuilderState;
import org.ml4j.nn.components.builders.componentsgraph.ComponentsGraphNeurons;
import org.ml4j.nn.neurons.Neurons;

public interface AxonsStateBuilder<T> {

	ComponentsGraphNeurons<Neurons> getComponentsGraphNeurons();

	BaseGraphBuilderState getBuilderState();

}
