package org.ml4j.nn.activationfunctions;

import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.neurons.NeuronsActivation;
import org.ml4j.nn.neurons.NeuronsActivationContext;

public interface DifferentiableActivationFunctionComponent extends ChainableDirectedComponent<NeuronsActivation, DifferentiableActivationFunctionActivation, NeuronsActivationContext> {

	DifferentiableActivationFunction getActivationFunction();
}
