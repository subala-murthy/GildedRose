package com.gildedrose.app.domain;

public class ConjuredItem extends Item {

	
	public ConjuredItem(String itemName, int sellIn, int quality) {
		super(itemName, sellIn, quality);		
	}

	@Override
	public void updateQuality(){
		//twice as normal item
		super.updateQuality();
		super.updateQuality();
		
	}

}
