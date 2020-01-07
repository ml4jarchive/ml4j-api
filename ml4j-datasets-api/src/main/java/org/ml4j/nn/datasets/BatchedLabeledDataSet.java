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
package org.ml4j.nn.datasets;

import org.ml4j.nn.datasets.floatarray.FloatArrayBatchedLabeledDataSet;

/**
 * Encapsulates a BatchedDataSet consisting of DataBatch instances containing LabeledData instances of a defined type.
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of element within each LabeledData instance within each DataBatch.
 * @param <L> The type of label within each LabeledData instance withinin each DataBatch.
 */
public interface BatchedLabeledDataSet<E, L> extends BatchedDataSet<LabeledData<E, L>> {

	/**
	 * Convert this BatchedLabeledDataSet to a FloatArrayBatchedLabeledDataSet
	 * 
	 * @param featureExtractor The feature extractor used to obtain the float arrays.
	 * @param labelMapper The mapper used to obtain the float array labels.
	 * @param featureExtractionErrorMode The error mode.
	 * @return a FloatArrayBatchedLabeledDataSet.
	 */
	FloatArrayBatchedLabeledDataSet toFloatArrayBatchedLabeledDataSet(FeatureExtractor<E> featureExtractor, FeatureExtractor<L> labelMapper, FeatureExtractionErrorMode featureExtractionErrorMode);
}
