package org.ml4j.nn.axons;

import org.ml4j.Matrix;

public class FeaturesVectorImpl implements FeaturesVector {
	
	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private Matrix matrix;
	private FeaturesVectorFormat format;

	public FeaturesVectorImpl(Matrix matrix, FeaturesVectorFormat format) {
		this.matrix = matrix;
		this.format = format;
	}
	
	@Override
	public Matrix getVector() {
		return matrix;
	}

	@Override
	public FeaturesVectorFormat getFormat() {
		return format;
	}

	@Override
	public FeaturesVector dup() {
		return new FeaturesVectorImpl(matrix.dup(), format);
	}
}
