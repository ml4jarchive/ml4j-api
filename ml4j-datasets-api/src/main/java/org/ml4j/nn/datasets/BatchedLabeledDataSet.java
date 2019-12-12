package org.ml4j.nn.datasets;

import org.ml4j.MatrixFactory;
import org.ml4j.nn.datasets.neuronsactivation.NeuronsActivationLabeledDataSet;

public interface BatchedLabeledDataSet<E, L> extends LabeledDataSet<DataBatch<E>, DataBatch<L>> {

	NeuronsActivationLabeledDataSet toNeuronsActivationLabeledDataSet(MatrixFactory matrixFactory,
			FeatureExtractor<E> featureExtractor, LabelMapper<L> labelMapper);
}
