package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.DirectedComponentChain;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface InitialComponents3DGraphBuilder extends Components3DGraphBuilder<InitialComponents3DGraphBuilder, InitialComponentsGraphBuilder> {

	DirectedComponentChain<NeuronsActivation, ?, ?, ?> getComponentChain();
}
