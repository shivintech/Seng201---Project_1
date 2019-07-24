package items;
/**
 * class dedicated to the number of space ship parts found attribute of the Crew class.
 *
 */
public class SpaceshipPart extends Items{
	private String name;
	/**
	 * Subclass of items 
	 */
	public SpaceshipPart(){
		super(1, 0);
		name = "Spaceship part";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
