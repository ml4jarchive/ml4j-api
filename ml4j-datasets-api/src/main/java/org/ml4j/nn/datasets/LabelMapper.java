package org.ml4j.nn.datasets;

public interface LabelMapper<L> {

	float[] getAsFloatArray(L label);

	int getFloatArrayLength();
}
