package org.ml4j.nn.components.onetone;

import java.util.List;

import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.manytomany.DefaultDirectedComponentChainBatch;

public interface DefaultDirectedComponentBipoleGraph 
// extends DirectedComponentBipoleGraph<NeuronsActivation, DirectedComponentsContext, DefaultDirectedComponentBipoleGraphActivation, DefaultDirectedComponentChainBatch<DefaultDirectedComponentChain, DefaultDirectedComponentChainActivation>>,
extends DefaultChainableDirectedComponent<DefaultDirectedComponentBipoleGraphActivation, DirectedComponentsContext> {

	@Override
	DefaultDirectedComponentBipoleGraph dup();

	@Override
	List<DefaultChainableDirectedComponent<?, ?>> decompose();
		
	DefaultDirectedComponentChainBatch getEdges();

}
