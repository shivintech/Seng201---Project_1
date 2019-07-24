package gui;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import changepaneshape.IsoscelesTrapezoidTabbedPaneUI;
import gameengine.GameEnvironment;
import items.FoodItems;
import items.Medicine;
import planet.Planet;
import sound.Sound;
import spaceship.SpaceShip;
import units.Crew;
import units.CrewMember;
import units.Nebula;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants; 
/**
 * The main screen of the game that contains all the crew member details, ship details and the action buttons. 
 *
 */
public class ThirdScreen {

	private JFrame thirdScreenFrame;
	private GuiManager rocketManager;
	private JLabel label1;
	private GameEnvironment ge;
	private Crew crew;
	private SpaceShip ship;
	private JLabel currMoney;
	private JLabel foodLabel;
	private JLabel medicineLabel;
	private setupscreen setup;
	private JProgressBar sleepbar;
	private JProgressBar hungerbar;
	private JLabel actionLabel;
	private ArrayList<JLabel> labelList = new ArrayList<>(); 
	private ArrayList<JProgressBar> hungerBarList = new ArrayList<>(); 
	private ArrayList<JProgressBar> healthBarList = new ArrayList<>(); 
	private ArrayList<JProgressBar> sleepBarList = new ArrayList<>(); 
	private ArrayList<Planet> planets;
	private ArrayList<JRadioButton> radioButtonList = new ArrayList<>();
	private ArrayList<String> selectedNames = new ArrayList<>();
	private ArrayList<String> deadCrew = new ArrayList<>();
	private JLabel newLocation;
	private JProgressBar shipHealthbar;
	private JLabel daysLabel;
	private JLabel partsLabel;
	private JTabbedPane crewPane;
	private JLabel scoreLabel;
	private JTabbedPane mainTabbedpane;
	
	/**
	 * Returns the hunger progress bar
	 * @return the hunger progress bar
	 */
	public JProgressBar getHungerbar() {
		return hungerbar;
	}


	ThirdScreen(GuiManager incommingmanager, GameEnvironment ge, Crew crew, SpaceShip ship, ArrayList<Planet>planets){
		rocketManager = incommingmanager;
		this.ge = ge;
		this.crew = crew;
		this.ship = ship;
		this.planets = planets;
		initialize();
		thirdScreenFrame.setVisible(true);
	}
	
	/**
	 * method that launches the space outpost screen when the 'go to space outpost button is clicked.
	 * 
	 */
	public void launchNewWorld(){
		rocketManager.launchNewWorld(ge, crew, this);
		}
	/**
	 * launches the screen which contains the foodList and the medicineList of the crew, when the crew member wants to consume a medicine/food. 
	 * launched when the eat button is clicked in one of the tabs dedicated to each crew member.
	 * @param member is the crew member that wishes to consume the food or medicine.
	 */
	public void launchscreen(CrewMember member) {
		rocketManager.launchShipStock(ge, crew, ship, this, member);
	}
	/**
	 * helper function for the pilot functionality in the GUI.  
	 * @param names is a list of names of the crew members that have been selected to pilot the ship. 
	 * @param members is the list of crew members in the crew list. 
	 * @return a list of crew members with who have been selected to the pilot the ship.
	 */
	public ArrayList<CrewMember> nameSelector(ArrayList<String> names, ArrayList<CrewMember> members) {
		ArrayList<CrewMember> newMembers = new ArrayList<>();
		for (String name: names) {
			for(CrewMember member: members) {
				if (name.equals(member.getName())) {
					newMembers.add(member);
				}
			}
		}
		return newMembers;
	}

	/**
	 * Create the application.
	 */
	public ThirdScreen() {
		initialize();
	}
	/**
	 * updates the label to the current location of the crew when the pilot method is called. 
	 */
	public void refreshLocationLabel()
	{
		newLocation.setText(crew.getPosition());
	}
	/**
	 * updates the label to number of days left to play the game, when the next day button is called. 
	 */
	public void refreshDaysLabel() {
		daysLabel.setText("Number of Days Left: " + (ge.getNumberOfDays()-ge.getCurrentDay()));
	}
	/**
	 * updates the label to the number of parts the crew have found so far. Called when the search button is clicked. 
	 */
	public void refreshPartsLabel() {
		partsLabel.setText("Parts Collected:  " +  crew.getNumberOfpartsFound() + " / " + ge.gameSetUp(ge.getNumberOfDays()));
	}
	/**
	 * updates the money the crew have left when the crew have spent money in the space outpost or when they have randomly found money while searching the planet.
	 */
	public void refreshMoney() {
		currMoney.setText("$" + Integer.toString(crew.getMoney()));
	}
	/**
	 * method that launches the final screen, called when the player has won the game or has run out of days to find missing parts of space ship.
	 */
	public void launchfinalscreen() {
		rocketManager.launchFinalscreen(ge);
	}
	
	public void showTheMessage()

	{
	 JOptionPane.showMessageDialog(null, "No actions remaining");
	 }

