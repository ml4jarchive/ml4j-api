package org.ml4j.nn.components;

import org.ml4j.nn.activationfunctions.DifferentiableActivationFunctionComponent;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface TrailingActivationFunctionDirectedComponentChain<L extends ChainableDirectedComponent<NeuronsActivation, ? extends ChainableDirectedComponentActivation<NeuronsActivation>, ?>>
		extends DirectedComponentChain<NeuronsActivation, L, ChainableDirectedComponentActivation<NeuronsActivation>, TrailingActivationFunctionDirectedComponentChainActivation> {

	DifferentiableActivationFunctionComponent getFinalComponent();
	
}
