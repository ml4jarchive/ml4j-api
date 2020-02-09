package org.ml4j.nn.neurons;

import org.junit.Assert;
import org.junit.Test;

public class Neurons3DTest {

	@Test
	public void testA() {
		
		Neurons3D neurons1 = new Neurons3D(2, 3, 5, false);
		
		Assert.assertFalse(neurons1.hasBiasUnit());
		Assert.assertEquals(30, neurons1.getNeuronCountExcludingBias());
		Assert.assertEquals(30, neurons1.getNeuronCountIncludingBias());
		Assert.assertEquals(2, neurons1.getWidth());
		Assert.assertEquals(3, neurons1.getHeight());
		Assert.assertEquals(5, neurons1.getDepth());
		
		Neurons neurons10 = new Neurons(30, false);
		Assert.assertNotEquals(neurons10, neurons1);
		Assert.assertNotEquals(neurons1, neurons10);

		Neurons3D neurons2 = new Neurons3D(2, 3, 5, false);
		Assert.assertFalse(neurons2.hasBiasUnit());
		Assert.assertEquals(30, neurons2.getNeuronCountExcludingBias());
		Assert.assertEquals(30, neurons2.getNeuronCountIncludingBias());
		Assert.assertEquals(2, neurons2.getWidth());
		Assert.assertEquals(3, neurons2.getHeight());
		Assert.assertEquals(5, neurons2.getDepth());
		
		Neurons3D neurons3 = new Neurons3D(2, 3, 5, true);
		Assert.assertTrue(neurons3.hasBiasUnit());
		Assert.assertEquals(30, neurons3.getNeuronCountExcludingBias());
		Assert.assertEquals(31, neurons3.getNeuronCountIncludingBias());
		Assert.assertEquals(2, neurons3.getWidth());
		Assert.assertEquals(3, neurons3.getHeight());
		Assert.assertEquals(5, neurons3.getDepth());	
		
		Assert.assertEquals(neurons1, neurons1);
		Assert.assertEquals(neurons1.hashCode(), neurons1.hashCode());
		
		Assert.assertNotNull(neurons1.toString());

	}
}
