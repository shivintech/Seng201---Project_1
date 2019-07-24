package items;

import units.CrewMember;
/**
 * The super class to all the different medicines in the game.
 *
 */
public class Medicine extends Items {
	/**
	 * The amount by which the crew member gets healed 
	 */
	private int heal;
	/**
	 * name of the medicine
	 */
	private String name;
	public Medicine() { 
		super();
		name = "";
		heal = 0;
	}
	public Medicine(String medicineName, int medicineQuantity, int medicinePrice, int healingPower)  {
		super(medicineQuantity, medicinePrice);
		heal = healingPower;
		name = medicineName;
	}
	/**
	 * this method is called when a medicine is consumed by a crew member.
	 * @param member is the crew member that consumes the medicine. 
	 * @param heal is the amount by which the health of the crew member increases.
	 */
	public void healing(CrewMember member, int heal) {
		member.increaseHealth(heal);
	}
	/**
	 * this method is used to test equality of two medicines, by comparing the name and the healing power.
	 * @param otherMed the medicine object that is used for the comparison.
	 * @return a boolean true or false 
	 */
	public boolean isEqual(Medicine otherMed) { 
		if (otherMed.getHeal() == this.heal && this.getName().equals(otherMed.getName())) {
			return true;
		} else return false;
	}
	/**
	* @returns the name of the medicine.
	*/
	public String getName() {
		return name;
	}
	/**
	* sets the name of the medicine.
	* @param name is the name the medicine name is set to.
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
	* returns the healing power of the medicine.
	* @return heal attribute of Medicine object. 
	*/
	public int getHeal() {
		return heal;
	}
	/**
	* sets the healing power of the medicine.
	* @param heal sets the heal attribute of the Medicine class. 
	*/
	public void setHeal(int heal) {
		this.heal = heal;
	}
	/**
	 * this method is called when the medicine object is printed.
	 * This method type cast's the integer values to string which enables them to get displayed on the label.
	 */
	public String toString() {
		return String.format("%s, %s", this.getName(), this.getQuantity());
	}
	
}
