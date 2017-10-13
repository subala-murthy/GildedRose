package com.gildedrose.app.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gildedrose.app.domain.Item;

/**
 * 
 * @author subala
 *
 * Inventory Manager class reads the input text file and prints out the updated inventory
 */
public class InventoryManager {

	private List<Item> itemList = new ArrayList<Item>();
	//getter and setter methods
	public List<Item> getItemList(){
		return itemList;
	}
	public void setItemList(List<Item> itemList){
		this.itemList=itemList;
	}

	/**
	 * reads the file given in the filePath and parses each line and creates the
	 * corresponding Item Object and adds the object in itemList (e-g) filePath
	 * = "D:/input.txt"
	 * 
	 * @param filePath
	 */
	
	public boolean loadItems(String filePath) {
		boolean itemsLoaded = false;
		BufferedReader reader;
		try {			
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			List<Item> tempList = new ArrayList<Item>(); //empty array list
			while (line != null) {
				String[] itemParams = parseLine(line); // parse the input line from the file
				if (itemParams != null) {
					Item i = generateItem(itemParams); // generates Item object from the input array 
					tempList.add(i); //adds the item object to list
					itemsLoaded = true;
				} else {
					System.out.println("Invalid values found in the file");
				}
				line = reader.readLine();
			}
			setItemList(tempList);
			reader.close();
		} catch (IOException e) {
			System.out.println("Unable to read the file!!!");
			
		}
		return itemsLoaded;
	}

	/**
	 * This method iterates through all the items in the itemList and updates their sell in
	 * and quality value and prints the updated result
	 * 
	 * validateQuality is used to amend the quality when it is out of the range i.e., 0-50
	 */
	public void updateInventory() {
		for (Item i : getItemList()) {
			i.updateSellIn();
			if (i.validateQuality()) {
				i.updateQuality();
				if (i.getSellIn() < 0) {
					i.updateQuality();
				}
			}
			i.validateQuality(); // after the update, re check and update the quality									
			System.out.println(i);
		}
	}

	/**
	 * splits the input line to get item name, sellin value and quality
	 * @param line e-g Backstage passes 4 10
	 * @return itemParam e-g {"Backstage passes","4","10"}
	 */
	private String[] parseLine(String line) {
		String words[] = line.split(" ");
		String itemParam[] = new String[3];
		String product = "";
		if (words.length >= 3) {
			for (int i = 0; i <= words.length - 3; i++) {
				if (product.equals("")) {
					product = words[i];
				} else {
					product = product + " " + words[i];
				}
			}
			itemParam[0] = product;
			itemParam[1] = words[words.length - 2];
			itemParam[2] = words[words.length - 1];
		} else {
			itemParam = null;
		}
		return itemParam;
	}

	/**
	 * Generates the Item object from the given item parameter array
	 * @param itemParam e-g {"Backstage passes","4","10"}
	 * @return Item e-g PassItem with itemName="Backstage passes", sellIn=4, quality=10 
	 */
	private Item generateItem(String[] itemParam) {
		Item i = null;
		if (itemParam != null) {
			String itemName = itemParam[0];
			try {
				int sellIn = Integer.parseInt(itemParam[1]);
				int quality = Integer.parseInt(itemParam[2]);
				i = ItemFactory.getItemObject(itemName, sellIn, quality);
			} catch (NumberFormatException ne) {				
				System.out.println("Invalid sell in (or) quality has been given");
			}
		}
		return i;
	}
}
