/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.ml4j.nn.activationfunctions;

import org.ml4j.nn.neurons.NeuronsActivation;
import org.ml4j.nn.neurons.NeuronsActivationContext;

/**
 *
 * Encapsulates a differentiable (or pseudo-differentiable) function to create
 * an output ActivationFunctionActivation from an input NeuronsActivation -
 * typically applied to the output of Axons to introduce non linearities.
 * 
 * @author Michael Lavelle
 *
 * @param <F> The specific class of this DifferentiableActivationFunction.
 * @param <G> The specific class of DifferentiableActivationFunctionActivation
 *            produced on activation.
 */
public interface DifferentiableActivationFunction
		extends ActivationFunction<DifferentiableActivationFunction, DifferentiableActivationFunctionActivation> {

	/**
	 * Obtains the gradient of a differentiable (or pseudo-differentiable) function
	 * given the output of the function.
	 * 
	 * @param outputActivation The output activation of the
	 *                         DifferentiableActivationFunction
	 * @param context          The context under which we wish to obtain the
	 *                         gradient
	 * @return The gradient neuron activations of the function at the output
	 */
	NeuronsActivation activationGradient(DifferentiableActivationFunctionActivation outputActivation,
			NeuronsActivationContext context);
	
	
	/**
	 * @return The properties of this activation function.
	 */
	ActivationFunctionProperties getActivationFunctionProperties();

}
