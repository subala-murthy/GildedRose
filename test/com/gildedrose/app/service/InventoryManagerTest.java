/**
 * 
 */
package com.gildedrose.app.service;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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
public class InventoryManagerTest {
	private InventoryManager manager;
	private String rootDir;	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Item item;	
	List<Item> itemList;

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
		manager = new InventoryManager();
		itemList = new ArrayList<Item>();
		rootDir=System.getProperty("user.dir")+"/test/resources/";		
		System.setOut(new PrintStream(outContent));
	}
		
		
		

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		itemList.clear();
	}

	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#loadItems(java.lang.String)}.
	 */
	@Test
	public final void testLoadItems_InvalidFilePath() {
		boolean result = manager.loadItems(rootDir+"xxx.txt");
		assertTrue(outContent.toString().startsWith("Unable to read the file!!!") && !result);
		
		
	}
	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#loadItems(java.lang.String)}.
	 */
	@Test
	public final void testLoadItems_ValidFilePath() {
		assertTrue(manager.loadItems(rootDir+"input.txt")&& !manager.getItemList().isEmpty());				
	}		

	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#updateInventory()}.
	 */
	@Test
	public final void testLoadItems_withInvalidParameter1() {		
		manager.loadItems(rootDir+"invalidParam.txt");
		assertTrue(outContent.toString().startsWith("Invalid values found in the file"));
		
		
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#updateInventory()}.
	 */
	@Test
	public final void testLoadItems_withInvalidParameter2() {		
		manager.loadItems(rootDir+"invalidQuality.txt");
		assertTrue(outContent.toString().startsWith("Invalid sell in (or) quality has been given"));				
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#updateInventory()}.
	 */
	@Test
	public final void testUpdateInventory_CheeseItem() {	
		item=new CheeseItem("Aged Brie",2,5);		
		itemList.add(item);
		manager.setItemList(itemList);
		manager.updateInventory();
		assertTrue(outContent.toString().startsWith("Aged Brie 1 6"));	
						
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#updateInventory()}.
	 */
	@Test
	public final void testUpdateInventory_PassItemWithin5DaysSellIn() {	
		item=new PassItem("Backstage passes",2,5);			
		itemList.add(item);
		manager.setItemList(itemList);
		manager.updateInventory();
		assertTrue(outContent.toString().startsWith("Backstage passes 1 8"));	
						
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#updateInventory()}.
	 */
	@Test
	public final void testUpdateInventory_PassItemWithin10DaysSellIn() {	
		item=new PassItem("Backstage passes",7,5);			
		itemList.add(item);
		manager.setItemList(itemList);
		manager.updateInventory();
		assertTrue(outContent.toString().startsWith("Backstage passes 6 7"));	
						
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#updateInventory()}.
	 */
	@Test
	public final void testUpdateInventory_PassItemWithin0DaysSellIn() {	
		item=new PassItem("Backstage passes",1,20);			
		itemList.add(item);
		manager.setItemList(itemList);
		manager.updateInventory();
		assertTrue(outContent.toString().startsWith("Backstage passes 0 0"));	
						
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#updateInventory()}.
	 */
	@Test
	public final void testUpdateInventory_ItemWithQualityOver50() {	
		item=new Item("Normal Item",7,55);			
		itemList.add(item);
		manager.setItemList(itemList);
		manager.updateInventory();
		assertTrue(outContent.toString().startsWith("Normal Item 6 50"));							
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#updateInventory()}.
	 */
	@Test
	public final void testUpdateInventory_ItemWithQualityUnder0() {	
		item=new Item("Normal Item",7,-3);			
		itemList.add(item);
		manager.setItemList(itemList);
		manager.updateInventory();
		assertTrue(outContent.toString().startsWith("Normal Item 6 0"));							
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#updateInventory()}.
	 */
	@Test
	public final void testUpdateInventory_LegendaryItem() {	
		item=new LegendaryItem("Sulfuras Sellin",7,7);			
		itemList.add(item);
		manager.setItemList(itemList);
		manager.updateInventory();
		assertTrue(outContent.toString().startsWith("Sulfuras Sellin 7 7"));							
	}
	
	/**
	 * Test method for {@link com.gildedrose.app.service.InventoryManager#updateInventory()}.
	 */
	@Test
	public final void testUpdateInventory_ConjuredItem() {	
		item=new ConjuredItem("Conjured",7,7);			
		itemList.add(item);
		manager.setItemList(itemList);
		manager.updateInventory();
		assertTrue(outContent.toString().startsWith("Conjured 6 5"));							
	}

}
