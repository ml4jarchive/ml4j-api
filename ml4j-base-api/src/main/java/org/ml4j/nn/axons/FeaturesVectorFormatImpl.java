/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ml4j.nn.axons;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.ml4j.nn.neurons.format.features.Dimension;
import org.ml4j.nn.neurons.format.features.DimensionScope;

/**
 * FeaturesVectorFormat built from a list of dimension.
 * 
 * @author Michael Lavelle
 */
public class FeaturesVectorFormatImpl implements FeaturesVectorFormat {
	
	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	private List<Dimension> dimensions;
	private DimensionScope dimensionScope;
	private FeaturesVectorOrientation featuresVectorOrientation;
	
	public FeaturesVectorFormatImpl(List<Dimension> dimensions, 
			FeaturesVectorOrientation featuresVectorOrientation, DimensionScope dimensionScope) {
		this.dimensions = dimensions;
		this.featuresVectorOrientation = featuresVectorOrientation;
		DimensionScope dimensionScopeFromDimensionList = getDimensionScope(dimensions);
		if (dimensionScope == DimensionScope.ANY) {
			this.dimensionScope = dimensionScopeFromDimensionList;
		} else if (dimensionScopeFromDimensionList == DimensionScope.ANY) {
				this.dimensionScope = dimensionScope;
		} else {
			if (dimensionScope == dimensionScopeFromDimensionList) {
				this.dimensionScope = dimensionScope;
			} else {
				throw new IllegalStateException("Inconsistency between the scope of the dimensions provided (" + dimensionScopeFromDimensionList + ") and the specified"
						+ " dimension scope (" + dimensionScope + ")");
			}
		}
	}
	
	private DimensionScope getDimensionScope(List<Dimension> dimensions) {
		Set<DimensionScope> spannedDimensions = dimensions.stream().map(d -> d.getScope()).collect(Collectors.toSet());
		if (spannedDimensions.size() == 1) {
			return spannedDimensions.iterator().next();
		} else if (spannedDimensions.contains(DimensionScope.INPUT) && spannedDimensions.contains(DimensionScope.OUTPUT)) {
			throw new IllegalStateException("Unable to determine scope of features vector dimensions as dimensions with both INPUT and OUTPUT scope are provided");
		} else if (spannedDimensions.contains(DimensionScope.INPUT)) {
			return DimensionScope.INPUT;
		} else if (spannedDimensions.contains(DimensionScope.OUTPUT)) {
			return DimensionScope.OUTPUT;
		} else {
			return DimensionScope.ANY;
		}
	}
	
	@Override
	public List<Dimension> getDimensions() {
		return dimensions;
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

	@Override
	public DimensionScope getDimensionScope() {
		return dimensionScope;
	}

	@Override
	public FeaturesVectorOrientation getOrientation() {
		return featuresVectorOrientation;
	}
}
