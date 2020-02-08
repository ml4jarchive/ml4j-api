package org.ml4j.nn.neurons.format.features;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FeaturesFormatTest {
	
	@Test
	public void testDepthHeightWidthFormatDimensionsSize() {
		Assert.assertTrue(ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH.getDimensions().size() == 3);
	}
	
	@Test
	public void testDepthHeightWidthFormatToString() {
		Assert.assertEquals("[Depth, Height, Width]", ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH.toString());
	}

	@Test
	public void testDepthHeightWidthFormatEquivalenceInInputScope() {
		Assert.assertTrue(Dimension.isEquivalent(ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH.getDimensions(),
				Arrays.asList(Dimension.INPUT_DEPTH, Dimension.INPUT_HEIGHT, Dimension.INPUT_WIDTH),
				DimensionScope.INPUT));
	}
	
	@Test
	public void testDepthHeightWidthFormatNonEquivalenceInInputScope() {
		Assert.assertFalse(Dimension.isEquivalent(ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH.getDimensions(),
				Arrays.asList(Dimension.OUTPUT_DEPTH, Dimension.OUTPUT_HEIGHT, Dimension.OUTPUT_WIDTH),
				DimensionScope.INPUT));
	}
	
	@Test
	public void testDepthHeightWidthFormatNonEquivalenceInOutputScope() {
		Assert.assertFalse(Dimension.isEquivalent(ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH.getDimensions(),
				Arrays.asList(Dimension.INPUT_DEPTH, Dimension.INPUT_HEIGHT, Dimension.INPUT_WIDTH),
				DimensionScope.OUTPUT));
	}
	
	@Test
	public void testDepthHeightWidthFormatEquivalenceInOutputScope() {
		Assert.assertTrue(Dimension.isEquivalent(ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH.getDimensions(),
				Arrays.asList(Dimension.OUTPUT_DEPTH, Dimension.OUTPUT_HEIGHT, Dimension.OUTPUT_WIDTH),
				DimensionScope.OUTPUT));
	}
	
	@Test
	public void testDepthHeightWidthInputFormatEquivalenceInAnyScope() {
		Assert.assertTrue(Dimension.isEquivalent(ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH.getDimensions(),
				Arrays.asList(Dimension.INPUT_DEPTH, Dimension.INPUT_HEIGHT, Dimension.INPUT_WIDTH),
				DimensionScope.ANY));
	}
	
	@Test
	public void testDepthHeightWidthFormatOutputEquivalenceInAnyScope() {
		Assert.assertTrue(Dimension.isEquivalent(ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH.getDimensions(),
				Arrays.asList(Dimension.OUTPUT_DEPTH, Dimension.OUTPUT_HEIGHT, Dimension.OUTPUT_WIDTH),
				DimensionScope.ANY));
	}
}
