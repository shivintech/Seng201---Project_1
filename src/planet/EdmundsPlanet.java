package planet;

import items.Items;
/**
 * 
 * One of the planets that selected crew members can travel.
 *
 */

public class EdmundsPlanet extends Planet {
	
	/**
	 * 
	 * @param item is an object of class Items. 
	 * EdmundsPlanet is a subclass of type Planet, inherits attributes such as planetName, distance, hasItemStatus, item, hasSpaceShipStatus.  
	 */
	public EdmundsPlanet(Items item) {
		super("Edmund's Planet", 200, false, item,false);
	}
}
