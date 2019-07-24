package units;
import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import gameengine.RandomEvents;
import items.CalceraPhos400;
import items.FoodItems;
import items.Items;
import items.Medicine;
import items.Money;
import items.NZT48;
import items.R89;
import items.SpaceshipPart;
import planet.Planet;
import sound.Sound;
import spaceship.SpaceShip;

import javax.swing.*;
/**
 * The super class dedicated to the different CrewMember types.
 * @author sga113
 *
 */
public class CrewMember{
	
	/**
	 * The name of the crew member.
	 */
	private String name;
    
	/**
	 * Health of the crew member.
	 */
	public int health;
    
	/**
	 * Hunger level of the crew member.
	 */
	private int hunger;
    
    /**
     * Tiredness level of the crew member.
     */
    private int tiredness;
    /**
     * A new crew object is created.
     */
    private Crew crew;
    /**
     * attribute that checks space plague status of the Crew member. 
     */
    private boolean hasSpacePlague;
    /**
     * the number of actions of each crew member
     */
    private int numberOfActions;
    /**
     * the type of each crew member.
     */
    private String type;
    /**
     * a string that specifies the special power of the crew member.
     */
    private String power;
	/**
	 * Constructor for CrewMember
	 * @param crew The object of Crew called crew.
	 */
	 public CrewMember(Crew crew){
		 	name = "";
		 	this.crew = crew;
		 	health = 100;
		 	tiredness = 0;
		 	hunger = 0;
		 	hasSpacePlague = false;
		 	numberOfActions = 2;

	 }
	 /**
	  * getter method for power attribute.
	  * @return the special power of the crew member.
	  */
	    
	 public String getPower() {
		return power;
	}
	 /**
	  * setter method for power attribute.
	  * @param power takes a String as an input parameter.
	  */
	public void setPower(String power) {
		this.power = power;
	}

		public CrewMember(String crewMemberName, int crewMemberHealth, int crewHunger, int crewTiredness, Crew crew, boolean spacePlague, String type, String power){
	        this.crew = crew;
	    	name = crewMemberName;
	        health = crewMemberHealth;
	        hunger = crewHunger;
	        tiredness = crewTiredness;
	        hasSpacePlague = spacePlague;
	        numberOfActions = 2;
	        this.type = type;
	        this.power = power;
	    }
	    /**Returns the name of the crew member
	     * @return the name of the crew member
	     */
	
	  public String getName() { 
	        return name;

	    }
	  /**
	   * Returns the health status of a particular crew member
	   * @return the health of the crew member.
	   */

	    public int getHealth() {
	        return health;
	    }
	    /**
	     * setter method for health attribute.
	     * @param healthLevel takes an integer value as a parameter.
	     */
	    public void setHealth(int healthLevel) { 
	    	health = healthLevel;
	    }
	    /**
	     * increases health of the crew member, it is called when a medicine is consumed.
	     * @param healthLevel
	     */
	    public void increaseHealth(int healthLevel) {
	    	if (health+healthLevel>100) {
	    		health = 100;
	    	}
	    	health += healthLevel;
	    }
	    /**
	     * decreases health of the crew member.
	     * called when the member is affected by space plague. 
	     * @param amount integer parameter which decreases health by specific amount
	     */
	    public void decreaseHealth(int amount) { 
	    	if(health >= amount) {
	    		health -= amount;
	    		
	    	}
	    	else {
	    	health = 0;
	    }
	    }
	    /**
	     * getter method for hunger attribute, which returns the hunger level of the crew member.
	     * @return the hunger level of the crew member.
	     */

	    public int getHunger() { 
	        return hunger;
	    }
	    /**
	     * called when the repair/search method is called.
	     * @param level by which the hunger of the crew member increases
	     */
	    public void increaseHunger(int level) {
	    	hunger +=level;
	    	if (hunger>100){
	    		hunger = 100;
	    	}
	    }
	    /**
	     * called when the crew member consumes a food item (when the eat method is called).	
	     * @param level reduces the hunger of the crew member by specific level. 
	     */
	    public void setHunger(int level) {
	    		hunger -= level;
	    		if(hunger < 0) {
	    			hunger = 0;
	    		}
	    	
	    }
	    /**
	     * Returns the level of tiredness of the crew member.
	     * @return the level of tiredness of the crew member.
	     */

