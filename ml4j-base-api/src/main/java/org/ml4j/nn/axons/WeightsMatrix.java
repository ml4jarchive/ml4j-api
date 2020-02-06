package org.ml4j.nn.axons;

import org.ml4j.Matrix;

public interface WeightsMatrix {

	Matrix getWeights();
	WeightsFormat getFormat();
	WeightsMatrix dup();
}
