package org.ml4j.nn.axons;

import org.junit.Assert;
import org.junit.Test;

public class Axons3DConfigTest {
	
	@Test
	public void testBuilderWithFilterHeightAndWidthSet() {
		Axons3DConfig config = new Axons3DConfig();
		config.withFilterHeight(1).withFilterWidth(2)
			.withPaddingHeight(3).withPaddingWidth(4).withStrideHeight(5).withStrideWidth(6);
		
		Assert.assertEquals((int)1, (int)config.getFilterHeight());
		Assert.assertEquals((int)2, (int)config.getFilterWidth());
		Assert.assertEquals((int)3, (int)config.getPaddingHeight());
		Assert.assertEquals((int)4, (int)config.getPaddingWidth());
		Assert.assertEquals((int)5, (int)config.getStrideHeight());
		Assert.assertEquals((int)6, (int)config.getStrideWidth());

		Axons3DConfig dupConfig = config.dup();
		
		Assert.assertEquals((int)1, (int)dupConfig.getFilterHeight());
		Assert.assertEquals((int)2, (int)dupConfig.getFilterWidth());
		Assert.assertEquals((int)3, (int)dupConfig.getPaddingHeight());
		Assert.assertEquals((int)4, (int)dupConfig.getPaddingWidth());
		Assert.assertEquals((int)5, (int)dupConfig.getStrideHeight());
		Assert.assertEquals((int)6, (int)dupConfig.getStrideWidth());

		Assert.assertTrue(config.equals(dupConfig));

	}
	
	@Test
	public void testBuilderWithoutFilterHeightAndWidthSet() {
		Axons3DConfig config = new Axons3DConfig();
		config.withPaddingHeight(3).withPaddingWidth(4).withStrideHeight(5).withStrideWidth(6);
		
		Assert.assertEquals((int)3, (int)config.getPaddingHeight());
		Assert.assertEquals((int)4, (int)config.getPaddingWidth());
		Assert.assertEquals((int)5, (int)config.getStrideHeight());
		Assert.assertEquals((int)6, (int)config.getStrideWidth());

		Axons3DConfig dupConfig = config.dup();
		Axons3DConfig dupConfig2 = config.dup();
		
		dupConfig2.withFilterHeight(10);
		dupConfig2.withFilterWidth(10);

		Assert.assertEquals((int)3, (int)dupConfig.getPaddingHeight());
		Assert.assertEquals((int)4, (int)dupConfig.getPaddingWidth());
		Assert.assertEquals((int)5, (int)dupConfig.getStrideHeight());
		Assert.assertEquals((int)6, (int)dupConfig.getStrideWidth());


		Assert.assertEquals(config.hashCode(), dupConfig.hashCode());
		Assert.assertTrue(config.equals(dupConfig));
		Assert.assertFalse(config.equals(dupConfig2));
		Assert.assertNotEquals(config.hashCode(), dupConfig2.hashCode());


	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuilderWithoutFilterHeightAndWidthSetAndFilterHeightCalled() {
		Axons3DConfig config = new Axons3DConfig();
		config.withPaddingHeight(3).withPaddingWidth(4).withStrideHeight(5).withStrideWidth(6);
	
		Assert.assertEquals((int)3, (int)config.getPaddingHeight());
		Assert.assertEquals((int)4, (int)config.getPaddingWidth());
		Assert.assertEquals((int)5, (int)config.getStrideHeight());
		Assert.assertEquals((int)6, (int)config.getStrideWidth());
		config.getFilterHeight();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBuilderWithoutFilterHeightAndWidthSetAndFilterWidthCalled() {
		Axons3DConfig config = new Axons3DConfig();
		config.withPaddingHeight(3).withPaddingWidth(4).withStrideHeight(5).withStrideWidth(6);
	
		Assert.assertEquals((int)3, (int)config.getPaddingHeight());
		Assert.assertEquals((int)4, (int)config.getPaddingWidth());
		Assert.assertEquals((int)5, (int)config.getStrideHeight());
		Assert.assertEquals((int)6, (int)config.getStrideWidth());
		config.getFilterWidth();
	}

}
