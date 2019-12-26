package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.generic.DirectedComponentChain;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface InitialComponents3DSubGraphBuilder extends Components3DSubGraphBuilder<InitialComponents3DSubGraphBuilder, InitialComponentsSubGraphBuilder> {

	DirectedComponentChain<NeuronsActivation, ?, ?, ?> getComponentChain();

}
