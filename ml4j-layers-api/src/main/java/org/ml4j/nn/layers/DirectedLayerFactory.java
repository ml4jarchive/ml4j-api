package org.ml4j.nn.layers;

import org.ml4j.nn.activationfunctions.ActivationFunctionProperties;
import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.axons.Axons3DConfig;
import org.ml4j.nn.axons.AxonsConfig;
import org.ml4j.nn.axons.BiasMatrix;
import org.ml4j.nn.axons.WeightsMatrix;
import org.ml4j.nn.neurons.Neurons;

public interface DirectedLayerFactory {

	FullyConnectedFeedForwardLayer createFullyConnectedFeedForwardLayer(String name, AxonsConfig<Neurons, Neurons> axonsConfig, WeightsMatrix connectionWeights, BiasMatrix biases,
			ActivationFunctionType activationFunctionType, ActivationFunctionProperties activationFunctionProperties,
			boolean withBatchNorm);

	MaxPoolingFeedForwardLayer createMaxPoolingFeedForwardLayer(String name, Axons3DConfig axons3DConfig, boolean scaleOutputs);

	AveragePoolingFeedForwardLayer createAveragePoolingFeedForwardLayer(String name, 
			Axons3DConfig axons3DConfig);

	ConvolutionalFeedForwardLayer createConvolutionalFeedForwardLayer(String name,
			Axons3DConfig axons3DConfig,
			WeightsMatrix connectionWeights, BiasMatrix biases, ActivationFunctionType activationFunctionType, ActivationFunctionProperties activationFunctionProperties, boolean withBatchNorm);

}
