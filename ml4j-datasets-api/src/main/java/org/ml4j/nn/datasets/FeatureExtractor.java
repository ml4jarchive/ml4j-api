package org.ml4j.nn.datasets;

public interface FeatureExtractor<E> {

	float[] getFeatures(E data);

	int getFeatureCount();

}
