package org.ml4j.nn.axons;

import org.ml4j.Matrix;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.format.features.Dimension;

public class BatchNormConfig<N extends Neurons> {
	
	private BatchNormDimension batchNormDimension;
	private WeightsMatrix gammaColumnVector;
	private BiasMatrix betaColumnVector;
	private Matrix meanColumnVector;
	private Matrix varianceColumnVector;
	private N neurons;
	
	public BatchNormConfig(N neurons, BatchNormDimension batchNormDimension) {
		this.neurons = neurons;
		this.batchNormDimension = batchNormDimension;
	}
	
	public N getNeurons() {
		return neurons;
	}

	public enum BatchNormDimension {
		INPUT_FEATURE(Dimension.FEATURE), CHANNEL(Dimension.CHANNEL);
		
		Dimension inputDimension;
		
		BatchNormDimension(Dimension inputDimension) {
			this.inputDimension = inputDimension;
		}
	}

	public WeightsMatrix getGammaColumnVector() {
		return gammaColumnVector;
	}

	public BatchNormConfig<N> withGammaColumnVector(WeightsMatrix gammaColumnVector) {
		this.gammaColumnVector = gammaColumnVector;
		return this;
	}

	public BiasMatrix getBetaColumnVector() {
		return betaColumnVector;
	}

	public BatchNormConfig<N> withBetaColumnVector(BiasMatrix betaColumnVector) {
		this.betaColumnVector = betaColumnVector;
		return this;
	}

	public Matrix getMeanColumnVector() {
		return meanColumnVector;
	}

	public BatchNormConfig<N> withMeanColumnVector(Matrix meanColumnVector) {
		this.meanColumnVector = meanColumnVector;
		return this;
	}

	public Matrix getVarianceColumnVector() {
		return varianceColumnVector;
	}

	public BatchNormConfig<N> withVarianceColumnVector(Matrix varianceColumnVector) {
		this.varianceColumnVector = varianceColumnVector;
		return this;
	}

	public BatchNormDimension getBatchNormDimension() {
		return batchNormDimension;
	}
	
	public BatchNormConfig<N> dup() {
		BatchNormConfig<N> config = new BatchNormConfig<N>(neurons, batchNormDimension);
		if (betaColumnVector != null) {
			config.withBetaColumnVector(betaColumnVector.dup());
		}
		if (gammaColumnVector != null) {
			config.withBetaColumnVector(betaColumnVector.dup());
		}
		if (meanColumnVector != null) {
			config.withMeanColumnVector(meanColumnVector.dup());
		}
		if (varianceColumnVector != null) {
			config.withMeanColumnVector(varianceColumnVector.dup());
		}
		return config;
	}

}
