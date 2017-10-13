/**
 * 
 */
package com.gildedrose.app.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gildedrose.app.domain.CheeseItem;
import com.gildedrose.app.domain.ConjuredItem;
import com.gildedrose.app.domain.Item;
import com.gildedrose.app.domain.LegendaryItem;
import com.gildedrose.app.domain.PassItem;

/**
 * @author subala
 *
 */
public class ItemFactoryTest {

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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCheeseItem() {
		Item cheeseItem = ItemFactory.getItemObject("Aged Brie",5, 5);
		assertTrue(cheeseItem instanceof CheeseItem);
		
	}
	@Test
	public final void testPassItem() {
		Item passItem = ItemFactory.getItemObject("Backstage passes",5, 5);
		assertTrue(passItem instanceof PassItem);
	}
	@Test
	public final void testLegendaryItem() {
		Item legendaryItem = ItemFactory.getItemObject("Sulfuras SellIn",5, 5);
		assertTrue(legendaryItem instanceof LegendaryItem);
	}
	@Test
	public final void testNormalItem() {
		Item normalItem = ItemFactory.getItemObject("Normal Item",5, 5); 
		normalItem.updateQuality();
		normalItem.updateSellIn();
		assertTrue(normalItem.getQuality()==4 && normalItem.getSellIn()==4);
	}
	@Test
	public final void testConjuredItem() {
		Item conjuredItem = ItemFactory.getItemObject("Conjured",5, 5); 
		assertTrue(conjuredItem instanceof ConjuredItem);
	}	
	@Test
	public final void testInvalidItem() {
		Item invalidItem = ItemFactory.getItemObject("Invalid Item Name",5,5);
		assertTrue(invalidItem.getItemName().equals("NO SUCH ITEM"));
		
	}

}
