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

import org.ml4j.nn.datasets.floatarray.FloatArrayBatchedDataSet;

/**
 * Encapsulates a DataSet consisting of DataBatch instances containing elements
 * of a defined type.
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of element within each DataBatch within this DataSet
 */
public interface BatchedDataSet<E> extends DataSet<DataBatch<E>> {

	/**
	 * Convert this BatchedDataSet to a FloatArrayBatchedDataSet using the specified
	 * FeatureExtractor.
	 * 
	 * @param featureExtractor The feature extractor we use to convert elements of type E
	 * to float arrays.
	 * @param featureExtractionErrorMode A mode specifying how feature extraction errors should
	 * be handled.
	 * @return A FloatArrayBatchedDataSet instance containing the extracted data from this BatchedDataSet
	 */
	FloatArrayBatchedDataSet toFloatArrayBatchedDataSet(FeatureExtractor<E> featureExtractor,
			FeatureExtractionErrorMode featureExtractionErrorMode);

}
