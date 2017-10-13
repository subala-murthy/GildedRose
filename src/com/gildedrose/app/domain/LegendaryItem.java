package com.gildedrose.app.domain;

public class LegendaryItem extends Item{
	public LegendaryItem(String itemName, int sellIn, int quality) {
		super(itemName, sellIn, quality);		
	}
	@Override
	public void updateQuality(){
		//do not update anything
	}
	@Override
	public void updateSellIn(){
		//do not update anything
	}

}
