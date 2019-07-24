package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameengine.GameEnvironment;
import items.FoodItems;
import items.Items;
import items.Medicine;
import planet.Planet;
import planet.SpaceOutpost;
import spaceship.SpaceShip;
import units.Crew;
import units.CrewMember;

class GameEnvironmentTest {

	private SpaceShip ship; 
	private Crew crew;
	private int level;
	private int numberOfPartsreq; 
	private int numberOfDays;
	private Planet planet;
	private Items items;
	private Random ranom;
	private SpaceOutpost sp;
	private int numberOfActions; 
	private CrewMember member;
	private GameEnvironment ge;
	private FoodItems food; 
	private Medicine med;
	
	
@BeforeEach
	
	public void init() {
		items = new Items();
		planet = new Planet("planet", 1, false, items, false);
		crew = new Crew("crewName", "shipName", planet);
		ship = new SpaceShip(100, crew);
		member = new CrewMember("name", 100, 60, 90, crew, false, "human","power");
		ge = new GameEnvironment(crew, ship, numberOfDays);
		food = new FoodItems("dosa",9, 30, 15);
		med = new Medicine("crocin", 5, 40, 40);
}
		
		
	@Test
	void gameSetUpTest() {
		assertEquals(4, ge.gameSetUp(7));
		assertEquals(2, ge.gameSetUp(3));
		assertEquals(5, ge.gameSetUp(8));
		assertEquals(4, ge.gameSetUp(6));
		assertEquals(2, ge.gameSetUp(3));
	}
	
	@Test
	void goToNextDayTest() {
		crew.addCrewMember(member);
		ge.repair(member, ship);
		assertEquals(1, member.getNumberOfActions());
		ge.goToNextDay();
		assertEquals(2,member.getNumberOfActions());
		
	}
	
	@Test 
	void buyItem_test() {
		ge.buyItems(food, 2);
		ge.buyItems(med, 3);
		assertEquals(1, crew.getFoodList().size());
		assertEquals(1, crew.getMedicineList().size());
		assertEquals(2, crew.getFoodList().get(0).getQuantity());
		assertEquals(3, crew.getMedicineList().get(0).getQuantity());
		assertEquals(820, crew.getMoney());
	}
	
	@Test
	void consumeItems_test() {
		ge.buyItems(food, 1);
		ge.consume(member, food, 1);
		assertEquals(45, member.getHunger());
		
	}
	@Test
	void sleep_Test(){
		member.sleep();
		assertEquals(0,member.getTiredness());
		
	}

}