package org.ml4j.nn.components.axons;

import org.ml4j.Matrix;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.Neurons3D;

public interface DirectedAxonsComponentFactory {

	DirectedAxonsComponent<Neurons, Neurons> createFullyConnectedAxonsComponent(Neurons leftNeurons, Neurons rightNeurons, Matrix connectionWeights, Matrix biases);
	
	DirectedAxonsComponent<Neurons3D, Neurons3D> createConvolutionalAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, int strideWidth, int strideHeight, Integer paddingWidth, Integer paddingHeight, Matrix connectionWeights, Matrix biases);

	DirectedAxonsComponent<Neurons3D, Neurons3D> createMaxPoolingAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, int strideWidth, int strideHeight, Integer paddingWidth, Integer paddingHeight, boolean scaleOutputs);

	DirectedAxonsComponent<Neurons3D, Neurons3D> createAveragePoolingAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, int strideWidth, int strideHeight, Integer paddingWidth, Integer paddingHeight);

	<N extends Neurons> BatchNormDirectedAxonsComponent<N, N> createBatchNormAxonsComponent(N leftNeurons, N rightNeurons);
	
	<N extends Neurons> BatchNormDirectedAxonsComponent<N, N> createBatchNormAxonsComponent(N leftNeurons, N rightNeurons, Matrix gamma, Matrix beta, Matrix mean, Matrix stddev);


}
