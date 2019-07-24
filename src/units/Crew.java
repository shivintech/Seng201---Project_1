package units;
import java.util.ArrayList;

import items.FoodItems;
import items.Medicine;
import planet.Planet;
/**
 * The class dedicated to the Crew of the game.
 *
 */
public class Crew {
	/**
	 * The name of the crew.
	 */
    private String name;
    /**
     * The name of the ship.
     */
    private String shipName;
    /**
     * The list of medicines the crew has available to them. 
     */
    private ArrayList<Medicine> medicineList = new ArrayList<>();
    /**
     * The list of food items the crew has available.  
     */
    private ArrayList<FoodItems> foodList = new ArrayList<FoodItems>();
    /**
     * The list of Crew Members that are part of the crew.
     */
    private ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
    /**
     * The current position of the Crew. 
     */
    private String position;
    /**
     * The money the crew has available to them. 
     */
    private int money;
    /**
     * boolean attribute that says if the crew is of valid size.
     */
    private boolean check;
    /**
     * The number of parts that the crew finds as the play the game.
     */
    private int numberOfpartsFound;
    /**
     * The current position of the crew.
     */
    private Planet planetPositiion;
    /**
     * stealMoney method is called only when a particular CrewMember searches a planet he/she is on currently and they happen to find money.   
     * @param cash amount of money increased
     */
    
    public void stealMoney(int cash) { 
    	money+=cash;
    }
    /**
     * returns the number of parts the crew has found so far.
     * @return getter method for attribute numberOfPartsFound
     */
    public int getNumberOfpartsFound() {
		return numberOfpartsFound;
	}
    /**
     * Setter method for attribute numberOfpartsFound.
     */
	public void setNumberOfpartsFound(int numberOfpartsFound) {
		this.numberOfpartsFound = numberOfpartsFound;
	}
	/**
	 * increaseNumberOfPartsFound is only called when a CrewMember searches a planet and finds a space ship part.
	 * @param parts increments the numberOfpartsFound 
	 */
	public void increaseNumberOfpartsFound(int parts) {
		numberOfpartsFound += parts; 
	}
	/**
	 * Crew constructor.
	 * @param crewName attribute of Crew class, names the Crew
	 * @param crewShipname attribute of Crew class, assigns name to a ship
	 * @param planetPosition attribute of Crew, assigns a planetPostion to the Crew
	 */
	public Crew(String crewName, String crewShipname, Planet planetPosition){
        name = crewName;
        shipName = crewShipname;
        money = 1000;
        this.planetPositiion = planetPosition;
        position = planetPosition.getName();
	}
	/**
	 * returns the current position of the Crew
	 * @return getter method for attribute planetPosition
	 */
    public Planet getPlanetPositiion() {
		return planetPositiion;
	}
    /**
     * sets the Position of the Crew to planetPostion
     * @param planetPositiion
     */
	public void setPlanetPositiion(Planet planetPositiion) {
		this.planetPositiion = planetPositiion;
	}
	/**
	 * getter method for attribute medicineList of Crew class.
	 * @return the list of medicine items 
	 */
	public ArrayList<Medicine> getMedicineList() {
		return medicineList;
	}
	/**
	 * setter method for attribute medicineList of Crew class.
	 * @param medicineList
	 */
	public void setMedicineList(ArrayList<Medicine> medicineList) {
		this.medicineList = medicineList;
	}
	/**
	 * getter method for attribute FoodList of Crew class. 
	 * @return the list of food items 
	 */
	public ArrayList<FoodItems> getFoodList() {
		return foodList;
	}
	/**
	 * setter method for attribute FoodList of Crew class.
	 * @param foodList
	 */
	public void setFoodList(ArrayList<FoodItems> foodList) {
		this.foodList = foodList;
	}
	/**
	 * getter method for attribute position of Crew class  
	 * @return the current position of the crew
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * setter method of attribute position of Crew class. 
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * getter method for attribute name of Crew class.
	 * @return the name of the crew member as set by the player
	 */
	public String getName(){ 
        return name;

    }
    /**
     * getter method for attribute shipName of Crew class. 
     * @return
     */
    public String getshipName() { 
    	return shipName;
    }
    /**
     * Returns the length of the crew list.
     * @return length of the crewList attribute of Crew class. 
     */
    public int getcrewListlength() {
    	return crewList.size();
    }
    /**
     *  Returns length of the medicineList attribute of Crew class 
     * @return length of the medicineList attribute of Crew class 
     */
    public int getmedicineListlength() {
    	return medicineList.size();
    }
   
    /**
     * Returns CrewMember object from the crewList at a particular index/position.
     * @param index
     * @return CrewMember object from the crewList at a particular index/position.
     */
    public CrewMember getCrewMember(int index) {
		return crewList.get(index);
	}

	/**
	 * setter method for crewList attribute of Crew class.
	 * @param crewList
	 */
    public void setCrewList(ArrayList<CrewMember> crewList) {
		this.crewList = crewList;
	}


