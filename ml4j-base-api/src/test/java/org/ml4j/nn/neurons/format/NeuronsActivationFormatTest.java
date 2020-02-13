package org.ml4j.nn.neurons.format;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.ml4j.nn.neurons.NeuronsActivationFeatureOrientation;
import org.ml4j.nn.neurons.format.features.Dimension;
import org.ml4j.nn.neurons.format.features.DimensionScope;
import org.ml4j.nn.neurons.format.features.FeaturesFormat;
import org.ml4j.nn.neurons.format.features.FeaturesFormatImpl;

public class NeuronsActivationFormatTest {

	@Test
	public void testRowsSpanFeatureSetFormatRowDimensions() {
		Assert.assertEquals(Arrays.asList(Dimension.FEATURE), 
				NeuronsActivationFormat.ROWS_SPAN_FEATURE_SET.getRowDimensions());	
	}
	
	@Test
	public void testRowsSpanFeatureSetFormatRowDimensionsName() {
		Assert.assertEquals("[Feature]", 
				NeuronsActivationFormat.ROWS_SPAN_FEATURE_SET.getRowDimensionsName());	
	}
	
	@Test
	public void testRowsSpanFeatureSetFormatColumnDimensionsName() {
		Assert.assertEquals("[Example]", 
				NeuronsActivationFormat.ROWS_SPAN_FEATURE_SET.getColumnDimensionsName());	
	}
	
	@Test
	public void testRowsSpanFeatureSetFormatColumnDimensions() {
		Assert.assertEquals(Arrays.asList(Dimension.EXAMPLE), 
				NeuronsActivationFormat.ROWS_SPAN_FEATURE_SET.getColumnDimensions());	
	}
	
	@Test
	public void testRowsSpanFeatureSetFormatDimensions() {
		Assert.assertEquals(Arrays.asList(Dimension.FEATURE, Dimension.EXAMPLE), 
				NeuronsActivationFormat.ROWS_SPAN_FEATURE_SET.getDimensions());	
	}
	
	@Test
	public void testRowsSpanFeatureSetExampleDimensions() {
		Assert.assertEquals(Arrays.asList(Dimension.EXAMPLE), 
				NeuronsActivationFormat.ROWS_SPAN_FEATURE_SET.getExampleDimensions());	
	}
	
	@Test
	public void testRowsSpanFeatureSetGetFeatureFormat() {
		Assert.assertEquals(FeaturesFormat.FLAT, 
				NeuronsActivationFormat.ROWS_SPAN_FEATURE_SET.getFeaturesFormat());	
	}
	
	@Test
	public void testRowsSpanFeatureSetGetFeatureOrientation() {
		Assert.assertEquals(NeuronsActivationFeatureOrientation.ROWS_SPAN_FEATURE_SET, 
				NeuronsActivationFormat.ROWS_SPAN_FEATURE_SET.getFeatureOrientation());	
	}
	
	@Test
	public void testColumnsSpanFeatureSetFormatRowDimensions() {
		Assert.assertEquals(Arrays.asList(Dimension.EXAMPLE), 
				NeuronsActivationFormat.COLUMNS_SPAN_FEATURE_SET.getRowDimensions());	
	}
	
	@Test
	public void testColumnsSpanFeatureSetFormatRowDimensionsName() {
		Assert.assertEquals("[Example]", 
				NeuronsActivationFormat.COLUMNS_SPAN_FEATURE_SET.getRowDimensionsName());	
	}
	
	@Test
	public void testColumnsSpanFeatureSetFormatColumnDimensionsName() {
		Assert.assertEquals("[Feature]", 
				NeuronsActivationFormat.COLUMNS_SPAN_FEATURE_SET.getColumnDimensionsName());	
	}
	
	@Test
	public void testColumnsSpanFeatureSetFormatColumnDimensions() {
		Assert.assertEquals(Arrays.asList(Dimension.FEATURE), 
				NeuronsActivationFormat.COLUMNS_SPAN_FEATURE_SET.getColumnDimensions());	
	}
	
	@Test
	public void testColumnsSpanFeatureSetFormatDimensions() {
		Assert.assertEquals(Arrays.asList(Dimension.EXAMPLE, Dimension.FEATURE), 
				NeuronsActivationFormat.COLUMNS_SPAN_FEATURE_SET.getDimensions());	
	}
	
