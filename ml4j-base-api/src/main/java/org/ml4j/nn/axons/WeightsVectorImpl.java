package org.ml4j.nn.axons;

import java.util.Arrays;

import org.ml4j.Matrix;
import org.ml4j.nn.neurons.format.features.Dimension;
import org.ml4j.nn.neurons.format.features.DimensionScope;

/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
public class WeightsVectorImpl extends FeaturesVectorImpl implements WeightsVector {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private DimensionScope dimensionScope;
	
	public WeightsVectorImpl(Matrix matrix, FeaturesVectorFormat format) {
		this(matrix, format, format.getDimensionScope());
	}
	
	@Override
	public WeightsVector dup() {
		return new WeightsVectorImpl(getVector().dup(), getFormat());
	}
	
	public WeightsVectorImpl(Matrix matrix, FeaturesVectorFormat format, DimensionScope dimensionScope) {
		super(matrix, format);
		if (dimensionScope == DimensionScope.ANY) {
			throw new IllegalArgumentException("Unable to create a WeightsVector with dimension scope = ANY");
		} else {
			if (getFormat().getDimensionScope() == dimensionScope) {
				this.dimensionScope = dimensionScope;
			} else if (getFormat().getDimensionScope() == DimensionScope.ANY) {
				this.dimensionScope = dimensionScope;
			} else {
				throw new IllegalStateException("Inconsistency between the specified dimension scope of:" + dimensionScope + " and the "
						+ " dimension scope of the FeaturesVectorFormat");
			}
		}
	}

	@Override
	public WeightsMatrix toWeightsMatrix() {
		
		// Extra check here, but this should be prevented by the constructor.
		if (dimensionScope == DimensionScope.ANY) {
			throw new IllegalStateException("Unable to create a WeightsVector with dimension scope = ANY");
		} else {
			if (this.getFormat().getDimensionScope() == DimensionScope.INPUT) {
				if (getFormat().getOrientation() == FeaturesVectorOrientation.COLUMN_VECTOR) {
					return new WeightsMatrixImpl(getVector(), 
							new WeightsFormatImpl(getFormat().getDimensions(), Arrays.asList(Dimension.OUTPUT_FEATURE),
									WeightsMatrixOrientation.ROWS_SPAN_INPUT_DIMENSIONS));
				} else {
					return new WeightsMatrixImpl(getVector(), 
							new WeightsFormatImpl(getFormat().getDimensions(), Arrays.asList(Dimension.OUTPUT_FEATURE),
									WeightsMatrixOrientation.ROWS_SPAN_OUTPUT_DIMENSIONS));
				} 
			} else {
				if (getFormat().getOrientation() == FeaturesVectorOrientation.COLUMN_VECTOR) {
					return new WeightsMatrixImpl(getVector(), 
							new WeightsFormatImpl(Arrays.asList(Dimension.INPUT_FEATURE), getFormat().getDimensions(),
									WeightsMatrixOrientation.ROWS_SPAN_INPUT_DIMENSIONS));
				} else {
					return new WeightsMatrixImpl(getVector(), 
							new WeightsFormatImpl(getFormat().getDimensions(), Arrays.asList(Dimension.OUTPUT_FEATURE),
									WeightsMatrixOrientation.ROWS_SPAN_OUTPUT_DIMENSIONS));
				} 
			}
		}
	}
	

}
