package com.gildedrose.app.domain;


public class CheeseItem extends Item {

	public CheeseItem(String itemName, int sellIn, int quality) {
		super(itemName, sellIn, quality);		
	}
	@Override
	public void updateQuality(){	
		// "Aged Brie" actually increases in Quality the older it gets
		int quality=this.getQuality()+1;
		this.setQuality(quality);				
	}

}
