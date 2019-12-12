package org.ml4j.nn.datasets;

import org.ml4j.MatrixFactory;
import org.ml4j.nn.datasets.neuronsactivation.NeuronsActivationDataSet;

public interface BatchedDataSet<E> extends DataSet<DataBatch<E>> {

	NeuronsActivationDataSet toNeuronsActivationDataSet(MatrixFactory matrixFactory, FeatureExtractor<E> featureExtractor) ;

}
