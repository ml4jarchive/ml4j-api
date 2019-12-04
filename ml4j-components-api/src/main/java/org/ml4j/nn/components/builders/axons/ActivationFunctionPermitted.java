package org.ml4j.nn.components.builders.axons;

import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;

public interface ActivationFunctionPermitted<C>{

	C withActivationFunction(DifferentiableActivationFunction activationFunction);
}
