package org.ml4j.nn.layers.builders;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.ml4j.nn.activationfunctions.ActivationFunctionProperties;
import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.axons.AxonsConfigBuilderBase;
import org.ml4j.nn.axons.AxonsContextConfigurer;
import org.ml4j.nn.axons.BatchNormAxonsConfig;
import org.ml4j.nn.axons.BiasVector;
import org.ml4j.nn.axons.WeightsFormat;
import org.ml4j.nn.axons.WeightsMatrix;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.format.features.Dimension;
import org.ml4j.nn.neurons.format.features.DimensionScope;

public class FullyConnectedLayerConfigBuilder extends AxonsConfigBuilderBase<FullyConnectedLayerAxonsConfig, FullyConnectedLayerConfigBuilder> {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private ActivationFunctionType activationFunctionType;
	private ActivationFunctionProperties activationFunctionProperties;
	private DifferentiableActivationFunction activationFunction;
	private WeightsMatrix weightsMatrix;
	private WeightsFormat weightsFormat;
	private BiasVector biasMatrix;
	private Boolean withBiasUnit;
	private BatchNormAxonsConfig<Neurons> batchNormAxonsConfig;
	private AxonsContextConfigurer axonsContextConfigurer;
	
	public BatchNormAxonsConfig<Neurons> getBatchNormAxonsConfig() {
		return batchNormAxonsConfig;
	}

	public FullyConnectedLayerConfigBuilder withBatchNormConfig(BatchNormAxonsConfig<Neurons> batchNormAxonsConfig) {
		this.batchNormAxonsConfig = batchNormAxonsConfig;
		return this;
	}

	public WeightsMatrix getWeightsMatrix() {
		return weightsMatrix;
	}

	public FullyConnectedLayerConfigBuilder withWeightsMatrix(WeightsMatrix weightsMatrix) {
		if (weightsFormat != null && ((weightsMatrix.getFormat() == null)
				|| (weightsMatrix.getFormat() == null || !Dimension.isEquivalent(weightsFormat.getDimensions(),
						weightsMatrix.getFormat().getDimensions(), DimensionScope.ANY)))) {
			throw new IllegalStateException(
					"Weights matrix format has already been set and has an format incompatible with the provided weights matrix");
		}
		this.weightsMatrix = weightsMatrix;
		return this;
	}
	
	public FullyConnectedLayerConfigBuilder withBiasUnit() {
		if (leftNeurons != null && !leftNeurons.hasBiasUnit()) {
			throw new IllegalStateException("Unable to set a bias unit as left neurons instance has not been configured with a bias unit");
		}
		withBiasUnit = true;
		return this;
	}
	
	public AxonsContextConfigurer getAxonsContextConfigurer() {
		return axonsContextConfigurer;
	}

	public FullyConnectedLayerConfigBuilder withAxonsContextConfigurer(AxonsContextConfigurer axonsContextConfigurer) {
		if (this.axonsContextConfigurer != null) {
			throw new IllegalStateException("Axons context configurer has already been set on this layer config");
		}
		this.axonsContextConfigurer = axonsContextConfigurer;
		return this;
	}

	public FullyConnectedLayerConfigBuilder withBiasVector(BiasVector biasMatrix) {
		if (leftNeurons != null && !leftNeurons.hasBiasUnit()) {
			throw new IllegalStateException("Unable to set a bias matrix as left neurons instance has not been configured with a bias unit");
		}
		this.biasMatrix = biasMatrix;
		withBiasUnit = true;
		return this;
	}
	
	public FullyConnectedLayerConfigBuilder withWeightsFormat(WeightsFormat weightsFormat) {
		if (this.weightsMatrix != null && (weightsMatrix.getFormat() == null || (weightsMatrix.getFormat() != null 
				&& !Dimension.isEquivalent(weightsFormat.getDimensions(), 
						weightsMatrix.getFormat().getDimensions(), DimensionScope.ANY)))) {
			throw new IllegalStateException("Weights matrix has already been set and has an format incompatible with the provided weights format");
		} 
		
		this.weightsFormat = weightsFormat;
		return this;
	}

