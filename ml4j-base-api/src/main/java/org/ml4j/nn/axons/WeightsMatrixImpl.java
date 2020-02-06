package org.ml4j.nn.axons;

import org.ml4j.Matrix;

public class WeightsMatrixImpl implements WeightsMatrix {

	private Matrix weights;
	private WeightsFormat format;
	
	public WeightsMatrixImpl(Matrix weights, WeightsFormat format) {
		this.weights = weights;
		this.format = format;
	}
	
	@Override
	public Matrix getWeights() {
		return weights;
	}

	@Override
	public WeightsFormat getFormat() {
		return format;
	}

	@Override
	public WeightsMatrix dup() {
		return new WeightsMatrixImpl(weights.dup(), format);
	}
}
