package org.ml4j;

import java.io.Serializable;

public interface Matrix extends Serializable {
	
	int getColumns();
	int getRows();
	float[] getRowByRowArray();
	float[] getColumnByColumnArray();
	float[] toColumnByColumnArray();

	Matrix getColumn(int columnIndex);
	Matrix getRow(int rowIndex);
	int argmax();

	Matrix appendVertically(Matrix other);
	Matrix get(int[] rows, int[] columns);
	Matrix transpose();
	Matrix columnSums();
	Matrix rowSums();
	int[] columnArgmaxs();
	int getLength();
	Matrix mul(Matrix other);
	Matrix mulColumnVector(Matrix other);
	Matrix mulRowVector(Matrix other);
	Matrix add(Matrix other);
	Matrix addColumnVector(Matrix other);
	Matrix addRowVector(Matrix other);
	Matrix div(Matrix other);
	Matrix divColumnVector(Matrix other);
	Matrix divRowVector(Matrix other);
	Matrix sub(Matrix other);
	Matrix subColumnVector(Matrix other);
	Matrix subRowVector(Matrix other);
	Matrix mul(float v);
	Matrix add(float v);
	Matrix div(float v);
	Matrix sub(float v);
	Matrix mmul(Matrix other);
	EditableMatrix asEditableMatrix();
	float sum();

	float get(int i);

	float get(int r, int c);
	Matrix dup();
	InterrimMatrix asInterrimMatrix();
	Matrix appendHorizontally(Matrix other);
	Matrix getColumns(int[] columns);
	Matrix getRows(int[] rows);

	Matrix sigmoid();
	Matrix log();
	Matrix logi();
	void close();
	boolean isImmutable();
	void setImmutable(boolean immutable);
	

}
