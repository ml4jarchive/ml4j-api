package org.ml4j.nn.datasets.floatarray;

import org.ml4j.MatrixFactory;
import org.ml4j.nn.datasets.BatchedLabeledDataSet;
import org.ml4j.nn.datasets.neuronsactivation.NeuronsActivationLabeledDataSet;

public interface FloatArrayBatchedLabeledDataSet extends BatchedLabeledDataSet<float[], float[]> {

	NeuronsActivationLabeledDataSet toNeuronsActivationLabeledDataSet(MatrixFactory matrixFactory);

}
