package org.ml4j.nn.axons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.ml4j.nn.neurons.format.features.Dimension;
import org.ml4j.nn.neurons.format.features.DimensionScope;

public class BiasFormatImpl extends FeaturesVectorFormatImpl implements FeaturesVectorFormat {
	
	/**
	 * Default seriaization id.
	 */
	private static final long serialVersionUID = 1L;

	public BiasFormatImpl(FeaturesVectorOrientation featuresVectorOrientation) {
		this(Dimension.OUTPUT_FEATURE, featuresVectorOrientation);
	}
	
	public BiasFormatImpl(List<Dimension> dimensions, FeaturesVectorOrientation featuresVectorOrientation) {
		super(dimensions, featuresVectorOrientation, DimensionScope.OUTPUT);
	}
	
	public BiasFormatImpl(Dimension dimension, FeaturesVectorOrientation featuresVectorOrientation) {
		this(Arrays.asList(dimension), featuresVectorOrientation);
	}
	
	@Override
	public String toString() {
		return getDimensions().stream().map(Dimension::getName).collect(Collectors.toList()).toString();
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
