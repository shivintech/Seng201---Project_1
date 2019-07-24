package items;
/**
 *  Popplers is an object of NeutrinoBombs medicine type, which costs 25 dollars and decreases hunger by 20 points
 *
 */
public class Popplers extends FoodItems{
	
	/**
	 *
	 * @param  quantity Popplers is an attribute of Items/Food, used in the constructor.
	 */
	
	public Popplers(int quantity) { 
		super("Popplers", quantity, 25, 20);
	}

}