	/**
	 * updates the foodLabel in the space ship tab when a food item is consumed.
	 */
	public void refreshFoodList() {
		String template = "<html>";
		for (FoodItems food: crew.getFoodList()) {
			template += "-" + food.toString() + "<br>";
	}
		template += "</html>";
		foodLabel.setText(template);
	}
	/**
	 * updates the label dedicated to showing the score, when a crew member has found a space ship part.
	 */
	public void refreshScorelabel() {
		ge.settingScore();
		scoreLabel.setText(String.valueOf(ge.getScore()));
	}
	/**
	 * updates the Medicine label in the spaceship tab when a medicine is consumed. 
	 */
	public void refreshMedicineList() {
		String template = "<html>";
		for (Medicine med: crew.getMedicineList()) {
			template += "-" + med.toString() + "<br>";
	}
		template += "</html>";
		medicineLabel.setText(template);
	}
	/**
	 * updates the actions remaining label of the crew member when the crew member has completed any of the four actions, or when the player has progressed to the next day. 
	 * @param index
	 */
	public void refreshNumberOfActions(int index) {
		labelList.get(index).setText("Number of actions remaining:"+Integer.toString(crew.getCrewList().get(index).getNumberOfActions()));
		
	}
	/**
	 * returns the List of labels used in the current screen.
	 * @return labelList attribute of ThitdScreen class.
	 */
	public ArrayList<JLabel> getLabelList() {
		return labelList;
	}
	/**
	 * setter method for labelList attribute of ThirdScreen class.
	 * @param labelList is the argument the labelList of ThirdScreen attribute is being set to.
	 */
	public void setLabelList(ArrayList<JLabel> labelList) {
		this.labelList = labelList;
	}
	/**
	 * returns the list of progressBars dedicated to the hunger of the crew member.
	 * @return hungerBarList attribute of ThirdScreen class.
	 */
	public ArrayList<JProgressBar> getHungerBarList() {
		return hungerBarList;
	}
	/**
	 * setter method for hungerBarList attribute of ThirdScxreen class 
	 * @param hungerBarList is the argument that the hungerBarList attribute is being set to. 
	 */
	public void setHungerBarList(ArrayList<JProgressBar> hungerBarList) {
		this.hungerBarList = hungerBarList;
	}
	/**
	 * gets the list of progress bars dedicated to the health of the crew member.
	 * @return healthBarList attribute of ThirdScreen.
	 */
	public ArrayList<JProgressBar> getHealthBarList() {
		return healthBarList;
	}
	/**
	 * setter method of healthBarList attribute of ThirdScreen class.
	 * @param healthBarList is the argument that the healthBarList is set to.
	 */
	public void setHealthBarList(ArrayList<JProgressBar> healthBarList) {
		this.healthBarList = healthBarList;
	}
	/**
	 * gets the list of progress bars dedicated to the tiredness of the crew members.
	 * @return the sleepBarList attribute of ThirdScreen class.
	 */
	public ArrayList<JProgressBar> getSleepBarList() {
		return sleepBarList;
	}
	/**
	 * setter method for sleepBarList attribute of ThirdScreen class
	 * @param sleepBarList is the argument that the sleepBarList attribute is set to.
	 */
	public void setSleepBarList(ArrayList<JProgressBar> sleepBarList) {
		this.sleepBarList = sleepBarList;
	}

