package org.ml4j.nn.components.builders.common;

import java.util.List;

import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.components.builders.componentsgraph.ComponentsGraphNeurons;
import org.ml4j.nn.components.defaults.DefaultDirectedComponentChain;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface ComponentsContainer<N extends Neurons> {

	List<ChainableDirectedComponent<NeuronsActivation, ? extends ChainableDirectedComponentActivation<NeuronsActivation>, ?>> getComponents();
	ComponentsGraphNeurons<N> getComponentsGraphNeurons();
	ComponentsContainer<Neurons> getAxonsBuilder();
	List<DefaultDirectedComponentChain<ChainableDirectedComponentActivation<NeuronsActivation>>> getChains();
	List<N> getEndNeurons();
	void addAxonsIfApplicable();
	void addComponents(List<ChainableDirectedComponent<NeuronsActivation, ? extends ChainableDirectedComponentActivation<NeuronsActivation>, ?>> components);
	void addComponent(ChainableDirectedComponent<NeuronsActivation, ? extends ChainableDirectedComponentActivation<NeuronsActivation>, ?> component);
}
