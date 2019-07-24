package units;

import spaceship.SpaceShip;
/**
 * Crew member if type starlord, whose special power is that he gets tired the least out of all the crew members. 
 *
 */
public class StarLord  extends CrewMember {
	
	/**
	 * 
	 * Constructor of type Star Lord which sets the default levels of hunger and tiredness equal to 0, heath to 100 and, space plague status 
	 * to false and assigns special power.
	 *
	 */
	
	public StarLord(String crewMemberName, Crew crew) {
		super(crewMemberName, 100, 0, 0, crew, false, "Star Lord", "I never get tired, weak people need sleep.");
		
	}
	/**
	 * This method overrides the repair method in class CrewMember and is only called when type starlord is selected to repair
	 * the ship. This method only increases the huger level for starlord by 10 points.
	 */
	public void repair(SpaceShip ship) {
		this.setNumberOfActions(1);
    	this.increaseHunger(10);
    	super.repair(ship);
		
	}
}
