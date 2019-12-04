package org.ml4j.nn.components.builders.axons;

import org.ml4j.nn.neurons.Neurons3D;

public interface UncompletedPoolingAxonsBuilder<C> extends UncompletedAxonsBuilder<Neurons3D, C> {
	UncompletedPoolingAxonsBuilder<C> withStride(int widthStride, int heightStride);
	UncompletedPoolingAxonsBuilder<C> withFilterSize(int width, int height);
	UncompletedPoolingAxonsBuilder<C> withPadding(int widthPadding, int heightPadding);
	UncompletedPoolingAxonsBuilder<C> withValidPadding();
	UncompletedPoolingAxonsBuilder<C> withSamePadding();
	boolean isScaleOutputs();
	UncompletedPoolingAxonsBuilder<C> withScaledOutputs();
	int getStrideWidth();
	int getStrideHeight();
	int getPaddingWidth();
	int getPaddingHeight();

}
