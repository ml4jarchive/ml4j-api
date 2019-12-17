package org.ml4j.nn.datasets.floatarray;

import org.ml4j.MatrixFactory;
import org.ml4j.nn.datasets.BatchedDataSet;
import org.ml4j.nn.datasets.neuronsactivation.NeuronsActivationDataSet;

public interface FloatArrayBatchedDataSet extends BatchedDataSet<float[]> {

	NeuronsActivationDataSet toNeuronsActivationDataSet(MatrixFactory matrixFactory);

}
