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

/**
 * Interface for a feature extractor which extracts numerical features from
 * elements of type E.
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of element we wish to extract the features from.
 */
public interface FeatureExtractor<E> {

	/**
	 * Obtain the features of an element as a float array.
	 * 
	 * @param data
	 * @return
	 * @throws FeatureExtractionException
	 */
	float[] getFeatures(E data) throws FeatureExtractionException;

	/**
	 * 
	 * @return The number of elements in the float array representations produced by
	 *         this extractor.
	 */
	int getFeatureCount();

}
