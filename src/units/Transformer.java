package units;

import spaceship.SpaceShip;
/**
 * Crew member of type transformer whose special power is that he is the best mechanic out of all the crew members. 
 *
 */
public class Transformer extends CrewMember{
	
	/**
	 * 
	 * Constructor of type Transformer which sets the default levels of hunger and tiredness equal to 0, heath to 100 and, space plague status 
	 * to false and assigns special power.
	 *
	 */
	
	

	public Transformer(String crewMemberName, Crew crew) {
		super(crewMemberName, 100, 0, 0, crew, false, "Transformer", "I can restore your ship health three times faster by only using one actoin.");
		
	}
	
	/**
	 * This method overrides the repair method in class CrewMember and is only called when type Transformer is selected to repair
	 * the ship. This method calls repair method in class SpaceShip thrice when Transformer type is selected to repair the ship. 
	 * 
	 */
	
	
	
	public void repair(SpaceShip ship) { 
		this.setNumberOfActions(1);
		super.repair(ship);
		super.repair(ship);
		super.repair(ship);		
		this.increaseHunger(10);
		this.setTiredness(10);
	}
	
	
}
