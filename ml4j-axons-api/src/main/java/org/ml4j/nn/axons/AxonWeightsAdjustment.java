package org.ml4j.nn.axons;

import java.util.Optional;

import org.ml4j.Matrix;

public interface AxonWeightsAdjustment {

	Matrix getConnectionWeights();
	Optional<Matrix> getLeftToRightBiases();
	Optional<Matrix> getRightToLeftBiases();
	
}
