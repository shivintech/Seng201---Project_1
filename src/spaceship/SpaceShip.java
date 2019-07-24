package spaceship;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import units.Crew;
/**
 *  class dedicated to the Spaceship feature in the game.
 *
 */
public class SpaceShip {
	
	/** 
	 * Name of the Space Ship 
	 */
	private String name; 
	/** 
	 * Amount of damage taken by the space ship 
	 */
	private int damage;
	/** 
	 * Current health of the space ship 
	 */
	private int health;
	/** 
	 * Object of class Crew
	 */
	private Crew crew;
	/**
	 * This constructor for class SpaceShip sets the default ship health to 100. 
	 * @param crew is the object of class Crew
	 */
	
	public SpaceShip(Crew crew) {
		name = crew.getshipName();
		health = 100;
		damage = 0;
		this.crew = crew;
		
	}
	/**
	 * This constructor uses a getter method and sets the name of the Spaceship.
	 * @param shieldHealth is an attribute of class Spaceship
	 * @param crew is an object of class crew
	 */
	
	public SpaceShip(int shieldHealth, Crew crew) {
		name = crew.getshipName();
		health = shieldHealth;
		this.crew = crew;
	}
	/**
	 * 
	 * @return the name of the ship as set by the player
	 */
	public String getName() { 
		return name;
	}
	/**
	 * This method sets the name of the spaceship
	 * @param shipname gets set by the player 
	 */
	public void setName(String shipname) {
		name = shipname;
	}
	/**
	 * 
	 * @return the ship health 
	 */
	public int getShieldHealth() { 
		if (health < 0) {
			health = 0;
		}
		return health;
	}
	/**
	 * When called increases the ship health by 20 and prevents the health going over 100.
	 */
	public void setShieldHealth() { 
		health += 20;
		if(health > 100) {
			health = 100;
		}
		
	}
	/**
	 * This method calculates the ship health depending upon its current level.
	 * @param level is the current ship health 
	 */
	
	public void updateShieldHealth(int level) { 
		if (health >= 79) {
			health -= level * 0.50;
		}
		else if (health >= 50 && health < 79) {
			health -= level * 0.60;
		}
		else if (health >= 20 && health < 50) {
			health -= level * 0.70;
		}
		else if (health >=1 && health < 20) {
			health -= level * 0.80;
		}
		if (health <= 0) {
			health = 0;
			JOptionPane.showMessageDialog(new JFrame(), "The ship just crashed. It needs repair!!");
		}
	}
	
	
}
