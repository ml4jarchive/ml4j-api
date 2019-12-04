package org.ml4j.nn.components.builders.axons;

import java.util.function.Consumer;

import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.neurons.Neurons3D;

public interface UncompletedConvolutionalAxonsBuilder<C> extends UncompletedTrainableAxonsBuilder<Neurons3D, C, UncompletedConvolutionalAxonsBuilder<C>> {
	UncompletedConvolutionalAxonsBuilder<C> withStride(int widthStride, int heightStride);
	UncompletedConvolutionalAxonsBuilder<C> withFilterSize(int width, int height);
	UncompletedConvolutionalAxonsBuilder<C> withFilterCount(int filterCount);
	UncompletedConvolutionalAxonsBuilder<C> withValidPadding();
	UncompletedConvolutionalAxonsBuilder<C> withSamePadding();
	UncompletedConvolutionalAxonsBuilder<C> withPadding(int widthPadding, int heightPadding);
	UncompletedConvolutionalAxonsBuilder<C> withAxonsContext(DirectedComponentsContext directedComponentsContext, Consumer<AxonsContext> axonsContextConfigurer);

	int getStrideWidth();
	int getStrideHeight();
	int getPaddingWidth();
	int getPaddingHeight();

}
