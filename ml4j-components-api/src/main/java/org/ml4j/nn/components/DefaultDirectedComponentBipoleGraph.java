package org.ml4j.nn.components;

import java.util.List;

import org.ml4j.nn.components.defaults.DefaultDirectedComponentChainBatch;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentBipoleGraph extends DirectedComponentBipoleGraph<NeuronsActivation, DirectedComponentsContext, DefaultDirectedComponentBipoleGraphActivation, DefaultDirectedComponentChainBatch<DefaultDirectedComponentChain, DefaultDirectedComponentChainActivation>>,
DefaultChainableDirectedComponent<DefaultDirectedComponentBipoleGraphActivation, DirectedComponentsContext>{

	@Override
	DefaultDirectedComponentBipoleGraph dup();

	@Override
	List<DefaultChainableDirectedComponent<?, ?>> decompose();

}
