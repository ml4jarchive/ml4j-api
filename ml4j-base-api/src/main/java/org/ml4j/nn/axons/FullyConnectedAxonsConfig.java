package org.ml4j.nn.axons;

import java.io.Serializable;

import org.ml4j.nn.neurons.Neurons;

public class FullyConnectedAxonsConfig implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private AxonsConfig<Neurons, Neurons> axonsConfig;
	private AxonsContextConfigurer axonsContextConfigurer;
	
	public static FullyConnectedAxonsConfig create(Neurons leftNeurons, Neurons rightNeurons) {
		return create(leftNeurons, rightNeurons, AxonsContextConfigurer.defaultConfigurer());
	}
	
	public static FullyConnectedAxonsConfig create(Neurons leftNeurons, Neurons rightNeurons, AxonsContextConfigurer axonsContextConfigurer) {
		FullyConnectedAxonsConfig config = new FullyConnectedAxonsConfig(new AxonsConfigBuilder().withInputNeurons(leftNeurons).withOutputNeurons(rightNeurons).build());
		return config.withAxonsContextConfigurer(axonsContextConfigurer);
	}
	
	public FullyConnectedAxonsConfig(AxonsConfig<Neurons, Neurons> axonsConfig) {
		this.axonsConfig = axonsConfig;
	}

	public FullyConnectedAxonsConfig withAxonsContextConfigurer(AxonsContextConfigurer axonsContextConfigurer) {
		this.axonsContextConfigurer = axonsContextConfigurer;
		return this;
	}

	public AxonsConfig<Neurons, Neurons> getAxonsConfig() {
		return axonsConfig;
	}

	public AxonsContextConfigurer getAxonsContextConfigurer() {
		return axonsContextConfigurer;
	}
}
