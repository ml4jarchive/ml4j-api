package org.ml4j;

import java.io.Serializable;

public interface Tensor<T extends Tensor<T, E, I>, E extends T, I extends T> extends Serializable {
	
	/*
	
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

	
	*/
	
	int argmax();
	float get(int i);
	float sum();
	int getLength();

	
	
	T mul(float v);
	T add(float v);
	T div(float v);
	T sub(float v);
	
	T div(T other);
	T sub(T other);
	T mul(T other);
	T add(T other);


	T sigmoid();
	T log();
	T logi();
	
	void close();
	
	T dup();

	E asEditableMatrix();
	I asInterrimMatrix();

	
	boolean isImmutable();
	void setImmutable(boolean immutable);


}