	@Test
	public void testColumnsSpanFeatureSetExampleDimensions() {
		Assert.assertEquals(Arrays.asList(Dimension.EXAMPLE), 
				NeuronsActivationFormat.COLUMNS_SPAN_FEATURE_SET.getExampleDimensions());	
	}
	
	@Test
	public void testColumnsSpanFeatureSetGetFeatureFormat() {
		Assert.assertEquals(FeaturesFormat.FLAT, 
				NeuronsActivationFormat.COLUMNS_SPAN_FEATURE_SET.getFeaturesFormat());	
	}
	
	@Test
	public void testColumnsSpanFeatureSetGetFeatureOrientation() {
		Assert.assertEquals(NeuronsActivationFeatureOrientation.COLUMNS_SPAN_FEATURE_SET, 
				NeuronsActivationFormat.COLUMNS_SPAN_FEATURE_SET.getFeatureOrientation());	
	}
	
	@Test
	public void testCustomNeuronsActivationFormat() {
		
		NeuronsActivationFormat<?> customDepthHeightWidthWithExampleColumnsFormat = new NeuronsActivationFormat<>(
				NeuronsActivationFeatureOrientation.ROWS_SPAN_FEATURE_SET, new FeaturesFormatImpl(
				Arrays.asList(Dimension.DEPTH, Dimension.HEIGHT, Dimension.WIDTH)), 
				Arrays.asList(Dimension.EXAMPLE));

		
		Assert.assertTrue(ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT
				.isEquivalentFormat(customDepthHeightWidthWithExampleColumnsFormat, DimensionScope.ANY));
		
		Assert.assertTrue(ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT
				.isEquivalentFormat(customDepthHeightWidthWithExampleColumnsFormat, DimensionScope.INPUT));
		
		Assert.assertTrue(ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT
				.isEquivalentFormat(customDepthHeightWidthWithExampleColumnsFormat, DimensionScope.OUTPUT));
		
		Assert.assertTrue(Dimension.isEquivalent(
				customDepthHeightWidthWithExampleColumnsFormat.getDimensions(), ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT.getDimensions(), DimensionScope.ANY));
		
		Assert.assertTrue(Dimension.isEquivalent(
				customDepthHeightWidthWithExampleColumnsFormat.getDimensions(), ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT.getDimensions(), DimensionScope.INPUT));
	
		Assert.assertTrue(Dimension.isEquivalent(
				customDepthHeightWidthWithExampleColumnsFormat.getDimensions(), ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT.getDimensions(), DimensionScope.OUTPUT));
		
	}
	
	@Test
	public void testCustomNeuronsActivationFormat2() {
		
		NeuronsActivationFormat<?> customDepthHeightWidthWithExampleColumnsFormat = new NeuronsActivationFormat<>(
				NeuronsActivationFeatureOrientation.ROWS_SPAN_FEATURE_SET, new FeaturesFormatImpl(
				Arrays.asList(Dimension.INPUT_DEPTH, Dimension.INPUT_HEIGHT, Dimension.INPUT_WIDTH)), 
				Arrays.asList(Dimension.EXAMPLE));
		
		Assert.assertTrue(ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT
				.isEquivalentFormat(customDepthHeightWidthWithExampleColumnsFormat, DimensionScope.ANY));
		
		Assert.assertTrue(ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT
				.isEquivalentFormat(customDepthHeightWidthWithExampleColumnsFormat, DimensionScope.INPUT));
		
		Assert.assertFalse(ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT
				.isEquivalentFormat(customDepthHeightWidthWithExampleColumnsFormat, DimensionScope.OUTPUT));
		
		Assert.assertTrue(Dimension.isEquivalent(
				customDepthHeightWidthWithExampleColumnsFormat.getDimensions(), ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT.getDimensions(), DimensionScope.ANY));
		
		Assert.assertTrue(Dimension.isEquivalent(
				customDepthHeightWidthWithExampleColumnsFormat.getDimensions(), ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT.getDimensions(), DimensionScope.INPUT));
	
		Assert.assertFalse(Dimension.isEquivalent(
				customDepthHeightWidthWithExampleColumnsFormat.getDimensions(), ImageNeuronsActivationFormat.ML4J_DEFAULT_IMAGE_FORMAT.getDimensions(), DimensionScope.OUTPUT));
		
	}
}
