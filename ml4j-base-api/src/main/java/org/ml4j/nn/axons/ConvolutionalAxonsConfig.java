package org.ml4j.nn.axons;

import java.io.Serializable;

public class ConvolutionalAxonsConfig implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private Axons3DConfig axonsConfig;
	private AxonsContextConfigurer axonsContextConfigurer;
	
	public static ConvolutionalAxonsConfig create(Axons3DConfig axonsConfig) {
		return create(axonsConfig, AxonsContextConfigurer.defaultConfigurer());
	}
	
	public static ConvolutionalAxonsConfig create(Axons3DConfig axonsConfig, AxonsContextConfigurer axonsContextConfigurer) {
		ConvolutionalAxonsConfig config = new ConvolutionalAxonsConfig(axonsConfig);
		return config.withAxonsContextConfigurer(axonsContextConfigurer);
	}
	
	public ConvolutionalAxonsConfig(Axons3DConfig axonsConfig) {
		this.axonsConfig = axonsConfig;
	}

	public ConvolutionalAxonsConfig withAxonsContextConfigurer(AxonsContextConfigurer axonsContextConfigurer) {
		if (axonsContextConfigurer != null) {
			this.axonsContextConfigurer = axonsContextConfigurer;
		} else {
			this.axonsContextConfigurer = AxonsContextConfigurer.defaultConfigurer();
		}
		return this;
	}

	public Axons3DConfig getAxonsConfig() {
		return axonsConfig;
	}

	public AxonsContextConfigurer getAxonsContextConfigurer() {
		return axonsContextConfigurer;
	}
}