	    public int getTiredness() { 
	        return tiredness;
	    }
	    /**
	     * 
	     * @param amount by which the tiredness is decreased if CalceraPhos400 medicine is taken.
	     * @return The updated level of tiredness.
	     */
	    
	    /**
	     * setter method for tiredness attribute.
	     * @param amount 
	     */
	    public void setTiredness(int amount) { 
	    	if (tiredness < 0) {
	    		tiredness = 0;
	    	}
	    	else {
	    		tiredness = amount;
	    	}
	    }
	    /**
	     * increases the tiredness of the crew member by a specific amount.
	     * called when repair or search is called.  
	     * @param amount
	     */
	    public void increaseTiredness(int amount) {
	    	tiredness += amount;
	    	if (tiredness >100) {
	    		tiredness = 100;
	    	}
	    }
	   /**
	    * getter method for crew object attribute.
	    * @return crew object.
	    */
	    public Crew getCrew() {
			return crew;
		}
	    /**
	     * setter method for crew attribute.
	     * @param crew 
	     */
		public void setCrew(Crew crew) {
			this.crew = crew;
		}

		/**
	     * Returns the boolean hasSpcePlague and if true means the crew member is infected else false.
	     * @return the boolean hasSpcePlague and if true means the crew member is infected else false.
	     */
	    
	    public boolean getSpacePlagueStatus() {
	    	return hasSpacePlague;
	    }
	    /**
	     * Sets the status which is boolean and sets the variable hasSpacePlague equal to the status.
	     * @param status which is boolean and sets the variable hasSpacePlague equal to the status.
	     */
	    public void setSpacePlagueStatus(boolean status) { 
	    	hasSpacePlague = status;
	    }
	    /**
	     * this method is called when a crew member object is printed. 
	     * This method type cast's the integer values to string which enables them to get displayed on the label.
	     */
	    public String toString() {
	    	String newString= "";
	    	if (this instanceof Human) { 
	    		newString = String.format("<html>Name: %s <br> Type: Human <br> Health: %s <br> Special Power: The best pilot on board", this.getName(), this.getHealth());
	    	}
	    	else if (this instanceof Martian) {
	    		newString = String.format("<html>Name: %s <br> Type: Martian <br> Health: %s <br> Special Power: He gets double amount of nutrition when he eats", this.getName(), this.getHealth());
	    	}
	    	else if (this instanceof Medic) {
	    		newString = String.format("<html>Name: %s <br> Type: Medic <br> Health: %s <br> Special Power: She takes half the damage when hit by Space Plague", this.getName(), this.getHealth());
	    	}
	    	else if (this instanceof Transformer) {
	    		newString = String.format("<html>Name: %s <br> Type: Transformer <br> Health: %s <br> Special Power: The best and the fastest engineer on board", this.getName(), this.getHealth());
	    	}
	    	else if (this instanceof StarLord) {
	    		newString = String.format("<html>Name: %s <br> Type: Star Lord <br> Health: %s <br> Special Power:I don't need sleep as I never get tired.", this.getName(), this.getHealth());
	    	}
	    	else if (this instanceof Nebula) {
	    		newString = String.format("<html>Name: %s <br> Type: Nebula <br> Health: %s <br> Special Power: She is immune to Space Plague", this.getName(), this.getHealth());
	    	}
	    	return newString;
	    }
	    
	    /**
	     * getter method for type attribute
	     * @return the type of the crew member.
	     */
	    public String getType() {
			return type;
		}


