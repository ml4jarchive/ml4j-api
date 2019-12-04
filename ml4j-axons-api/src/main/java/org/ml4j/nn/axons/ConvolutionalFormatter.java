package org.ml4j.nn.axons;

import org.ml4j.Matrix;
import org.ml4j.MatrixFactory;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface ConvolutionalFormatter {

	Matrix reformatLeftToRightInput(MatrixFactory matrixFactory, NeuronsActivation activations);

	Matrix reformatRightToLeftOutput(MatrixFactory matrixFactory, Matrix initialOutputMatrix);

	Matrix reformatRightToLeftInput(MatrixFactory matrixFactory, NeuronsActivation activations1);

	Matrix reformatLeftToRightOutput(MatrixFactory matrixFactory, Matrix origOutput);
	
	  Matrix getIndexes();

}
