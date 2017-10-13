package com.gildedrose.app.service;


/**  
 * @author subala
 *
 *Main class for GildedRose Application
 *
 */
public class Main {
	public static void main(String a[]){
		InventoryManager manager=new InventoryManager();		
		if(a.length>0){
			manager.loadItems(a[0]);
			manager.updateInventory();
		} else {
			System.out.println("Please specify the file name as argument");
		}
	}

}
