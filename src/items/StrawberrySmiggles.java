package items;
/**
 * StrawberrySmiggles is an object of NeutrinoBombs medicine type, which costs 30 dollars and decreases hunger by 25 points
 *
 */
public class StrawberrySmiggles extends FoodItems{ 
	
	/**
	 * 
	 * @param  quantity StrawberrySmiggles is an attribute of Items/Food, used in the constructor.
	 */
	
	public StrawberrySmiggles(int quantity) { 
		super("Strawberry Smiggles", quantity, 30, 25);
	}

}
