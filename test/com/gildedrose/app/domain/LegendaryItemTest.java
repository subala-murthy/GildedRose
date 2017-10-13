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
public class LegendaryItemTest {
	Item legendaryItem;
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
		legendaryItem = new LegendaryItem("Sulfuras",3,3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.gildedrose.app.domain.LegendaryItem#updateQuality()}.
	 */
	@Test
	public final void testUpdateQuality() {		
		legendaryItem.updateQuality();
	    assertEquals(3,legendaryItem.getQuality());		
	}

	/**
	 * Test method for {@link com.gildedrose.app.domain.LegendaryItem#updateSellIn()}.
	 */
	@Test
	public final void testUpdateSellIn() {		
		legendaryItem.updateSellIn();
	    assertEquals(3,legendaryItem.getSellIn());		
	}		

	

}
