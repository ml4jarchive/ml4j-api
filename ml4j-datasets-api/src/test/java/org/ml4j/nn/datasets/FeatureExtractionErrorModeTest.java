package org.ml4j.nn.datasets;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FeatureExtractionErrorModeTest {

	@Test
	public void testValues() {
		Assert.assertEquals(Arrays.asList(FeatureExtractionErrorMode.IGNORE, FeatureExtractionErrorMode.LOG_WARNING, FeatureExtractionErrorMode.RAISE_EXCEPTION), Arrays.asList(FeatureExtractionErrorMode.values()));
	}
}
