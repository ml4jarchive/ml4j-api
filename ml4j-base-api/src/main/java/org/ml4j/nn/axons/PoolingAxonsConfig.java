package org.ml4j.nn.axons;

import java.io.Serializable;

public class PoolingAxonsConfig implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private Axons3DConfig axonsConfig;
	
	public static PoolingAxonsConfig create(Axons3DConfig axonsConfig) {
		return new PoolingAxonsConfig(axonsConfig);
	}
	
	public PoolingAxonsConfig(Axons3DConfig axonsConfig) {
		this.axonsConfig = axonsConfig;
	}

	public Axons3DConfig getAxonsConfig() {
		return axonsConfig;
	}
}
