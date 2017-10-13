package com.gildedrose.app.service;


/**  
 * @author subala
 *
 *Main class for GildedRose Application
 *
 */
public class Main {
	public static void main(String a[]){
		// alternate means of running this method is to uncomment the line below and assign a valid file path
		//String input[] = {"D:/input.txt"};	a=input;	
		InventoryManager manager=new InventoryManager();		
		if(a.length>0){
			manager.loadItems(a[0]);
			manager.updateInventory();
		} else {
			System.out.println("Please specify the file name as argument");
		}
	}

}
