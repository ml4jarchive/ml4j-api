package org.ml4j.nn.axons;

import org.junit.Assert;
import org.junit.Test;
import org.ml4j.nn.neurons.Neurons3D;

public class Axons3DConfigTest {
	
	@Test
	public void testBuilderWithFilterHeightAndWidthSet() {
		Axons3DConfig config = new Axons3DConfig(new Neurons3D(3, 3, 1, false), new Neurons3D(3,3,1,false));
		config.withFilterHeight(3).withFilterWidth(3)
			.withPaddingHeight(1).withPaddingWidth(1).withStrideHeight(1).withStrideWidth(1);
		
		Assert.assertEquals((int)3, (int)config.getFilterHeight());
		Assert.assertEquals((int)3, (int)config.getFilterWidth());
		Assert.assertEquals((int)1, (int)config.getPaddingHeight());
		Assert.assertEquals((int)1, (int)config.getPaddingWidth());
		Assert.assertEquals((int)1, (int)config.getStrideHeight());
		Assert.assertEquals((int)1, (int)config.getStrideWidth());

		Axons3DConfig dupConfig = config.dup();
		
		Assert.assertEquals((int)3, (int)dupConfig.getFilterHeight());
		Assert.assertEquals((int)3, (int)dupConfig.getFilterWidth());
		Assert.assertEquals((int)1, (int)dupConfig.getPaddingHeight());
		Assert.assertEquals((int)1, (int)dupConfig.getPaddingWidth());
		Assert.assertEquals((int)1, (int)dupConfig.getStrideHeight());
		Assert.assertEquals((int)1, (int)dupConfig.getStrideWidth());

		Assert.assertTrue(config.equals(dupConfig));

	}
	
	@Test
	public void testBuilderWithoutFilterHeightAndWidthSet() {
		Axons3DConfig config = new Axons3DConfig(new Neurons3D(3, 3, 1, false), new Neurons3D(3,3,1,false))
				.withPaddingHeight(1).withPaddingWidth(1).withStrideHeight(1).withStrideWidth(1);
		
		Assert.assertEquals((int)3, (int)config.getFilterHeight());
		Assert.assertEquals((int)3, (int)config.getFilterWidth());
		Assert.assertEquals((int)1, (int)config.getPaddingHeight());
		Assert.assertEquals((int)1, (int)config.getPaddingWidth());
		Assert.assertEquals((int)1, (int)config.getStrideHeight());
		Assert.assertEquals((int)1, (int)config.getStrideWidth());

		Axons3DConfig dupConfig = config.dup();
		
		Assert.assertEquals((int)3, (int)dupConfig.getFilterHeight());
		Assert.assertEquals((int)3, (int)dupConfig.getFilterWidth());
		Assert.assertEquals((int)1, (int)dupConfig.getPaddingHeight());
		Assert.assertEquals((int)1, (int)dupConfig.getPaddingWidth());
		Assert.assertEquals((int)1, (int)dupConfig.getStrideHeight());
		Assert.assertEquals((int)1, (int)dupConfig.getStrideWidth());

		Assert.assertTrue(config.equals(dupConfig));

	}

}
