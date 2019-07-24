package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.Box;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

import gameengine.GameEnvironment;
import items.Items;
import planet.MillerPlanet;
import planet.Planet;
import sound.Sound;
import spaceship.SpaceShip;
import units.Crew;
import units.Human;
import units.Martian;
import units.Medic;
import units.Nebula;
import units.StarLord;
import units.Transformer;
//import main.*;

//import javafx.beans.value.ChangeListener;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.util.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
/**
 * The screen which enables the player to select the crew members and name the ship. 
 * 
 *
 */
public class setupscreen {

	private JFrame frmSetupscreen;
	private JTextField transformerText;
	private JTextField txtHuman;
	private JTextField txtMartian;
	private JTextField txtMedic;
	private JTextField txtNebula;
	private JTextField txtStarLord;
	private GameEnvironment ge;
	private Crew crew;
	private SpaceShip ship;
	private int SpinnerValue;
	private ArrayList<Planet> planets = new ArrayList<>() ;
	private JSpinner spinner = new JSpinner();
	private Items item;
	private Planet planet;
	private ArrayList<String> names = new ArrayList<>() ;
	private Clip clip1;
	private GuiManager rocketManager;
	private JTextField shipNameTextBox;
	private InputStream wavFile1;
	private InputStream bufferedIn;
	private AudioInputStream audioStream;
	setupscreen(GuiManager incommingmanager, InputStream wavFile1, InputStream bufferedIn, AudioInputStream audioStream, Clip clip1){
		item = new Items();
		rocketManager = incommingmanager;
		planet = new MillerPlanet(item);
		crew = new Crew("", "", planet);
		ship = new SpaceShip(100, crew);
		ge = new GameEnvironment(crew, ship, 3);
		planets = ge.getPlanetList();
		this.wavFile1 = wavFile1;
		this.bufferedIn = bufferedIn;
		this.audioStream = audioStream;
		this.clip1 = clip1;
		initialize();
		frmSetupscreen.setVisible(true);
		
	}
	/**
	 * launches the third screen of the game.
	 */
	public void launchThirdScreen() {
		rocketManager.launchThirdScreen(ge, crew, ship, planets);
	}
	/**
	 * closes the current window.
	 */
	public void closeWindow() {
		frmSetupscreen.dispose();
	}
	/** 
	 * Return the value from the spinner i.e the number of days the player wants the mission to last 
	 * @return the value from the spinner i.e the number of days the player wants the mission to last 
	 */
	public int getSpinnerValue() {
		return SpinnerValue;
	}
	/**
	 * Closes the Setup Screen
	 */
	public void finishedWindow() {
		rocketManager.closeSetupScreen(this);
	}
	/** 
	 * method used to check for duplicate names of crew members in the crew.
	 * @param name is the name of the crew member being checked.
	 * @return true if
	 */
	
	public boolean nameCheck(String name) {
		if (!(names.contains(name))){
			names.add(name);
			return true;
		}
		
		else {
			JOptionPane.showMessageDialog(new JFrame(), "<html>Duplicate name.<br> Enter a different name. ");
			return false;
		}
	}

	
	public setupscreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmSetupscreen = new JFrame();
		frmSetupscreen.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		frmSetupscreen.getContentPane().setBackground(Color.BLACK);
		frmSetupscreen.setResizable(false);
		frmSetupscreen.setTitle("Antrix SetupScreen");
		frmSetupscreen.setBounds(0, 0, 1000, 800);
		frmSetupscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetupscreen.getContentPane().setLayout(null);
		
		transformerText = new JTextField();
		transformerText.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		transformerText.getCaret().setVisible(true);
		transformerText.setCaretColor(Color.CYAN);
		transformerText.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		transformerText.setBorder(new LineBorder(Color.RED));
		transformerText.setForeground(new Color(255, 250, 250));
		transformerText.setBackground(new Color(0, 0, 0));
		transformerText.setText(" Transformer ");
		transformerText.setBounds(12, 314, 138, 22);
		frmSetupscreen.getContentPane().add(transformerText);
		transformerText.setColumns(10);
		
