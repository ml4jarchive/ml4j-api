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

import org.ml4j.nn.datasets.floatarray.FloatArrayLabeledDataBatch;

/**
 * Encapsulates a finite dynamic-size batch of LabeledData instances containing
 * elements and labels of a defined type
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of element within each LabeledData instance within this
 *            DataSet
 * @param <L> The type of label within each LabeledData instance within this
 *            DataSet
 */
public interface LabeledDataBatch<E, L> extends LabeledDataSet<E, L> {

	/**
	 * @return A DataBatch consisting of all the elements without labels.
	 */
	DataBatch<E> getDataSet();

	/**
	 * 
	 * @return The size of this LabeledDataBatch
	 */
	int size();

	/**
	 * Add an element and associated label to this LabeledDataBatch
	 * 
	 * @param element The element/
	 * @param label   The label.
	 */
	void add(E element, L label);

	/**
	 * @return Whether this LabeledDataBatch is empty.
	 */
	boolean isEmpty();

	/**
	 * Convert to a FloatArrayLabeledDataBatch, using the specified featureExtractor
	 * and labelMapper to map elements and labels to float arrays.
	 * 
	 * 
	 * @param featureExtractor           The feature extractor used to convert each
	 *                                   element of type E to a float array.
	 * @param labelMapper                The label mapper used to convert each
	 *                                   element of type L to a float array.
	 * @param featureExtractionErrorMode How to handle exceptions occuring during
	 *                                   the feature extraction process.
	 * @return A FloatArrayLabeledDataBatch
	 */
	FloatArrayLabeledDataBatch toFloatArrayLabeledDataBatch(FeatureExtractor<E> featureExtractor,
			FeatureExtractor<L> labelMapper, FeatureExtractionErrorMode featureExtractionErrorMode);

}
