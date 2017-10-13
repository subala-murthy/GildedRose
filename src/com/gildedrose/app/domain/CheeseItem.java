package com.gildedrose.app.domain;

public class CheeseItem extends Item {

	public CheeseItem(String itemName, int sellIn, int quality) {
		super(itemName, sellIn, quality);		
	}
	@Override
	public void updateQuality(){		
		int quality=this.getQuality()+1;
		this.setQuality(quality);				
	}

}
