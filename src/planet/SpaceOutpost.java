package planet;
import java.util.ArrayList;

import items.AlienGrubs;
import items.CalceraPhos400;
import items.Items;
import items.KalaxianCrystals;
import items.Money;
import items.NZT48;
import items.NeutrinoBombs;
import items.Popplers;
import items.R89;
import items.Spaceettios;
import items.SpaceshipPart;
import items.StrawberrySmiggles;

/**
 * 
 * Default quantity of items found using search method in case of a random event occurs.
 *
 */
public class SpaceOutpost extends Planet{
	/**
	 * object of R89 medicine.
	 */
	private R89 r89 = new R89(1);
	/**
	 * object of NZT48 medicine. 
	 */
	private NZT48 nzt48 = new NZT48(1);
	/**
	 * object of CalceraPhos400 medicine type.
	 */
	private CalceraPhos400 cp = new CalceraPhos400(1);
	/**
	 * object of type NeutrinoBombs
	 */
	private NeutrinoBombs nb = new NeutrinoBombs(1);
	/**
	 * Object of type KalaxianCrystals
	 */
	private KalaxianCrystals kc = new KalaxianCrystals(1);
	/**
	 * Object of type Popplers.
	 */
	private Popplers pop = new Popplers(1);
	/**
	 * Object of type StrawberrySmiggles. 
	 */
	private StrawberrySmiggles straw = new StrawberrySmiggles(1);
	/**
	 * Object of type Spaceettios.
	 */
	private Spaceettios spag = new Spaceettios(1);
	/**
	 * Object of type AlienGrubs
	 */
	private AlienGrubs ag = new AlienGrubs(1);
	/**
	 * ArrayList of items.
	 */
	private ArrayList<Items> itemList = new ArrayList<>(); 
	/**
	 * Object if type SpaceshipPart 
	 */
	private SpaceshipPart part = new SpaceshipPart(); 
	/**
	 * ArrayList of Spaceship parts. 
	 */
	private ArrayList <SpaceshipPart> partList = new ArrayList<>(); 
	/**
	 * object of type Money.
	 */
	private Money money = new Money(300);
	public SpaceOutpost(Items item) {
		super("New World", 100,false, item,false);
		itemList.add(r89);
		itemList.add(cp);
		itemList.add(nzt48);
		itemList.add(nb);
		itemList.add(kc);
		itemList.add(pop);
		itemList.add(straw);
		itemList.add(spag);
		itemList.add(ag);
		partList.add(part);
		itemList.add(money);
	}
	/**
	 * returns an ArrayList of SpaceshipPart objects
	 * @return partList attribute of SpaceOutpost.
	 */
	public ArrayList<SpaceshipPart> getPartList() {
		return partList;
	}
	/**
	 * returns an ArrayList of Items objects
	 * @return itemList attribute of SpaceOutpost class.
	 */
	public ArrayList<Items> getItemList() {
		return itemList;
	}
	
}

