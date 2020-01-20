/*
 * Copyright 2019 the original author or authors.
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
package org.ml4j.nn.activationfunctions.factories;

import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;

/**
 * Factory for different types of DifferentiableActivationFunction.
 * 
 * @author Michael Lavelle
 *
 */
public interface DifferentiableActivationFunctionFactory {

	/**
	 * @return A RELU activation function instance.
	 */
	DifferentiableActivationFunction createReluActivationFunction();

	/**
	 * @return A sigmoid activation function instance.
	 */
	DifferentiableActivationFunction createSigmoidActivationFunction();

	/**
	 * @return A softmax activation function instance.
	 */
	DifferentiableActivationFunction createSoftmaxActivationFunction();

	/**
	 * @return A linear (identity) activation function instance.
	 */
	DifferentiableActivationFunction createLinearActivationFunction();

	/**
	 * @param activationFunctionType The type of activation function required.
	 * @return A DifferentiableActivationFunction given the provided
	 *         activationFunctionType;
	 */
	DifferentiableActivationFunction createActivationFunction(ActivationFunctionType activationFunctionType);

}
