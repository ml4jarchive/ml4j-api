package org.ml4j.nn.datasets.floatarray;

import org.ml4j.nn.datasets.LabeledDataSet;

public interface FloatArrayLabeledDataSet extends LabeledDataSet<float[], float[]> {

	FloatArrayBatchedLabeledDataSet toBatchedLabeledDataSet(int batchSize);

}
