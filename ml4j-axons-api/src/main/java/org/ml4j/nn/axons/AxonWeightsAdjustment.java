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

/**
 * Encapsulates an adjustment request to AxonWeights values.
 * 
 * @author Michael Lavelle
 *
 */
public interface AxonWeightsAdjustment {

	/**
	 * @return The AxonWeights connection weights adjustment.
	 */
	Matrix getConnectionWeights();

	/**
	 * 
	 * @return An optional adjustment to the AxonWeights leftToRightBiases
	 */
	Optional<Matrix> getLeftToRightBiases();

	/**
	 * 
	 * @return An optional adjustment to the AxonWeights rightToLeftBiases.
	 */
	Optional<Matrix> getRightToLeftBiases();

}
