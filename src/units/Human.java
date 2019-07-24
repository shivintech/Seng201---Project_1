package units;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import gameengine.RandomEvents;
import planet.Planet;
import sound.Sound;

/**
 * CrewMember of type human with health 100, special power of avoiding the asteroid when piloting the ship. 
 *
 */
public class Human extends CrewMember {
	/**
	 * 
	 * Constructor of type Human which sets the default levels of hunger and tiredness equal to 0, heath to 100 and, space plague status 
	 * to false and assigns special power.
	 *
	 */
	public Human(String crewMemberName, Crew crew) {
		super(crewMemberName, 100, 0, 0, crew, false, "Human", "When I drive no asteroid can touch the ship.");
		
	}
	/**
	 * This method overrides the pilot ship method in class Crew member only when one of the selected pilot is of type Human.
	 * Rocket Launch Sound - http://soundbible.com/1498-Rocket.html
	 */
	
	public void pilotShip(Planet source, Planet destination, CrewMember member, RandomEvents random) {
    	
		if (this.getNumberOfActions() < 1 && member.getNumberOfActions() <1) {
    		throw new IllegalStateException("Both dont have enough actions");
    	}
    	if (this.getNumberOfActions() < 1 ) {
    		throw new IllegalStateException(this.getName() + " dont have enough actions");
    	}
    	else if(member.getNumberOfActions() <1) {
    		throw new IllegalStateException(member.getName() + " does not have enough actions");
    	}
    	if (!(source.isEqual(destination))){
    		
    		try {
		    	InputStream wavFile = Sound.class.getResourceAsStream("/image/launchw.wav");
		    	InputStream bufferedIn = new BufferedInputStream(wavFile);
		    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
		    	
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioStream);
		        clip.start();
			
		    	
			} catch(Exception ee){}
    	this.getCrew().setPosition(destination.getName());
    	this.getCrew().setPlanetPositiion(destination);
    	this.increaseHunger(30);
    	member.increaseHunger(30); 
    	
	    this.setNumberOfActions(1);
	    member.setNumberOfActions(1);
	    
		this.increaseTiredness(20);
		member.increaseTiredness(20);
    	}
    }
	
}
