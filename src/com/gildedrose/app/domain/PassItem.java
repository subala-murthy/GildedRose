package com.gildedrose.app.domain;

public class PassItem extends Item{

	public PassItem(String itemName, int sellIn, int quality) {
		super(itemName, sellIn, quality);		
	}
	
	@Override
	public void updateQuality(){
		int quality= this.getQuality();
		int sellIn=this.getSellIn();
		if(sellIn>5 && sellIn<=10){
			quality=quality+2; // quality increases by 2 when there are 10 days or less
		} else if(sellIn<=5 && sellIn>0){
			quality=quality+3;//quality increases by 3 when there are 5 days or less
		} else if(sellIn<=0){
			quality =0; // quality drops to 0 after the concert
		}
		this.setQuality(quality);
	}

}
