package com.gildedrose.app.domain;

public class PassItem extends Item{

	public PassItem(String itemName, int sellIn, int quality) {
		super(itemName, sellIn, quality);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void updateQuality(){
		int quality= this.getQuality();
		int sellIn=this.getSellIn();
		if(sellIn>5 && sellIn<=10){
			quality=quality+2;
		} else if(sellIn<=5 && sellIn>0){
			quality=quality+3;
		} else if(sellIn<=0){
			quality =0;
		}
		this.setQuality(quality);
	}

}
