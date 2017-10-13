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
public class PassItemTest {
	Item passItem1;
	Item passItem2;
	Item passItem3;
	

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
		passItem1 = new PassItem("Backstage Passes",7, 10);
		passItem2 = new PassItem("Backstage Passes", 3, 15);
		passItem3 = new PassItem("Backstage Passes",0,25);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.gildedrose.app.domain.PassItem#updateQuality()}.
	 */
	@Test
	public final void testUpdateQualityForLessThan10Days() {
		
		passItem1.updateQuality();
		assertEquals(12,passItem1.getQuality());
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.domain.PassItem#updateQuality()}.
	 */
	@Test
	public final void testUpdateQualityForLessThan5Days() {
		
		passItem2.updateQuality();
		assertEquals(18,passItem2.getQuality());
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.domain.PassItem#updateQuality()}.
	 */
	@Test
	public final void testUpdateQualityFor0Sellin() {		
		passItem3.updateQuality();
		assertEquals(0,passItem3.getQuality());
	}	

	/**
	 * Test method for {@link com.gildedrose.app.domain.Item#updateSellIn()}.
	 */
	@Test
	public final void testUpdateSellIn() {		
	    passItem1.updateSellIn();
	    assertEquals(6,passItem1.getSellIn());
	}

}
