package org.ml4j.nn.components;

import java.util.List;

import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentChain extends DirectedComponentChain<NeuronsActivation, DefaultChainableDirectedComponent<?, ?>, DefaultChainableDirectedComponentActivation, DefaultDirectedComponentChainActivation>, DefaultChainableDirectedComponent<DefaultDirectedComponentChainActivation, DirectedComponentsContext > {

	@Override
	DefaultDirectedComponentChain dup();

	@Override
	List<DefaultChainableDirectedComponent<?, ?>> decompose();

	@Override
	List<DefaultChainableDirectedComponent<?, ?>> getComponents();

}
