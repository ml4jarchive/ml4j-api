package org.ml4j.nn.components.builders.common;

import java.util.List;

import org.ml4j.nn.components.DefaultChainableDirectedComponent;
import org.ml4j.nn.components.DefaultDirectedComponentChain;
import org.ml4j.nn.components.builders.componentsgraph.ComponentsGraphNeurons;
import org.ml4j.nn.neurons.Neurons;

public interface ComponentsContainer<N extends Neurons> {

	List<DefaultChainableDirectedComponent<?, ?>> getComponents();
	ComponentsGraphNeurons<N> getComponentsGraphNeurons();
	ComponentsContainer<Neurons> getAxonsBuilder();
	List<DefaultDirectedComponentChain> getChains();
	List<N> getEndNeurons();
	void addAxonsIfApplicable();
	void addComponents(List<DefaultChainableDirectedComponent<?, ?>> components);
	void addComponent(DefaultChainableDirectedComponent<?,?> component);
}
