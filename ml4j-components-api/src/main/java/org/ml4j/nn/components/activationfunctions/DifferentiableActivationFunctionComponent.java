package org.ml4j.nn.components.activationfunctions;

import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunctionActivation;
import org.ml4j.nn.components.DefaultChainableDirectedComponent;
import org.ml4j.nn.neurons.NeuronsActivationContext;

public interface DifferentiableActivationFunctionComponent extends DefaultChainableDirectedComponent<DifferentiableActivationFunctionActivation, NeuronsActivationContext> {

	DifferentiableActivationFunction getActivationFunction();
	
	
	@Override
	DifferentiableActivationFunctionComponent dup();
	
}
