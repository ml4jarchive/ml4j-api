package org.ml4j.nn.neurons.format.features;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

public class DimensionTest {
	
	// Test a dimension is always equivalent to itself, whatever the scope
	@Test
	public void testHeightIsEquivalentToHeightWithinInputScope() {
		Assert.assertTrue(Dimension.HEIGHT.isEquivalent(Dimension.HEIGHT, DimensionScope.INPUT));
	}
	
	@Test
	public void testHeightIsEquivalentToHeightWithinOutputScope() {
		Assert.assertTrue(Dimension.HEIGHT.isEquivalent(Dimension.HEIGHT, DimensionScope.OUTPUT));
	}
	
	@Test
	public void testHeightIsEquivalentToHeightWithinAnyScope() {
		Assert.assertTrue(Dimension.HEIGHT.isEquivalent(Dimension.HEIGHT, DimensionScope.ANY));
	}
	
	@Test
	public void testInputHeightIsEquivalentToInputHeightWithinInputScope() {
		Assert.assertTrue(Dimension.INPUT_HEIGHT.isEquivalent(Dimension.INPUT_HEIGHT, DimensionScope.INPUT));
	}
	
	@Test
	public void testInputHeightIsEquivalentToInputHeightWithinOutputScope() {
		Assert.assertTrue(Dimension.INPUT_HEIGHT.isEquivalent(Dimension.INPUT_HEIGHT, DimensionScope.OUTPUT));
	}
	
	@Test
	public void testInputHeightIsEquivalentToInputHeightWithinAnyScope() {
		Assert.assertTrue(Dimension.INPUT_HEIGHT.isEquivalent(Dimension.INPUT_HEIGHT, DimensionScope.ANY));
	}
	
	@Test
	public void testOutputHeightIsEquivalentToOutputHeightWithinInputScope() {
		Assert.assertTrue(Dimension.OUTPUT_HEIGHT.isEquivalent(Dimension.OUTPUT_HEIGHT, DimensionScope.INPUT));
	}
	
	@Test
	public void testOutputHeightIsEquivalentToOutputHeightWithinOutputScope() {
		Assert.assertTrue(Dimension.OUTPUT_HEIGHT.isEquivalent(Dimension.OUTPUT_HEIGHT, DimensionScope.OUTPUT));
	}
	
	@Test
	public void testOutputHeightIsEquivalentToOutputHeightWithinAnyScope() {
		Assert.assertTrue(Dimension.OUTPUT_HEIGHT.isEquivalent(Dimension.OUTPUT_HEIGHT, DimensionScope.ANY));
	}
	
	// Test that a dimension is always equivalent to it's scoped dimension within a scope matching the scoped dimension
	
	@Test
	public void testHeightIsEquivalentToInputHeightWithinInputScope() {
		Assert.assertTrue(Dimension.HEIGHT.isEquivalent(Dimension.INPUT_HEIGHT, DimensionScope.INPUT));
	}
	
	@Test
	public void testInputHeightIsEquivalentToHeightWithinInputScope() {
		Assert.assertTrue(Dimension.INPUT_HEIGHT.isEquivalent(Dimension.HEIGHT, DimensionScope.INPUT));
	}
	
	@Test
	public void testHeightIsEquivalentToOutputHeightWithinOutputScope() {
		Assert.assertTrue(Dimension.HEIGHT.isEquivalent(Dimension.OUTPUT_HEIGHT, DimensionScope.OUTPUT));
	}
	
	@Test
	public void testOutputHeightIsEquivalentToHeightWithinOutputScope() {
		Assert.assertTrue(Dimension.OUTPUT_HEIGHT.isEquivalent(Dimension.HEIGHT, DimensionScope.OUTPUT));
	}
	
	// Test that a dimension is always not equal to it's scoped dimension within a non-matching scope
	
	@Test
	public void testHeightIsNotEquivalentToInputHeightWithinOutputScope() {
		Assert.assertFalse(Dimension.HEIGHT.isEquivalent(Dimension.INPUT_HEIGHT, DimensionScope.OUTPUT));
	}
	
	@Test
	public void testInputHeightIsNotEquivalentToHeightWithinOutputScope() {
		Assert.assertFalse(Dimension.INPUT_HEIGHT.isEquivalent(Dimension.HEIGHT, DimensionScope.OUTPUT));
	}
	
	@Test
	public void testHeightIsNotEquivalentToOutputHeightWithinInputScope() {
		Assert.assertFalse(Dimension.HEIGHT.isEquivalent(Dimension.OUTPUT_HEIGHT, DimensionScope.INPUT));
	}
	
