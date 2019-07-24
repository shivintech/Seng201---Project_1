package items;

import units.CrewMember;
/**
 * NZT48 is an object of CalceraPhos400 medicine type, which costs 75 dollars and increases health by 60 points
 *
 */

public class NZT48 extends Medicine {
	
	
	/**
	 * 
	 * @param nzt48Quantity is an attribute of Items/Medicine, used in the constructor.
	 */
	public NZT48(int nzt48Quantity) {
		super("NZT48", nzt48Quantity, 75, 60);
	}
	/**
	 * Takes an object of crew member and cures them from space plague by setting the boolean hasSpacePlague back to false.
	 * @param member is the object of CrewMember whose space plague status is being set to false.
	 */

	public void cureSpacePlague(CrewMember member) {
		member.setSpacePlagueStatus(false);
		
	}
}
