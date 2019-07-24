package planet;

import items.Items;

/** 
 * 
 * One of the planets that selected crew members can travel.
 *
 */
public class Osiris extends Planet{
	
	/**
	 * 
	 * @param item is an object of class Items. 
	 * Osiris is a subclass of type Planet, inherits attributes such as planetName, distance, hasItemStatus, item, hasSpaceShipStatus.  
	 */
	public Osiris(Items item) {
		super("Osiris", 150, false, item,false);
	}
}
