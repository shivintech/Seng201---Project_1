package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameengine.RandomEvents;
import items.FoodItems;
import items.Items;
import items.Medicine;
import planet.Planet;
import planet.SpaceOutpost;
import spaceship.SpaceShip;
import units.Crew;
import units.Human;
import units.Nebula;

class RandomEventsTest {
	

	private SpaceShip ship; 
	private Crew crew;
	private int level;
	private Planet planet;
	private Items items;
	private RandomEvents random;
	private SpaceOutpost sp;
	private FoodItems food;
	private Medicine med;
	
	@BeforeEach
	
	public void init() {
		items = new Items();
		planet = new Planet("planet", 1, false, items, false);
		crew = new Crew("crewName", "shipName", planet);
		ship = new SpaceShip(100, crew);
		ArrayList <Planet> pl_list = new ArrayList<>();
		pl_list.add(planet);
		sp = new SpaceOutpost(items);
		random = new RandomEvents(crew, ship, pl_list, sp);
		
	}

	
	@Test 
	void NebulaPowerTest() {
		Nebula n = new Nebula("nebula", crew);
		Human h = new Human("h", crew);
		crew.addCrewMember(n);
		random.spacePlague();
		assertEquals(false,crew.getCrewList().get(0).getSpacePlagueStatus());
		assertEquals(100, crew.getCrewList().get(0).getHealth());
	}
	@Test
	void Damageshieldtest() {
		random.asteroidBelt();
		assertEquals(80, ship.getShieldHealth());		
	}

	
	@Test
	void spaceplagueTest() {
		Human h = new Human("h", crew);
		crew.addCrewMember(h);
		random.spacePlague();
		assertEquals(true, h.getSpacePlagueStatus());
		
	}
	
	
}