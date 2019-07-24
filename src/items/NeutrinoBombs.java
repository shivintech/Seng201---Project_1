package items;
/**
 * NeutrinoBombs is an object of NeutrinoBombs medicine type, which costs 100 dollars and decreases hunger by 70 points.
 *
 */
public class NeutrinoBombs extends FoodItems{
	
	/**
	 * @param  quantity NeutrinoBombs is an attribute of Items/Food, used in the constructor.
	 */
	
	public NeutrinoBombs(int quantity)  { 
		super("Neutrino Bombs", quantity, 100, 70);
	}
}