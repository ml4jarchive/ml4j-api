package org.ml4j.images;

import org.ml4j.FloatModifier;
import org.ml4j.FloatPredicate;
import org.ml4j.Matrix;
import org.ml4j.MatrixFactory;

public interface ImageContainer<I extends ImageContainer<I>> {

	int getChannels();
	int getHeight();
	int getWidth();
	int getPaddingHeight();
	int getPaddingWidth();
	void setPaddingHeight(int paddingHeight);
	void setPaddingWidth(int paddingWidth);
	int getDataLength();
	void populateData(float[] data, int startIndex);
	void populateDataSubImage(float[] data, int startIndex, int startHeight, int startWidth, int height, int width, int strideHeight, int strideWidth, boolean forIm2col2);
	void populateIm2colConvImport(float[] data, int startIndex, int filterHeight, int filterWidth, int strideHeight, int strideWidth, int channels);
	void populateIm2colConvExport(float[] data, int startIndex, int filterHeight, int filterWidth, int strideHeight, int strideWidth, int channels);

	void populateIm2colPoolExport(float[] data, int startIndex, int filterHeight, int filterWidth, int strideHeight, int strideWidth, int channels);
	void populateIm2colPoolImport(float[] data, int startIndex, int filterHeight, int filterWidth, int strideHeight, int strideWidth, int channels);

	I dup();
	I softDup();
	void close();
	
	Matrix im2colConvExport(MatrixFactory matrixFactory, int filterHeight, int filterWidth, int strideHeight, int strideWidth);
	
	Matrix im2colPoolExport(MatrixFactory matrixFactory, int filterHeight, int filterWidth, int strideHeight, int strideWidth);
	
	void im2colConvImport(MatrixFactory matrixFactory, Matrix matrix, int filterHeight, int filterWidth, int strideHeight, int strideWidth);
	
	void im2colPoolImport(MatrixFactory matrixFactory, Matrix matrix, int filterHeight, int filterWidth, int strideHeight, int strideWidth);
	
	int getSubImageDataLength(int height, int width);
	void applyValueModifier(FloatPredicate condition, FloatModifier modifier);
	
	void applyValueModifier(FloatModifier modifier);
	float[] getData();

}
