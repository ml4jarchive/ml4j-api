package org.ml4j.nn.axons;

import java.io.Serializable;

import org.ml4j.Matrix;

public interface WeightsMatrix extends Serializable {

	Matrix getWeights();
	WeightsFormat getFormat();
	WeightsMatrix dup();
}
