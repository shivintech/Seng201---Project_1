package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import gameengine.RandomEvents;
import items.CalceraPhos400;
import items.FoodItems;
import items.Items;
import items.Medicine;
import items.NZT48;
import items.R89;
import planet.MillerPlanet;
import planet.Planet;
import planet.SpaceOutpost;
import spaceship.SpaceShip;
import units.Crew;
import units.CrewMember;
import units.Human;
import units.Martian;
import units.StarLord;
import units.Transformer;

class crewmemberTest {
	
	@Test 
	void check_Martian_special_power_Test() {
		Items items = new Items();
		FoodItems food = new FoodItems("dosa",9, 30, 15);
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		crew.addingFood(food, food.getQuantity());
		CrewMember sunny = new CrewMember("Sunny", 561, 50, 0, crew, false, "Human", "power1");
		Martian pooja = new Martian("Mar", crew);
		crew.addCrewMember(sunny);
		crew.addCrewMember(pooja);
		pooja.increaseHunger(100);
		pooja.eat(food, 3);
		sunny.eat(food, 1);
		assertEquals(10, pooja.getHunger());
		assertEquals(35, sunny.getHunger());
		pooja.eat(food, 1);
		assertEquals(0, pooja.getHunger());
	
		
	}
	
	@Test 
	void check_Transformer_special_power_Test() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		SpaceShip ship = new SpaceShip(20, crew);
		Transformer leo = new Transformer("Sunny", crew);
		crew.addCrewMember(leo);
		crew.getCrewList().get(0).repair(ship);
		assertEquals(80, ship.getShieldHealth());
		}
	
	
	@Test 
	void check_StarLord_special_power_Test() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		SpaceShip ship = new SpaceShip(20, crew);
		StarLord lord = new StarLord("Sunny", crew);
		lord.repair(ship);
		lord.searchPlanet(planet);
		assertEquals(0, lord.getTiredness());
	}
	
	@Test
	void spaceplague_cure_Test() {
		Items items = new Items();
		NZT48 med = new NZT48(2);
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		crew.addingMeds(med, med.getQuantity());
		CrewMember Rahul = new CrewMember("Rahul", 100, 50, 0, crew, true, "Human", "power1");
		crew.addCrewMember(Rahul);
		Rahul.usingMeds(med, 1);
		assertEquals(false, Rahul.getSpacePlagueStatus());
}
	
	@Test
	void pilotshipTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		SpaceShip ship = new SpaceShip(100, crew);
		StarLord lord = new StarLord("Sunny", crew);
		Human h = new Human("rahul", crew);
		MillerPlanet des = new MillerPlanet(items);
		ArrayList <Planet> pl_list = new ArrayList<>();
		pl_list.add(planet);
		pl_list.add(des);
		SpaceOutpost sp = new SpaceOutpost(items);
		RandomEvents random = new RandomEvents(crew, ship, pl_list, sp);
		h.pilotShip(planet, des, lord, random);
		assertEquals(100, ship.getShieldHealth());
		
		
	}
	
	@Test
	void increase_health_Test() {
		Items items = new Items();
		R89 med = new R89(2);
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		crew.addingMeds(med, med.getQuantity());
		CrewMember max = new CrewMember("Rahul", 10, 50, 0, crew, false, "Human", "power1");
		crew.addCrewMember(max);
		max.usingMeds(med, 1);
		assertEquals(80, max.getHealth());

	}
	@Test
	void decreaseHealthTest() {
		Items items = new Items();
		ArrayList <Planet> planets = new ArrayList<>();
		Planet planet = new Planet("planet", 1, false, items, false);
		planets.add(planet);
		Crew crew = new Crew("crewName", "shipName", planet);
		SpaceShip ship = new SpaceShip(crew);
		CrewMember nakul = new CrewMember("Nakul", 100, 0, 0, crew, false, "Human", "power1");
		crew.addCrewMember(nakul);
		SpaceOutpost sp = new SpaceOutpost(items);
		RandomEvents random = new RandomEvents(crew, ship, planets, sp);
		nakul.decreaseHealth(50);
		assertEquals(50, nakul.getHealth());
		nakul.decreaseHealth(60);
		assertEquals(0, nakul.getHealth());
		
	}
	@Test
	void setHungerTest() {
		Items items = new Items(); 
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		CrewMember shivin = new CrewMember("Shivin", 100, 100, 0, crew, false, "Human", "power1");
		shivin.setHunger(30);
		System.out.println(shivin.getHunger());
		assertEquals(70, shivin.getHunger());
		shivin.setHunger(110);
		System.out.println(shivin.getHunger());
		assertEquals(0, shivin.getHunger());
	}	
	@Test
	void increaseTirednessTest() {
		Items items = new Items(); 
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		CrewMember kenzie = new CrewMember("Kenzie", 100, 0, 0, crew, false, "Human", "power1");
		kenzie.increaseTiredness(30);
		assertEquals(30, kenzie.getTiredness());
	}
	@Test
	void setTirednessTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		CrewMember harry = new CrewMember("Harry", 100, 0, -10, crew, false, "Human", "power1");
		harry.setTiredness(0);
		assertEquals(0, harry.getTiredness());
		harry.setTiredness(30);
		assertEquals(30, harry.getTiredness());
		
	}
	@Test
	void usingMedsTest() {
		Medicine med = new NZT48(10);
		NZT48 nz = new NZT48(2);
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		crew.addingMeds(med, med.getQuantity());
		CrewMember ryo = new CrewMember("Ryo", 50, 0, 0, crew, true, "Human", "power1");
		crew.addCrewMember(ryo);
		crew.getCrewList().get(0).usingMeds(med, 2);
		crew.addingMeds(nz, 2);
		nz.cureSpacePlague(ryo);
		assertEquals(false, ryo.getSpacePlagueStatus());
		assertEquals(100, ryo.getHealth());
	}
	
	@Test 
	void decreaseTirednesstest() {
		CalceraPhos400 med = new CalceraPhos400(10);
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		crew.addingMeds(med, 5);;
		CrewMember ryo = new CrewMember("Ryo", 50, 40, 0, crew, true, "Human", "power1");
		ryo.usingMeds(med, 1);
		assertEquals(20, ryo.getTiredness());
		assertEquals(90, ryo.getHealth());
		
	}
	@Test
	void isEqualTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		CrewMember member1 = new CrewMember("Ryo", 50, 0, 0, crew, true, "Human", "power1");
		CrewMember member2 = new CrewMember("Ryo", 50, 0, 0, crew, true, "Human", "power1");
		assertEquals(true, member1.isEqual(member2));
		
	}
}
	
	
	
	
	
	
	
	
	
	
	