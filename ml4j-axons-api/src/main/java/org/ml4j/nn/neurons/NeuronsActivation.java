package org.ml4j.nn.neurons;

import org.ml4j.FloatModifier;
import org.ml4j.FloatPredicate;
import org.ml4j.Matrix;
import org.ml4j.MatrixFactory;

public interface NeuronsActivation {
	
	int getFeatureCount();
	int getExampleCount();
	int getRows();
	int getColumns();
	void setImmutable(boolean immutable);
	String getStackTrace();
	boolean isImmutable();
	Matrix getActivations(MatrixFactory matrixFactory);
	NeuronsActivationFeatureOrientation getFeatureOrientation();
	void addInline(MatrixFactory matrixFactory, NeuronsActivation other);
	void combineFeaturesInline(NeuronsActivation other);
	void close();
	Neurons getNeurons();	
	void applyValueModifier(FloatPredicate condition, FloatModifier modifier);
	void applyValueModifier(FloatModifier modifier);
	NeuronsActivation dup();
	ImageNeuronsActivation asImageNeuronsActivation(Neurons3D neurons);

}
