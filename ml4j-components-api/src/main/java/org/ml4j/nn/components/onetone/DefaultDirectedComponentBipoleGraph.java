package org.ml4j.nn.components.onetone;

import java.util.List;

import org.ml4j.nn.components.DirectedComponentBipoleGraph;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.manytomany.DefaultDirectedComponentChainBatch;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentBipoleGraph extends DirectedComponentBipoleGraph<NeuronsActivation, DirectedComponentsContext, DefaultDirectedComponentBipoleGraphActivation, DefaultDirectedComponentChainBatch<DefaultDirectedComponentChain, DefaultDirectedComponentChainActivation>>,
DefaultChainableDirectedComponent<DefaultDirectedComponentBipoleGraphActivation, DirectedComponentsContext>{

	@Override
	DefaultDirectedComponentBipoleGraph dup();

	@Override
	List<DefaultChainableDirectedComponent<?, ?>> decompose();

}
