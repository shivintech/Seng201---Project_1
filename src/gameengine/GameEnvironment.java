package gameengine;
import java.util.*;



import javax.swing.JFrame;
import javax.swing.JOptionPane;

import items.FoodItems;
import items.Items;
import items.Medicine;
import planet.CoopersPlanet;
import planet.EdmundsPlanet;
import planet.LumbarPlanet;
import planet.MillerPlanet;
import planet.Osiris;
import planet.Planet;
import planet.Solaris;
import planet.SpaceOutpost;
import spaceship.SpaceShip;
import units.Crew;
import units.CrewMember;

import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 * 
 * The game-engine and game logic.
 *
 */
public class GameEnvironment {
	/**
	 * default crew object.
	 */
	private Crew crew;
	/**
	 *  default spaceship object
	 */
	private SpaceShip ship;
	/**
	 * default planet object.
	 */
	private Planet planet;
	/**
	 * default space outpost object.
	 */
	private SpaceOutpost outpost;
	/**
	 * default planetList attribute.
	 */
	private ArrayList <Planet> planetList = new ArrayList<>();
	/**
	 * default random events attribute. 
	 */
	private RandomEvents random;
	/**
	 * number of parts required to win the game.
	 */
	private int numberOfPartsreq; 
	/**
	 * duration of the game
	 */
	
	private int numberOfDays;
	/**
	 * current day of the game.
	 */
	private int currentDay;
	/**
	 * default item attribute.
	 */
	private Items item;
	/**
	 * personal score.
	 */
	private int score;
	/**
	 * game won or lost status.
	 */
	private boolean gameWon;
	
	public GameEnvironment(Crew crew, SpaceShip ship, int numberOfDays) {
		this.crew = crew;
		this.ship = ship;
		item = new Items();
		planet = new MillerPlanet(item);
		outpost = new SpaceOutpost(item);
		
		this.numberOfDays = numberOfDays;

		numberOfPartsreq = gameSetUp(numberOfDays);
		currentDay = 0;
		planetList.add(new MillerPlanet(item));
		planetList.add(new CoopersPlanet(item));
		planetList.add(new LumbarPlanet(item));
		planetList.add(new EdmundsPlanet(item));
		planetList.add(new Solaris(item));
		planetList.add(new Osiris(item));
		random = new RandomEvents(crew, ship, planetList, outpost);
		this.crew.setPlanetPositiion(planetList.get(0));
		gameWon = false;
	}
	/**
	* returns RandomEvents object.
	* @return random attribute of GameEnvironment.
	*/
	public RandomEvents getRandom() {
		return random;
	}
	/**
	* sets/initializes RandomEvents object.
	* @param random is the the parameter that sets/initializes the random attribute of GameEnvironment   
	*/
	public void setRandom(RandomEvents random) {
		this.random = random;
	}
	
	/**
	 * method that decides the number of parts required to win the game given the number of days.
	 * @param numberOfDays decides the number of parts required to win the game.
	 * @return the number of parts required.
	 */
	public int gameSetUp(int numberOfDays) {

		switch (numberOfDays) {
			case 3: 
				numberOfPartsreq = 2;
				break;
			case 4:
				numberOfPartsreq = 2;
				break;
			case 5:
				numberOfPartsreq = 3;
				break;
			case 6:
				numberOfPartsreq = 4;
				break;
			case 7:
				numberOfPartsreq = 4;
				break;
			case 8:
				numberOfPartsreq = 5;
				break;
			case 9:
				numberOfPartsreq = 6;
				break;
			case 10:
				numberOfPartsreq = 6;
				break;
			default:
				numberOfPartsreq = 0;
				break;
			}
		return numberOfPartsreq;
	}
	/**
	* returns the currentDay of the game.
	* @return currentDay attribute of GameEnvironment.
	*/
	public int getCurrentDay() {
		return currentDay;
	}
	/**
	* returns duration of the game
	* @return numberOfDays attribute of GameEnvironment.
	*/
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	/**
	* sets / initializes the duration of the game.
	* @param numberOfDays sets the numberOfDays attribute in GameEnvironment class.
	*/
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	/**
	* returns the string representation of the CrewMember object
	* @param member is the CrewMember object that is being viewed.
	*/
	public void viewCrewMemberStatus(CrewMember member) {
		System.out.println(member);
	}
	/**
	* returns the string representation of the SpaceShip object.
	* @param ship the SpaceShip that is being viewed.
	*/
	public void viewSpaceShipStatus(SpaceShip ship) {
		System.out.println(ship);
	}
	/**
	* updates the current day of the game and resets the actions of the CrewMembers.
	*/
	public void goToNextDay() {
		if (currentDay <= numberOfDays) { 
			currentDay += 1;
		}

		for (CrewMember member: crew.getCrewList()) {
			member.resetNumberOfActions();
		}
	}
	
