package org.ml4j.nn.axons;

import org.ml4j.Matrix;

public class BiasMatrixImpl implements BiasMatrix {

	private Matrix biasWeights;
	private BiasFormat biasFormat;
	
	public BiasMatrixImpl(Matrix biasWeights) {
		this.biasWeights = biasWeights;
		this.biasFormat = BiasFormat.DEFAULT_BIAS_FORMAT;
	}
	
	public BiasMatrixImpl(Matrix biasWeights, BiasFormat biasFormat) {
		this.biasWeights = biasWeights;
		this.biasFormat = biasFormat;
	}
	
	@Override
	public Matrix getWeights() {
		return biasWeights;
	}

	@Override
	public BiasMatrix dup() {
		return new BiasMatrixImpl(biasWeights.dup());
	}

	@Override
	public BiasFormat getFormat() {
		return biasFormat;
	}
}
