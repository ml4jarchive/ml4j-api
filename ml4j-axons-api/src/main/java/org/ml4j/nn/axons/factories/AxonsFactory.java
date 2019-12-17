package org.ml4j.nn.axons.factories;

import java.io.Serializable;

import org.ml4j.Matrix;
import org.ml4j.nn.axons.AveragePoolingAxons;
import org.ml4j.nn.axons.ConvolutionalAxons;
import org.ml4j.nn.axons.FullyConnectedAxonsFactory;
import org.ml4j.nn.axons.MaxPoolingAxons;
import org.ml4j.nn.axons.ScaleAndShiftAxons;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.Neurons3D;

public interface AxonsFactory extends FullyConnectedAxonsFactory, Serializable {

	ConvolutionalAxons createConvolutionalAxons(Neurons3D leftNeurons, Neurons3D rightNeurons, int strideWidth, int strideHeight, Integer paddingWidth, Integer paddingHeight, Matrix connectionWeights, Matrix biases);
	MaxPoolingAxons createMaxPoolingAxons(Neurons3D leftNeurons, Neurons3D rightNeurons, boolean scaleOutputs, int stideWidth, int strideHeight, int paddingWidth, int paddingHeight);
	AveragePoolingAxons createAveragePoolingAxons(Neurons3D leftNeurons, Neurons3D rightNeurons, int stideWidth, int strideHeight, int paddingWidth, int paddingHeight);
	<N extends Neurons> ScaleAndShiftAxons<N> createScaleAndShiftAxons(N leftNeurons, N rightNeurons, Matrix gamma, Matrix beta);
}
