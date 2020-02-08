package org.ml4j.nn.components;

import org.junit.Assert;
import org.junit.Test;

public class NeuralComponentTypeTest {

	@Test
	public void testProperties() {
		
		for (NeuralComponentBaseType baseType :NeuralComponentBaseType.values()) {
			Assert.assertNotNull(baseType.getParentType());
			Assert.assertEquals(baseType, baseType.getBaseType());
			Assert.assertEquals(baseType, baseType.getParentType());
			Assert.assertEquals(baseType.name(), baseType.getId());
			Assert.assertEquals(baseType.name(), baseType.getQualifiedId());
			Assert.assertEquals(baseType, baseType.getBaseType());
		}
	}
}
