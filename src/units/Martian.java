package units;
/**
 * CrewMember of type Martian, whose special power is that he eats less food than the other crewmembers.  
 *
 */
public class Martian extends CrewMember{
	
	/**
	 * 
	 * Constructor of type Human which sets the default levels of hunger and tiredness equal to 0, heath to 100 and, space plague status 
	 * to false and assigns special power.
	 *
	 */
	
	public Martian(String crewMemberName, Crew crew) {
		super(crewMemberName, 100, 0, 0, crew, false, "Martian", "My hunger goes down by double the amount of food I eat.");
		
	}

}
