package org.ml4j.nn.components;

import org.junit.Assert;
import org.junit.Test;

public class NeuralComponentBaseTypeTest {

	@Test
	public void testProperties() {
		
		for (NeuralComponentBaseType baseType :NeuralComponentBaseType.values()) {
			Assert.assertNotNull(baseType.getParentType());
			Assert.assertEquals(baseType, baseType.getBaseType());
			Assert.assertEquals(baseType, baseType.getParentType());
			Assert.assertEquals(baseType.name(), baseType.getId());
			Assert.assertEquals(baseType.name(), baseType.getQualifiedId());
			Assert.assertEquals(baseType, baseType.getBaseType());
			Assert.assertFalse(baseType.isCustomBaseType());
			Assert.assertTrue(baseType.isStandardBaseType());
			Assert.assertNotNull(baseType.asNeuralNetworkType());
			NeuralComponentType neuralComponentType = baseType.asNeuralNetworkType();
			Assert.assertNotEquals(baseType, neuralComponentType);
			Assert.assertEquals(baseType, neuralComponentType.getBaseType());
			Assert.assertEquals(baseType, neuralComponentType.getParentType());
			Assert.assertFalse(neuralComponentType.isCustomBaseType());
			Assert.assertTrue(neuralComponentType.isStandardBaseType());
			Assert.assertEquals(baseType.getId(),neuralComponentType.getId());
			Assert.assertEquals(baseType.getQualifiedId(),neuralComponentType.getQualifiedId());
		}
	}
}