	public BiasVector getBiasVector() {
		return biasMatrix;
	}

	public ActivationFunctionType getActivationFunctionType() {
		return activationFunctionType;
	}

	public ActivationFunctionProperties getActivationFunctionProperties() {
		return activationFunctionProperties;
	}

	public DifferentiableActivationFunction getActivationFunction() {
		return activationFunction;
	}

	public FullyConnectedLayerConfigBuilder() {
		super();
	}

	public FullyConnectedLayerConfigBuilder(Neurons leftNeurons) {
		super(leftNeurons);
	}

	@Override
	protected FullyConnectedLayerAxonsConfig createDefaultConfig(Neurons leftNeurons, Neurons rightNeurons) {
		return new FullyConnectedLayerAxonsConfig(leftNeurons, rightNeurons);
	}

	@Override
	protected FullyConnectedLayerConfigBuilder getInstance() {
		return this;
	}

	
	public FullyConnectedLayerConfigBuilder withActivationFunctionProperties(ActivationFunctionProperties activationFunctionProperties) {
		if (this.activationFunction != null && !activationFunctionProperties.equals(this.activationFunction.getActivationFunctionProperties())) {
			throw new IllegalStateException("Activation function properties have already been set and are not consistent with the provided activation function properties");
		}
		this.activationFunctionProperties = activationFunctionProperties;
		return this;
	}
	
	public FullyConnectedLayerConfigBuilder withActivationFunction(DifferentiableActivationFunction activationFunction) {
		if (activationFunctionType != null && !activationFunctionType.equals(activationFunction.getActivationFunctionType())) {
			throw new IllegalStateException("An activation function of type has already been set of:" + activationFunctionType + " "
					+ " which is not consistent with the type of the provided activation function:" + activationFunction.getActivationFunctionType());
		}
		if (activationFunctionProperties != null && !activationFunctionProperties.equals(activationFunction.getActivationFunctionProperties())) {
			throw new IllegalStateException("Activation function properties have already been set and are not consistent with the provided activation function properties");
		}
		this.activationFunctionProperties = activationFunction.getActivationFunctionProperties();
		this.activationFunctionType = activationFunction.getActivationFunctionType();
		this.activationFunction = activationFunction;
		return this;
	}

	public FullyConnectedLayerConfigBuilder withActivationFunctionType(ActivationFunctionType activationFunctionType) {
		if (activationFunction != null && !activationFunctionType.equals(activationFunction.getActivationFunctionType())) {
			throw new IllegalStateException("An activation function has already been set with type:" + activationFunction.getActivationFunctionType() + " "
					+ " which is not consistent with the type provided:" + activationFunctionType);
		}
		this.activationFunctionType = activationFunctionType;
		return this;
	}

	@Override
	public FullyConnectedLayerAxonsConfig build() {
		
		if (leftNeurons == null) {
			throw new IllegalStateException("Input neurons have not been specified");
		}
		
		if ((biasMatrix != null || (withBiasUnit != null && withBiasUnit.booleanValue())) && !leftNeurons.hasBiasUnit()) {
			this.biasMatrix = null;
			this.withBiasUnit = false;
			throw new IllegalStateException("Unable to set bias as left neurons instance has not been configured with a bias unit");
		}
		
		withBiasUnit = leftNeurons.hasBiasUnit();
			
		FullyConnectedLayerAxonsConfig config = createDefaultConfig(leftNeurons, rightNeurons);
		
		if (activationFunctionProperties != null && activationFunctionType == null) {
			throw new IllegalStateException("Activation function properties have been set, but no activation function type set");
		} else {
			if (activationFunctionType != null) {
				config.withActivationFunctionType(activationFunctionType);
				if (activationFunctionProperties != null) {
					config.withActivationFunctionProperties(activationFunctionProperties);

				}
			}
		}
	
		return config;
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
