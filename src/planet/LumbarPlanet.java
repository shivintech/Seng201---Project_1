package planet;

import items.Items;

/**
 * 
 * One of the planets that selected crew members can travel.
 *
 */

public class LumbarPlanet extends Planet{
	/**
	 * 
	 * @param item is an object of class Items. 
	 * LumbarPlanet is a subclass of type Planet, inherits attributes such as planetName, distance, hasItemStatus, item, hasSpaceShipStatus.  
	 */
	public LumbarPlanet(Items item) {
		super("Lumbar Planet", 150, false, item,false);
	}
}
