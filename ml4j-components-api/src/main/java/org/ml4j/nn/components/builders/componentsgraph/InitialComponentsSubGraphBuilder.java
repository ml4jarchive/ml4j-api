package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.generic.DirectedComponentChain;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface InitialComponentsSubGraphBuilder extends SubComponentsGraphBuilder<InitialComponentsSubGraphBuilder> {

	DirectedComponentChain<NeuronsActivation, ?, ?, ?> getComponentChain();

}
