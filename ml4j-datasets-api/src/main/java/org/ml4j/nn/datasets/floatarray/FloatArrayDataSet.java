package org.ml4j.nn.datasets.floatarray;

import org.ml4j.nn.datasets.DataSet;

public interface FloatArrayDataSet extends DataSet<float[]> {

	FloatArrayBatchedDataSet toBatchedDataSet(int batchSize);
}