		txtHuman = new JTextField();
		txtHuman.setForeground(new Color(255, 250, 250));
		txtHuman.setBackground(Color.BLACK);
		txtHuman.setBorder(new LineBorder(Color.RED));
		txtHuman.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		txtHuman.setText(" Human");
		txtHuman.setBounds(170, 314, 106, 22);
		frmSetupscreen.getContentPane().add(txtHuman);
		txtHuman.setColumns(10);
		
		txtMartian = new JTextField();
		txtMartian.setForeground(new Color(255, 250, 250));
		txtMartian.setBorder(new LineBorder(Color.RED));
		txtMartian.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		txtMartian.setBackground(Color.BLACK);
		txtMartian.setText(" Martian ");
		txtMartian.setBounds(301, 314, 118, 22);
		frmSetupscreen.getContentPane().add(txtMartian);
		txtMartian.setColumns(10);
		
		txtMedic = new JTextField();
		txtMedic.setForeground(new Color(255, 250, 250));
		
		txtMedic.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		txtMedic.setBackground(new Color(0, 0, 0));
		txtMedic.setBorder(new LineBorder(Color.RED));
		txtMedic.setText(" Medic ");
		txtMedic.setBounds(12, 514, 126, 22);
		frmSetupscreen.getContentPane().add(txtMedic);
		txtMedic.setColumns(10);
		
		txtNebula = new JTextField();
		txtNebula.setForeground(new Color(255, 250, 250));
		txtNebula.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		txtNebula.setBorder(new LineBorder(Color.RED));
		txtNebula.setBackground(new Color(0, 0, 0));
		txtNebula.setText(" Nebula ");
		txtNebula.setBounds(160, 514, 116, 22);
		frmSetupscreen.getContentPane().add(txtNebula);
		txtNebula.setColumns(10);
		
		txtStarLord = new JTextField();
		txtStarLord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtStarLord.setForeground(new Color(255, 250, 250));
		txtStarLord.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		txtStarLord.setBorder(new LineBorder(Color.RED));
		txtStarLord.setBackground(new Color(0, 0, 0));
		txtStarLord.setText(" Star Lord ");
		txtStarLord.setBounds(301, 514, 126, 22);
		frmSetupscreen.getContentPane().add(txtStarLord);
		txtStarLord.setColumns(10);
		
