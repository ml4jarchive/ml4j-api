package org.ml4j.nn.axons;

import java.util.Optional;

import org.ml4j.Matrix;
import org.ml4j.MatrixFactory;

public interface AxonWeightsInitialiser {

	Matrix getInitialConnectionWeights(MatrixFactory matrixFactory);
	Optional<Matrix> getInitialLeftToRightBiases(MatrixFactory matrixFactory);
	Optional<Matrix> getInitialRightToLeftBiases(MatrixFactory matrixFactory);
	
}
