package org.ml4j.nn.axons;

import org.ml4j.Matrix;

public interface AxonsDropoutMask {
		
	AxonsDropoutMaskType getType();
	Matrix getDropoutMask();
}