	    /**
	     * decreases hunger of the crew member when a certain food is consumed.
	     * decreases stock of the particular food item when it is consumed. 
	     * @param food of type FoodItems
	     * @param quantity
	     */
	    public void eat(FoodItems food, int quantity) { 
	    	
	    	for(int i=0; i<crew.getFoodListLength(); i++) {
	    		FoodItems foodItem = crew.getFooditem(i);
	    		if (foodItem.isEqual(food) && foodItem.getQuantity() >= quantity) {
	    			if ((this instanceof Martian)) {
	    				if (hunger >= 2* food.getNutrients()*quantity) {
		    	    		hunger -= 2 * food.getNutrients()*quantity;
		    			}
		    	    	else {
		    	    		hunger = 0;
		    	    	}
	    			}
	    			else {
	    				if (hunger >= food.getNutrients()*quantity) {
		    	    		hunger -= food.getNutrients()*quantity;
		    			}
		    	    	else {
		    	    		hunger = 0;
		    	    	}
	    			}
	    			crew.removingFood(foodItem, quantity);
	    			this.numberOfActions -= 1;
	    		}
	    		
	    	}
	    	
	    }
	    /** 
	     * Displays the J option pane if a crew member finds something.
	     * @param item that was found 
	     * @param size the quantity of the item 
	     */
	   