	@Test
	public void testOutputHeightIsNotEquivalentToHeightWithinInputScope() {
		Assert.assertFalse(Dimension.OUTPUT_HEIGHT.isEquivalent(Dimension.HEIGHT, DimensionScope.INPUT));
	}
	
	// Test that a dimension is always equal to it's scoped dimension within the ANY scope
	
	@Test
	public void testHeightIsEquivalentToInputHeightWithinAnyScope() {
		Assert.assertTrue(Dimension.HEIGHT.isEquivalent(Dimension.INPUT_HEIGHT, DimensionScope.ANY));
	}
	
	@Test
	public void testInputHeightIsEquivalentToHeightWithinAnyScope() {
		Assert.assertTrue(Dimension.INPUT_HEIGHT.isEquivalent(Dimension.HEIGHT, DimensionScope.ANY));
	}
	
	@Test
	public void testHeightIsEquivalentToOutputHeightWithinAnyScope() {
		Assert.assertTrue(Dimension.HEIGHT.isEquivalent(Dimension.OUTPUT_HEIGHT, DimensionScope.ANY));
	}
	
	@Test
	public void testOutputHeightIsEquivalentToHeightWithinAnyScope() {
		Assert.assertTrue(Dimension.OUTPUT_HEIGHT.isEquivalent(Dimension.HEIGHT, DimensionScope.ANY));
	}
	
	// Test synonyms
	
	@Test
	public void testDepthIsEqualivalentToChannelWithinInputScope() {
		Assert.assertTrue(Dimension.DEPTH.isEquivalent(Dimension.CHANNEL, DimensionScope.INPUT));
	}
	
	@Test
	public void testChannelIsEqualivalentToDepthWithinInputScope() {
		Assert.assertTrue(Dimension.CHANNEL.isEquivalent(Dimension.DEPTH, DimensionScope.INPUT));
	}
	
	@Test
	public void testDepthIsEqualivalentToChannelWithinOutputScope() {
		Assert.assertTrue(Dimension.DEPTH.isEquivalent(Dimension.CHANNEL, DimensionScope.OUTPUT));
	}
	
	@Test
	public void testChannelIsEqualivalentToDepthWithinOutputScope() {
		Assert.assertTrue(Dimension.CHANNEL.isEquivalent(Dimension.DEPTH, DimensionScope.OUTPUT));
	}
	
	@Test
	public void testDepthIsEqualivalentToChannelWithinAnyScope() {
		Assert.assertTrue(Dimension.DEPTH.isEquivalent(Dimension.CHANNEL, DimensionScope.ANY));
	}
	
	@Test
	public void testChannelIsEqualivalentToDepthWithinAnyScope() {
		Assert.assertTrue(Dimension.CHANNEL.isEquivalent(Dimension.DEPTH, DimensionScope.ANY));
	}
	
	@Test
	public void testGetAliasesOfDepthInAnyScope() {
		Assert.assertEquals(Sets.newSet(Dimension.CHANNEL), 
				Dimension.DEPTH.getAliases(DimensionScope.ANY));
	}
	
	@Test
	public void testGetAliasesOfDepthInInputScope() {
		Assert.assertEquals(Sets.newSet(Dimension.INPUT_DEPTH, Dimension.CHANNEL), 
				Dimension.DEPTH.getAliases(DimensionScope.INPUT));
	}
	
	@Test
	public void testGetAliasesOfOutputHeightInInputScope() {
		Assert.assertTrue(Dimension.OUTPUT_HEIGHT.getAliases(DimensionScope.INPUT).isEmpty());
	}
	
	@Test
	public void testGetAliasesOfOutputHeightInOutputScope() {
		Assert.assertEquals(Sets.newSet(Dimension.HEIGHT), 
				Dimension.OUTPUT_HEIGHT.getAliases(DimensionScope.OUTPUT));
	}
	
	@Test
	public void testGetAliasesOfOutputHeightInAnyScope() {
		Assert.assertEquals(Sets.newSet(Dimension.HEIGHT), 
				Dimension.OUTPUT_HEIGHT.getAliases(DimensionScope.ANY));
	}
	
	@Test
	public void testGetAliasesOfDepthInOutputScope() {
		Assert.assertEquals(Sets.newSet(Dimension.OUTPUT_DEPTH, Dimension.CHANNEL), 
				Dimension.DEPTH.getAliases(DimensionScope.OUTPUT));
	}
	
}
