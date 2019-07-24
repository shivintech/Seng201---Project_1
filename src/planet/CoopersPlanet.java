package planet;

import items.Items;

/**
 * 
 * One of the planets that selected crew members can travel.
 *
 */
public class CoopersPlanet extends Planet{
	/**
	 * 
	 * @param item is an object of class Items. 
	 * CoopersPlanet is a subclass of type Planet, inherits attributes such as planetName, distance, hasItemStatus, item, hasSpaceShipStatus.  
	 */
	public CoopersPlanet(Items item) {
		super("Cooper's Planet", 250, false, item,false);
	}

}
