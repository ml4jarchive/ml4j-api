/*
 * Copyright 2019 the original author or authors.
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
package org.ml4j.nn.components.builders.axons;

import org.ml4j.nn.axons.AxonsContextConfigurer;
import org.ml4j.nn.axons.BatchNormConfig.BatchNormDimension;
import org.ml4j.nn.axons.BiasVector;
import org.ml4j.nn.axons.FeaturesVector;
import org.ml4j.nn.axons.WeightsVector;
import org.ml4j.nn.neurons.Neurons;

public interface UncompletedBatchNormAxonsBuilder<N extends Neurons, C>
		extends UncompletedTrainableAxonsBuilder<N, C, UncompletedBatchNormAxonsBuilder<N, C>> {

	UncompletedBatchNormAxonsBuilder<N, C> withAxonsContextConfigurer(AxonsContextConfigurer axonsContextConfig);

	UncompletedBatchNormAxonsBuilder<N, C> withGamma(WeightsVector gamma);

	UncompletedBatchNormAxonsBuilder<N, C> withBeta(BiasVector beta);

	UncompletedBatchNormAxonsBuilder<N, C> withMean(FeaturesVector mean);

	UncompletedBatchNormAxonsBuilder<N, C> withVariance(FeaturesVector variance);

	WeightsVector getGamma();

	BiasVector getBeta();

	FeaturesVector getMean();

	FeaturesVector getVariance();
	
	BatchNormDimension<N> getBatchNormDimension();

}
