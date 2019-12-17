package org.ml4j.nn.datasets;

import org.ml4j.nn.datasets.floatarray.FloatArrayBatchedDataSet;

public interface BatchedDataSet<E> extends DataSet<DataBatch<E>> {
	
	FloatArrayBatchedDataSet toFloatArrayBatchedDataSet(FeatureExtractor<E> featureExtractor, FeatureExtractionErrorMode featureExtractionErrorMode);

}