	/**
	 * this method is called when the crew buys foodItems,medicines from the space outpost.
	 * @param item is the item that the crew wants to purchase from the space outpost.
	 * @param quantity is the number of items that they want to purchase.
	 */
	public void buyItems(Items item, int quantity) {
		if (item instanceof FoodItems) {
			crew.addingFood((FoodItems)item, quantity);
			crew.spendMoney(item.getPrice() * quantity);
		}
		else if (item instanceof Medicine) {
			crew.addingMeds((Medicine)item, quantity);
			crew.spendMoney(item.getPrice() * quantity);
		}
	}
	/**
	 * called when a crew member consumes a foodItem or medicine from the foodList or medicineList.
	 * @param member the crew member that consumes the particular item.
	 * @param item is the item being consumed by the crew member
	 * @param quantity number of items consumed by the crew member. 
	 */
	public void consume(CrewMember member, Items item, int quantity) {
		if (item instanceof FoodItems) {
			member.eat((FoodItems)item, quantity);
		}
		else if (item instanceof Medicine) {
			member.usingMeds((Medicine) item, quantity);
		}
	}
	/**
	* Returns numberOfPartsreq attribute GameEnvironment object to win the game.
	* @return numberOfPartsreq attribute GameEnvironment object to win the game.
	*/
	public int getNumberOfPartsreq() {
		return numberOfPartsreq;
	}
	/**
	* sets the number of parts required to win the game  
	* @param numberOfPartsreq updates or initializes the number of parts required. 
	*/
	public void setNumberOfPartsreq(int numberOfPartsreq) {
		this.numberOfPartsreq = numberOfPartsreq;
	}
	/**
	 * restores the tiredness of a crew member level to zero.
	 * @param  member is the member that sleeps.
	 */
	public void sleep(CrewMember member) {
		member.sleep();
	}
	/**
	 * restores the ship shield level by twenty points.
	 * @param member
	 * @param ship
	 */
	public void repair(CrewMember member, SpaceShip ship) {
		member.repair(ship);
	}
	/**
	* returns a SpaceShip object in GameEnvironment class.
	* @return ship attribute of GameEnvironment class.
	*/
	public SpaceShip getShip() {
		return ship;
	}
	/**
	* ship is the ship that is being set/initialized.
	* @param ship is the ship that is being set/initialized.
	*/
	public void setShip(SpaceShip ship) {
		this.ship = ship;
	}
	/**
	 * calls the pilot method of the crew member class.
	 * @param member1 is the main pilot in this case
	 * @param member2 is the co-pilot.
	 * @param source is the current position of the crew.
	 * @param destination is the planet that the crew/spaceship flies to.
	 * @param random object of the random events class.
	 */
	public void pilot(CrewMember member1, CrewMember member2, Planet source, Planet destination, RandomEvents random) {
		member1.pilotShip(source, destination, member2, random);
		
		
	}
	
	/**
	 * this method is used to generate random number within a certain range. Used for setting a score for the player. 
	 * @param min is the start bound of the range 
	 * @param max is the end bound of the range
	 * @return a number within the specified range
	 * This method was taken from stackoverflow.com by Alexis C.
	 */
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	/**
	 * this method is used to generate the score for the player. Score is generated using random number generators and the numbers generated are multiplied by the parts found.
	 */
	public void settingScore() {
		if (gameWon) {
			score += getRandomNumberInRange(500,700)*crew.getNumberOfpartsFound();
			}
		else {
			score += getRandomNumberInRange(100,300)*crew.getNumberOfpartsFound();
		}
		
	
	}
	/**
	* returns the score of the game
	* @return score attribute of GameEnvironment object.
	*/
	public int getScore() {
		return score;
	}
	/**
	* sets the score of the game.
	* @param score score that is being set to the score attribute of the GameEnvironment class. 
	*/
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	* returns if player has won the game.
	* @return gameWon attribute of GameEnviroment object.
	*/
	public boolean isGameWon() {
		return gameWon;
	}
	
	/**
	* updates the gameWon status of the GameEnvironment class. 
	* @param gameWon is the status that is being updated.
	*/
	public void setGameWon(boolean gameWon) {
		this.gameWon = gameWon;
	}
	
	/**
	* returns the planetList attribute of the GameEnvironment class
	* @return the planetList.
	*/
	public ArrayList<Planet> getPlanetList() {
		return planetList;
	}
	/**
	* setter method for planetList attribute in GameEnvironment object.
	* @param planetList is the planetList that the planetList attribute is set to.
	*/
	public void setPlanetList(ArrayList<Planet> planetList) {
		this.planetList = planetList;
	}
	/**
	 * method that is used to search the planet for food, money, medicines and space ship parts.
	 * @param member that searches the planet.
	 * @param planetName is the planet that is being searched.
	 * @return true if a space ship part is found else returns false.
	 */
	public boolean searchPlanet(CrewMember member, String planetName) {
		for (Planet newplanet: planetList) {
		if (planetName.equals(newplanet.getName())) {
			return member.searchPlanet(newplanet);
			
		}
		}return false;
		}

	}
