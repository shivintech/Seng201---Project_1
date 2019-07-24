package planet;

import items.Items;

/** 
 * 
 * One of the planets that selected crew members can travel.
 *
 */
public class MillerPlanet extends Planet{
	
	/**
	 * 
	 * @param item is an object of class Items. 
	 * MillerPlanet is a subclass of type Planet, inherits attributes such as planetName, distance, hasItemStatus, item, hasSpaceShipStatus.  
	 */
	public MillerPlanet(Items item) {
		super("Miller's Planet", 50, false, item,false);
	}

}
