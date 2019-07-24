package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import items.FoodItems;
import items.Items;
import planet.Planet;
import units.Crew;
import units.CrewMember;

class FoodItemsTest {

	@Test
	void isEqualtest() {
		Items items = new Items();
		FoodItems food = new FoodItems("dosa",9, 30, 15);
		FoodItems food1 = new FoodItems("dosa", 4, 30, 15);
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		crew.addingFood(food1, 3);
		crew.addingFood(food, 2);
		assertEquals(true,food.isEqual(food1));
		

}

}