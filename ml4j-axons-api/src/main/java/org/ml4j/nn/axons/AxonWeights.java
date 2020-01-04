package org.ml4j.nn.axons;

import java.io.Serializable;

import org.ml4j.Matrix;

public interface AxonWeights extends Serializable {
	
	Matrix getConnectionWeights();
	Matrix getLeftToRightBiases();
	Matrix getRightToLeftBiases();
	int getInputNeuronCount();
	int getOutputNeuronsCount();
	AxonWeights dup();
	
	void adjustWeights(AxonWeightsAdjustment axonWeightsAdjustment, AxonWeightsAdjustmentDirection adjustmentDirection);
	
	Matrix applyToLeftToRightInput(Matrix input);
	
	Matrix applyToRightToLeftInput(Matrix input);


}