	/**
	 * method that checks whether a crew member can pilot a ship or not. 
	 * @param member is the crew member that is being checked.
	 */
	public void pilotCondition(CrewMember member) {
		if (member.getNumberOfActions()==0) { 
			showTheMessage();}
			
			else if (member.getHunger()>=80 && member.getTiredness()>=80) {
				JOptionPane.showMessageDialog(new JFrame(), member.getName()+ " needs food and sleep!");
			}
			else if (member.getHunger()>=80) {
		
				JOptionPane.showMessageDialog(new JFrame(), member.getName()+" needs food!");
			}
			else if (member.getTiredness()>=80) {
				JOptionPane.showMessageDialog(new JFrame(), member.getName()+" needs sleep!");
			}
	}
	/**
	 * Initializes the GUI objects
	 */
	private void initialize() {
		thirdScreenFrame = new JFrame();
		thirdScreenFrame.setResizable(false);
		thirdScreenFrame.getContentPane().setBackground(new Color(0, 0, 0));
		thirdScreenFrame.setTitle("Odyssey Third Screen ");
		thirdScreenFrame.setBounds(100, 100, 1000, 800);
		thirdScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thirdScreenFrame.getContentPane().setLayout(null);
		
		JButton visitOutpostButton = new JButton("Visit Space Outpost");
		visitOutpostButton.setFocusPainted(false);
		visitOutpostButton.setForeground(Color.RED);
		visitOutpostButton.setBackground(Color.WHITE);
		visitOutpostButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		visitOutpostButton.setOpaque(false);
		visitOutpostButton.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		visitOutpostButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchNewWorld();
			}
		});
		visitOutpostButton.setBounds(625, 680, 190, 35);
		thirdScreenFrame.getContentPane().add(visitOutpostButton);
		
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.setFocusable(false);
		btnNextDay.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		btnNextDay.setOpaque(false);
		btnNextDay.setForeground(Color.RED);
		btnNextDay.setBackground(Color.WHITE);
		btnNextDay.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		btnNextDay.setBounds(827, 680, 132, 35);
		thirdScreenFrame.getContentPane().add(btnNextDay);
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ge.goToNextDay();
				if (ge.getCurrentDay()==ge.getNumberOfDays()) {
					launchfinalscreen();
					thirdScreenFrame.dispose();
					return;
				}
				ge.getRandom().randomEvent();
				
				for (int i=0; i < crew.getcrewListlength(); i++) {
					refreshNumberOfActions(i);
				}
				for (int j = 0; j< crew.getcrewListlength(); j++) {
					CrewMember member = crew.getCrewList().get(j);
					if (member.getSpacePlagueStatus() && !(member instanceof Nebula)) {
						member.decreaseHealth(30);
						JProgressBar healthBar = healthBarList.get(j);
						healthBar.setValue(member.getHealth());
						healthBar.setString(member.getHealth() + "%");
					}
					if (member.getHealth()<=0 && crew.getCrewList().size()>0) {
						if(!(deadCrew.contains(member.getName()))){
							deadCrew.add(member.getName());
							JOptionPane.showMessageDialog(new JFrame(), member.getName()+ " is dead");
							crewPane.setEnabledAt(j, false);
							radioButtonList.get(j).setEnabled(false);
							radioButtonList.get(j).setSelected(false);
							mainTabbedpane.setSelectedIndex(-1);							
						}

					}		
					}
					
					
				
				
				refreshDaysLabel();
				refreshFoodList();
				refreshMedicineList();
				
			}
		});
		

		
		mainTabbedpane = new JTabbedPane(JTabbedPane.TOP);
		mainTabbedpane.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
		mainTabbedpane.setForeground(Color.CYAN);
		mainTabbedpane.setOpaque(false);
		crewPane = mainTabbedpane;
		
		mainTabbedpane.setBorder(null);
		mainTabbedpane.setUI(new IsoscelesTrapezoidTabbedPaneUI());
		mainTabbedpane.setBounds(0, 0, 798, 647);
		thirdScreenFrame.getContentPane().add(mainTabbedpane);
		
		JLabel currentScoreLabel = new JLabel("   Score ");
		currentScoreLabel.setVerticalAlignment(SwingConstants.TOP);
		currentScoreLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 21));
		currentScoreLabel.setForeground(Color.WHITE);
		currentScoreLabel.setBounds(821, 184, 132, 35);
		thirdScreenFrame.getContentPane().add(currentScoreLabel);
		
		
		JLabel lblMoney = new JLabel("$" + Integer.toString(crew.getMoney()));
		lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoney.setVerticalTextPosition(SwingConstants.TOP);
		lblMoney.setVerticalAlignment(SwingConstants.TOP);
		currMoney = lblMoney;
		
		lblMoney.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		lblMoney.setForeground(new Color(255, 0, 0));
		lblMoney.setBounds(827, 13, 143, 61);
				thirdScreenFrame.getContentPane().add(lblMoney);
		
		scoreLabel = new JLabel("");
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 21));
		scoreLabel.setBounds(831, 232, 128, 82);
		thirdScreenFrame.getContentPane().add(scoreLabel);
		
		JLabel daysleftLabel = new JLabel("Number of Days Left : " + (ge.getNumberOfDays()-ge.getCurrentDay()));
		daysleftLabel.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		daysleftLabel.setForeground(Color.WHITE);
		daysleftLabel.setBounds(12, 681, 298, 46);
		thirdScreenFrame.getContentPane().add(daysleftLabel);
		daysLabel = daysleftLabel;
		
		JLabel lblPartsToCollect = new JLabel("Parts Collected : " + crew.getNumberOfpartsFound() + " / " + ge.gameSetUp(ge.getNumberOfDays()));
		lblPartsToCollect.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblPartsToCollect.setForeground(Color.WHITE);
		lblPartsToCollect.setBounds(325, 681, 288, 46);
		thirdScreenFrame.getContentPane().add(lblPartsToCollect);
		partsLabel = lblPartsToCollect;
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocation.setVerticalAlignment(SwingConstants.TOP);
		lblLocation.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setBounds(810, 69, 154, 35);
		thirdScreenFrame.getContentPane().add(lblLocation);
		
		JLabel locationLabel = new JLabel("");
		locationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		locationLabel.setForeground(Color.CYAN);
		locationLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		locationLabel.setBounds(820, 101, 168, 36);
		thirdScreenFrame.getContentPane().add(locationLabel);
		locationLabel.setText("<html>" + crew.getPosition() + "<html/>");
		newLocation = locationLabel;

		createTabbedPanes(crew.getCrewList(), mainTabbedpane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		mainTabbedpane.addTab("Spaceship" ,null, panel, null);
		panel.setFont(new Font("OCR A Extended", Font.BOLD, 21));
		panel.setLayout(null);
		
		JLabel spaceshipNamelabel = new JLabel("Space Ship name:");
		spaceshipNamelabel.setForeground(Color.CYAN);
		spaceshipNamelabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		spaceshipNamelabel.setBounds(26, 0, 237, 73);
		panel.add(spaceshipNamelabel);
		
		JLabel lblGetSpaceshipName = new JLabel(crew.getshipName());
		lblGetSpaceshipName.setForeground(Color.RED);
		lblGetSpaceshipName.setFont(new Font("OCR A Extended", Font.BOLD, 21));
		lblGetSpaceshipName.setBounds(307, 2, 349, 73);
		panel.add(lblGetSpaceshipName);
		
		JLabel spaceShiphealthLabel = new JLabel((crew.getshipName() +"'s health:"));
		spaceShiphealthLabel.setForeground(Color.CYAN);
		spaceShiphealthLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		spaceShiphealthLabel.setBounds(31, 166, 379, 63);
		panel.add(spaceShiphealthLabel);
		
		shipHealthbar = new JProgressBar();
		shipHealthbar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(51, 255, 255)));
		shipHealthbar.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		shipHealthbar.setStringPainted(true);
		shipHealthbar.setString("100%");
		shipHealthbar.setForeground(Color.GREEN);
		shipHealthbar.setBounds(26, 237, 756, 41);
		panel.add(shipHealthbar);
		shipHealthbar.setValue(100);
		
		JLabel foodAvailableLabel = new JLabel("FOOD AVAILABLE");
		foodAvailableLabel.setForeground(Color.CYAN);
		foodAvailableLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		foodAvailableLabel.setBounds(44, 303, 202, 41);
		panel.add(foodAvailableLabel);
		
		JLabel medicineAvailablelabel = new JLabel("MEDICINES AVAILABLE");
		medicineAvailablelabel.setForeground(Color.CYAN);
		medicineAvailablelabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		medicineAvailablelabel.setBounds(473, 304, 266, 41);
		panel.add(medicineAvailablelabel);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_10.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblNewLabel_10.setBackground(Color.WHITE);
		lblNewLabel_10.setBounds(33, 350, 330, 246);
		panel.add(lblNewLabel_10);
		foodLabel = lblNewLabel_10;
		if (crew.getFoodListLength() > 0) {
			
			foodLabel.setText(crew.getFoodList().toString());

		}
		

			
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setBounds(475, 352, 287, 246);
		panel.add(label);
		medicineLabel = label;
		
		/**
		 * Rocket Image - https://www.shutterstock.com/video/clip-1009007789-rocket-on-black-background
		 * Fair use, satire 
		 */
		JLabel rocketImageLabel = new JLabel("");
		rocketImageLabel.setIcon(new ImageIcon(ThirdScreen.class.getResource("/image/rrr.png")));
		rocketImageLabel.setBounds(6, 56, 770, 101);
		panel.add(rocketImageLabel);
		if (crew.getmedicineListlength() > 0) {
			medicineLabel.setText(crew.getFoodList().toString());
		}
		
		JPanel pilotPanel = new JPanel();
		pilotPanel.setOpaque(false);
				pilotPanel.setBorder(null);
				mainTabbedpane.addTab("Pilot", null, pilotPanel, null);
				pilotPanel.setFont(new Font("OCR A Extended", Font.BOLD, 21));
				pilotPanel.setLayout(null);
				
				JLabel availableCrewlabel = new JLabel("Crew Members available to pilot ");
				availableCrewlabel.setForeground(Color.CYAN);
				availableCrewlabel.setFont(new Font("OCR A Extended", Font.BOLD, 22));
				availableCrewlabel.setBounds(12, 0, 547, 38);
				pilotPanel.add(availableCrewlabel);
				
				int count = 60; 
				for (CrewMember member1: crew.getCrewList()) {
				if (member1.getNumberOfActions()>0) {
				JRadioButton rdbtnNewRadioButton = new JRadioButton(member1.getName());
				rdbtnNewRadioButton.setFont(new Font("OCR A Extended", Font.BOLD, 19));
				rdbtnNewRadioButton.setForeground(Color.WHITE);
				rdbtnNewRadioButton.setOpaque(false);
				rdbtnNewRadioButton.setBorder(null);
				rdbtnNewRadioButton.setBounds(12, 44 + count, 272, 35);
				pilotPanel.add(rdbtnNewRadioButton);
				count += 40;
				radioButtonList.add(rdbtnNewRadioButton);
				}
				}
				
				/**
				 * Miller's Planet image - https://gfycat.com/thirdslipperyaardvark
				 * Fair use, satire 
				 */
				
				JButton millerButton = new JButton("");
				millerButton.setIcon(new ImageIcon(ThirdScreen.class.getResource("/image/mars.gif")));
				millerButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						for (JRadioButton button: radioButtonList) {
							if (button.isSelected()==true) {
								selectedNames.add(button.getText());
								
							}
							
							
						}
						
						if (nameSelector(selectedNames, crew.getCrewList()).size()>= 2 && ship.getShieldHealth()>5 && nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness()<80) {

							
							
							try {
								ge.pilot(nameSelector(selectedNames, crew.getCrewList()).get(0), nameSelector(selectedNames, crew.getCrewList()).get(1), crew.getPlanetPositiion(), planets.get(0), ge.getRandom());
							}
							catch(IllegalStateException err) {
								
								
								selectedNames.clear();
								JOptionPane.showMessageDialog(new JFrame(), err.getMessage());
								
								return;
							}

							
							shipHealthbar.setValue(ship.getShieldHealth());
							shipHealthbar.setString(ship.getShieldHealth() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness() + "%");
							
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness() + "%");
						
							
							crew.setPosition(planets.get(0).getName());
							crew.setPlanetPositiion(planets.get(0));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0)));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1)));
							nameSelector(selectedNames, crew.getCrewList()).clear();
							refreshLocationLabel();
							
						}
						else {
							if (ship.getShieldHealth()<=30) {
							JOptionPane.showMessageDialog(new JFrame(), "Ship needs reapiring!");
							}
							else if (nameSelector(selectedNames, crew.getCrewList()).size()< 2) {
							JOptionPane.showMessageDialog(new JFrame(), "Need to select more pilots");
						}
							else {
								pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(0));
								pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(1));
							}
						}
						selectedNames.clear();
						for (int k = 0; k<radioButtonList.size(); k++) {
							JRadioButton selectedButton = radioButtonList.get(k);
							if (selectedButton.isSelected()) {
								selectedButton.setSelected(false);
							}
						}
					}
				});
				millerButton.setBorder(null);
				millerButton.setBackground(Color.BLACK);
				millerButton.setBounds(30, 282, 151, 142);
				pilotPanel.add(millerButton);
				
				/**
				 * Cooper's Planet Image - https://giphy.com/explore/mercury
				 * Fair use, satire 
				 */
				JButton cooperbutton = new JButton("");
				cooperbutton.setIcon(new ImageIcon(ThirdScreen.class.getResource("/image/ezgif.com-resize (4).gif")));
				cooperbutton.setContentAreaFilled(false);;
				cooperbutton.setRolloverEnabled(false);
				cooperbutton.setOpaque(true);
				cooperbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (JRadioButton button: radioButtonList) {
							if (button.isSelected()==true) {
								selectedNames.add(button.getText());
							}
						}


						if (nameSelector(selectedNames, crew.getCrewList()).size()>= 2 && !((nameSelector(selectedNames, crew.getCrewList()).get(0).isEqual(nameSelector(selectedNames, crew.getCrewList()).get(1)))) && ship.getShieldHealth()>5 && nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness()<80) {
							try {
								ge.pilot(nameSelector(selectedNames, crew.getCrewList()).get(0), nameSelector(selectedNames, crew.getCrewList()).get(1), crew.getPlanetPositiion(), planets.get(1), ge.getRandom());
							}
							catch(IllegalStateException err) {
								selectedNames.clear();
								JOptionPane.showMessageDialog(new JFrame(), err.getMessage());
								
								return;
							}
							shipHealthbar.setValue(ship.getShieldHealth());
							shipHealthbar.setString(ship.getShieldHealth() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness() + "%");
							
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness() + "%");
						
							
							crew.setPosition(planets.get(1).getName());
							crew.setPlanetPositiion(planets.get(1));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0)));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1)));
							nameSelector(selectedNames, crew.getCrewList()).clear();
							selectedNames.clear();
							refreshLocationLabel();
													}
						else {
							if (ship.getShieldHealth()<=30) {
								JOptionPane.showMessageDialog(new JFrame(), "Ship needs reapiring!");
								}
							else if (nameSelector(selectedNames, crew.getCrewList()).size()< 2) {
								JOptionPane.showMessageDialog(new JFrame(), "Need to select more pilots");
							}
							else {
									pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(0));
									pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(1));
								}
							
						}
						selectedNames.clear();
						for (int k = 0; k<radioButtonList.size(); k++) {
							JRadioButton selectedButton = radioButtonList.get(k);
							if (selectedButton.isSelected()) {
								selectedButton.setSelected(false);
							}
						}

					}
				});
				cooperbutton.setBorder(null);
				cooperbutton.setBackground(Color.BLACK);
				cooperbutton.setBounds(255, 282, 144, 142);
				pilotPanel.add(cooperbutton);
				/**
				 * Lumbar's PLanet Image - https://imgur.com/gallery/5qVdq7K
				 * Fair use, satire 
				 */
				JButton lumbarButtton = new JButton("");
				lumbarButtton.setIcon(new ImageIcon(ThirdScreen.class.getResource("/image/cyb.gif")));
				lumbarButtton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (JRadioButton button: radioButtonList) {
							if (button.isSelected()==true) {
								selectedNames.add(button.getText());
							}
						}

						if (nameSelector(selectedNames, crew.getCrewList()).size()>=2 && !((nameSelector(selectedNames, crew.getCrewList()).get(0).isEqual(nameSelector(selectedNames, crew.getCrewList()).get(1)))) && ship.getShieldHealth()>5 && nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness()<80) {
							try {
								ge.pilot(nameSelector(selectedNames, crew.getCrewList()).get(0), nameSelector(selectedNames, crew.getCrewList()).get(1), crew.getPlanetPositiion(), planets.get(2), ge.getRandom());
							}
							catch(IllegalStateException err) {
								selectedNames.clear();
								JOptionPane.showMessageDialog(new JFrame(), err.getMessage());
								return;
							}
							shipHealthbar.setValue(ship.getShieldHealth());
							shipHealthbar.setString(ship.getShieldHealth() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness() + "%");
							
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness() + "%");
						
							
							crew.setPosition(planets.get(2).getName());
							crew.setPlanetPositiion(planets.get(2));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0)));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1)));
							nameSelector(selectedNames, crew.getCrewList()).clear();
							
							refreshLocationLabel();
						}
						else {
							if (ship.getShieldHealth()<=30) {
								JOptionPane.showMessageDialog(new JFrame(), "Ship needs reapiring!");
								}
							else if (nameSelector(selectedNames, crew.getCrewList()).size()< 2) {
								JOptionPane.showMessageDialog(new JFrame(), "Need to select more pilots");
							}	
							else {
									pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(0));
									pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(1));
								}
						}
						selectedNames.clear();
						for (int k = 0; k<radioButtonList.size(); k++) {
							JRadioButton selectedButton = radioButtonList.get(k);
							if (selectedButton.isSelected()) {
								selectedButton.setSelected(false);
							}
						}

					}
				});
				lumbarButtton.setBorder(null);
				lumbarButtton.setBackground(Color.BLACK);
				lumbarButtton.setBounds(460, 282, 147, 127);
				pilotPanel.add(lumbarButtton);
				/**
				 * Edmund's Planet Image - https://giphy.com/explore/jupiter
				 * Fair use, satire 
				 */
				JButton edmundButton = new JButton("");
				edmundButton.setIcon(new ImageIcon(ThirdScreen.class.getResource("/image/jup.gif")));
				edmundButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (JRadioButton button: radioButtonList) {
							if (button.isSelected()==true) {
								selectedNames.add(button.getText());
							}
						}

						if (nameSelector(selectedNames, crew.getCrewList()).size()>=2 && !((nameSelector(selectedNames, crew.getCrewList()).get(0).isEqual(nameSelector(selectedNames, crew.getCrewList()).get(1)))) && ship.getShieldHealth()>5 && nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness()<80) {
							try {
								ge.pilot(nameSelector(selectedNames, crew.getCrewList()).get(0), nameSelector(selectedNames, crew.getCrewList()).get(1), crew.getPlanetPositiion(), planets.get(3), ge.getRandom());
							}
							catch(IllegalStateException err) {
								selectedNames.clear();
								JOptionPane.showMessageDialog(new JFrame(), err.getMessage());
								return;
							}

							shipHealthbar.setValue(ship.getShieldHealth());
							shipHealthbar.setString(ship.getShieldHealth() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness() + "%");
							
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness() + "%");
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0)));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1)));
							refreshLocationLabel();
							
						}
						else  {
							if (ship.getShieldHealth()<=30) {
								JOptionPane.showMessageDialog(new JFrame(), "Ship needs reapiring!");
								}
							else if (nameSelector(selectedNames, crew.getCrewList()).size()< 2) {
								JOptionPane.showMessageDialog(new JFrame(), "Need to select more pilots");
							}	
							else {
									pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(0));
									pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(1));
								}
						}
						selectedNames.clear();
						for (int k = 0; k<radioButtonList.size(); k++) {
							JRadioButton selectedButton = radioButtonList.get(k);
							if (selectedButton.isSelected()) {
								selectedButton.setSelected(false);
							}
						}
					}
				});
				edmundButton.setBorder(null);
				edmundButton.setBackground(Color.BLACK);
				edmundButton.setBounds(30, 468, 151, 145);
				pilotPanel.add(edmundButton);
				/**
				 * Solaris Image- https://www.deviantart.com/bubblemaster/art/Purple-Planet-439450735 
				 * Fair use, satire 
				 */
				JButton solarisButton = new JButton("");
				solarisButton.setIcon(new ImageIcon(ThirdScreen.class.getResource("/image/ezgif.com-resize (7).gif")));
				solarisButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (JRadioButton button: radioButtonList) {
							if (button.isSelected()==true) {
								selectedNames.add(button.getText());
							}
						}


						if (nameSelector(selectedNames, crew.getCrewList()).size()>=2 && !((nameSelector(selectedNames, crew.getCrewList()).get(0).isEqual(nameSelector(selectedNames, crew.getCrewList()).get(1)))) && ship.getShieldHealth()>5 && nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness()<80) {
							
							try {
								ge.pilot(nameSelector(selectedNames, crew.getCrewList()).get(0), nameSelector(selectedNames, crew.getCrewList()).get(1), crew.getPlanetPositiion(), planets.get(4), ge.getRandom());
							}
							catch(IllegalStateException err) {
								selectedNames.clear();
								JOptionPane.showMessageDialog(new JFrame(), err.getMessage());
								return;
							}
							

							
							
							shipHealthbar.setValue(ship.getShieldHealth());
							shipHealthbar.setString(ship.getShieldHealth() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness() + "%");
							
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness() + "%");
							crew.setPosition(planets.get(4).getName());
							crew.setPlanetPositiion(planets.get(4));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0)));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1)));
							nameSelector(selectedNames, crew.getCrewList()).clear();
							refreshLocationLabel();
							
						}
						else  {
							if (ship.getShieldHealth()<=30) {
								JOptionPane.showMessageDialog(new JFrame(), "Ship needs reapiring!");
								}
							else if (nameSelector(selectedNames, crew.getCrewList()).size()< 2) {
								JOptionPane.showMessageDialog(new JFrame(), "Need to select more pilots");
							}	
							else {
									pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(0));
									pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(1));
								}
						}
						selectedNames.clear();
						for (int k = 0; k<radioButtonList.size(); k++) {
							JRadioButton selectedButton = radioButtonList.get(k);
							if (selectedButton.isSelected()) {
								selectedButton.setSelected(false);
							}
						}
					}
				});

				solarisButton.setBorder(null);
				solarisButton.setBackground(Color.BLACK);
				solarisButton.setBounds(247, 468, 152, 136);
				pilotPanel.add(solarisButton);
				/**
				 * Osaris Image - https://gifer.com/en/TLOm
				 * Fair use, satire 
				 */
				
				JButton osirisButton = new JButton("");
				osirisButton.setIcon(new ImageIcon(ThirdScreen.class.getResource("/image/moon.gif")));
				osirisButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (JRadioButton button: radioButtonList) {
							if (button.isSelected()==true) {
								selectedNames.add(button.getText());
							}
						}

						if (nameSelector(selectedNames, crew.getCrewList()).size()>=2 && !((nameSelector(selectedNames, crew.getCrewList()).get(0).isEqual(nameSelector(selectedNames, crew.getCrewList()).get(1)))) && ship.getShieldHealth()>5 && nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger()<80 && nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness()<80) {
							
							try {
								ge.pilot(nameSelector(selectedNames, crew.getCrewList()).get(0), nameSelector(selectedNames, crew.getCrewList()).get(1), crew.getPlanetPositiion(), planets.get(5), ge.getRandom());
							}
							catch(IllegalStateException err) {
								selectedNames.clear();
								JOptionPane.showMessageDialog(new JFrame(), err.getMessage());
								return;
							}

							shipHealthbar.setValue(ship.getShieldHealth());
							shipHealthbar.setString(ship.getShieldHealth() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0))).setString(nameSelector(selectedNames, crew.getCrewList()).get(0).getTiredness() + "%");
							
							
							
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setValue(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger());
							hungerBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getHunger() + "%");
							sleepBarList.get(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1))).setString(nameSelector(selectedNames, crew.getCrewList()).get(1).getTiredness() + "%");
						
							
							
							crew.setPlanetPositiion(planets.get(5));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(0)));
							refreshNumberOfActions(crew.getCrewList().indexOf(nameSelector(selectedNames, crew.getCrewList()).get(1)));
							
							refreshLocationLabel();
							
						}
						else{
							if (ship.getShieldHealth()<=30) {
								JOptionPane.showMessageDialog(new JFrame(), "Ship needs reapiring!");
								}
							else if (nameSelector(selectedNames, crew.getCrewList()).size()< 2) {
								JOptionPane.showMessageDialog(new JFrame(), "Need to select more pilots");
							}	
							else {
									pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(0));
									pilotCondition(nameSelector(selectedNames, crew.getCrewList()).get(1));
								}
						}
						selectedNames.clear();
						for (int k = 0; k<radioButtonList.size(); k++) {
							JRadioButton selectedButton = radioButtonList.get(k);
							if (selectedButton.isSelected()) {
								selectedButton.setSelected(false);
							}
						}
					}
				});
				osirisButton.setBorder(null);
				osirisButton.setBackground(Color.BLACK);
				osirisButton.setBounds(459, 466, 152, 136);
				pilotPanel.add(osirisButton);
				
				JLabel MillersPlanet = new JLabel("Miller's Planet");
				MillersPlanet.setBorder(null);
				MillersPlanet.setForeground(Color.CYAN);
				MillersPlanet.setHorizontalAlignment(SwingConstants.CENTER);
				MillersPlanet.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
				MillersPlanet.setBounds(12, 250, 169, 28);
				pilotPanel.add(MillersPlanet);
				
				JLabel lblCoopersPlanet = new JLabel("Cooper's Planet");
				lblCoopersPlanet.setBorder(null);
				lblCoopersPlanet.setForeground(Color.CYAN);
				lblCoopersPlanet.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
				lblCoopersPlanet.setHorizontalAlignment(SwingConstants.CENTER);
				lblCoopersPlanet.setBounds(247, 251, 152, 28);
				pilotPanel.add(lblCoopersPlanet);
				
				JLabel lblLumbarsPlanet = new JLabel("Lumbar's Planet");
				lblLumbarsPlanet.setBorder(null);
				lblLumbarsPlanet.setForeground(Color.CYAN);
				lblLumbarsPlanet.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
				lblLumbarsPlanet.setBounds(460, 251, 161, 28);
				pilotPanel.add(lblLumbarsPlanet);
				
				JLabel lblEdmundsPlanet = new JLabel("Edmund's Planet");
				lblEdmundsPlanet.setForeground(Color.CYAN);
				lblEdmundsPlanet.setBorder(null);
				lblEdmundsPlanet.setHorizontalAlignment(SwingConstants.CENTER);
				lblEdmundsPlanet.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
				lblEdmundsPlanet.setBounds(12, 436, 169, 28);
				pilotPanel.add(lblEdmundsPlanet);
				
				JLabel lblSolaris = new JLabel("Solaris");
				lblSolaris.setBorder(null);
				lblSolaris.setForeground(Color.CYAN);
				lblSolaris.setHorizontalAlignment(SwingConstants.CENTER);
				lblSolaris.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
				lblSolaris.setBounds(254, 436, 132, 28);
				pilotPanel.add(lblSolaris);
				
				JLabel lblOsaris = new JLabel("Osiris");
				lblOsaris.setForeground(Color.CYAN);
				lblOsaris.setBorder(null);
				lblOsaris.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
				lblOsaris.setHorizontalAlignment(SwingConstants.CENTER);
				lblOsaris.setBounds(469, 431, 132, 28);
				pilotPanel.add(lblOsaris);
				
				JLabel pilotInfoLabel = new JLabel("(Only the first two selected members will be the pilots)");
				pilotInfoLabel.setForeground(Color.RED);
				pilotInfoLabel.setFont(new Font("OCR A Extended", Font.ITALIC, 16));
				pilotInfoLabel.setBounds(12, 29, 595, 38);
				pilotPanel.add(pilotInfoLabel);
				

	}
				
					
	/**
	 *  This method iterates over the crew member selected by the player and creates their panes according to the generic layout. 
	 * @param crewList
	 * @param tabbedPane
	 */
	public void createTabbedPanes(ArrayList <CrewMember> crewList, JTabbedPane tabbedPane) { 
		
		for (CrewMember member: crewList) {
			
			JPanel crewPanel = new JPanel();
			crewPanel.setOpaque(false);

			crewPanel.setBackground(Color.BLACK);
			tabbedPane.addTab(member.getName(), null, crewPanel, null); 

			crewPanel.setForeground(Color.YELLOW);
			crewPanel.setLayout(null);
			
				
				hungerbar = new JProgressBar();
				hungerbar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 255, 255)));
				hungerbar.setValue(0);
				
				hungerbar.setStringPainted(true);
				hungerbar.setString("0%");
				hungerbar.setForeground(Color.RED);
				hungerbar.setBounds(233, 323, 422, 25);
				crewPanel.add(hungerbar);
				hungerBarList.add(hungerbar);
				
				
				JButton eat = new JButton("EAT");
				eat.setOpaque(false);
				eat.setContentAreaFilled(false);
				eat.setBorderPainted(true);
				eat.setFont(new Font("OCR A Extended", Font.BOLD, 18));
				eat.setForeground(Color.WHITE);
				eat.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 255, 255)));
						eat.setBounds(12, 529, 124, 33);
						crewPanel.add(eat);
						eat.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								launchscreen(member);
								
							}
						});
						
						

						sleepbar = new JProgressBar();
						sleepbar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 255, 255)));
						
						sleepbar.setValue(0);
						sleepbar.setStringPainted(true);
						sleepbar.setString("0%");
						sleepbar.setForeground(Color.RED);
						sleepbar.setBounds(235, 424, 420, 25);
						crewPanel.add(sleepbar);
						sleepBarList.add(sleepbar);
						
						JProgressBar progressBar = new JProgressBar();
						progressBar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 255, 255)));
						progressBar.setString("100%");
						progressBar.setStringPainted(true);
						progressBar.setForeground(Color.GREEN);
						progressBar.setBounds(232, 232, 423, 25);
						crewPanel.add(progressBar);
						progressBar.setValue(100);
						healthBarList.add(progressBar);
						
						/**
						 * Sleep sound - http://soundbible.com/1634-Snoring.html
						 */
						JButton sleep = new JButton("SLEEP");
						sleep.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
								if (member.getNumberOfActions()==0) { 
									showTheMessage();
									}
								if (member.getNumberOfActions()>0) {
									try {
								    	InputStream wavFile = Sound.class.getResourceAsStream("/image/Snoring-Popup_Pixels-869228912.wav");
								    	InputStream bufferedIn = new BufferedInputStream(wavFile);
								    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
								    	
								        Clip clip = AudioSystem.getClip();
								        clip.open(audioStream);
								        clip.start();
									
								    	
									} catch(Exception ee){}
								ge.sleep(member);
								sleepBarList.get(crewList.indexOf(member)).setValue(member.getTiredness());
								refreshNumberOfActions(crewList.indexOf(member));
								sleepBarList.get(crewList.indexOf(member)).setString(member.getTiredness() + "%");
								}
								else {
									if (member.getNumberOfActions()<=0) {
									}
									
								}
							}
						});
						sleep.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(51, 255, 255)));
						sleep.setForeground(Color.WHITE);
						sleep.setOpaque(false);
						sleep.setContentAreaFilled(false);
						sleep.setFont(new Font("OCR A Extended", Font.BOLD, 18));
						sleep.setBounds(192, 529, 118, 33);
						crewPanel.add(sleep);
						
						/**
						 * Repair sound - http://soundbible.com
						 */
						JButton repair = new JButton("REPAIR");
						repair.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (member.getNumberOfActions()>0) {
									
									
									try {
								    	InputStream wavFile = Sound.class.getResourceAsStream("/image/repair.wav");
								    	InputStream bufferedIn = new BufferedInputStream(wavFile);
								    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
								    	
								        Clip clip = AudioSystem.getClip();
								        clip.open(audioStream);
								        clip.start();
									
								    	
									} catch(Exception m){}
								ge.repair(member, ship);
								sleepBarList.get(crewList.indexOf(member)).setValue(member.getTiredness());
								hungerBarList.get(crewList.indexOf(member)).setValue(member.getHunger());
								hungerBarList.get(crewList.indexOf(member)).setString(member.getHunger() + "%");
								sleepBarList.get(crewList.indexOf(member)).setString(member.getTiredness() + "%");
								shipHealthbar.setValue(ship.getShieldHealth());
								shipHealthbar.setString(ship.getShieldHealth() + "%");
								refreshNumberOfActions(crewList.indexOf(member));
								}
							else{
								
								if (member.getNumberOfActions()==0) { 
								showTheMessage();
								}
								else if (member.getHunger()>=80 && member.getTiredness()>=80) {
									JOptionPane.showMessageDialog(new JFrame(), member.getName()+ " needs food and sleep!");
								}
								else if (member.getHunger()>=80) {
									JOptionPane.showMessageDialog(new JFrame(), member.getName()+" needs food!");
								}
								else if (member.getTiredness()>=80) {
									JOptionPane.showMessageDialog(new JFrame(), member.getName()+" needs sleep!");
								}
							}}}
						);
						repair.setForeground(Color.WHITE);
						repair.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(51, 255, 255)));
						repair.setOpaque(false);
						repair.setContentAreaFilled(false);
						repair.setBorderPainted(true);
						repair.setFont(new Font("OCR A Extended", Font.BOLD, 18));
						repair.setBounds(381, 529, 118, 33);
						crewPanel.add(repair);
						
							
						/**
						 * Search Sound - https://www.zedge.net/find/ringtones/pink%20panther
						 * Fair use, satire
						 */
							JButton search = new JButton("SEARCH");
							search.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									if (member.getNumberOfActions()>0) {
										
																				
											try {
										    	InputStream wavFile = Sound.class.getResourceAsStream("/image/search.wav");
										    	InputStream bufferedIn = new BufferedInputStream(wavFile);
										    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
										    	
										        Clip clip = AudioSystem.getClip();
										        clip.open(audioStream);
										        clip.start();
											
										    	
											} catch(Exception n){}
										
											
									ge.getRandom().affectPlanet();	
									if (ge.searchPlanet(member, crew.getPosition())){
										refreshScorelabel();
									};
									if (crew.getNumberOfpartsFound() == ge.getNumberOfPartsreq()) {
										JOptionPane.showMessageDialog(new JFrame(), "Game Over, Yay!");
										ge.setGameWon(true);
										thirdScreenFrame.dispose();
										launchfinalscreen();
									}
									sleepBarList.get(crewList.indexOf(member)).setValue(member.getTiredness());
									hungerBarList.get(crewList.indexOf(member)).setValue(member.getHunger());
									hungerBarList.get(crewList.indexOf(member)).setString(member.getHunger() + "%");
									sleepBarList.get(crewList.indexOf(member)).setString(member.getTiredness() + "%");
									refreshFoodList();
									refreshMoney();
									refreshMedicineList();
									refreshFoodList();
									refreshNumberOfActions(crewList.indexOf(member));
									refreshPartsLabel();
									}
									else {
										if (member.getNumberOfActions()==0) { 
											showTheMessage();}
											
											else if (member.getHunger()>=80 && member.getTiredness()>=80) {
												JOptionPane.showMessageDialog(new JFrame(), member.getName()+ "needs food and sleep!");
											}
											else if (member.getHunger()>=80) {
										
												JOptionPane.showMessageDialog(new JFrame(), member.getName()+" needs food!");
											}
											else if (member.getTiredness()>=80) {
												JOptionPane.showMessageDialog(new JFrame(), member.getName()+" needs sleep!");
											}
									}
								}
							});
						
										search.setForeground(Color.WHITE);
										search.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(51, 255, 255)));
										search.setOpaque(false);
										search.setContentAreaFilled(false);
										search.setBorderPainted(true);
										search.setFont(new Font("OCR A Extended", Font.BOLD, 18));
										search.setBounds(565, 529, 126, 33);
										crewPanel.add(search);
										
										JLabel lblHealth = new JLabel("Health :");
										lblHealth.setForeground(Color.CYAN);
										lblHealth.setFont(new Font("OCR A Extended", Font.BOLD, 20));
										lblHealth.setBounds(23, 216, 118, 65);
										crewPanel.add(lblHealth);
										
										
										
										JLabel typeLabel = new JLabel("Type : ");
										typeLabel.setForeground(Color.WHITE);
										typeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 17));
										typeLabel.setBounds(192, 33, 323, 58);
										typeLabel.setText(member.getType());
										crewPanel.add(typeLabel);
										
										JLabel lblSpecialPower = new JLabel("Special Power : ");
										lblSpecialPower.setForeground(new Color(255, 255, 255));
										lblSpecialPower.setBounds(191, 127, 587, 58);
										crewPanel.add(lblSpecialPower);
										lblSpecialPower.setText("<html>" + member.getPower()+ "<br>");
										lblSpecialPower.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
										
										JLabel lblHunger = new JLabel("Hunger:");
										lblHunger.setForeground(Color.CYAN);
										lblHunger.setFont(new Font("OCR A Extended", Font.BOLD, 20));
										lblHunger.setBounds(25, 302, 149, 65);
										crewPanel.add(lblHunger);
										
										JLabel lblTierdness = new JLabel("Tiredness:");
										lblTierdness.setForeground(Color.CYAN);
										
										lblTierdness.setBounds(27, 398, 147, 65);
										crewPanel.add(lblTierdness);
										lblTierdness.setFont(new Font("OCR A Extended", Font.BOLD, 20));
										
										JLabel numberOfActionsLabel = new JLabel("Number of actions remaining: " + member.getNumberOfActions());
										numberOfActionsLabel.setForeground(new Color(255, 0, 0));
										numberOfActionsLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
										numberOfActionsLabel.setBounds(381, 1, 400, 40);
										crewPanel.add(numberOfActionsLabel);
										labelList.add(numberOfActionsLabel);
										
										JLabel powerLabel = new JLabel("Special Power:");
										powerLabel.setForeground(Color.CYAN);
										powerLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
										powerLabel.setBounds(12, 125, 181, 58);
										crewPanel.add(powerLabel);
										
										JLabel crewTypeLabel = new JLabel("Type:");
										crewTypeLabel.setVisible(true);
										crewTypeLabel.setForeground(Color.CYAN);
										crewTypeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
										crewTypeLabel.setBounds(12, 25, 124, 65);
										crewPanel.add(crewTypeLabel);

			

}

	}
	}


