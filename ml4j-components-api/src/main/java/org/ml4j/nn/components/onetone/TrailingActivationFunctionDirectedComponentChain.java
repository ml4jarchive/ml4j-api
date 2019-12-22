package org.ml4j.nn.components.onetone;

import java.util.List;

import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.activationfunctions.DifferentiableActivationFunctionComponent;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface TrailingActivationFunctionDirectedComponentChain
		extends DefaultDirectedComponentChain {

	DifferentiableActivationFunctionComponent getFinalComponent();

	@Override
	TrailingActivationFunctionDirectedComponentChain dup();

	@Override
	List<DefaultChainableDirectedComponent<?, ?>> decompose();

	@Override
	TrailingActivationFunctionDirectedComponentChainActivation forwardPropagate(NeuronsActivation input,
			DirectedComponentsContext context);
	
	
	
}
