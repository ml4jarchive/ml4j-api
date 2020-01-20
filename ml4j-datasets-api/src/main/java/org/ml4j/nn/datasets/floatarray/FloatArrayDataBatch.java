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
package org.ml4j.nn.datasets.floatarray;

import org.ml4j.Matrix;
import org.ml4j.MatrixFactory;
import org.ml4j.nn.datasets.DataBatch;
import org.ml4j.nn.neurons.NeuronsActivation;
import org.ml4j.nn.neurons.NeuronsActivationFeatureOrientation;

/**
 * Convenience interface for a DataBatch of float arrays.
 * 
 * @author Michael Lavelle
 */
public interface FloatArrayDataBatch extends DataBatch<float[]> {

	/**
	 * Obtain the data within this FloatArrayDataBatch as a Matrix, with each float
	 * array element forming a row in the matrix.
	 * 
	 * @param matrixFactory The matrix factory used to construct the Matrix.
	 * @return The Matrix.
	 */
	Matrix getAsMatrix(MatrixFactory matrixFactory);

	/**
	 * Obtain the data within this FloatArrayDataBatch as a NeuronsActivation
	 * instance.
	 * 
	 * @param matrixFactory      The matrix factory used to construct the
	 *                           NeuronsActivation.
	 * @param featureOrientation The desired feature orientation of the resulting
	 *                           NeuronsActivationLabeledDataSet
	 * @return The NeuronsActivation.
	 */
	NeuronsActivation toNeuronsActivation(MatrixFactory matrixFactory,
			NeuronsActivationFeatureOrientation featureOrientation);

}