		JLabel selectLabel = new JLabel("Select  & name your crew members (max 4):");
		selectLabel.setForeground(Color.WHITE);
		selectLabel.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 19));
		selectLabel.setBounds(12, 267, 540, 34);
		frmSetupscreen.getContentPane().add(selectLabel);

		
		
		JLabel statsLabel = new JLabel("\"Crew member stats displayed here \"");
		statsLabel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.RED));
		statsLabel.setVerticalAlignment(SwingConstants.TOP);
		statsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statsLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		statsLabel.setForeground(Color.WHITE);
		statsLabel.setBackground(Color.BLACK);
		statsLabel.setBounds(12, 13, 383, 241);
		statsLabel.setOpaque(true);
		frmSetupscreen.getContentPane().add(statsLabel);
		
		/** 
		 * Appear Sound - http://soundbible.com/suggest.php?q=appear+&x=0&y=0
		 */
		JButton playGameButton = new JButton(">>>>>");
		playGameButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		playGameButton.setOpaque(false);
		playGameButton.setForeground(Color.RED);
		playGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crew.getcrewListlength() >= 2) {
					try {
			
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/Appear-KP-1137861048.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				    	
				    	clip1.stop();
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				   
				        clip.start();
					
				    	
					} catch(Exception n){}
				
				
				crew.setShipName(shipNameTextBox.getText());
				launchThirdScreen();
				finishedWindow();
				ge.getRandom().affectPlanet();
			}
				else {
					statsLabel.setText("<html>You need to select minimum of <br> 2 crew memebers!!");
				}
			}
		}
		);
		playGameButton.setBackground(Color.LIGHT_GRAY);
		playGameButton.setFont(new Font("OCR A Extended", Font.BOLD, 22));
		playGameButton.setBounds(832, 676, 126, 25);
		frmSetupscreen.getContentPane().add(playGameButton);
		
		
		
		JLabel numberOfDaysLabel = new JLabel("Select number of days for the mission ");
		numberOfDaysLabel.setForeground(new Color(255, 250, 250));
		numberOfDaysLabel.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 19));
		numberOfDaysLabel.setBounds(418, 13, 484, 34);
		frmSetupscreen.getContentPane().add(numberOfDaysLabel);
		
		JLabel shipNameLabel = new JLabel("Name your ship :");
		shipNameLabel.setForeground(new Color(255, 250, 250));
		shipNameLabel.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 19));
		shipNameLabel.setBounds(418, 130, 220, 34);
		frmSetupscreen.getContentPane().add(shipNameLabel);
		
		
		JLabel numberOfPartsLabel = new JLabel("Number of parts to be collected : 2" );
		numberOfPartsLabel.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 19));
		numberOfPartsLabel.setForeground(new Color(255, 250, 250));
		numberOfPartsLabel.setBackground(new Color(0, 255, 0));
		numberOfPartsLabel.setBounds(418, 83, 526, 34);
		frmSetupscreen.getContentPane().add(numberOfPartsLabel);
		JSpinner selectDaysSpinner = new JSpinner();
		selectDaysSpinner.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		selectDaysSpinner.setBackground(Color.BLACK);
		selectDaysSpinner.setForeground(Color.WHITE);
		selectDaysSpinner.setOpaque(false);
		
		SpinnerNumberModel spinModel = new SpinnerNumberModel(3, 3, 10, 1);
		selectDaysSpinner.setFont(new Font("Magneto", Font.PLAIN, 15));
		selectDaysSpinner.setModel(spinModel);
		selectDaysSpinner.setBounds(914, 21, 44, 34);
		frmSetupscreen.getContentPane().add(selectDaysSpinner);
		
		selectDaysSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				SpinnerValue = Integer.parseInt(spinModel.getValue().toString());
				numberOfPartsLabel.setText("Number of parts to be collected : " + ge.gameSetUp(SpinnerValue));
				ge.setNumberOfDays(SpinnerValue);
			}
		});
		
		shipNameTextBox = new JTextField();
		shipNameTextBox.setCaretColor(Color.RED);
		shipNameTextBox.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		shipNameTextBox.setForeground(Color.CYAN);
		shipNameTextBox.setBackground(new Color(0, 0, 0));
		shipNameTextBox.setBorder(null);
		shipNameTextBox.setText("\"Odyssey\"");
		shipNameTextBox.getCaret().setVisible(true);
		transformerText.setCaretColor(Color.CYAN);
		shipNameTextBox.setBounds(651, 134, 278, 26);
		frmSetupscreen.getContentPane().add(shipNameTextBox);
		shipNameTextBox.setColumns(10);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBounds(520, 328, 435, 257);
		frmSetupscreen.getContentPane().add(lblNewLabel_2);
		
		JLabel numberOfCrewMembers = new JLabel("Current number of crew members :" );
		numberOfCrewMembers.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 19));
		numberOfCrewMembers.setForeground(Color.WHITE);
		numberOfCrewMembers.setBounds(418, 193, 526, 34);
		frmSetupscreen.getContentPane().add(numberOfCrewMembers);
		
		
		
		JLabel adventureLabel = new JLabel("Let the adventure begin");
		adventureLabel.setForeground(new Color(255, 250, 250));
		adventureLabel.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 19));
		adventureLabel.setBounds(447, 678, 383, 22);
		frmSetupscreen.getContentPane().add(adventureLabel);
		
		
		/**
		 * Crew Member selection sound - https://soundbible.com/857-Swords-Clashing.html
		 * Transformer Image - https://wallpapercave.com/transformers-logo-wallpapers
		 */
		JButton transfomerButton = new JButton("");
		transfomerButton.setToolTipText("I can restore your ship health  ");
		transfomerButton.setBorder(null);
		transfomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Transformer transformer = new Transformer(transformerText.getText(), crew);
				
				if (nameCheck(transformerText.getText())) {
					
					
					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/selection.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.stop();
				        clip.start();
				        
					
				    	
					} catch(Exception z){}
				statsLabel.setText(transformer.toString());
				 if (crew.checkSizecrewList()) {
					 
					lblNewLabel_2.setText("<html>" + transformerText.getText() + " is added <br>to the crew");
					crew.addCrewMember(transformer);
					numberOfCrewMembers.setText(String.format("Current number of crew members : %s",crew.getcrewListlength()));
				}
				else {
					lblNewLabel_2.setText(String.format("<html>Crew is full!!<br>  %s cannot be added to the crew.<br> Maximum of 4 crew member can be added",transformerText.getText()));
				}
			}}
		});
		transfomerButton.setIcon(new ImageIcon(setupscreen.class.getResource("/image/t2f.jpg")));
		transfomerButton.setBounds(12, 352, 126, 149);
		frmSetupscreen.getContentPane().add(transfomerButton);
		
		/**
		 * Human Image -https://www.allwallpaper.in/men-suit-helmets-simple-background-black-astronaut-wallpaper-9180.html
		 */
		JButton humanButton = new JButton("");
		humanButton.setToolTipText("I am the best pilot on board ");
		humanButton.setBorder(null);
		humanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Human human = new Human(txtHuman.getText(), crew);
				if (nameCheck(txtHuman.getText())) {
					
					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/selection.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception z){}
				statsLabel.setText(human.toString());
				 if (crew.checkSizecrewList()) {
						lblNewLabel_2.setText(txtHuman.getText() + " is added to the crew");
						crew.addCrewMember(human);
						numberOfCrewMembers.setText(String.format("Current number of crew members : %s",crew.getcrewListlength()));
					}
					else {
						lblNewLabel_2.setText(String.format("<html>Crew is full!!<br>  %s cannot be added to the crew.<br> Maximum of 4 crew member can be added",txtHuman.getText()));
					}
			}}
			
		});
		humanButton.setIcon(new ImageIcon(setupscreen.class.getResource("/image/hf.png")));
		humanButton.setBounds(157, 350, 132, 151);
		frmSetupscreen.getContentPane().add(humanButton);
		
		/**
		 * Martian reference - https://www.desktopbackground.org/wallpaper/predator-wallpapers-207142
		 * 
		 */
		JButton martianButton = new JButton("");
		martianButton.setToolTipText("I don't use much food ");
		martianButton.setBorder(null);
		martianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Martian martian = new Martian(txtMartian.getText(), crew);
				if (nameCheck(txtMartian.getText())) {
					
					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/selection.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception z){}

				statsLabel.setText(martian.toString());
				 if (crew.checkSizecrewList()) {
						lblNewLabel_2.setText(txtMartian.getText() + " is added to the crew");
						crew.addCrewMember(martian);
						numberOfCrewMembers.setText(String.format("Current number of crew members : %s",crew.getcrewListlength()));
					}
					else {
						lblNewLabel_2.setText(String.format("<html>Crew is full!!<br>  %s cannot be added to the crew.<br> Maximum of 4 crew member can be added",txtMartian.getText()));
					}
			}}
			
				
		});
		martianButton.setIcon(new ImageIcon(setupscreen.class.getResource("/image/mff.PNG")));
		martianButton.setBounds(301, 352, 118, 149);
		frmSetupscreen.getContentPane().add(martianButton);
		
		/**
		 * Medic reference - https://fortniteskins.net/outfits/field-surgeon/
		 */
		JButton medicButton = new JButton("");
		medicButton.setToolTipText("I take half the damage.");
		medicButton.setBorder(null);
		medicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medic medic = new Medic(txtMedic.getText(), crew);
				if (nameCheck(txtMedic.getText())) {
					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/selection.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception z){}

				statsLabel.setText(medic.toString());
				 if (crew.checkSizecrewList()) {
						lblNewLabel_2.setText(txtMedic.getText() + " is added to the crew");
						crew.addCrewMember(medic);
						numberOfCrewMembers.setText(String.format("Current number of crew members : %s",crew.getcrewListlength()));
					}
					else {
						lblNewLabel_2.setText(String.format("<html>Crew is full!!<br>  %s cannot be added to the crew.<br> Maximum of 4 crew member can be added",txtMedic.getText()));
					}}
			}
			});
		medicButton.setIcon(new ImageIcon(setupscreen.class.getResource("/image/med.PNG")));
		medicButton.setBounds(12, 551, 126, 150);
		frmSetupscreen.getContentPane().add(medicButton);
		
		/**
		 * Nebula reference - https://dotesports.com/apex-legends/news/this-cosplay-of-wraith-from-apex-legends-is-incredibly-accurate
		 */
		JButton nebulaButton = new JButton("");
		nebulaButton.setToolTipText("I am immortal ");
		nebulaButton.setBorder(null);
		nebulaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nebula nebula = new Nebula(txtNebula.getText(), crew);
				if (nameCheck(txtNebula.getText())) {
					
					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/selection.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception z){}
				statsLabel.setText(nebula.toString());
				 if (crew.checkSizecrewList()) {
						lblNewLabel_2.setText(txtNebula.getText() + " is added to the crew");
						crew.addCrewMember(nebula);
						numberOfCrewMembers.setText(String.format("Current number of crew members : %s",crew.getcrewListlength()));
					}
					else {
						lblNewLabel_2.setText(String.format("<html>Crew is full!!<br>  %s cannot be added to the crew.<br> Maximum of 4 crew member can be added",txtNebula.getText()));
					}
			}}
		});
		nebulaButton.setIcon(new ImageIcon(setupscreen.class.getResource("/image/Capture5.PNG")));
		nebulaButton.setBounds(157, 547, 126, 154);
		frmSetupscreen.getContentPane().add(nebulaButton);
		
		/**
		 * StarLord Image - https://www.pinterest.nz/pin/211176670008278427/?lp=true
		 */
		JButton starlordButton = new JButton("");
		starlordButton.setToolTipText("I don't need to sleep and never get tired.");
		starlordButton.setBorder(null);
		starlordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StarLord lord = new StarLord(txtStarLord.getText(), crew);
				if (nameCheck(txtStarLord.getText())) {
					
					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/selection.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception z){}
				statsLabel.setText(lord.toString());
				 if (crew.checkSizecrewList()) {
						lblNewLabel_2.setText(txtStarLord.getText() + " is added to the crew");
						crew.addCrewMember(lord);
						numberOfCrewMembers.setText(String.format("Current number of crew members : %s",crew.getcrewListlength()));
					}
					else {
						lblNewLabel_2.setText(String.format("<html>Crew is full!!<br>  %s cannot be added to the crew.<br> Maximum of 4 crew member can be added",txtStarLord.getText()));
					}
			}}
		});
		
		JLabel memberInfoLabel = new JLabel("* Hover over the charachters to view their special power.");
		memberInfoLabel.setFont(new Font("OCR A Extended", Font.ITALIC, 13));
		memberInfoLabel.setForeground(Color.WHITE);
		memberInfoLabel.setBounds(12, 736, 477, 16);
		frmSetupscreen.getContentPane().add(memberInfoLabel);
		starlordButton.setIcon(new ImageIcon(setupscreen.class.getResource("/image/stlf.jpg")));
		starlordButton.setBounds(297, 549, 122, 149);
		frmSetupscreen.getContentPane().add(starlordButton);

		
		
	}
}
