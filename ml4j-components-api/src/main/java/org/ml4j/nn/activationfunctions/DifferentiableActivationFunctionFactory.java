package org.ml4j.nn.activationfunctions;

public interface DifferentiableActivationFunctionFactory {

	DifferentiableActivationFunction createReluActivationFunction(); 
	DifferentiableActivationFunction createSigmoidActivationFunction(); 
	DifferentiableActivationFunction createSoftmaxActivationFunction(); 
}