	/**
	 * gets a medicine when name is passed as an argument.	
	 * @param name
	 * @return medicine object from the medicineList when a medicine name is passed as a parameter.
	 */
    public Medicine getMedicine(String name) {
		for (Medicine medicine: medicineList) {
			if (medicine.getName().equals(name)) {
				return medicine;
			}
		}
		return null;
	}
	/**
	 * removes a Medicine object from the medicineList at a specific index  
	 * @param index
	 */
    public void removeMedicine(int index) {
		 medicineList.remove(index);
	}
    /**
     * returns the length of the food inventory of the crew.
     * @return the length of the foodList attribute of the Crew class.
     */
    public int getFoodListLength() {
    	return foodList.size();
    }
    /**
     * removes a FoodItem object from the foodList at a specific index. 
     * @param index
     */
    public void removeFoodItem(int index) {
    	foodList.remove(index);
    }
    
    /**
     * gets a food item from the inventory at an index when the index is passed as an argument. 
     * @param index
     * @return foodItem from the foodList at a specific index.
     */
    public FoodItems getFooditem(int index) {
		return foodList.get(index);
    }
	/**
	 * 
	 * gets a food item from the inventory when the food name is passed as an argument.
	 * @param name
	 * @return a FoodItem from the foodList after passing a particular food name as a parameter 
	 */
    public FoodItems getFoodItem(String name){
		for (FoodItems food: foodList) {
			if (food.getName().equals(name)) {
				return food;
		}
	}
	return null;}	

    /**
     * gets the list of crew members that form the crew 
     * @return crewList attribute of Crew class.
     */
    public ArrayList<CrewMember> getCrewList() {
		return crewList;
	}
	
    /**
	 * addingMeds is usually called when a Medicine is purchased from SpaceOutpost.
	 * adds a Medicine and updates its quantity in the  medicineList if it is present
	 * adds the Medicine and its respective quantity if not present in the medicineList.  
	 * @param newMeds
	 * @param quantity
	 */
    
    public void addingMeds(Medicine newMeds, int quantity) { 

    	boolean bool = false;
    	for (Medicine med:medicineList) {
    		if(med.isEqual(newMeds)) { 
    			bool = true;
    			med.increaseStockLevel(quantity);
    		}
    	}
    	if (bool == false) {
    		newMeds.setQuantity(quantity);
    		medicineList.add(newMeds);
    	}
    
    }
    
    /**
     * removingMeds is usually called when a Medicine is consumed from the CrewMember or when the Alien Pirates raid the ship and steal a Medicine item
     * 
     * @param oldMeds
     * @param quantity
     */
    
    public void removingMeds(Medicine oldMeds, int quantity) {

    	boolean bool = false;
    	for(int i=0; i <medicineList.size(); i++) {
    		Medicine med = medicineList.get(i);
    		if(med.isEqual(oldMeds)) {
    			bool = true;
    			med.decreaseStockLevel(quantity);
    			if(med.getQuantity() == 0) {
    				medicineList.remove(med);
    				}
    			}
    	}
    }
    
    /**
     *  usually called when crew purchases food from the space outpost
     *  or when a crew searches a planet
     *  adds a the FoodItem object newFood to the foodList, if not already in foodList
     *  updates the quantity of the foodItem in the foodList if already present in the foodList.
     * @param newFood
     * @param quantity
     */
    public void addingFood(FoodItems newFood, int quantity) {
    	boolean bool = false;
    	for (FoodItems food:foodList) {
    		if(food.isEqual(newFood)) { 
    			bool = true;
    			food.increaseStockLevel(quantity);
    		}
    	}
    	if (bool == false) {
    		newFood.setQuantity(quantity);
    		foodList.add(newFood);
    	}
    }   
    
    /**
     * usually called when CrewMember consumes a foodItem or when AliePirates raid the ship and steal a random FoodItem in the foodList. 
     * @param oldFood
     * @param quantity
     */
    public void removingFood(FoodItems oldFood, int quantity) {
    	boolean bool = false;
    	for(int i=0; i <foodList.size(); i++) {
    		FoodItems food = foodList.get(i);
    		if(food.isEqual(oldFood)) {
    			bool = true;
    			food.decreaseStockLevel(quantity);
	    		if(food.getQuantity() == 0) {
	    			foodList.remove(food);
	    			}
    		}
    	}
    	
    }
	/**
	 * setter method for attribute shipName of Crew class.
	 * @param shipName
	 */
    public void setShipName(String shipName) {
		this.shipName = shipName;
	}
    	
    /**
     * removes a CrewMember at a particular index from the crewList.
     * @param index
     */
    public void removeCrewMember(int index) {
    	crewList.remove(index);
    }
    
    /**
     * adds a CrewMember member to the CrewList. 
     * @param member
     */
    public void addCrewMember(CrewMember member){ 
    	crewList.add(member);
    }
    /**
     * checks of the crew is of valid size, i.e between 2 and 4 crew members.
     * @return valid crewList size.
     */
    public boolean checkSizecrewList() { 
    	if (crewList.size() < 4) { 
    		check = true;
    	
    	}
    	else {
    		check = false;
    	}
    	return check;
    }
    

    
    /**
     * spendMoney called when Crew purchases item from Space Outpost 
     * @param price
     */
	public void spendMoney(int price) {
		if (money >= price) {
			money -= price;
		}
	}
	
	/**
	 * gets the money that the crew currently has available to them.  
	 * @return the current amount of money that the crew holds
	 */
	public int getMoney() {
		return money;
	}

}








