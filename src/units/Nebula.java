package units;
/**
 * Crewmember of type Nebula whose special power is that she is immune to Space plague. 
 *
 */
public class Nebula extends CrewMember{ 
	
	/**
	 * 
	 * Constructor of type Nebula which sets the default levels of hunger and tiredness equal to 0, heath to 100 and, space plague status 
	 * to false and assigns special power.
	 *
	 */
	
	public Nebula(String crewMemberName, Crew crew) {
		super(crewMemberName, 100, 0, 0, crew, false, "Nebula", "I am immune to Space Plague.");
		
	}

}
