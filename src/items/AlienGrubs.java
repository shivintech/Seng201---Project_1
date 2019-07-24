package items;
/**
 * AlienGrubs is an object of food type Alien Grubs which costs 60 dollars and reduces hunger by 45 points.
 * 
 *
 */
public class AlienGrubs extends FoodItems{
	/**
	 
	 * @param quantity attribute of class Items/FoodItems.  
	 */
	public AlienGrubs(int quantity) { 
		super("Alien Grubs", quantity, 60, 45);
	}

}
