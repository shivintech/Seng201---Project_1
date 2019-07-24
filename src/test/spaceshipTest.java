package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameengine.RandomEvents;
import items.Items;
import planet.Planet;
import planet.SpaceOutpost;
import spaceship.SpaceShip;
import units.Crew;

class spaceshipTest {
	
	
	private SpaceShip ship; 
	private Crew crew;
	private int level;
	private Planet planet;
	private Items items;
	private RandomEvents random;
	private SpaceOutpost sp;
	private SpaceShip ship2;
	private SpaceShip ship3;
	private SpaceShip ship4;
	private RandomEvents random1;
	private RandomEvents random2;
	private RandomEvents random3;
	
	@BeforeEach
	
	public void init() {
		items = new Items();
		planet = new Planet("planet", 1, false, items, false);
		crew = new Crew("crewName", "shipName", planet);
		ship = new SpaceShip(50, crew);
		ship2 = new SpaceShip(100, crew);
		ship3 = new SpaceShip(30, crew);
		ship4 = new SpaceShip(15, crew);
		ArrayList <Planet> pl_list = new ArrayList<>();
		pl_list.add(planet);
		sp = new SpaceOutpost(items);
		random = new RandomEvents(crew, ship, pl_list, sp);
		random1 = new RandomEvents(crew, ship2, pl_list, sp);
		random2 = new RandomEvents(crew, ship3, pl_list, sp);
		random3 = new RandomEvents(crew, ship4, pl_list, sp);
		
		
	}
	
	@Test
	void asteoroidHitTest() {
		random.asteroidBelt();
		assertEquals(26, ship.getShieldHealth());
		random1.asteroidBelt();
		assertEquals(80, ship2.getShieldHealth());
		random2.asteroidBelt();
		assertEquals(2, ship3.getShieldHealth());
		random3.asteroidBelt();
		assertEquals(0, ship4.getShieldHealth());
		
		
		
		
		
	}

}