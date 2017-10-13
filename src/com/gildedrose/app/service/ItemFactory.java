package com.gildedrose.app.service;

import com.gildedrose.app.domain.CheeseItem;
import com.gildedrose.app.domain.ConjuredItem;
import com.gildedrose.app.domain.Item;
import com.gildedrose.app.domain.LegendaryItem;
import com.gildedrose.app.domain.PassItem;

/**
 * Factory class for getting Item Object
 * @author subala
 *
 */

public class ItemFactory {
	
	public static Item getItemObject(String itemName,int sellIn, int quality){
		Item itemObject;
		if(itemName.equals("Aged Brie")){
			itemObject = new CheeseItem(itemName,sellIn,quality);
		} else if(itemName.equals("Backstage passes")){
			itemObject = new PassItem(itemName,sellIn,quality);
		} else if(itemName.equals("Sulfuras SellIn")){
			itemObject = new LegendaryItem(itemName,sellIn,quality);
		} else if(itemName.equals("Normal Item")){
			itemObject = new Item(itemName,sellIn,quality);
		} else if(itemName.equals("Conjured")){
			itemObject = new ConjuredItem(itemName,sellIn,quality);
		} else {
			itemObject = new Item("NO SUCH ITEM");
		}			
		return itemObject;
		
	}

}
