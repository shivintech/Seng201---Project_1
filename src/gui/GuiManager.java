package gui;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import gameengine.GameEnvironment;
//import main.*;
import planet.Planet;
import spaceship.SpaceShip;
import units.Crew;
import units.CrewMember;
/**
 * The class that manages all the GUI classes.
 * 
 *
 */
public class GuiManager {
		
		private JFrame frame;
		private GraphicsEnvironment g;

		public GuiManager() {  //Code from stackoverflow.com  is implemented to import a specific font for the game 
			g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			g.registerFont(Font.createFont(Font.TRUETYPE_FONT, GuiManager.class.getResourceAsStream("/font/OCRAEXT.TTF")));
		}
		catch(FontFormatException er) {
			er.printStackTrace();
		}
		catch(IOException ee) {
			ee.printStackTrace();
			
		}
		}
		/**
		 * Closes the space outpost window
		 * @param world is the object of class SpaceOutpost 
		 */
		public void closeNewWorld(NewWorld world) {
			world.closeWindow();
		}
		/**
		 * Launches the SpaceOutpost 	
		 * @param game object of class GameEnvironment
		 * @param crew object of class Crew
		 * @param screen object of class ThirdScreen 
		 */
		public void launchNewWorld(GameEnvironment game, Crew crew, ThirdScreen screen) {
			NewWorld world = new NewWorld(this, crew, game, screen);
		}
		/**
		 * Launches the Third Screen
		 * @param ge object of class GameEnvironment 
		 * @param crew object of class Crew 
		 * @param ship object of class Spaceship
		 * @param planets object of class Planet 
		 */
		public void launchThirdScreen(GameEnvironment ge , Crew crew, SpaceShip ship, ArrayList<Planet> planets) {
			ThirdScreen third = new ThirdScreen(this, ge, crew, ship, planets);
		}
		/**
		 * launches the Final Screen 
		 * @param ge object of class GameEnvironment 
		 */
		
		public void launchFinalscreen(GameEnvironment ge) {
			FinalScreen FinalScreen = new FinalScreen(this, ge);
		}
		/**
		 * Launches the MainScreen
		 */
		
		public void launchMainScreen () {
			MainScreen mainWindow = new MainScreen(this);
		}
		/**
		 * Closes the main Screen 
		 * @param mainWindow
		 */
		public void closeMainScreen(MainScreen mainWindow) {
			mainWindow.closeWindow();
		}
		/**
		 *Closes the setup screen  
		 * @param setupWindow object of class SetupScreen 
		 */
		public void closeSetupScreen(setupscreen setupWindow) {
			setupWindow.closeWindow();

		}
		/**
		 * Launches setupscreen 
		 * @param wavFile1 object of class Wavfile 
		 * @param bufferedIn is an object of class bufferedn
		 * @param audioStream audioStream of class AudioStream
		 * @param clip1 is aobject of class Clip 
		 */
		public void launchSetupScreen(InputStream wavFile1, InputStream bufferedIn, AudioInputStream audioStream, Clip clip1) {
			setupscreen setupWindow = new setupscreen(this, wavFile1, bufferedIn, audioStream, clip1);
		}
		
		/** 
		 * Launches a new windows which displays the items avaiable to the crew member.
		 * @param ge object of class GameEnvironment 
		 * @param crew object of class Crew
		 * @param ship object of class Spaceship 
		 * @param screen object of class ThirdScreen 
		 * @param member object of class CrewMember 
		 */
		public void launchShipStock(GameEnvironment ge, Crew crew, SpaceShip ship, ThirdScreen screen, CrewMember member) {
			ShipStock stock = new ShipStock(this, ge, crew, ship, screen, member);
		}
			
	}
	
