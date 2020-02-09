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

import org.ml4j.nn.datasets.exceptions.FeatureExtractionException;
import org.ml4j.nn.datasets.floatarray.FloatArrayDataBatch;

/**
 * Encapsulates a finite dynamic-size batch of elements of a defined type
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of element within this DataSet
 */
public interface DataBatch<E> extends DataSet<E> {

	/**
	 * @return The number of elements in this DataBatch.
	 */
	int size();

	/**
	 * Add an element to this DataBatch.
	 * 
	 * @param element The element to add.
	 */
	void add(E element);

	/**
	 * @return Whether this DataBatch is empty.
	 */
	boolean isEmpty();

	/**
	 * Convert to a FloatArrayDataBatch (DataBatch of float arrays), using the
	 * specified FeatureExtractor to extract the float arrays.
	 * 
	 * @param featureExtractor           The feature extractor used to obtain the
	 *                                   float array for each element.
	 * @param featureExtractionErrorMode How to handle any errors occurring during
	 *                                   feature extraction.
	 * @return The FloatArrayDataBatch.
	 * @throws FeatureExtractionException In the event an error occurs during
	 *                                    feature extraction and
	 *                                    FeatureExtractionErrorMode.RAISE_EXCEPTION
	 *                                    is specified
	 */
	FloatArrayDataBatch toFloatArrayDataBatch(FeatureExtractor<E> featureExtractor,
			FeatureExtractionErrorMode featureExtractionErrorMode) throws FeatureExtractionException;

}
