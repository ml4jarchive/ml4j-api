package org.ml4j.nn.components.builders.axons;

import java.util.function.Consumer;

import org.ml4j.Matrix;
import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.neurons.Neurons3D;

public interface UncompletedBatchNormAxonsBuilder<C> extends UncompletedTrainableAxonsBuilder<Neurons3D, C, UncompletedBatchNormAxonsBuilder<C>> {

	UncompletedBatchNormAxonsBuilder<C> withAxonsContext(DirectedComponentsContext directedComponentsContext, Consumer<AxonsContext> axonsContextConfigurer);
	UncompletedBatchNormAxonsBuilder<C> withGamma(Matrix gamma);
	UncompletedBatchNormAxonsBuilder<C> withBeta(Matrix beta);
	UncompletedBatchNormAxonsBuilder<C> withMean(Matrix mean);
	UncompletedBatchNormAxonsBuilder<C> withVariance(Matrix variance);
	Matrix getGamma();
	Matrix getBeta();
	Matrix getMean();
	Matrix getVariance();




}
