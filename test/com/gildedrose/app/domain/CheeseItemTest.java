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
public class CheeseItemTest {
	
	Item cheeseItem;

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
		cheeseItem = new CheeseItem("Aged Brie",5,10);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.gildedrose.app.domain.CheeseItem#updateQuality()}.
	 */
	@Test
	public final void testUpdateQuality() {
		cheeseItem.updateQuality();
		assertEquals(11,cheeseItem.getQuality());
	}	

	/**
	 * Test method for {@link com.gildedrose.app.domain.Item#updateSellIn()}.
	 */
	@Test
	public final void testUpdateSellIn() {
		cheeseItem.updateSellIn();
		assertEquals(4,cheeseItem.getSellIn());
	}

}
