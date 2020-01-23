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

import org.ml4j.MatrixFactory;
import org.ml4j.nn.datasets.BatchedDataSet;
import org.ml4j.nn.datasets.neuronsactivation.NeuronsActivationDataSet;
import org.ml4j.nn.neurons.NeuronsActivationFormat;

/**
 * Convenience interface for a DataSet of DataBatches of float arrays.
 * 
 * @author Michael Lavelle
 */
public interface FloatArrayBatchedDataSet extends BatchedDataSet<float[]> {

	/**
	 * Convert this FloatArrayBatchedDataSet to a NeuronsActivationDataSet
	 * 
	 * @param matrixFactory The matrix factory used to construct the matrices
	 *                      contained within each NeuronsActivation in the result
	 *                      NeuronsActivationDataSet
	 * @param format        The desired format of the resulting
	 *                      NeuronsActivationDataSet
	 * @return The NeuronsActivationDataSet.
	 */
	NeuronsActivationDataSet toNeuronsActivationDataSet(MatrixFactory matrixFactory, NeuronsActivationFormat<?> format);

}
