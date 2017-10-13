package com.gildedrose.app.domain;
/**
 * 
 * @author subala
 * Baseclass for all the items
 * 
 */
public class Item {
	private String itemName;
	private int sellIn;
	private int quality;
	/*Quality can never be negative and should not exceed 50 */
	public static final int MIN_QUALITY=0;
	public static final int MAX_QUALITY=50;
	
	public Item(String itemName){
		this.itemName=itemName;
	}
	
	public Item(String itemName, int sellIn, int quality){
		this.itemName = itemName;
		this.sellIn = sellIn;
		this.quality = quality;
	}
	/* getter methods */
	public String getItemName() {
		return itemName;
	}	
	public int getSellIn() {
		return sellIn;
	}	
	public int getQuality() {
		return quality;
	}
	/* setter method */
	public void setQuality(int quality) {
		this.quality = quality;
	}
	
	@Override
	public String toString(){ 
		if(this.getItemName().equals("NO SUCH ITEM"))
			return this.getItemName(); // Invalid items doesnt get printed with their sellin and quality values
		
		return this.getItemName()+" "+this.getSellIn()+" "+this.getQuality();
		
	}
	/** validates the quality for the minimum and maximum constraints
	 * returns true if the quality given is valid so that it 
	 * can be updated further
	 * returns false when the quality is invalid and updated to valid quality
	 * so that it need not be updated further
	 * 
	 * @return result
	 */
	public boolean validateQuality(){
		boolean result = false;
		if(quality<MIN_QUALITY){
			quality = MIN_QUALITY;			
		} else if(quality>MAX_QUALITY){
			quality = MAX_QUALITY;
		} else {
			result = true;
		}			
		return result;
	}
	
	/**
	 * base method that decreases the quality by 1
	 */
	public void updateQuality(){
		quality = quality-1;
	}
	/**
	 * base method that decreases the sell In value by 1
	 */
	public void updateSellIn(){
		sellIn = sellIn-1;
	}
	
	

}
