package org.ml4j.nn.datasets.floatarray;

import org.ml4j.nn.datasets.LabeledDataBatch;

public interface FloatArrayLabeledDataBatch extends LabeledDataBatch<float[], float[]> {

	FloatArrayDataBatch getDataSet();

	FloatArrayDataBatch getLabelsSet();

}
