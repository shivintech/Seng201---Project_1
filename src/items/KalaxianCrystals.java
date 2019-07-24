package items;
/**
 * KalaxianCrystals is an object of CalceraPhos400 medicine type, which costs 50 dollars and decreases hunger by 40 points
 *
 */
public class KalaxianCrystals extends FoodItems{
	
	/**
	 * 
	 * @param quantity assigns quantity to a KalaxianCrystal object
	 */
	
	public KalaxianCrystals(int quantity)  { 
		super("Kalaxian Crystals", quantity, 50, 40);
	}


}
