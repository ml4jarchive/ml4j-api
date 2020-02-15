package org.ml4j.nn.axons;

import org.ml4j.nn.neurons.Neurons;

/**
 * 
 * @author Michael Lavelle
 *
 */
public class AxonsConfigBuilder extends AxonsConfigBuilderBase<AxonsConfig<Neurons, Neurons>, AxonsConfigBuilder> {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected AxonsConfig<Neurons, Neurons> createDefaultConfig(Neurons leftNeurons, Neurons rightNeurons) {
		return new AxonsConfig<>(leftNeurons, rightNeurons);
	}

	@Override
	protected AxonsConfigBuilder getInstance() {
		return this;
	}

	@Override
	public AxonsConfig<Neurons, Neurons> build() {
		if (leftNeurons == null) {
			throw new IllegalStateException("Input neurons have not been specified");
		} else {
			return createDefaultConfig(leftNeurons, rightNeurons);
		}
		
	}

}
