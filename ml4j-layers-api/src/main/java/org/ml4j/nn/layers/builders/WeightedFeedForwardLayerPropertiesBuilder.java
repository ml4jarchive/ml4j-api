package org.ml4j.nn.layers.builders;

import org.ml4j.nn.activationfunctions.ActivationFunctionBaseType;
import org.ml4j.nn.activationfunctions.ActivationFunctionProperties;
import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.axons.AxonsContextConfigurer;
import org.ml4j.nn.axons.BatchNormAxonsConfigConfigurer;
import org.ml4j.nn.axons.BiasVector;
import org.ml4j.nn.axons.WeightsFormat;
import org.ml4j.nn.axons.WeightsMatrix;
import org.ml4j.nn.neurons.Neurons;

/**
 * Interface for the additional builder setter methods (final, and non-initial) for a weighted layer
 *
 */
public interface WeightedFeedForwardLayerPropertiesBuilder<C, B, N extends Neurons>  {

	B withWeightsMatrix(WeightsMatrix weightsMatrix);
	
	B withBiasVector(BiasVector weightsMatrix);

	B withBiasUnit();
	
	B withBatchNormAxonsConfig(BatchNormAxonsConfigConfigurer<N> batchNormAxonsConfigConfigurer);
	
	B withAxonsContextConfigurer(AxonsContextConfigurer axonsContextConfigurer);
	
	B withWeightsFormat(WeightsFormat weightsFormat);

	C withActivationFunction(ActivationFunctionType activationFunctionType, ActivationFunctionProperties activationFunctionProperties);
	
	C withActivationFunction(ActivationFunctionBaseType activationFunctionType, ActivationFunctionProperties activationFunctionProperties);

	C withActivationFunction(ActivationFunctionType activationFunctionType);
	
	C withActivationFunction(ActivationFunctionBaseType activationFunctionType);

	C withActivationFunction(DifferentiableActivationFunction activationFunction);


}
