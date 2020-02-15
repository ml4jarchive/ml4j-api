package org.ml4j.nn.layers.builders;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.ml4j.nn.activationfunctions.ActivationFunctionProperties;
import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.axons.AxonsConfig;
import org.ml4j.nn.neurons.Neurons;

public class FullyConnectedLayerAxonsConfig extends AxonsConfig<Neurons, Neurons> {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	private ActivationFunctionType activationFunctionType;
	private ActivationFunctionProperties activationFunctionProperties;

	public ActivationFunctionType getActivationFunctionType() {
		return activationFunctionType;
	}

	public FullyConnectedLayerAxonsConfig withActivationFunctionType(ActivationFunctionType activationFunctionType) {
		this.activationFunctionType = activationFunctionType;
		return this;
	}

	public ActivationFunctionProperties getActivationFunctionProperties() {
		return activationFunctionProperties;
	}

	public FullyConnectedLayerAxonsConfig withActivationFunctionProperties(ActivationFunctionProperties activationFunctionProperties) {
		this.activationFunctionProperties = activationFunctionProperties;
		return this;
	}

	public FullyConnectedLayerAxonsConfig(Neurons leftNeurons, Neurons rightNeurons) {
		super(leftNeurons, rightNeurons);
	}

	public FullyConnectedLayerAxonsConfig(Neurons leftNeurons) {
		super(leftNeurons);
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
