package org.ml4j.nn.neurons;

import org.ml4j.Matrix;
import org.ml4j.MatrixFactory;
import org.ml4j.images.Image;

public interface ImageNeuronsActivation extends NeuronsActivation {
	

	  Image getImage();
	
	  Matrix im2Col(MatrixFactory matrixFactory, int filterHeight, int filterWidth, int strideHeight, int strideWidth, int paddingHeight, int paddingWidth);
	
	  Matrix im2Col2(MatrixFactory matrixFactory, int filterHeight, int filterWidth, int strideHeight, int strideWidth, int paddingHeight, int paddingWidth);
		
	  @Override
	  Neurons3D getNeurons();
}
