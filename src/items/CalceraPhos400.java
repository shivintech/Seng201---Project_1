
package items;

import units.CrewMember;
/**
 * CalceraPhos400 is an object of CalceraPhos400 medicine type, which costs 50 dollars and increases health by 50 points
 *
 */
public class CalceraPhos400 extends Medicine {
	
	
	
	/**
	 * @param CalceraPhos400Quantity is an attribute of Items/Medicine, used in the constructor.
	 */
	
	public CalceraPhos400(int CalceraPhos400Quantity) {
		super("Calcera Phos400", CalceraPhos400Quantity, 50, 40);
		}
	
	/**
	 * 
	 * 
	 * @param member is the object of CrewMembver type whose tiredness is being decreased
	 * consumption of CalceraPhos 400 decreases the tiredness of the said CrewMember by 20 points. Calls setTiredness method in CrewMember class.
	 */
	public void decreaseTiredness(CrewMember member) {
		member.setTiredness(20);
		
		
		}
}

