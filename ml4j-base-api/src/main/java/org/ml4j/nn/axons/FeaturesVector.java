package org.ml4j.nn.axons;

import java.io.Serializable;

import org.ml4j.Matrix;

public interface FeaturesVector extends Serializable  {

	Matrix getVector();
	FeaturesVectorFormat getFormat();
	FeaturesVector dup();
}
