/*
 * Copyright 2019 the original author or authors.
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
package org.ml4j;

import java.io.Serializable;

public interface Matrix extends Tensor<Matrix, EditableMatrix, InterrimMatrix>, Serializable {
	
	
	int getColumns();
	int getRows();
	float[] getRowByRowArray();
	float[] getColumnByColumnArray();
	float[] toColumnByColumnArray();

	Matrix getColumn(int columnIndex);
	Matrix getRow(int rowIndex);

	Matrix appendVertically(Matrix other);
	Matrix get(int[] rows, int[] columns);
	Matrix transpose();
	Matrix columnSums();
	Matrix rowSums();
	int[] columnArgmaxs();
	Matrix mulColumnVector(Matrix other);
	Matrix mulRowVector(Matrix other);
	Matrix addColumnVector(Matrix other);
	Matrix addRowVector(Matrix other);
	Matrix divColumnVector(Matrix other);
	Matrix divRowVector(Matrix other);
	Matrix subColumnVector(Matrix other);
	Matrix subRowVector(Matrix other);

	Matrix mmul(Matrix other);


	float get(int r, int c);
	Matrix appendHorizontally(Matrix other);
	Matrix getColumns(int[] columns);
	Matrix getRows(int[] rows);

	
	
	

}
