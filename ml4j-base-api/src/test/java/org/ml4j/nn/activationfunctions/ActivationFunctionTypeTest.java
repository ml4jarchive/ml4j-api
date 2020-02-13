package org.ml4j.nn.activationfunctions;

import org.junit.Assert;
import org.junit.Test;

public class ActivationFunctionTypeTest {
	
	@Test
	public void testGetBaseType() {
		ActivationFunctionBaseType activationFunctionBaseType = ActivationFunctionBaseType.RELU;
		ActivationFunctionType activationFunctionType = ActivationFunctionType.getBaseType(activationFunctionBaseType);
		Assert.assertNotNull(activationFunctionType);
		Assert.assertEquals(activationFunctionBaseType, activationFunctionType.getBaseType());
		Assert.assertEquals(activationFunctionBaseType.getId(), activationFunctionType.getId());
		Assert.assertEquals(activationFunctionBaseType.getQualifiedId(), activationFunctionType.getQualifiedId());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU", activationFunctionType.getQualifiedId());
		Assert.assertEquals(activationFunctionBaseType.getParentType(), activationFunctionType.getParentType());
		Assert.assertEquals(activationFunctionBaseType.getBaseType(), activationFunctionType.getBaseType());
		Assert.assertEquals(activationFunctionBaseType, activationFunctionType.getBaseType());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU", activationFunctionType.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetBaseTypeWhenBaseTypeIsCustom() {
		ActivationFunctionBaseType activationFunctionBaseType = ActivationFunctionBaseType.CUSTOM;
		ActivationFunctionType.getBaseType(activationFunctionBaseType);
	}
	
	@Test
	public void testCreateCustomBaseType() {
		ActivationFunctionType activationFunctionType = ActivationFunctionType.createCustomBaseType("SOME_ID");
		Assert.assertNotNull(activationFunctionType);
		Assert.assertEquals(ActivationFunctionBaseType.CUSTOM, activationFunctionType.getBaseType());
		Assert.assertEquals("SOME_ID", activationFunctionType.getId());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.SOME_ID", activationFunctionType.getQualifiedId());		
		Assert.assertEquals(ActivationFunctionBaseType.CUSTOM.getBaseType(), activationFunctionType.getParentType());	
		Assert.assertEquals(ActivationFunctionBaseType.CUSTOM.asActivationFunctionType().getId(), activationFunctionType.getParentType().getId());	
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.SOME_ID", activationFunctionType.toString());
	}
	
	@Test
	public void testCreateSubType() {
		ActivationFunctionType activationFunctionSubType = ActivationFunctionType.createSubType(ActivationFunctionBaseType.RELU, "SOME_ID");
		Assert.assertNotNull(activationFunctionSubType);
		Assert.assertEquals(ActivationFunctionBaseType.RELU, activationFunctionSubType.getBaseType());
		Assert.assertEquals("SOME_ID", activationFunctionSubType.getId());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU.SOME_ID", activationFunctionSubType.getQualifiedId());
		Assert.assertEquals(ActivationFunctionBaseType.RELU, activationFunctionSubType.getParentType());	
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU.SOME_ID", activationFunctionSubType.toString());

	}
	
	@Test
	public void testCreateSubTypeWhenParentIsActivationFunctionType() {
		ActivationFunctionType activationFunctionSubType = ActivationFunctionType.createSubType(ActivationFunctionBaseType.RELU.asActivationFunctionType(), "SOME_ID");
		Assert.assertNotNull(activationFunctionSubType);
		Assert.assertEquals(ActivationFunctionBaseType.RELU, activationFunctionSubType.getBaseType());
		Assert.assertEquals("SOME_ID", activationFunctionSubType.getId());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU.SOME_ID", activationFunctionSubType.getQualifiedId());
		Assert.assertEquals(ActivationFunctionBaseType.RELU.asActivationFunctionType(), activationFunctionSubType.getParentType());	
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU.SOME_ID", activationFunctionSubType.toString());
	}
	
