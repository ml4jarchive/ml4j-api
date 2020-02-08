package org.ml4j.nn.activationfunctions;

import org.junit.Assert;
import org.junit.Test;

public class ActivationFunctionBaseTypeTest {

	@Test
	public void testProperties() {
		
		for (ActivationFunctionBaseType baseType :ActivationFunctionBaseType.values()) {
			Assert.assertNotNull(baseType.getParentType());
			Assert.assertEquals(baseType, baseType.getBaseType());
			Assert.assertEquals(baseType, baseType.getParentType());
			Assert.assertEquals(baseType.name(), baseType.getId());
			Assert.assertEquals(baseType.name(), baseType.getQualifiedId());
			Assert.assertEquals(baseType, baseType.getBaseType());
			Assert.assertFalse(baseType.isCustomBaseType());
			Assert.assertTrue(baseType.isStandardBaseType());
			Assert.assertNotNull(baseType.asActivationFunctionType());
			ActivationFunctionType activationFunctionType = baseType.asActivationFunctionType();
			Assert.assertNotEquals(baseType, activationFunctionType);
			Assert.assertEquals(baseType, activationFunctionType.getBaseType());
			Assert.assertEquals(baseType, activationFunctionType.getParentType());
			Assert.assertFalse(activationFunctionType.isCustomBaseType());
			Assert.assertTrue(activationFunctionType.isStandardBaseType());
			Assert.assertEquals(baseType.getId(),activationFunctionType.getId());
			Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType." + baseType.getId(),activationFunctionType.getQualifiedId());
		}
	}
}
