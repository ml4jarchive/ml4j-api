package org.ml4j.nn.datasets;

import java.util.stream.Stream;

import org.ml4j.nn.datasets.floatarray.FloatArrayLabeledDataSet;
import org.ml4j.streams.Streamable;


public interface LabeledDataSet<E, L> extends Streamable<LabeledData<E, L>> {

	DataSet<E> getDataSet();

	DataSet<L> getLabelsSet();

	Stream<L> getLabels();

	Stream<LabeledData<E, L>> stream();

	BatchedLabeledDataSet<E, L> toBatchedLabeledDataSet(int batchSize);
	
	FloatArrayLabeledDataSet toFloatArrayLabeledDataSet(FeatureExtractor<E> featureExtractor, FeatureExtractor<L> labelMapper, FeatureExtractionErrorMode featureExtractionErrorMode);


}
