/**
 * 
 */
package com.gildedrose.app.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author subala
 *
 */
public class ItemTest {
	Item i1;
	Item i2;
	Item i3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		i1=new Item("Normal Item",-2,-1);
		i2=new Item("Normal Item",5,55);
		i3=new Item("Normal Item",10,10);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}	

	/**
	 * Test method for {@link com.gildedrose.app.domain.Item#validateQuality()}.
	 */
	@Test
	public final void testValidateQualityforMinimumQuantity() {
		assertFalse(i1.validateQuality());
		assertEquals(0,i1.getQuality());
		
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.domain.Item#validateQuality()}.
	 */
	@Test
	public final void testValidateQualityforMaximumQuantity() {
		assertFalse(i2.validateQuality());
		assertEquals(50,i2.getQuality());
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.domain.Item#validateQuality()}.
	 */
	@Test
	public final void testValidateQualityforValidQuality() {
		assertTrue(i3.validateQuality());
		assertEquals(10,i3.getQuality());
	}

	/**
	 * Test method for {@link com.gildedrose.app.domain.Item#updateQuality()}.
	 */
	@Test
	public final void testUpdateQuality() {
		i1.updateQuality();
		i2.updateQuality();
		i3.updateQuality();
		assertEquals(-2,i1.getQuality());
		assertEquals(54,i2.getQuality());
		assertEquals(9,i3.getQuality());
		
	}

	/**
	 * Test method for {@link com.gildedrose.app.domain.Item#updateSellIn()}.
	 */
	@Test
	public final void testUpdateSellIn() {
		i1.updateSellIn();
		i2.updateSellIn();
		i3.updateSellIn();
		assertEquals(-3,i1.getSellIn());
		assertEquals(4,i2.getSellIn());
		assertEquals(9,i3.getSellIn());
	}

}
