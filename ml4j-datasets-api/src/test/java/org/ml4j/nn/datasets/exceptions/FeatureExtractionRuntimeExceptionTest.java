package org.ml4j.nn.datasets.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class FeatureExtractionRuntimeExceptionTest {

	@Test
	public void testConstructionWithMessageAndException() {
		Assert.assertNotNull(new FeatureExtractionRuntimeException("some message", new RuntimeException("some exception")));
	}
}
