package items;

import units.CrewMember;
/**
 * The super class of all the food types available in the game. 
 *
 */
public class FoodItems extends Items{
	
	/**
	 *  name of the food item
	 */
	private String name;
	/**
	 * nutrition value of the food item
	 */
	private int nutrients;
	
	public FoodItems() { 
		super();
		name = "";
		nutrients = 0;
	}
	public FoodItems(String foodName, int foodQuantity, int foodPrice, int nutritionValue) {
		super(foodQuantity, foodPrice);
		nutrients = nutritionValue;
		name = foodName;
	}
	/**
	 * this method is called when a crew member consumes a food item, reduces the hunger of the crew member.  
	 * @param member is the crew member that consumes the food item
	 * @param nutritionAmount is the amount by which the hunger of the crew member reduces.
	 */
	public void increaseNutrition(CrewMember member, int nutritionAmount) {
		member.setHunger(nutritionAmount);
	}
    /**
     * method to test equality of food items by comparing the nutrition value and the name of the food item.  
     * @param otherFood is the food item object that is used for the comparison. 
     * @return 
     */
	public boolean isEqual(FoodItems otherFood) { //This method is checking the equality of the medicine by checking its healing power and the name.
		if (otherFood.getNutrients() == this.getNutrients() && this.getName().equals(otherFood.getName())) {
			return true;
		} else return false;
	}
	/** 
	 * Returns the name of the food item.
	 */
	
	public String getName() {
		return name;
	}
	/** 
	 * setter method for name attribute.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/** 
	 * Returns the level of nutrients the in a food item.
	 * @return the level of nutrients in a food item 
	 */
	public int getNutrients() {
		return nutrients;
	}
	/** 
	 * Sets the lebvel of nutrients for a food item.
	 * @param nutrients
	 */
	public void setNutrients(int nutrients ) {
		this.nutrients = nutrients;
	}
	/**
	 * this method is called when the Food Item object is printed.
	 */
	public String toString() {
		return String.format("%s,  %s", this.getName(), this.getQuantity());
	}
	
}

	
	
	
