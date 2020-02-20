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

import org.ml4j.nn.neurons.Neurons;

public class BatchNormAxonsConfig<N extends Neurons> extends BatchNormConfig<N> implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private AxonsContextConfigurer batchNormAxonsContextConfigurer;
	private N neurons;

	public static <N extends Neurons> BatchNormAxonsConfig<N> create(BatchNormDimension<N> dimension) {
		return new BatchNormAxonsConfig<>(dimension);
	}
	
	public BatchNormAxonsConfig(BatchNormDimension<N> batchNormDimension) {
		super(batchNormDimension);
	}
	
	public BatchNormAxonsConfig<N> withNeurons(N neurons) {
		this.neurons = neurons;
		return this;
	}

	public N getNeurons() {
		return neurons;
	}
	
	public AxonsConfig<N, N> getAxonsConfig() {
		return new AxonsConfig<>(neurons, neurons);
	}

	public BatchNormAxonsConfig<N> withBatchNormAxonsContextConfigurer(AxonsContextConfigurer batchNormAxonsContextConfigurer) {
		this.batchNormAxonsContextConfigurer = batchNormAxonsContextConfigurer;
		return this;
	}

	public BatchNormConfig<N> getBatchNormConfig() {
		return this;
	}

	public AxonsContextConfigurer getBatchNormAxonsContextConfigurer() {
		return batchNormAxonsContextConfigurer;
	}

	@Override
	public BatchNormAxonsConfig<N> withGammaColumnVector(WeightsVector gammaColumnVector) {
		super.withGammaColumnVector(gammaColumnVector);
		return this;
	}

	@Override
	public BatchNormAxonsConfig<N>  withBetaColumnVector(BiasVector betaColumnVector) {
		super.withBetaColumnVector(betaColumnVector);
		return this;
	}

	@Override
	public BatchNormAxonsConfig<N>  withMeanColumnVector(FeaturesVector meanColumnVector) {
		super.withMeanColumnVector(meanColumnVector);
		return this;
	}

	@Override
	public BatchNormAxonsConfig<N>  withVarianceColumnVector(FeaturesVector varianceColumnVector) {
		super.withVarianceColumnVector(varianceColumnVector);
		return this;
	}
	
	
}
