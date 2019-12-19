package org.ml4j.nn.components.onetone;

import org.ml4j.nn.components.DirectedComponentBipoleGraph;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.manytomany.DefaultDirectedComponentChainBatch;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentChainBipoleGraph
		extends
		DirectedComponentBipoleGraph<NeuronsActivation, DirectedComponentsContext, DefaultDirectedComponentBipoleGraphActivation, DefaultDirectedComponentChainBatch<DefaultDirectedComponentChain, DefaultDirectedComponentChainActivation>> {

}
