package org.ml4j.nn.components.builders.axons;

public interface Axons3DPermitted<C extends Axons3DBuilder, A extends AxonsBuilder> extends AxonsPermitted<A> {

	UncompletedConvolutionalAxonsBuilder<C> withConvolutionalAxons();
	UncompletedPoolingAxonsBuilder<C> withMaxPoolingAxons();
	UncompletedPoolingAxonsBuilder<C> withAveragePoolingAxons();
	UncompletedBatchNormAxonsBuilder<C> withBatchNormAxons();

}
