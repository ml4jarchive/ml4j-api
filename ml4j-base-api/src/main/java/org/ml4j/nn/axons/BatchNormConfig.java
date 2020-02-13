package org.ml4j.nn.axons;

import java.util.function.ToIntFunction;

import org.ml4j.Matrix;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.Neurons3D;
import org.ml4j.nn.neurons.format.features.Dimension;

public class BatchNormConfig<N extends Neurons> {
	
	private BatchNormDimension<N> batchNormDimension;
	private WeightsMatrix gammaColumnVector;
	private BiasMatrix betaColumnVector;
	private Matrix meanColumnVector;
	private Matrix varianceColumnVector;
	
	public BatchNormConfig(BatchNormDimension<N> batchNormDimension) {
		this.batchNormDimension = batchNormDimension;
	}

	public static class BatchNormDimension<L extends Neurons> {
		
		public static final BatchNormDimension<Neurons> INPUT_FEATURE = 
				new BatchNormDimension<>(Dimension.FEATURE, n -> n.getNeuronCountExcludingBias());
		
		public static final BatchNormDimension<Neurons3D> 
			CHANNEL = new BatchNormDimension<>(Dimension.CHANNEL, n -> n.getDepth());
		
		private Dimension inputDimension;
		private ToIntFunction<L> dimensionSizeFunction;
		
		BatchNormDimension(Dimension inputDimension, ToIntFunction<L> dimensionSizeFunction) {
			this.inputDimension = inputDimension;
			this.dimensionSizeFunction = dimensionSizeFunction;
		}
		
		public int getDimensionSize(L neurons) {
			return dimensionSizeFunction.applyAsInt(neurons);
		}
		
		public Dimension getInputDimension() {
			return inputDimension;
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

	public BatchNormDimension<N> getBatchNormDimension() {
		return batchNormDimension;
	}
	
	public BatchNormConfig<N> dup() {
		BatchNormConfig<N> config = new BatchNormConfig<>(batchNormDimension);
		if (gammaColumnVector != null) {
			config.withGammaColumnVector(gammaColumnVector.dup());
		}
		if (betaColumnVector != null) {
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
