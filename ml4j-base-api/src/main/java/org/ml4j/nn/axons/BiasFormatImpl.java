package org.ml4j.nn.axons;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.ml4j.nn.neurons.format.features.Dimension;

public class BiasFormatImpl extends WeightsFormatImpl implements BiasFormat {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	public BiasFormatImpl(List<Dimension> inputDimensions, List<Dimension> outputDimensions, WeightsMatrixOrientation orientation) {
		super(inputDimensions, outputDimensions, orientation);
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
