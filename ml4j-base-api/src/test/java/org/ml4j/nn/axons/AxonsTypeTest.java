package org.ml4j.nn.axons;

import org.junit.Assert;
import org.junit.Test;

public class AxonsTypeTest {
	
	@Test
	public void testGetBaseType() {
		AxonsBaseType axonsBaseType = AxonsBaseType.CONVOLUTIONAL;
		AxonsType axonsType = AxonsType.getBaseType(axonsBaseType);
		Assert.assertNotNull(axonsType);
		Assert.assertEquals(axonsBaseType, axonsType.getBaseType());
		Assert.assertEquals(axonsBaseType.getId(), axonsType.getId());
		Assert.assertEquals(axonsBaseType.getQualifiedId(), axonsType.getQualifiedId());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL", axonsType.getQualifiedId());
		Assert.assertEquals(axonsBaseType.getParentType(), axonsType.getParentType());
		Assert.assertEquals(axonsBaseType.getBaseType(), axonsType.getBaseType());
		Assert.assertEquals(axonsBaseType, axonsType.getBaseType());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL", axonsType.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetBaseTypeWhenBaseTypeIsCustom() {
		AxonsBaseType axonsBaseType = AxonsBaseType.CUSTOM;
		AxonsType.getBaseType(axonsBaseType);
	}
	
	@Test
	public void testCreateCustomBaseType() {
		AxonsType axonsType = AxonsType.createCustomBaseType("SOME_ID");
		Assert.assertNotNull(axonsType);
		Assert.assertEquals(AxonsBaseType.CUSTOM, axonsType.getBaseType());
		Assert.assertEquals("SOME_ID", axonsType.getId());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.SOME_ID", axonsType.getQualifiedId());		
		Assert.assertEquals(AxonsBaseType.CUSTOM.getBaseType(), axonsType.getParentType());	
		Assert.assertEquals(AxonsBaseType.CUSTOM.asAxonsType().getId(), axonsType.getParentType().getId());	
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.SOME_ID", axonsType.toString());
	}
	
	@Test
	public void testCreateSubType() {
		AxonsType axonsSubType = AxonsType.createSubType(AxonsBaseType.CONVOLUTIONAL, "SOME_ID");
		Assert.assertNotNull(axonsSubType);
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL, axonsSubType.getBaseType());
		Assert.assertEquals("SOME_ID", axonsSubType.getId());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL.SOME_ID", axonsSubType.getQualifiedId());
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL, axonsSubType.getParentType());	
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL.SOME_ID", axonsSubType.toString());

	}
	
	@Test
	public void testCreateSubTypeWhenParentIsAxonsType() {
		AxonsType axonsSubType = AxonsType.createSubType(AxonsBaseType.CONVOLUTIONAL.asAxonsType(), "SOME_ID");
		Assert.assertNotNull(axonsSubType);
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL, axonsSubType.getBaseType());
		Assert.assertEquals("SOME_ID", axonsSubType.getId());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL.SOME_ID", axonsSubType.getQualifiedId());
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL.asAxonsType(), axonsSubType.getParentType());	
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL.SOME_ID", axonsSubType.toString());
	}
	
	@Test
	public void testCreateSubTypeWhenParentIsSubtypeAxonsType() {
		AxonsType parentType = AxonsType.createSubType(AxonsBaseType.CONVOLUTIONAL.asAxonsType(), "SOME_ID_1");
		AxonsType axonsSubType = AxonsType.createSubType(parentType, "SOME_ID_2");
		Assert.assertNotNull(axonsSubType);
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL, axonsSubType.getBaseType());
		Assert.assertEquals("SOME_ID_2", axonsSubType.getId());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL.SOME_ID_1.SOME_ID_2", axonsSubType.getQualifiedId());
		Assert.assertEquals(parentType, axonsSubType.getParentType());		
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL.SOME_ID_1.SOME_ID_2", axonsSubType.toString());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateCustomBaseTypeNameClash() {
		AxonsType.createCustomBaseType("CONVOLUTIONAL");
	}
	
	@Test
	public void testConstructorWhenNotBaseType() {
		AxonsType axonsType = new AxonsType(AxonsBaseType.CONVOLUTIONAL, "SOME_ID", false, false);
		Assert.assertEquals("SOME_ID", axonsType.getId());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL.SOME_ID", axonsType.getQualifiedId());
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL, axonsType.getBaseType());
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL, axonsType.getParentType());
		Assert.assertFalse(axonsType.isStandardBaseType());
		Assert.assertFalse(axonsType.isCustomBaseType());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL.SOME_ID", axonsType.toString());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWhenStandardBaseTypeAndIdDoesNotMatch() {
		new AxonsType(AxonsBaseType.CONVOLUTIONAL, "SOME_ID", true, false);
	}
	
	@Test
	public void testConstructorWhenStandardBaseTypeAndIdMatches() {
		AxonsType axonsType = new AxonsType(AxonsBaseType.CONVOLUTIONAL, "CONVOLUTIONAL", true, false);
		Assert.assertEquals("CONVOLUTIONAL", axonsType.getId());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL", axonsType.getQualifiedId());
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL, axonsType.getBaseType());
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL, axonsType.getParentType());
		Assert.assertTrue(axonsType.isStandardBaseType());
		Assert.assertFalse(axonsType.isCustomBaseType());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL", axonsType.toString());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWhenStandardBaseTypeAndIdMatchesAndParentTypeIsAnAxonsTypeInstance() {
		new AxonsType(AxonsBaseType.CONVOLUTIONAL.asAxonsType(), "CONVOLUTIONAL", true, false);
	}
	
	@Test
	public void testConstructorWhenCustomBaseType() {
		AxonsType axonsType = new AxonsType(AxonsBaseType.CONVOLUTIONAL, "SOME_ID", false, true);
		Assert.assertEquals("SOME_ID", axonsType.getId());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL.SOME_ID", axonsType.getQualifiedId());
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL, axonsType.getBaseType());
		Assert.assertEquals(AxonsBaseType.CONVOLUTIONAL, axonsType.getParentType());
		Assert.assertFalse(axonsType.isStandardBaseType());
		Assert.assertTrue(axonsType.isCustomBaseType());
		Assert.assertEquals("org.ml4j.nn.axons.AxonsBaseType.CONVOLUTIONAL.SOME_ID", axonsType.toString());
	}
	
	@Test
	public void testHashCode() {
		AxonsType axonsType1 = new AxonsType(AxonsBaseType.CONVOLUTIONAL, "CONVOLUTIONAL", true, false);
		AxonsType axonsType2 = new AxonsType(AxonsBaseType.CONVOLUTIONAL, "CONVOLUTIONAL", true, false);
		Assert.assertEquals(axonsType1.hashCode(), axonsType2.hashCode());
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWhenCustomBaseTypeAndStandardBaseTypeAndNameMatches() {
		new AxonsType(AxonsBaseType.CONVOLUTIONAL, "CONVOLUTIONAL", true, true);
	}

}
