/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ml4j.nn.axons;

import java.io.Serializable;

import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Encapsulates the weights within an Axons instance.
 * 
 * @author Michael Lavelle
 *
 */
public interface AxonWeights extends Serializable {

	/**
	 * @return The weights connecting the input neurons to the output neurons.
	 */
	WeightsMatrix getConnectionWeights();

	/**
	 * @return A column vector of left to right biases.
	 */
	BiasMatrix getLeftToRightBiases();

	/**
	 * @return A column vector of right to left biases.
	 */
	BiasMatrix getRightToLeftBiases();

	/**
	 * @return The type of these AxonWeights.
	 */
	AxonWeightsType getType();

	/**
	 * @return The number of input neurons (excluding bias).
	 */
	int getInputNeuronCount();

	/**
	 * @return The number of output neurons (excluding bias).
	 */
	int getOutputNeuronsCount();

	/**
	 * @return A deep copy of these AxonWeights.
	 */
	AxonWeights dup();

	/**
	 * Adjust these AxonWeights using the specified adjustment and direction.
	 * 
	 * @param axonWeightsAdjustment The adjustment.
	 * @param adjustmentDirection   The adjustment direction.
	 */
	void adjustWeights(AxonWeightsAdjustment axonWeightsAdjustment, AxonWeightsAdjustmentDirection adjustmentDirection);

	/**
	 * Apply these AxonWeights to the left to right input of an Axons instance
	 * 
	 * @param input The left to right input.
	 * @return The left to right output after applying these axon weights.
	 */
	NeuronsActivation applyToLeftToRightInput(NeuronsActivation input, AxonsContext axonsContext);

	/**
	 * Apply these AxonWeights to the right to left input of an Axons instance
	 * 
	 * @param input The right to left input.
	 * @return The right to left output after applying these axon weights.
	 */
	NeuronsActivation applyToRightToLeftInput(NeuronsActivation input, AxonsContext axonsContext);

}
