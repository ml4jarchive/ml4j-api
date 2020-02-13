package org.ml4j.nn.axons;

import org.junit.Assert;
import org.junit.Test;

public class AxonsBaseTypeTest {

	@Test
	public void testProperties() {
		
		for (AxonsBaseType baseType :AxonsBaseType.values()) {
			Assert.assertNotNull(baseType.getParentType());
			Assert.assertEquals(baseType, baseType.getBaseType());
			Assert.assertEquals(baseType, baseType.getParentType());
			Assert.assertEquals(baseType.name(), baseType.getId());
			Assert.assertEquals(baseType.name(), baseType.getQualifiedId());
			Assert.assertEquals(baseType, baseType.getBaseType());
			Assert.assertFalse(baseType.isCustomBaseType());
			Assert.assertTrue(baseType.isStandardBaseType());
			Assert.assertNotNull(baseType.asAxonsType());
			AxonsType axonsType = baseType.asAxonsType();
			Assert.assertEquals(baseType, axonsType.getBaseType());
			Assert.assertEquals(baseType, axonsType.getParentType());
			Assert.assertFalse(axonsType.isCustomBaseType());
			Assert.assertTrue(axonsType.isStandardBaseType());
			Assert.assertEquals(baseType.getId(),axonsType.getId());
			Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType." + baseType.getId(),axonsType.getQualifiedId());
		}
	}
}
