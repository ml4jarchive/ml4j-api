package org.ml4j.images;

import org.ml4j.FloatModifier;
import org.ml4j.FloatPredicate;
import org.ml4j.Matrix;
import org.ml4j.MatrixFactory;

public interface Image {

	int getChannels();
	int getHeight();
	int getWidth();
	int getPaddingHeight();
	int getPaddingWidth();
	int getExamples();
	void setPaddingHeight(int paddingHeight);
	void setPaddingWidth(int paddingWidth);
	int getDataLength();
	void populateData(float[] data, int startIndex);
	void populateDataSubImage(float[] data, int startIndex, int startHeight, int startWidth, int height, int width, int strideHeight, int strideWidth, boolean forIm2col2);
	void populateIm2col(float[] data, int startIndex, int filterHeight, int filterWidth, int strideHeight, int strideWidth, int channels);
	void populateIm2col2(float[] data, int startIndex, int filterHeight, int filterWidth, int strideHeight, int strideWidth, int channels);
	Image dup();
	Image softDup();
	void close();
	
	Matrix im2col(MatrixFactory matrixFactory, int filterHeight, int filterWidth, int strideHeight, int strideWidth);
	
	Matrix im2col2(MatrixFactory matrixFactory, int filterHeight, int filterWidth, int strideHeight, int strideWidth);
	
	Image getChannels(int channelRangeStart, int channelRangeEnd);

	int getSubImageDataLength(int height, int width);
	void applyValueModifier(FloatPredicate condition, FloatModifier modifier);
	
	void applyValueModifier(FloatModifier modifier);
	float[] getData();

}
