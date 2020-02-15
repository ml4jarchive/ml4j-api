package org.ml4j.nn.layers.builders;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.ml4j.nn.activationfunctions.ActivationFunctionProperties;
import org.ml4j.nn.activationfunctions.ActivationFunctionType;
import org.ml4j.nn.axons.Axons3DConfig;
import org.ml4j.nn.neurons.Neurons3D;

public class ConvolutionalLayerAxonsConfig extends Axons3DConfig {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	private ActivationFunctionType activationFunctionType;
	private ActivationFunctionProperties activationFunctionProperties;

	public ActivationFunctionType getActivationFunctionType() {
		return activationFunctionType;
	}

	public ConvolutionalLayerAxonsConfig withActivationFunctionType(ActivationFunctionType activationFunctionType) {
		this.activationFunctionType = activationFunctionType;
		return this;
	}

	public ActivationFunctionProperties getActivationFunctionProperties() {
		return activationFunctionProperties;
	}

	public ConvolutionalLayerAxonsConfig withActivationFunctionProperties(ActivationFunctionProperties activationFunctionProperties) {
		this.activationFunctionProperties = activationFunctionProperties;
		return this;
	}
	
	public ConvolutionalLayerAxonsConfig(Neurons3D leftNeurons, Neurons3D rightNeurons) {
		super(leftNeurons, rightNeurons);
	}

	public ConvolutionalLayerAxonsConfig(Neurons3D leftNeurons) {
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
