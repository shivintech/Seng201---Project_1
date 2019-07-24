package units;
/**
 * Crewmember of type medic, whose special power is that her health gets affected the least, out of all the crew members. 
 *
 */
public class Medic extends CrewMember{
	
	/**
	 * 
	 * Constructor of type Medic which sets the default levels of hunger and tiredness equal to 0, heath to 100 and, space plague status 
	 * to false and assigns special power.
	 *
	 */
	
	public Medic(String crewMemberName, Crew crew) {
		super(crewMemberName, 100, 0, 0, crew, false, "Medic", " I only take half the damage when hit by the Space Plague.");
		
	}
	/**
	 * This is method overrides the decreaseHealth method in the crew member class. 
	 * In case type medic gets the plague, she just takes half the damage as compared to other crew members of different types.
	 */
	
	 public void decreaseHealth(int amount) { 
		    	super.decreaseHealth(amount/2);

	
	
	

}}

