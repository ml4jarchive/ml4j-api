package org.ml4j.nn.datasets;

import org.ml4j.nn.datasets.exceptions.FeatureExtractionException;

public interface FeatureExtractor<E> {

	float[] getFeatures(E data) throws FeatureExtractionException;

	int getFeatureCount();

}
