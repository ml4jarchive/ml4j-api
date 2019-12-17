package org.ml4j.nn.datasets.floatarray;

import org.ml4j.MatrixFactory;
import org.ml4j.nn.datasets.LabeledData;
import org.ml4j.nn.datasets.LabeledDataBatch;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface FloatArrayLabeledDataBatch extends LabeledDataBatch<float[], float[]> {

	FloatArrayDataBatch getDataSet();

	FloatArrayDataBatch getLabelsSet();
	
	LabeledData<NeuronsActivation, NeuronsActivation> toNeuronsActivations(MatrixFactory matrixFactory);

}
