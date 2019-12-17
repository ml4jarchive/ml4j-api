package org.ml4j.nn.activationfunctions.factories;

import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;

public interface DifferentiableActivationFunctionFactory {

	DifferentiableActivationFunction createReluActivationFunction(); 
	DifferentiableActivationFunction createSigmoidActivationFunction(); 
	DifferentiableActivationFunction createSoftmaxActivationFunction(); 
	DifferentiableActivationFunction createLinearActivationFunction(); 

}