	@Test
	public void testCreateSubTypeWhenParentIsSubtypeActivationFunctionType() {
		ActivationFunctionType parentType = ActivationFunctionType.createSubType(ActivationFunctionBaseType.RELU.asActivationFunctionType(), "SOME_ID_1");
		ActivationFunctionType activationFunctionSubType = ActivationFunctionType.createSubType(parentType, "SOME_ID_2");
		Assert.assertNotNull(activationFunctionSubType);
		Assert.assertEquals(ActivationFunctionBaseType.RELU, activationFunctionSubType.getBaseType());
		Assert.assertEquals("SOME_ID_2", activationFunctionSubType.getId());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU.SOME_ID_1.SOME_ID_2", activationFunctionSubType.getQualifiedId());
		Assert.assertEquals(parentType, activationFunctionSubType.getParentType());		
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU.SOME_ID_1.SOME_ID_2", activationFunctionSubType.toString());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateCustomBaseTypeNameClash() {
		ActivationFunctionType.createCustomBaseType("RELU");
	}
	
	@Test
	public void testConstructorWhenNotBaseType() {
		ActivationFunctionType activationFunctionType = new ActivationFunctionType(ActivationFunctionBaseType.RELU, "SOME_ID", false, false);
		Assert.assertEquals("SOME_ID", activationFunctionType.getId());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU.SOME_ID", activationFunctionType.getQualifiedId());
		Assert.assertEquals(ActivationFunctionBaseType.RELU, activationFunctionType.getBaseType());
		Assert.assertEquals(ActivationFunctionBaseType.RELU, activationFunctionType.getParentType());
		Assert.assertFalse(activationFunctionType.isStandardBaseType());
		Assert.assertFalse(activationFunctionType.isCustomBaseType());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU.SOME_ID", activationFunctionType.toString());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWhenStandardBaseTypeAndIdDoesNotMatch() {
		new ActivationFunctionType(ActivationFunctionBaseType.RELU, "SOME_ID", true, false);
	}
	
	@Test
	public void testConstructorWhenStandardBaseTypeAndIdMatches() {
		ActivationFunctionType activationFunctionType = new ActivationFunctionType(ActivationFunctionBaseType.RELU, "RELU", true, false);
		Assert.assertEquals("RELU", activationFunctionType.getId());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU", activationFunctionType.getQualifiedId());
		Assert.assertEquals(ActivationFunctionBaseType.RELU, activationFunctionType.getBaseType());
		Assert.assertEquals(ActivationFunctionBaseType.RELU, activationFunctionType.getParentType());
		Assert.assertTrue(activationFunctionType.isStandardBaseType());
		Assert.assertFalse(activationFunctionType.isCustomBaseType());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU", activationFunctionType.toString());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWhenStandardBaseTypeAndIdMatchesAndParentTypeIsAnActivationFunctionTypeInstance() {
		new ActivationFunctionType(ActivationFunctionBaseType.RELU.asActivationFunctionType(), "RELU", true, false);
	}
	
	@Test
	public void testConstructorWhenCustomBaseType() {
		ActivationFunctionType activationFunctionType = new ActivationFunctionType(ActivationFunctionBaseType.RELU, "SOME_ID", false, true);
		Assert.assertEquals("SOME_ID", activationFunctionType.getId());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU.SOME_ID", activationFunctionType.getQualifiedId());
		Assert.assertEquals(ActivationFunctionBaseType.RELU, activationFunctionType.getBaseType());
		Assert.assertEquals(ActivationFunctionBaseType.RELU, activationFunctionType.getParentType());
		Assert.assertFalse(activationFunctionType.isStandardBaseType());
		Assert.assertTrue(activationFunctionType.isCustomBaseType());
		Assert.assertEquals("org.ml4j.nn.activationfunctions.ActivationFunctionBaseType.RELU.SOME_ID", activationFunctionType.toString());
	}
	
	@Test
	public void testHashCode() {
		ActivationFunctionType activationFunctionType1 = new ActivationFunctionType(ActivationFunctionBaseType.RELU, "RELU", true, false);
		ActivationFunctionType activationFunctionType2 = new ActivationFunctionType(ActivationFunctionBaseType.RELU, "RELU", true, false);
		Assert.assertEquals(activationFunctionType1.hashCode(), activationFunctionType2.hashCode());
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWhenCustomBaseTypeAndStandardBaseTypeAndNameMatches() {
		new ActivationFunctionType(ActivationFunctionBaseType.RELU, "RELU", true, true);
	}

}