	    public void showTheMessage(String item, int size) {
	    	JOptionPane.showMessageDialog(null,String.format("You just found %s %s", size, item));
	    }
	    /**
	     * changes the position of the crew from the source to the destination
	     * @param source the current planet position of the crew.
	     * @param destination the planet that the crew travels to, the planet position of the crew gets updated to destination.
	     * @param member co-pilot of the main pilot of the ship
	     * @param random RandomEvents object that calls random events like asteroid belt.
	     * Rocket Launch Sound - http://soundbible.com/1498-Rocket.html
	     */
	    public void pilotShip(Planet source, Planet destination, CrewMember member, RandomEvents random) {
	    	if (this.numberOfActions < 1 && member.numberOfActions <1) {
	    		throw new IllegalStateException("Both dont have enough actions");
	    	}
	    	if (this.numberOfActions < 1 ) {
	    		throw new IllegalStateException(this.getName() + " dont have enough actions");
	    	}
	    	else if(member.numberOfActions <1) {
	    		throw new IllegalStateException(member.getName() + " does not have enough actions");
	    	}
	    	if (!(source.isEqual(destination))){
	    		
	    		try {
			    	InputStream wavFile = Sound.class.getResourceAsStream("/image/launchw.wav");
			    	InputStream bufferedIn = new BufferedInputStream(wavFile);
			    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
			    	
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioStream);
			        clip.start();
				
			    	
				} catch(Exception ee){ee.printStackTrace();}
	    		
	    		
	    	crew.setPosition(destination.getName());
	    	crew.setPlanetPositiion(destination);
	    	this.increaseHunger(10);
	    	member.increaseHunger(10); 
	    	
		    this.numberOfActions-=1;
		    member.numberOfActions-=1;
		    if(!(this instanceof Human || member instanceof Human)) {
		    	random.callAsteroidBelt();
		    }
		    if (!(this instanceof StarLord) && this.tiredness < 80) {
		    		this.tiredness+=10;
		    	}
	    		if (!(member instanceof StarLord) && member.tiredness < 80) {
	    			member.tiredness += 10;
	    			
	    		}
	    		
	    	}
	    }
	    /**
	     * Sets the tiredness level back to zero if this method is called on a crew member.
	     */
	    public void sleep(){  
	        this.numberOfActions -= 1;
	    	tiredness = 0;
	    }
	    /**
	     * If enough medicine on stock then this method enables the crew member to use medicines and improves the crew member's health status.
	     * It also makes sure that the health of the crew member does not go over 100(i.e the max health).
	     * @param oldMeds existing medicines in stock
	     * @param quantity of the medicines being used.
	     */

	    public void usingMeds(Medicine oldMeds, int quantity){
	    	this.numberOfActions -=1;
	    	this.crew.removingMeds(oldMeds, quantity);
	    	if(oldMeds instanceof NZT48) {
	    		((NZT48)oldMeds).healing(this, oldMeds.getHeal()*quantity);
	    		if (this.hasSpacePlague) {
	    		this.hasSpacePlague = false;
	    		JOptionPane.showMessageDialog(new JFrame(),this.getName() + " has been cured of Space Plague");
	    		}
	    		
	    	}
	    	
	    	if(oldMeds instanceof CalceraPhos400) {
	    		((CalceraPhos400) oldMeds).decreaseTiredness(this);
	    		((CalceraPhos400)oldMeds).healing(this, oldMeds.getHeal()*quantity);
	    	}
	    	
	    	if(oldMeds instanceof R89) {
	    		((R89)oldMeds).healing(this, oldMeds.getHeal()*quantity);		
	    	}
	    	
	        if(health >100 && !(this instanceof Medic)) {
	        	health = 100;    
	        }
	        if (health > 200) {
	        	health = 200;
	        }
	    }
        	        		     
	    /**
	     * Repairs the Ship's shield and restores its health 100
	     * @param ship
	     */
	    	
	    public void repair(SpaceShip ship){
	    	if (!(this instanceof Transformer || this instanceof StarLord)) {
	    	this.numberOfActions -= 1;
	    	this.increaseHunger(10);;
	    	this.increaseTiredness(10);;
	    	}
	    	ship.setShieldHealth();
	    	
	    }

	    /**
	     * getter method for numberOfActions attribute.
	     * @return the number of action of the crew member
	     */
	    public int getNumberOfActions() {
			return numberOfActions;
		}
	    /**
	     * method that reduces the number of actions of the crew member.
	     * @param numberOfActions reduces the number of actions by a specific amount.
	     */
		public void setNumberOfActions(int numberOfActions) {
			this.numberOfActions -= numberOfActions;
		}
		/**
		 * this method is called when the next day method is called.
		 * resets the number of action of the crew member to 2 at the start of each day.   
		 */
		public void resetNumberOfActions() {
			this.numberOfActions = 2;
		}
		/**
		 * checks equality of crew members based on the name and the type of the crew member. 
		 * @param member
		 * @return 
		 */
		public boolean isEqual(CrewMember member) {
			if (this.getName().equals(member.getName())) {
				return true;
			}
		return false;
		}
		/**
		 * searches the planet for food, medicine, money, space ship parts.
		 * @param planet is the planet being searched.
		 * @return true if spaceship is found, false when anything else is found or not found.
		 */
		public boolean searchPlanet(Planet planet){
			
			this.numberOfActions-=1;
    		this.increaseHunger(10);
    		if (!(this instanceof StarLord)) {
    		this.increaseTiredness(10);
			
    		if (planet.gethasItemStatus()) {
	    		if (planet.getItem() instanceof FoodItems) {
	    			showTheMessage(planet.getItem().getName(), 1);
	    			crew.addingFood((FoodItems) planet.getItem(), 1);
	    			
	    			planet.sethasItemStatus(false, new Items());
	    		}
	    		else if (planet.getItem() instanceof Medicine) {
	    			
	    			showTheMessage(planet.getItem().getName(), 1);
	    			crew.addingMeds((Medicine) planet.getItem(), 1);
	    			planet.sethasItemStatus(false, new Items());
	    		}
	    		else if (planet.getItem() instanceof SpaceshipPart) {
	    			
	    			showTheMessage(planet.getItem().getName(), planet.getItem().getQuantity());
	    			crew.increaseNumberOfpartsFound(1);
	    			planet.sethasItemStatus(false, new Items());
	    			planet.setPartStatus();
	    			return true;
	    		}
	    		else if (planet.getItem() instanceof Money) {
	    			
	    			showTheMessage("dollars", planet.getItem().getQuantity());
	    			crew.stealMoney(planet.getItem().getQuantity());
	    			planet.sethasItemStatus(false, new Items());
	    			
	    		}
	    		
	    		}
	    	
		}
    		return false;
	    }
}
	    
	    
	    
