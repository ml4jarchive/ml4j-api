package org.ml4j.nn.datasets;

import org.ml4j.nn.datasets.floatarray.FloatArrayLabeledDataBatch;

public interface LabeledDataBatch<E, L> extends LabeledDataSet<E, L> {

	DataBatch<E> getDataSet();

	int size();

	void add(E element, L label);

	boolean isEmpty();
	
	FloatArrayLabeledDataBatch toFloatArrayLabeledDataBatch(FeatureExtractor<E> featureExtractor, FeatureExtractor<L> labelMapper, FeatureExtractionErrorMode featureExtractionErrorMode);


}
