package org.ml4j.nn.datasets.exceptions;

public class FeatureExtractionRuntimeException extends RuntimeException {

	/**
	 * Default serialization id
	 */
	private static final long serialVersionUID = 1L;

	public FeatureExtractionRuntimeException(String message, Exception featureExtractionException) {
		super(message, featureExtractionException);
	}
	

}
