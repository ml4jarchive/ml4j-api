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
import org.ml4j.nn.neurons.Neurons3D;

public interface UncompletedBatchNormAxonsBuilder<C> extends UncompletedTrainableAxonsBuilder<Neurons3D, C, UncompletedBatchNormAxonsBuilder<C>> {

	UncompletedBatchNormAxonsBuilder<C> withAxonsContextConfigurer(Consumer<AxonsContext> axonsContextConfigurer);
	UncompletedBatchNormAxonsBuilder<C> withGamma(Matrix gamma);
	UncompletedBatchNormAxonsBuilder<C> withBeta(Matrix beta);
	UncompletedBatchNormAxonsBuilder<C> withMean(Matrix mean);
	UncompletedBatchNormAxonsBuilder<C> withVariance(Matrix variance);
	Matrix getGamma();
	Matrix getBeta();
	Matrix getMean();
	Matrix getVariance();




}
