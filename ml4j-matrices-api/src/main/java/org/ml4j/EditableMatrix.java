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
