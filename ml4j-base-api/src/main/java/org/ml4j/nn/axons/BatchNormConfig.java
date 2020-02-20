/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.ml4j.nn.axons;

import java.io.Serializable;
import java.util.function.ToIntFunction;

import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.Neurons3D;
import org.ml4j.nn.neurons.format.features.Dimension;

public class BatchNormConfig<N extends Neurons> implements Serializable {
	
	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private BatchNormDimension<N> batchNormDimension;
	private WeightsVector gammaColumnVector;
	private BiasVector betaColumnVector;
	private FeaturesVector meanColumnVector;
	private FeaturesVector varianceColumnVector;
	
	public BatchNormConfig(BatchNormDimension<N> batchNormDimension) {
		this.batchNormDimension = batchNormDimension;
	}

	public static class BatchNormDimension<L extends Neurons> implements Serializable{
		
		/**
		 * Default serialization id.
		 */
		private static final long serialVersionUID = 1L;

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

	public WeightsVector getGammaColumnVector() {
		return gammaColumnVector;
	}

	public BatchNormConfig<N> withGammaColumnVector(WeightsVector gammaColumnVector) {
		this.gammaColumnVector = gammaColumnVector;
		return this;
	}

	public BiasVector getBetaColumnVector() {
		return betaColumnVector;
	}

	public BatchNormConfig<N> withBetaColumnVector(BiasVector betaColumnVector) {
		this.betaColumnVector = betaColumnVector;
		return this;
	}

	public FeaturesVector getMeanColumnVector() {
		return meanColumnVector;
	}

	public BatchNormConfig<N> withMeanColumnVector(FeaturesVector meanColumnVector) {
		this.meanColumnVector = meanColumnVector;
		return this;
	}

	public FeaturesVector getVarianceColumnVector() {
		return varianceColumnVector;
	}

	public BatchNormConfig<N> withVarianceColumnVector(FeaturesVector varianceColumnVector) {
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
