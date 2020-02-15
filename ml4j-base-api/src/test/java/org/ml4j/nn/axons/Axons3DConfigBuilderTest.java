package org.ml4j.nn.axons;

import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ml4j.nn.neurons.Neurons3D;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;


public class Axons3DConfigBuilderTest {
	
	@Mock
	private Axons3DConfigPopulator<Axons3DConfigBuilder> configPopulator;
	//private Axons3DConfigPopulator configPopulator = new Axons3DConfigPopulatorImpl();
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], null, null));

	}
	
	private Axons3DConfigBuilder mockPopulate(Axons3DConfigBuilder builder, Predicate<Axons3DConfigBuilder> predicate, Consumer<Axons3DConfigBuilder> populator) {
		if (populator != null && predicate != null) {
			if (predicate.test(builder)) {
				populator.accept(builder);
			}
		}
		return builder;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNullLeftNeurons() {
		new Axons3DConfigBuilder(null);
	}
	
	@Test
	public void testConstructorWithOnlyLeftNeurons() {
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		Assert.assertNotNull(builder);
		Assert.assertFalse(builder.isFullyPopulated());
	}
	

	@Test(expected = IllegalStateException.class)
	public void testBuildWithOnlyLeftNeurons() {
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(10, 10, 10, false));
		
		builder.build(configPopulator);
	}
	
	@Test
	public void testBuildWithOnlyLeftAndRightNeurons() {
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder.withOutputNeurons(new Neurons3D(20, 20, 6, false));
	
		Assert.assertFalse(builder.isFullyPopulated());
		
		Axons3DConfig config = builder.build(configPopulator);
	
		Assert.assertNotNull(config);
		
		Assert.assertTrue(config.isFullyPopulated());
		
		Assert.assertEquals(9, config.getFilterHeight());
		Assert.assertEquals(9, config.getFilterWidth());
		Assert.assertEquals(0, config.getPaddingHeight());
		Assert.assertEquals(0, config.getPaddingWidth());
		Assert.assertEquals(1, config.getStrideHeight());
		Assert.assertEquals(1, config.getStrideWidth());
		Assert.assertEquals(new Neurons3D(28, 28, 3, false), config.getLeftNeurons());
		Assert.assertEquals(new Neurons3D(20, 20, 6, false), config.getRightNeurons());	
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuildWithLeftAndIncorrectRightNeuronsWithSamePaddingWithNoFilterDimensionsSet() {
		
		Predicate<Axons3DConfigBuilder> condition = builder -> 
			builder.getLeftNeurons() != null && builder.getRightNeurons() != null && builder.getSamePadding() != null && builder.getSamePadding().booleanValue()
			&& (builder.getRightNeurons().getHeight() != builder.getLeftNeurons().getHeight() 
			|| builder.getRightNeurons().getWidth() != builder.getLeftNeurons().getWidth());
		
		Consumer<Axons3DConfigBuilder> populator = builder -> { throw new IllegalStateException("Left neurons and right neurons width and height dimension must match for same padding"); };
		
		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], condition, populator));
		
		
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder.withOutputNeurons(new Neurons3D(20, 20, 6, false)).withSamePadding();
		
		builder.build(configPopulator);

	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuildWithLeftAndCorrectRightNeuronsWithSamePaddingWithNoFilterDimensionsSet() {
		
		Predicate<Axons3DConfigBuilder> condition = builder -> 
		builder.getLeftNeurons() != null && builder.getRightNeurons() != null && builder.getSamePadding() != null && builder.getSamePadding().booleanValue()
		&& (builder.getRightNeurons().getHeight() == builder.getLeftNeurons().getHeight() 
		&& builder.getRightNeurons().getWidth() == builder.getLeftNeurons().getWidth() && (builder.getFilterHeight() == null || builder.getFilterWidth() == null));
	
		Consumer<Axons3DConfigBuilder> populator = builder -> { throw new IllegalStateException("Same padding cannot be set if either filter width or filter height is null"); };
	
		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], condition, populator));
		
		
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder.withOutputNeurons(new Neurons3D(28, 28, 6, false)).withSamePadding();
		
		builder.build(configPopulator);

	}
	
	@Test(expected=IllegalStateException.class)
	public void testBuildWithLeftAndIncorrectRightNeuronsWithSamePaddingWithFilterDimensionsSet() {
		
		Predicate<Axons3DConfigBuilder> condition = builder -> 
		builder.getLeftNeurons() != null && builder.getRightNeurons() != null && builder.getSamePadding() != null && builder.getSamePadding().booleanValue()
		&& (builder.getRightNeurons().getHeight() != builder.getLeftNeurons().getHeight() 
		|| builder.getRightNeurons().getWidth() != builder.getLeftNeurons().getWidth() && (builder.getFilterHeight() != null && builder.getFilterWidth() != null));
	
		Consumer<Axons3DConfigBuilder> populator = builder -> { throw new IllegalStateException("Left neurons and right neurons width and height dimension must match for same padding"); };
	
		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], condition, populator));
		
		
		
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		

		builder
		.withOutputNeurons(new Neurons3D(20, 20, 6, false))
		.withSamePadding()
		.withFilterHeight(9)
		.withFilterWidth(9);
		
		builder.build(configPopulator);
	}
		
	
	@Test
	public void testBuildWithLeftAndCorrectRightNeuronsWithSamePaddingWithFilterDimensionsSet() {
		
		Predicate<Axons3DConfigBuilder> condition = builder -> 
		builder.getLeftNeurons() != null && builder.getRightNeurons() != null && builder.getSamePadding() != null && builder.getSamePadding().booleanValue()
		&& (builder.getRightNeurons().getHeight() == builder.getLeftNeurons().getHeight() 
		&& builder.getRightNeurons().getWidth() == builder.getLeftNeurons().getWidth() && (builder.getFilterHeight() != null && builder.getFilterWidth() != null));
		
		// Here we would calculate these padding values from the properties already set on builder.
		// For the values used in this test, the padding values should be 4.
		Consumer<Axons3DConfigBuilder> populator = builder -> builder
				.withPaddingHeight(4)
				.withPaddingWidth(4);
	
		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], condition, populator));
		
		
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder
		.withOutputNeurons(new Neurons3D(28, 28, 6, false))
		.withSamePadding()
		.withFilterHeight(9)
		.withFilterWidth(9);
		
		Assert.assertFalse(builder.isFullyPopulated());
		
		Axons3DConfig config = builder.build(configPopulator);
		
		Assert.assertTrue(builder.isFullyPopulated());
		Assert.assertTrue(config.isFullyPopulated());

		
		Assert.assertNotNull(config);
		Assert.assertEquals(9, config.getFilterHeight());
		Assert.assertEquals(9, config.getFilterWidth());
		Assert.assertEquals(4, config.getPaddingHeight());
		Assert.assertEquals(4, config.getPaddingWidth());
		Assert.assertEquals(1, config.getStrideHeight());
		Assert.assertEquals(1, config.getStrideWidth());
		Assert.assertEquals(new Neurons3D(28, 28, 3, false), config.getLeftNeurons());
		Assert.assertEquals(new Neurons3D(28, 28, 6, false), config.getRightNeurons());	
	}
	
	@Test
	public void testBuildWithLeftAndCorrectRightNeuronsWithSamePaddingWithFilterDimensionsSetAndFilterCountSetToCorrectValue() {
		
		Predicate<Axons3DConfigBuilder> condition = builder -> 
		builder.getLeftNeurons() != null && builder.getRightNeurons() != null && builder.getSamePadding() != null && builder.getSamePadding().booleanValue()
		&& (builder.getRightNeurons().getHeight() == builder.getLeftNeurons().getHeight() 
		&& builder.getRightNeurons().getWidth() == builder.getLeftNeurons().getWidth() && (builder.getFilterHeight() != null && builder.getFilterWidth() != null
		&& builder.getOutputDepth() == builder.getRightNeurons().getDepth()));
		
		// Here we would calculate these padding values from the properties already set on builder.
		// For the values used in this test, the padding values should be 4.
		Consumer<Axons3DConfigBuilder> populator = builder -> builder
				.withPaddingHeight(4)
				.withPaddingWidth(4);
	
		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], condition, populator));
		
	
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder
		.withOutputNeurons(new Neurons3D(28, 28, 6, false))
		.withSamePadding()
		.withFilterHeight(9)
		.withFilterWidth(9)
		.withFilterCount(6);
		
		Assert.assertFalse(builder.isFullyPopulated());
		
		Axons3DConfig config = builder.build(configPopulator);
		
		Assert.assertTrue(builder.isFullyPopulated());
		Assert.assertTrue(config.isFullyPopulated());

		
		Assert.assertNotNull(config);
		Assert.assertEquals(9, config.getFilterHeight());
		Assert.assertEquals(9, config.getFilterWidth());
		Assert.assertEquals(4, config.getPaddingHeight());
		Assert.assertEquals(4, config.getPaddingWidth());
		Assert.assertEquals(1, config.getStrideHeight());
		Assert.assertEquals(1, config.getStrideWidth());
		Assert.assertEquals(new Neurons3D(28, 28, 3, false), config.getLeftNeurons());
		Assert.assertEquals(new Neurons3D(28, 28, 6, false), config.getRightNeurons());	
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuildWithLeftAndCorrectRightNeuronsWithSamePaddingWithFilterDimensionsSetAndFilterCountSetToIncorrectValue() {
		
		Predicate<Axons3DConfigBuilder> condition = builder -> 
		builder.getLeftNeurons() != null && builder.getRightNeurons() != null && builder.getSamePadding() != null && builder.getSamePadding().booleanValue()
		&& (builder.getRightNeurons().getHeight() == builder.getLeftNeurons().getHeight() 
		&& builder.getRightNeurons().getWidth() == builder.getLeftNeurons().getWidth() && (builder.getFilterHeight() != null && builder.getFilterWidth() != null
		&& builder.getOutputDepth() != builder.getRightNeurons().getDepth()));
		
		Consumer<Axons3DConfigBuilder> populator = builder -> { throw new IllegalStateException("Filter count does not match the output depth of the right neurons"); };
	
		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], condition, populator));
		
		
		
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder
		.withOutputNeurons(new Neurons3D(28, 28, 6, false))
		.withSamePadding()
		.withFilterHeight(9)
		.withFilterWidth(9)
		.withFilterCount(7);
		
		builder.build(configPopulator);
		
	}
	
	@Test
	public void testBuildWithLeftAndCorrectRightNeuronsWithSamePaddingWithFilterDimensionsAndCorrectPaddingSet() {
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder
		.withOutputNeurons(new Neurons3D(28, 28, 6, false))
		.withSamePadding()
		.withFilterHeight(9)
		.withFilterWidth(9)
		.withPaddingHeight(4)
		.withPaddingWidth(4);
		
		Axons3DConfig config = builder.build(configPopulator);
		
		Assert.assertNotNull(config);
		Assert.assertEquals(9, config.getFilterHeight());
		Assert.assertEquals(9, config.getFilterWidth());
		Assert.assertEquals(4, config.getPaddingHeight());
		Assert.assertEquals(4, config.getPaddingWidth());
		Assert.assertEquals(1, config.getStrideHeight());
		Assert.assertEquals(1, config.getStrideWidth());
		Assert.assertEquals(new Neurons3D(28, 28, 3, false), config.getLeftNeurons());
		Assert.assertEquals(new Neurons3D(28, 28, 6, false), config.getRightNeurons());	
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuildWithLeftAndCorrectRightNeuronsWithSamePaddingWithFilterDimensionsAndIncorrectPaddingHeightSet() {
		
		// Here we would calculate the correct padding height for this configuration 
		int correctPaddingHeightForThisConfiguration = 4;
		
		Predicate<Axons3DConfigBuilder> condition = builder -> 
		builder.getLeftNeurons() != null && builder.getRightNeurons() != null && builder.getSamePadding() != null && builder.getSamePadding().booleanValue()
		&& (builder.getRightNeurons().getHeight() == builder.getLeftNeurons().getHeight() 
		&& builder.getRightNeurons().getWidth() == builder.getLeftNeurons().getWidth() && (builder.getFilterHeight() != null && builder.getFilterWidth() != null
		&& builder.getPaddingHeight() != null && builder.getPaddingHeight().intValue() != correctPaddingHeightForThisConfiguration));
		
		// Here we would calculate these padding values from the properties already set on builder.
		// For the values used in this test, the padding values should be 4.
		Consumer<Axons3DConfigBuilder> populator = builder -> {throw new IllegalStateException("Incorrect padding height for this configuration");};
	
		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], condition, populator));
		
		
		
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder
		.withOutputNeurons(new Neurons3D(28, 28, 6, false))
		.withSamePadding()
		.withFilterHeight(9)
		.withFilterWidth(9)
		.withPaddingHeight(5)
		.withPaddingWidth(4);
		
		builder.build(configPopulator);
	
	}
	
	@Test
	public void testBuildWithLeftAndCorrectRightNeuronsWithSamePaddingWithFilterDimensionsSetAndCorrectStrideOfOneSet() {
		
		int correctStrideHeightForThisConfiguration = 1;
		
		Predicate<Axons3DConfigBuilder> condition = builder -> 
		builder.getLeftNeurons() != null && builder.getRightNeurons() != null && builder.getSamePadding() != null && builder.getSamePadding().booleanValue()
		&& (builder.getRightNeurons().getHeight() == builder.getLeftNeurons().getHeight() 
		&& builder.getRightNeurons().getWidth() == builder.getLeftNeurons().getWidth() && (builder.getFilterHeight() != null && builder.getFilterWidth() != null
		&& builder.getStrideHeight() == correctStrideHeightForThisConfiguration));
		
		// Here we would calculate these padding values from the properties already set on builder.
		// For the values used in this test, the padding values should be 4.
		Consumer<Axons3DConfigBuilder> populator = builder -> builder
				.withPaddingHeight(4)
				.withPaddingWidth(4);

		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], condition, populator));
	
		
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder
		.withOutputNeurons(new Neurons3D(28, 28, 6, false))
		.withSamePadding()
		.withFilterHeight(9)
		.withFilterWidth(9)
		.withStrideHeight(1)
		.withStrideWidth(1);
		
		Assert.assertFalse(builder.isFullyPopulated());
		
		Axons3DConfig config = builder.build(configPopulator);
		
		Assert.assertTrue(builder.isFullyPopulated());

		Assert.assertTrue(config.isFullyPopulated());

		Assert.assertNotNull(config);
		Assert.assertEquals(9, config.getFilterHeight());
		Assert.assertEquals(9, config.getFilterWidth());
		Assert.assertEquals(4, config.getPaddingHeight());
		Assert.assertEquals(4, config.getPaddingWidth());
		Assert.assertEquals(1, config.getStrideHeight());
		Assert.assertEquals(1, config.getStrideWidth());
		Assert.assertEquals(new Neurons3D(28, 28, 3, false), config.getLeftNeurons());
		Assert.assertEquals(new Neurons3D(28, 28, 6, false), config.getRightNeurons());	
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuildWithLeftAndCorrectRightNeuronsWithSamePaddingWithFilterDimensionsSetAndIncorrectStrideOfTwoSet() {
		
		int incorrectStrideHeightForThisConfiguration = 2;
		
		Predicate<Axons3DConfigBuilder> condition = builder -> 
		builder.getLeftNeurons() != null && builder.getRightNeurons() != null && builder.getSamePadding() != null && builder.getSamePadding().booleanValue()
		&& (builder.getRightNeurons().getHeight() == builder.getLeftNeurons().getHeight() 
		&& builder.getRightNeurons().getWidth() == builder.getLeftNeurons().getWidth() && (builder.getFilterHeight() != null && builder.getFilterWidth() != null
		&& builder.getStrideHeight() == incorrectStrideHeightForThisConfiguration));
		
		Consumer<Axons3DConfigBuilder> populator = builder -> { throw new IllegalStateException("Invalid configuration");};

		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], condition, populator));
	
		
		
		
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder
		.withOutputNeurons(new Neurons3D(28, 28, 6, false))
		.withSamePadding()
		.withFilterHeight(9)
		.withFilterWidth(9)
		.withStrideHeight(2)
		.withStrideWidth(1);
		
		Axons3DConfig config = builder.build(configPopulator);
		
		Assert.assertNotNull(config);
		Assert.assertEquals(9, config.getFilterHeight());
		Assert.assertEquals(9, config.getFilterWidth());
		Assert.assertEquals(4, config.getPaddingHeight());
		Assert.assertEquals(4, config.getPaddingWidth());
		Assert.assertEquals(1, config.getStrideHeight());
		Assert.assertEquals(1, config.getStrideWidth());
		Assert.assertEquals(new Neurons3D(28, 28, 3, false), config.getLeftNeurons());
		Assert.assertEquals(new Neurons3D(28, 28, 6, false), config.getRightNeurons());	
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuildWithLeftAndCorrectRightNeuronsWithSamePaddingWithFilterDimensionsSetAndValidPaddingOverride() {
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder
		.withOutputNeurons(new Neurons3D(28, 28, 6, false))
		.withSamePadding()
		.withFilterHeight(9)
		.withFilterWidth(9)
		.withStrideHeight(1)
		.withStrideWidth(1)
		.withValidPadding();
		
		builder.build(configPopulator);
	
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuildWithLeftAndCorrectRightNeuronsWithValidPaddingWithFilterDimensionsSetAndSamePaddingOverride() {
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));
		
		builder
		.withOutputNeurons(new Neurons3D(28, 28, 6, false))
		.withValidPadding()
		.withFilterHeight(9)
		.withFilterWidth(9)
		.withStrideHeight(1)
		.withStrideWidth(1)
		.withSamePadding();
		
		builder.build(configPopulator);
		
	}
	
	@Test
	public void testBuildWithLeftNeuronsButNoRightNeuronsAndNoSamePaddingAndFilterSizeAndCountSet() {
		

		Predicate<Axons3DConfigBuilder> condition = builder -> 
		builder.getLeftNeurons() != null && 
		 (builder.getFilterHeight() != null && builder.getFilterWidth() != null && builder.getOutputDepth() != null);
		
		// Here we would calculate this output neuron values from the properties already set on builder.
		// For the values used in this test, the output width/height/depth is 20/20/6.
		Consumer<Axons3DConfigBuilder> populator = builder -> { builder
			.withOutputNeurons(new Neurons3D(20, 20, 6, false));};
	
		Mockito.when(configPopulator.populateAndValidate(Mockito.any())).thenAnswer(
				  (InvocationOnMock invocation) -> mockPopulate((Axons3DConfigBuilder)invocation.getArguments()[0], condition, populator));
	
		
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));

		builder.withFilterHeight(9).withFilterWidth(9).withFilterCount(6);
				
		Assert.assertFalse(builder.isFullyPopulated());
		
		Axons3DConfig config = builder.build(configPopulator);
		
		Assert.assertFalse(builder.isFullyPopulated());
		
		Assert.assertTrue(config.isFullyPopulated());
		
		Assert.assertNotNull(builder.getRightNeurons());
		
		Assert.assertNotNull(config);
		Assert.assertEquals(9, config.getFilterHeight());
		Assert.assertEquals(9, config.getFilterWidth());
		Assert.assertEquals(0, config.getPaddingHeight());
		Assert.assertEquals(0, config.getPaddingWidth());
		Assert.assertEquals(1, config.getStrideHeight());
		Assert.assertEquals(1, config.getStrideWidth());
		Assert.assertEquals(new Neurons3D(28, 28, 3, false), config.getLeftNeurons());
		Assert.assertEquals(new Neurons3D(20, 20, 6, false), config.getRightNeurons());	
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuildWithLeftNeuronsButNoRightNeuronsAndFilterHeightSetAndCountAndFilterWidthNotSet() {
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));

		builder.withFilterHeight(9).withFilterCount(6);
				
		builder.build(configPopulator);
	
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuildWithLeftNeuronsButNoRightNeuronsAndFilterSizeSetAndCountNotSet() {
		Axons3DConfigBuilder builder = new Axons3DConfigBuilder(
				new Neurons3D(28, 28, 3, false));

		builder.withFilterHeight(9).withFilterWidth(9);
				
		builder.build(configPopulator);
	}
}
