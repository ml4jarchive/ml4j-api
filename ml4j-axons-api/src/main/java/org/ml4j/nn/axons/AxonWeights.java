package org.ml4j.nn.axons;

import java.io.Serializable;

import org.ml4j.Matrix;

public interface AxonWeights extends Serializable {
	
	Matrix getConnectionWeights();
	Matrix getLeftToRightBiases();
	Matrix getRightToLeftBiases();
	int getInputNeuronCount();
	int getOutputNeuronsCount();
	
	void adjustLeftToRightBiases(Matrix adjustment, ConnectionWeightsAdjustmentDirection adjustmentDirection);
	void adjustRightToLeftBiases(Matrix adjustment, ConnectionWeightsAdjustmentDirection adjustmentDirection);
	void adjustConnectionWeights(Matrix adjustment, ConnectionWeightsAdjustmentDirection adjustmentDirection, boolean initialisation);
	
	Matrix applyToInput(Matrix input);
	Matrix applyToGradient(Matrix input);


}
