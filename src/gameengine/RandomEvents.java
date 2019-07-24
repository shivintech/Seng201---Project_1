package gameengine;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import items.Items;
import planet.Planet;
import planet.SpaceOutpost;
import sound.Sound;
import spaceship.SpaceShip;
import units.Crew;
import units.Nebula;
/**
 * 
 * This class implements all the random events specified in the project specification.
 *
 */
public class RandomEvents {
	
	private Crew crew;
	private SpaceShip ship;
	private ArrayList <Items> itemList = new ArrayList<>();
	private ArrayList <Planet> planets = new ArrayList<>();
	Items item;
	
	private SpaceOutpost sp;
	public RandomEvents(Crew crew, SpaceShip ship, ArrayList <Planet> planets, SpaceOutpost sp) {
		this.crew = crew;
		this.ship = ship;
		item = new Items();
		this.sp = sp;
		this.planets = planets;
	}
	/**
	 * This methods uses the random generator to generate number within the specified range. based on the number generate events such as alien pirates, 
	 * space plague and asteroid hit happens 
	 */
	
	public void randomEvent() { 
		
		Random rand = new Random();
		int n = rand.nextInt(3);
		
		if (n ==0) {
			alienPirates();
		}
		else if(n == 1){
			spacePlague();
			
		}
	}	
	/**
	 * Calls the asteroid method and reduces the ship's health depending upon the current shield health of the ship
	 */
	public void callAsteroidBelt() {
		Random random = new Random();
		int n = random.nextInt(3);
		if (n==1) {
			asteroidBelt();
		}
	}
	
	
	/**
	 * Implementation of Alien pirate functionality
	 * Alien invasion sound - http://soundbible.com/suggest.php?q=alien&x=0&y=0
	 * When this method is called a random food/medicine item is looted by the aliens.
	 */
	public void alienPirates() {
		
		
		
		Random rand1 = new Random();
		int n = rand1.nextInt(2);
		if (n == 0) {
		
			if (crew.getFoodList().size() > 0) {
				
				
				try {
			    	InputStream wavFile = Sound.class.getResourceAsStream("/image/Alien.wav");
			    	InputStream bufferedIn = new BufferedInputStream(wavFile);
			    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
			    	
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioStream);
			        clip.start();
				
			    	
				} catch(Exception z){}
				
						
			
			Random random1 = new Random();
			
			int num1 = random1.nextInt(crew.getFoodList().size());
			JOptionPane.showMessageDialog(new JFrame(), "The aliens have looted your ship, they stole 1   " + crew.getFoodList().get(num1).getName());
			crew.removingFood(crew.getFoodList().get(num1), 1);
			
		}
			
			
		}
		
	
			
		else if (n==1) { 
			if(crew.getMedicineList().size() > 0) {
				
				
				try {
			    	InputStream wavFile = Sound.class.getResourceAsStream("/image/Alien.wav");
			    	InputStream bufferedIn = new BufferedInputStream(wavFile);
			    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
			    	
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioStream);
			        clip.start();
				
			    	
				} catch(Exception z){z.printStackTrace();}
				
			Random random2 = new Random();
			int num2 = random2.nextInt(crew.getMedicineList().size());
			JOptionPane.showMessageDialog(new JFrame(), "The aliens have looted your ship, they stole 1" + crew.getMedicineList().get(num2).getName());
			crew.removingMeds(crew.getMedicineList().get(num2), 1);
		}
		
		}
		
		else {
			
			try {
		    	InputStream wavFile = Sound.class.getResourceAsStream("/image/Alien.wav");
		    	InputStream bufferedIn = new BufferedInputStream(wavFile);
		    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
		    	
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioStream);
		        clip.start();
			
		    	
			} catch(Exception z){}
			JOptionPane.showMessageDialog(new JFrame(), "The aliens tried to loot your ship, but didn't find anything");
		}
	}
	/**
	 * Uses random generator based on the length of the crew member list and gives that random person the space plague only if they are not type nebula.
	 */
	public void spacePlague() { 
		Random rand2 = new Random();
		int n = rand2.nextInt(crew.getcrewListlength());
		if (!(crew.getCrewMember(n)instanceof Nebula) && crew.getCrewMember(n).getHealth()>0) {
			crew.getCrewMember(n).setSpacePlagueStatus(true);
			JOptionPane.showMessageDialog(new JFrame(), "Space Plague has affected " + crew.getCrewList().get(n).getName());

		
	}}
	/**
	 * This method displays the J option pane and informs the player if the ship just hit an asteroid and also calls the damage shield method to updates the ship health.
	 * Asteroid hit - http://soundbible.com/1592-Missile-Impact.html
	 */
	
	public void asteroidBelt() { 
		damageShield();
		JOptionPane.showMessageDialog(new JFrame(), "The ship just hit an asteroid");
	try {
	    	InputStream wavFile1 = Sound.class.getResourceAsStream("/image/hit.wav");
	    	InputStream bufferedIn1 = new BufferedInputStream(wavFile1);
	    	AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(bufferedIn1);
	    	
	        Clip clip3 = AudioSystem.getClip();
	        clip3.open(audioStream1);
	        clip3.start();
		
	    	
		} catch(Exception ee){};
		}
	
			
		
	
	/**
	 * Reduces the ship health by 40 points
	 */
	public void damageShield() { 
		ship.updateShieldHealth(40);
	}
	/**
	 * Assigns a random food, medicine, money, space ship part to a few planets.	
	 */

	public void affectPlanet() {
		sp.getItemList();
		Random rand3 = new Random();
		int n = rand3.nextInt(sp.getItemList().size());
			int e =rand3.nextInt(2); 
			if (e == 0) {
			planets.get(0).sethasItemStatus(true, sp.getItemList().get(n));
			planets.get(1).sethasItemStatus(true, sp.getItemList().get(n));
			planets.get(2).sethasItemStatus(true, sp.getItemList().get(n));
			planets.get(3).sethasItemStatus(true, sp.getItemList().get(n));
			planets.get(4).sethasItemStatus(true, sp.getItemList().get(n));
			planets.get(5).sethasItemStatus(true, sp.getItemList().get(n));
			}
			else if(( e==1) && planets.get(0).hasPart() != true && planets.get(1).hasPart() != true && planets.get(2).hasPart()!=true && planets.get(3).hasPart()!=true && planets.get(4).hasPart()!=true && planets.get(5).hasPart()!=true) { 
				planets.get(0).sethasItemStatus(true, sp.getPartList().get(0));
				planets.get(1).sethasItemStatus(true, sp.getPartList().get(0));
				planets.get(2).sethasItemStatus(true, sp.getPartList().get(0));
				planets.get(3).sethasItemStatus(true, sp.getItemList().get(0));
				planets.get(4).sethasItemStatus(true, sp.getItemList().get(0));
				planets.get(5).sethasItemStatus(true, sp.getItemList().get(0));
			}
	}
}

