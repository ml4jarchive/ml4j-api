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

public interface EditableMatrix extends Matrix {

	void putRow(int r, Matrix matrix);
	void putColumn(int c, Matrix matrix);
	void put(int r, int c, float v);
	void put(int i, float v);
	EditableMatrix subi(float v);
	EditableMatrix divi(float v);
	EditableMatrix addi(float v);
	EditableMatrix muli(float v);
	EditableMatrix subiColumnVector(Matrix other);
	EditableMatrix subiRowVector(Matrix other);
	EditableMatrix diviColumnVector(Matrix other);
	EditableMatrix diviRowVector(Matrix other);
	EditableMatrix addiRowVector(Matrix other);
	EditableMatrix addiColumnVector(Matrix other);
	EditableMatrix muliColumnVector(Matrix other);
	EditableMatrix muliRowVector(Matrix other);
	EditableMatrix muli(Matrix other);
	EditableMatrix addi(Matrix other);
	EditableMatrix divi(Matrix other);
	EditableMatrix subi(Matrix other);

	EditableMatrix expi();
	void reshape(int r, int c);

}
