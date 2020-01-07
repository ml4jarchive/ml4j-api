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

import java.util.stream.Stream;

import org.ml4j.nn.datasets.floatarray.FloatArrayLabeledDataSet;
import org.ml4j.streams.Streamable;


/**
 * Encapsulates a DataSet of LabeledData elements containing elements and labels of a defined type
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of element within each LabeledData instance with this DataSet
 * @param <L> The type of label within each LabeledData instance with this DataSet
 */
public interface LabeledDataSet<E, L> extends Streamable<LabeledData<E, L>> {

	/**
	 * @return A DataSet consisting of only the elements of this LabeledDataSet.
	 */
	DataSet<E> getDataSet();

	/**
	 * @return A DataSet consisting of only the labels of this LabeledDataSet.
	 */
	DataSet<L> getLabelsSet();

	/**
	 * @return A stream of the labels of this LabeledDataSet.
	 */
	Stream<L> getLabels();

	/**
	 * @return A stream of the LabeledData instances of this LabeledDataSet.
	 */
	Stream<LabeledData<E, L>> stream();

	/**
	 * Convert to a BatchedLabeledDataSet, with each batch containing at most batchSize elements with their labels.
	 * 
	 * @param batchSize The maximum size of each batch in the returned BatchedLabeledDataSet.
	 * @return A BatchedLabeledDataSet.
	 */
	BatchedLabeledDataSet<E, L> toBatchedLabeledDataSet(int batchSize);
	
	/**
	 * Convert to a FloatArrayLabeledDataSet, using the specified featureExtractor and labelMapper to map elements and labels
	 * to float arrays.
	 * 
	 * 
	 * @param featureExtractor The feature extractor used to convert each element of type E to a float array.
	 * @param labelMapper The label mapper used to convert each element of type L to a float array.
	 * @param featureExtractionErrorMode How to handle exceptions occuring during the feature extraction process.
	 * @return A FloatArrayLabeledDataSet
	 */
	FloatArrayLabeledDataSet toFloatArrayLabeledDataSet(FeatureExtractor<E> featureExtractor, FeatureExtractor<L> labelMapper, FeatureExtractionErrorMode featureExtractionErrorMode);


}
