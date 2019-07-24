package planet;

import items.Items;

/** 
 * 
 * Planet class that creates a different planet object 
 *
 */

public class Planet {
	
	/** 
	 * Name of planet 
	 */
	private String Name;
	/** 
	 * Distance of the planet from the source planet 
	 */
	private int Distance;
	/** 
	 * Boolean if True, means planet has an item on it 
	 */
	private boolean hasItem;
	/** 
	 *  Item is an object of class Item
	 */
	private Items item;
	
	/** 
	 * Boolean True, when a Planet has a part.
	 */
	private boolean part;
	
	/**
	 * 
	 * @param name of the planet 
	 * @param distance  
	 * @param HasItem boolean is True, when planet has an item(food/money/medicine). 
	 * @param item is an object of class Item
	 * @param part boolean is True, when Planet has a ship part
	 */
	public Planet(String name, int distance, boolean HasItem, Items item, boolean part) {
		Name = name;
		Distance = distance;
		HasItem = hasItem; 
		this.item = item;
		this.part = part;
	}
	/**
	 * Returns the name of the planet.
	 * @return the name of the Planet
	 */
	public String getName() {
		return Name;
	}
	/**
	 * Returns the distance of the planet from Source planet 
	 * @return the distance of the planet from Source planet 
	 */
	public int getDistance() {
		return Distance;
	}
	/**
	 * Returns the boolean depending upon the Item status of the part 
	 * @return the boolean depending upon the Item status of the part 
	 */
	public boolean gethasItemStatus() {
		return hasItem;
	}
	/**
	 * Sets the boolean status True if there is an item on the planet
	 * @param status 
	 * @param i
	 */
	public void sethasItemStatus(boolean status, Items i) {
		hasItem = status; 
		setItem(i);
	}
	/**
	 * Returns the random food items
	 * @return a random item 
	 */
	public Items getItem() {
		return item;
	}
	/**
	 * Sets an item that will be found if searched
	 * @param i 
	 */
	public void setItem(Items i) {
		item = i;
	}
	/**
	 * Returns the part if the status was set true 
	 * @return the part if the status was set true 
	 */
	
	public boolean hasPart() { 
		return part;
	}
	/**
	 * Sets part to True if planet has a part 
	 */
	public void setPartStatus() {
		this.part = true;
	}
	/**
	 * This method checks the equality of the planets
	 * @param planet 
	 * @return boolean if the source planet is same as the destination planet.
	 */
	public boolean isEqual(Planet planet) {
		if (planet.getName().equals(this.getName()) && planet.getDistance() == this.getDistance()) {
			return true;
		}
		else {
			return false;
		}
	}
}




