package items;
/**
 * The super class to all the food, medicine, money and spaceship parts in the game. 
 *
 */
public class Items {
	
	private int quantity;
	private int price;
	
	public Items() {
		quantity = 0;
		price =0;
	}
	/**
	 * Return the quantity of items
	 * @return the quantity of items
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Set quantity of the items 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * Return the name of the items
	 * @return the name of the items
	 */
	public String getName() {
		return "";
	}
	/**
	 * Return the price of the item 
	 * @return the price of the item 
	 */

	public int getPrice() {
		return price;
	}
	/**
	 * set the price of the item
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * Initializes the price and quantity of the item
	 * @param quantityOfItems
	 * @param priceOfItems
	 */
	public Items(int quantityOfItems, int priceOfItems) {
		quantity = quantityOfItems;
		price = priceOfItems;
	}
	/**
	 * Increases the stock level of an item already present in the foodList or medicineList.
	 * called when the crew buys a food item from the space outpost.
	 * @param increment is the quantity by which the stock level of the item increases. 
	 */
	public void increaseStockLevel(int increment) {
		quantity += increment;
	}
	/**
	 * Decreases the stock level of the item present in the foodList or medicineList. 
	 * Called when a crew member consumes a food item or medicine from foodList or medicineList 
	 * @param decrement the quantity by which the stock level increases. 
	 */
	public void decreaseStockLevel(int decrement) {
		if (quantity >= decrement) {
			quantity -= decrement;
		} 
	}
}
