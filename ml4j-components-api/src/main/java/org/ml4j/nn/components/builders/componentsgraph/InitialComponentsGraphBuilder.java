package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.DirectedComponentChain;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface InitialComponentsGraphBuilder extends ComponentsGraphBuilder<InitialComponentsGraphBuilder> {

	DirectedComponentChain<NeuronsActivation, ?, ?, ?> getComponentChain();
	
}
