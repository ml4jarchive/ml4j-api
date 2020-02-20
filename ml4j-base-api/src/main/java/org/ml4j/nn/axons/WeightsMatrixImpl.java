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

public class WeightsMatrixImpl implements WeightsMatrix {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private Matrix matrix;
	private WeightsFormat format;
	
	public WeightsMatrixImpl(Matrix matrix, WeightsFormat format) {
		this.matrix = matrix;
		this.format = format;
	}
	
	@Override
	public Matrix getMatrix() {
		return matrix;
	}

	@Override
	public WeightsFormat getFormat() {
		return format;
	}

	@Override
	public WeightsMatrix dup() {
		return new WeightsMatrixImpl(matrix.dup(), format);
	}
}
