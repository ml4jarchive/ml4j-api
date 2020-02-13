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

import java.util.function.Consumer;

import org.ml4j.Matrix;
import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.axons.BatchNormConfig.BatchNormDimension;
import org.ml4j.nn.axons.BiasMatrix;
import org.ml4j.nn.axons.WeightsMatrix;

public interface UncompletedBatchNormAxonsBuilder<N, C>
		extends UncompletedTrainableAxonsBuilder<N, C, UncompletedBatchNormAxonsBuilder<N, C>> {

	UncompletedBatchNormAxonsBuilder<N, C> withAxonsContextConfigurer(Consumer<AxonsContext> axonsContextConfigurer);

	UncompletedBatchNormAxonsBuilder<N, C> withGamma(WeightsMatrix gamma);

	UncompletedBatchNormAxonsBuilder<N, C> withBeta(BiasMatrix beta);

	UncompletedBatchNormAxonsBuilder<N, C> withMean(Matrix mean);

	UncompletedBatchNormAxonsBuilder<N, C> withVariance(Matrix variance);

	WeightsMatrix getGamma();

	BiasMatrix getBeta();

	Matrix getMean();

	Matrix getVariance();
	
	BatchNormDimension getBatchNormDimension();

}
