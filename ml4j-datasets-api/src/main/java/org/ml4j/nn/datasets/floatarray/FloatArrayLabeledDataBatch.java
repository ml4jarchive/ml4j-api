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
import org.ml4j.nn.datasets.LabeledData;
import org.ml4j.nn.datasets.LabeledDataBatch;
import org.ml4j.nn.neurons.NeuronsActivation;
import org.ml4j.nn.neurons.format.NeuronsActivationFormat;

/**
 * Convenience interface for a LabeledDataBatch of float arrays.
 * 
 * @author Michael Lavelle
 */
public interface FloatArrayLabeledDataBatch extends LabeledDataBatch<float[], float[]> {

	/**
	 * Obtain the elements of this FloatArrayLabeledDataBatch ( without labels) as a
	 * FloatArrayDataBatch
	 */
	FloatArrayDataBatch getDataSet();

	/**
	 * Obtain the labels of this FloatArrayLabeledDataBatch as a FloatArrayDataBatch
	 */
	FloatArrayDataBatch getLabelsSet();

	/**
	 * Convert this FloatArrayLabeledDataBatch to a pair of NeuronsActivations - one
	 * NeuronsActivation containing the elements and another for the labels.
	 * 
	 * @param matrixFactory
	 * @param format        The desired format of NeuronsActivations in the result
	 * @return
	 */
	LabeledData<NeuronsActivation, NeuronsActivation> toNeuronsActivations(MatrixFactory matrixFactory,
			NeuronsActivationFormat<?> format);

}
