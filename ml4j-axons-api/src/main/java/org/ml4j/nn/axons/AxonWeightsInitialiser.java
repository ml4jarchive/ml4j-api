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

import java.util.Optional;

import org.ml4j.Matrix;
import org.ml4j.MatrixFactory;

/**
 * Encapsulates an initialisation strategy for AxonWeights.
 * 
 * @author Michael Lavelle
 *
 */
public interface AxonWeightsInitialiser {

	/**
	 * Get the initial connection weights for the AxonWeights.
	 * 
	 * @param matrixFactory A MatrixFactory used to construct the matrix.
	 * @return The initial connection weights as a Matrix.
	 */
	Matrix getInitialConnectionWeights(MatrixFactory matrixFactory);


	/**
	 * Get the optional initial left to right biases for the AxonWeights.
	 * 
	 * @param matrixFactory A MatrixFactory used to construct the matrix.
	 * @return The optional initial left to right biases as a Matrix.
	 */
	Optional<Matrix> getInitialLeftToRightBiases(MatrixFactory matrixFactory);

	/**
	 * Get the optional initial right to left biases for the AxonWeights.
	 * 
	 * @param matrixFactory A MatrixFactory used to construct the matrix.
	 * @return The optional initial right to left biases as a Matrix.
	 */
	Optional<Matrix> getInitialRightToLeftBiases(MatrixFactory matrixFactory);

}
