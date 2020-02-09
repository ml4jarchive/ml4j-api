package org.ml4j.nn.datasets.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class FeatureExtractionExceptionTest {

	@Test
	public void testConstructionWithMessage() {
		Assert.assertNotNull(new FeatureExtractionException("some message"));
	}
	
	@Test
	public void testConstructionWithMessageAndThrowable() {
		Assert.assertNotNull(new FeatureExtractionException("some message", new RuntimeException("some exception")));
	}
}
