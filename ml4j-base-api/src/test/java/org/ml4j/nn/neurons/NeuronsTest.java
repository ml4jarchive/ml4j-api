package org.ml4j.nn.neurons;

import org.junit.Assert;
import org.junit.Test;

public class NeuronsTest {

	@Test
	public void testA() {
		
		Neurons neurons1 = new Neurons(5, false);
		
		Assert.assertFalse(neurons1.hasBiasUnit());
		Assert.assertEquals(5, neurons1.getNeuronCountExcludingBias());
		Assert.assertEquals(5, neurons1.getNeuronCountIncludingBias());
		
		Neurons neurons2 = new Neurons(5, false);
		Assert.assertFalse(neurons2.hasBiasUnit());
		Assert.assertEquals(5, neurons2.getNeuronCountExcludingBias());
		Assert.assertEquals(5, neurons2.getNeuronCountIncludingBias());
		
		Neurons neurons3 = new Neurons(5, true);
		Assert.assertTrue(neurons3.hasBiasUnit());
		Assert.assertEquals(5, neurons3.getNeuronCountExcludingBias());
		Assert.assertEquals(6, neurons3.getNeuronCountIncludingBias());
		
		Neurons neurons4 = new Neurons(6, false);
		Assert.assertFalse(neurons4.hasBiasUnit());
		Assert.assertEquals(6, neurons4.getNeuronCountExcludingBias());
		Assert.assertEquals(6, neurons4.getNeuronCountIncludingBias());	
		
		Assert.assertEquals(neurons1, neurons1);
		Assert.assertEquals(neurons1.hashCode(), neurons1.hashCode());
		
		Assert.assertNotNull(neurons1.toString());
	}
}
