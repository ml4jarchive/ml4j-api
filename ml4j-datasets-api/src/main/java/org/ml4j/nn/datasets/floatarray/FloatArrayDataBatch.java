package org.ml4j.nn.datasets.floatarray;

import org.ml4j.Matrix;
import org.ml4j.MatrixFactory;
import org.ml4j.nn.datasets.DataBatch;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface FloatArrayDataBatch extends DataBatch<float[]> {

	Matrix getAsMatrix(MatrixFactory matrixFactory);

	NeuronsActivation toNeuronsActivation(MatrixFactory matrixFactory);

}
