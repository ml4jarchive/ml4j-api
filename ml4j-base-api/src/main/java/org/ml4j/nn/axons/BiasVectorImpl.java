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
package org.ml4j.nn.axons;

import org.ml4j.Matrix;

public class BiasVectorImpl implements BiasVector {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private Matrix matrix;
	private FeaturesVectorFormat biasFormat;

	public BiasVectorImpl(Matrix matrix, FeaturesVectorFormat biasFormat) {
		if (biasFormat.getOrientation() == FeaturesVectorOrientation.COLUMN_VECTOR && matrix.getColumns() != 1) {
			throw new IllegalArgumentException("Expected matrix to be of dimensions (rows, cols) = (?, 1)");
		}
		if (biasFormat.getOrientation() == FeaturesVectorOrientation.ROW_VECTOR && matrix.getColumns() != 1) {
			throw new IllegalArgumentException("Expected matrix to be of dimensions (rows, cols) = (1, ?)");
		}
		this.matrix = matrix;
		this.biasFormat = biasFormat;
	}
	
	@Override
	public Matrix getVector() {
		return matrix;
	}

	@Override
	public BiasVector dup() {
		return new BiasVectorImpl(matrix.dup(), biasFormat);
	}

	@Override
	public FeaturesVectorFormat getFormat() {
		return biasFormat;
	}

	

}
