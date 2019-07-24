package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import items.AlienGrubs;
import items.CalceraPhos400;
import items.FoodItems;
import items.Items;
import items.KalaxianCrystals;
import items.Medicine;
import items.NZT48;
import items.R89;
import planet.Planet;
import units.Crew;
import units.CrewMember;
class CrewTest {

	@Test
	void crewStartsWith1000DollarsTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		assertEquals(1000, crew.getMoney());
	}
	
	@Test 
	void checkcrewlistlengthTest() {
		Items items = new Items();
		
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		CrewMember sunny = new CrewMember("Sunny", 561, 462, 0, crew, false, "Human", "power1");
		CrewMember sunny1 = new CrewMember("Sunny1", 56, 46, 1, crew, false, "Human1", "power2");
		crew.addCrewMember(sunny);
		crew.addCrewMember(sunny1);
		crew.getCrewList().size();	
		assertEquals(2, crew.getCrewList().size());
	}
	
	@Test
	 void checkscrewmemberattributes() {
			Items items = new Items();
			Planet planet = new Planet("planet", 1, false, items, false);
			Crew crew = new Crew("crewName", "shipName", planet);
			CrewMember sunny = new CrewMember("Sunny", 561, 462, 0, crew, false, "Human", "power1");
			crew.addCrewMember(sunny);
			assertEquals(561, crew.getCrewMember(0).getHealth());
			assertEquals(462, crew.getCrewMember(0).getHunger());
			assertEquals(0, crew.getCrewMember(0).getTiredness());
			assertEquals(false, crew.getCrewMember(0).getSpacePlagueStatus());
			assertEquals("Human", crew.getCrewMember(0).getType());
			assertEquals("power1", crew.getCrewMember(0).getPower());			
		
	}
	
	@Test 
	void checkfoodlistlengthTest() {
		Items items = new Items();
		FoodItems food = new FoodItems("dosa",3, 30, 70);
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		crew.addingFood(food, food.getQuantity());
		assertEquals("dosa", crew.getFoodList().get(0).getName());
		assertEquals(3, crew.getFoodList().get(0).getQuantity());
		assertEquals(30, crew.getFoodList().get(0).getPrice());
		assertEquals(70, crew.getFoodList().get(0).getNutrients());

}
	
	@Test 
	void checkmedicinelistlengthTest() {
		Items items = new Items();
		Medicine med = new Medicine("Crosin",5, 50, 30);
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		crew.addingMeds(med, med.getQuantity());
		assertEquals("Crosin", crew.getMedicineList().get(0).getName());
		assertEquals(5, crew.getMedicineList().get(0).getQuantity());
		assertEquals(50, crew.getMedicineList().get(0).getPrice());
		assertEquals(30, crew.getMedicineList().get(0).getHeal());
		crew.removingMeds(med, 2);
		assertEquals(3, crew.getMedicineList().get(0).getQuantity());

}
	
	
	@Test 
	void checkmoneyTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		crew.spendMoney(700);
		assertEquals(300, crew.getMoney());

}
	@Test
	void getMedicineTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		Medicine med = new NZT48(10);
		Medicine med1 = new CalceraPhos400(1);
		crew.addingMeds(med, med.getQuantity());
		crew.addingMeds(med1, med1.getQuantity());
		Medicine we = crew.getMedicine("Calcera Phos400");
		assertEquals("Calcera Phos400", we.getName());
		assertEquals(1, we.getQuantity());
		}
	@Test
	void removeMedicineTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false,items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		Medicine med = new NZT48(7); 
		crew.addingMeds(med, med.getQuantity());
		crew.removeMedicine(0);
		assertEquals(0, crew.getmedicineListlength());
	}
	@Test
	void removeFoodItemTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false,items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		FoodItems food = new FoodItems("dosa", 3, 30, 70);
		crew.addingFood(food, food.getQuantity());
		crew.removeFoodItem(0);
		assertEquals(0, crew.getFoodListLength());
	}
	@Test
	void getFoodItemTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		FoodItems med = new KalaxianCrystals(10);
		FoodItems med1 = new AlienGrubs(10);
		crew.addingFood(med, med.getQuantity());
		crew.addingFood(med1, med1.getQuantity());
		FoodItems we = crew.getFoodItem("Kalaxian Crystals");
		assertEquals("Kalaxian Crystals", we.getName());
		assertEquals(10, we.getQuantity());
		assertEquals("Alien Grubs", crew.getFooditem(1).getName());
		}
	@Test
	void checksizecrewListTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		CrewMember member1 = new CrewMember("Sunny", 561, 462, 0, crew, false, "Human", "power1");
		CrewMember member2 = new CrewMember("Sunny1", 561, 462, 0, crew, false, "Human", "power1");
		crew.addCrewMember(member1);
		crew.addCrewMember(member2);
		assertEquals(true, crew.checkSizecrewList());
	}
	@Test
	void addingMedsTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		Medicine med = new CalceraPhos400(1);
		Medicine med1 = new CalceraPhos400(10);
		crew.addingMeds(med, med.getQuantity());
		assertEquals(1, crew.getMedicineList().get(0).getQuantity());
		crew.addingMeds(med1, med1.getQuantity());
		assertEquals(11, crew.getMedicineList().get(0).getQuantity());
		
	}
	@Test
	void removingMedsTest() {
		Items items = new Items();
		Planet planet = new Planet("planet", 1, false, items, false);
		Crew crew = new Crew("crewName", "shipName", planet);
		Medicine med = new CalceraPhos400(1);
		Medicine med1 = new R89(10);
		crew.addingMeds(med, med.getQuantity());
		crew.removingMeds(med, 2);
		assertEquals(1, crew.getMedicineList().get(0).getQuantity());
		crew.removingMeds(med, med.getQuantity());
		assertEquals(0, crew.getMedicineList().size());
		crew.removingMeds(med1, med1.getQuantity());
		assertEquals(0, crew.getMedicineList().size());
	}
}
