package org.ml4j.nn.datasets;

import org.ml4j.nn.datasets.floatarray.FloatArrayBatchedLabeledDataSet;

public interface BatchedLabeledDataSet<E, L> extends BatchedDataSet<LabeledData<E, L>> {

	FloatArrayBatchedLabeledDataSet toFloatArrayBatchedLabeledDataSet(FeatureExtractor<E> featureExtractor, FeatureExtractor<L> labelMapper, FeatureExtractionErrorMode featureExtractionErrorMode);
}
