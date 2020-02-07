package org.ml4j.nn.neurons.format.features;

import org.junit.Assert;
import org.junit.Test;

public class DimensionScopeTest {

	@Test
	public void testIsInputScopeValidWithinAnyScope() {
		Assert.assertFalse(DimensionScope.INPUT.isValidWithin(DimensionScope.ANY));
	}
	
	@Test
	public void testIsOutputScopeValidWithinAnyScope() {
		Assert.assertFalse(DimensionScope.OUTPUT.isValidWithin(DimensionScope.ANY));
	}
	
	@Test
	public void testIsAnyScopeValidWithinAnyScope() {
		Assert.assertTrue(DimensionScope.ANY.isValidWithin(DimensionScope.ANY));
	}
	
	@Test
	public void testIsInputScopeValidWithinInputScope() {
		Assert.assertTrue(DimensionScope.INPUT.isValidWithin(DimensionScope.INPUT));
	}
	
	@Test
	public void testIsOutputScopeValidWithinInputScope() {
		Assert.assertFalse(DimensionScope.OUTPUT.isValidWithin(DimensionScope.INPUT));
	}
	
	@Test
	public void testIsAnyScopeValidWithinInputScope() {
		Assert.assertTrue(DimensionScope.ANY.isValidWithin(DimensionScope.INPUT));
	}
	
	@Test
	public void testIsInputScopeValidWithinOutputScope() {
		Assert.assertFalse(DimensionScope.INPUT.isValidWithin(DimensionScope.OUTPUT));
	}
	
	@Test
	public void testIsOutputScopeValidWithinOutputScope() {
		Assert.assertTrue(DimensionScope.OUTPUT.isValidWithin(DimensionScope.OUTPUT));
	}
	
	@Test
	public void testIsAnyScopeValidWithinOutputScope() {
		Assert.assertTrue(DimensionScope.ANY.isValidWithin(DimensionScope.OUTPUT));
	}

}
