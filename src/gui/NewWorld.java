package gui;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import gameengine.GameEnvironment;
import items.AlienGrubs;
import items.CalceraPhos400;
import items.KalaxianCrystals;
import items.NZT48;
import items.NeutrinoBombs;
import items.Popplers;
import items.R89;
import items.Spaceettios;
import items.StrawberrySmiggles;
import sound.Sound;
import units.Crew;

import javax.swing.border.BevelBorder;
/**
 * The space outpost screen of the game.
 *
 */
public class NewWorld {

	private JFrame frmNewWorld;
	private JTextField csrystalsTextField;
	private JTextField grubsTextField;
	private JTextField spaceTextField;
	private JTextField PopplersTextField;
	private JTextField smigglesTextField;
	private JTextField BombsTextField;
	private JTextField calceraTextField;
	private JTextField nztTextField;
	private JTextField r89TextField;
	private Crew crew;
	private  GameEnvironment game;
	private ThirdScreen screen;
	int quantity;
	
	
	NewWorld(GuiManager incommingmanager, Crew crew, GameEnvironment game, ThirdScreen screen){
		this.crew = crew;
		this.game = game;
		this.screen = screen;
		initialize();
		frmNewWorld.setVisible(true);
		
	}
	/**
	 * closes Window.
	 */
	public void closeWindow() {
		frmNewWorld.dispose();
	}
	

	/**
	 * Create the application.
	 */
	public NewWorld() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewWorld = new JFrame();
		frmNewWorld.setResizable(false);
		frmNewWorld.getContentPane().setBackground(Color.BLACK);
		frmNewWorld.setTitle("Space Outpost ");
		frmNewWorld.setBounds(100, 100, 1000, 800);
		frmNewWorld.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnLeaveSpaceOutpost = new JButton("<<<<<-Leave Space outpost ");
		btnLeaveSpaceOutpost.setFocusable(false);
		btnLeaveSpaceOutpost.setFocusPainted(false);
		btnLeaveSpaceOutpost.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.CYAN, Color.GREEN, Color.CYAN, Color.GREEN));
		btnLeaveSpaceOutpost.setBounds(12, 702, 293, 38);
		btnLeaveSpaceOutpost.setOpaque(false);
		btnLeaveSpaceOutpost.setBackground(Color.WHITE);
		btnLeaveSpaceOutpost.setForeground(Color.RED);
		btnLeaveSpaceOutpost.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		btnLeaveSpaceOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closeWindow();
			}
		});
		frmNewWorld.getContentPane().setLayout(null);
		frmNewWorld.getContentPane().add(btnLeaveSpaceOutpost);
		
		/**
		 * Kalaxian Crystals - https://rickandmorty.fandom.com/wiki/Kalaxian_Crystals
		 */
		JLabel kalaxianLabel = new JLabel("crystals");
		kalaxianLabel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		kalaxianLabel.setToolTipText("Reduces the hunger by 40 points ");
		kalaxianLabel.setIcon(new ImageIcon(NewWorld.class.getResource("/image/63aa5ff9ac06d003d90dff41f6d798be--hama-perler-perler-beads.jpg")));
		kalaxianLabel.setBounds(188, 206, 79, 57);
		frmNewWorld.getContentPane().add(kalaxianLabel);
		
		/**
		 * Alien Grubs image - https://www.pinterest.nz/pin/548876273311715274/?lp=true
		 */
		
		JLabel alienLabel = new JLabel("grubs");
		alienLabel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		alienLabel.setToolTipText("Reduces the hunger by 45 points ");
		alienLabel.setIcon(new ImageIcon(NewWorld.class.getResource("/image/CHvnENMWgAAJDVy.png")));
		alienLabel.setBounds(188, 288, 79, 57);
		frmNewWorld.getContentPane().add(alienLabel);
		/**
		 * CalceraPhos400 - https://www.stockunlimited.com/similar/1268416.html
		 */
		
		JLabel calceraLabels = new JLabel("calcera");
		calceraLabels.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		calceraLabels.setToolTipText("Increases your health by 40 points");
		calceraLabels.setIcon(new ImageIcon(NewWorld.class.getResource("/image/cpasulesfff.jpg")));
		calceraLabels.setBounds(693, 307, 79, 57);
		frmNewWorld.getContentPane().add(calceraLabels);
		
		/**
		 * Spacettios Image - https://www.digitaltrends.com/social-media/spaghettios-pearl-harbor-tweet-sparks-backlash-company-apologizes/
		 */
		
		JLabel spacettiosLabel = new JLabel("berry");
		spacettiosLabel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		spacettiosLabel.setToolTipText("Reduces the hunger by 50 points ");
		spacettiosLabel.setIcon(new ImageIcon(NewWorld.class.getResource("/image/img_0978.jpg")));
		spacettiosLabel.setBounds(188, 358, 79, 57);
		frmNewWorld.getContentPane().add(spacettiosLabel);
		/**
		 * R89 image - https://www.pinterest.nz/pin/536421005606950099/?lp=true
		 */
		
		JLabel r89Labels = new JLabel("r89");
		r89Labels.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		r89Labels.setToolTipText("Increases your health by 70 points");
		r89Labels.setIcon(new ImageIcon(NewWorld.class.getResource("/image/r89ff.PNG")));
		r89Labels.setBounds(693, 213, 79, 57);
		frmNewWorld.getContentPane().add(r89Labels);
		
		/**
		 * Poppler's Image - https://futurama.fandom.com/wiki/Popplers
		 */
		
		JLabel popplersLabel = new JLabel("popplers");
		popplersLabel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		popplersLabel.setToolTipText("Reduces the hunger by 20 points ");
		popplersLabel.setIcon(new ImageIcon(NewWorld.class.getResource("/image/popplers.PNG")));
		popplersLabel.setBounds(188, 428, 79, 57);
		frmNewWorld.getContentPane().add(popplersLabel);
		
		/**
		 * NZT48 image - https://www.stockunlimited.com/similar/1268429.html
		 */
		JLabel nzt48Labels = new JLabel("NZt48");
		nzt48Labels.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		nzt48Labels.setToolTipText("Cures the space plague and increases health by 60 points");
		nzt48Labels.setIcon(new ImageIcon(NewWorld.class.getResource("/image/syringe.PNG")));
		nzt48Labels.setBounds(693, 428, 79, 57);
		frmNewWorld.getContentPane().add(nzt48Labels);
		
		/**
		 * Strawberry Smiggles Image - https://www.pinterest.nz/pin/553872454166723491/?lp=true
		 */
		
		JLabel strawberryLabel = new JLabel("New label");
		strawberryLabel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		strawberryLabel.setToolTipText("Reduces the hunger by 25 points ");
		strawberryLabel.setIcon(new ImageIcon(NewWorld.class.getResource("/image/berry.jpg")));
		strawberryLabel.setBounds(188, 514, 79, 57);
		frmNewWorld.getContentPane().add(strawberryLabel);
		
		/**
		 * NutrenoBombs Image - https://www.shutterstock.com/es/search/food+bomb?searchterm=scale+obesity&search_source=base_related_searches&section=1&ref_context=keyword
		 */
		
		JLabel nutrenoBombslabel = new JLabel("Nutreno");
		nutrenoBombslabel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		nutrenoBombslabel.setToolTipText("Reduces the hunger by 70 points ");
		nutrenoBombslabel.setIcon(new ImageIcon(NewWorld.class.getResource("/image/Capture.PNG")));
		nutrenoBombslabel.setBounds(188, 584, 79, 57);
		frmNewWorld.getContentPane().add(nutrenoBombslabel);
		
		JLabel crystalsPricelbl = new JLabel("$50");
		crystalsPricelbl.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		crystalsPricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		crystalsPricelbl.setForeground(Color.WHITE);
		crystalsPricelbl.setBounds(279, 213, 79, 43);
		frmNewWorld.getContentPane().add(crystalsPricelbl);
		
		JLabel grubspricelbl = new JLabel("$60");
		grubspricelbl.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		grubspricelbl.setForeground(Color.WHITE);
		grubspricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		grubspricelbl.setBounds(279, 295, 79, 43);
		frmNewWorld.getContentPane().add(grubspricelbl);
		
		JLabel spaceittosPricelbl = new JLabel("$70");
		spaceittosPricelbl.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		spaceittosPricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		spaceittosPricelbl.setForeground(Color.WHITE);
		spaceittosPricelbl.setBounds(279, 372, 79, 43);
		frmNewWorld.getContentPane().add(spaceittosPricelbl);
		
		JLabel popplersPricelbl = new JLabel("$25");
		popplersPricelbl.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		popplersPricelbl.setForeground(Color.WHITE);
		popplersPricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		popplersPricelbl.setBounds(279, 435, 79, 43);
		frmNewWorld.getContentPane().add(popplersPricelbl);
		
		JLabel smigglesPricelbl = new JLabel("$30");
		smigglesPricelbl.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		smigglesPricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		smigglesPricelbl.setForeground(Color.WHITE);
		smigglesPricelbl.setBounds(279, 521, 79, 43);
		frmNewWorld.getContentPane().add(smigglesPricelbl);
		
		JLabel nutrinoPriceLbl = new JLabel("$100");
		nutrinoPriceLbl.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		nutrinoPriceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nutrinoPriceLbl.setForeground(Color.WHITE);
		nutrinoPriceLbl.setBounds(279, 591, 79, 43);
		frmNewWorld.getContentPane().add(nutrinoPriceLbl);
		
		JLabel r89Pricelbl = new JLabel("$60");
		r89Pricelbl.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		r89Pricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		r89Pricelbl.setForeground(Color.WHITE);
		r89Pricelbl.setBounds(771, 211, 66, 43);
		frmNewWorld.getContentPane().add(r89Pricelbl);
		
		JLabel calcerPhospricelbl = new JLabel("$50");
		calcerPhospricelbl.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		calcerPhospricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		calcerPhospricelbl.setForeground(Color.WHITE);
		calcerPhospricelbl.setBounds(771, 312, 66, 43);
		frmNewWorld.getContentPane().add(calcerPhospricelbl);
		
		JLabel nztPricelbl = new JLabel("$75");
		nztPricelbl.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		nztPricelbl.setForeground(Color.WHITE);
		nztPricelbl.setHorizontalAlignment(SwingConstants.CENTER);
		nztPricelbl.setBounds(784, 425, 54, 43);
		frmNewWorld.getContentPane().add(nztPricelbl);
		
		JLabel lblKalaxianCrystals = new JLabel("Kalaxian");
		lblKalaxianCrystals.setForeground(Color.WHITE);
		lblKalaxianCrystals.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblKalaxianCrystals.setToolTipText("");
		lblKalaxianCrystals.setBounds(12, 215, 164, 37);
		frmNewWorld.getContentPane().add(lblKalaxianCrystals);
		
		JLabel lblAlienGrubs = new JLabel("Alien Grubs");
		lblAlienGrubs.setForeground(Color.WHITE);
		lblAlienGrubs.setToolTipText("");
		lblAlienGrubs.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblAlienGrubs.setBounds(12, 308, 164, 37);
		frmNewWorld.getContentPane().add(lblAlienGrubs);
		
		JLabel lblSpaceettios = new JLabel("SpaceettiO's");
		lblSpaceettios.setForeground(Color.WHITE);
		lblSpaceettios.setToolTipText("");
		lblSpaceettios.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblSpaceettios.setBounds(12, 378, 164, 37);
		frmNewWorld.getContentPane().add(lblSpaceettios);
		
		JLabel lblPopplers = new JLabel("Popplers");
		lblPopplers.setForeground(Color.WHITE);
		lblPopplers.setToolTipText("");
		lblPopplers.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblPopplers.setBounds(12, 448, 164, 37);
		frmNewWorld.getContentPane().add(lblPopplers);
		
		JLabel lblStrawberrySmiggles = new JLabel("Strawberry");
		lblStrawberrySmiggles.setForeground(Color.WHITE);
		lblStrawberrySmiggles.setToolTipText("");
		lblStrawberrySmiggles.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblStrawberrySmiggles.setBounds(12, 514, 164, 37);
		frmNewWorld.getContentPane().add(lblStrawberrySmiggles);
		
		JLabel lblNeutrinoBombs = new JLabel("Neutrino Bombs");
		lblNeutrinoBombs.setForeground(Color.WHITE);
		lblNeutrinoBombs.setToolTipText("");
		lblNeutrinoBombs.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblNeutrinoBombs.setBounds(12, 604, 164, 37);
		frmNewWorld.getContentPane().add(lblNeutrinoBombs);
		
		JLabel lblR = new JLabel("R89");
		lblR.setForeground(Color.WHITE);
		lblR.setToolTipText("");
		lblR.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblR.setBounds(597, 226, 54, 37);
		frmNewWorld.getContentPane().add(lblR);
		
		JLabel lblCalceraPhos = new JLabel("Calcera");
		lblCalceraPhos.setForeground(Color.WHITE);
		lblCalceraPhos.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblCalceraPhos.setBounds(581, 308, 100, 37);
		frmNewWorld.getContentPane().add(lblCalceraPhos);
		
		JLabel lblNzt = new JLabel("NZT-48");
		lblNzt.setForeground(Color.WHITE);
		lblNzt.setToolTipText("");
		lblNzt.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblNzt.setBounds(597, 436, 71, 37);
		frmNewWorld.getContentPane().add(lblNzt);
		
		JLabel outpostLbl = new JLabel("           New World");
		outpostLbl.setForeground(Color.RED);
		outpostLbl.setFont(new Font("OCR A Extended", Font.BOLD, 38));
		outpostLbl.setBounds(147, 0, 691, 57);
		frmNewWorld.getContentPane().add(outpostLbl);
		
		JLabel itemsLbl = new JLabel("   Food Items ");
		itemsLbl.setBackground(Color.BLACK);
		itemsLbl.setForeground(Color.CYAN);
		itemsLbl.setFont(new Font("OCR A Extended", Font.BOLD, 31));
		itemsLbl.setBounds(25, 113, 356, 66);
		frmNewWorld.getContentPane().add(itemsLbl);
		
		JLabel lblMedicines = new JLabel("      Medicines");
		lblMedicines.setForeground(Color.CYAN);
		lblMedicines.setFont(new Font("OCR A Extended", Font.BOLD, 32));
		lblMedicines.setBounds(541, 113, 356, 66);
		frmNewWorld.getContentPane().add(lblMedicines);
		
		JLabel infoLbl = new JLabel("*Hover the pointer tover the food/medicine image to know more about the product.");
		infoLbl.setForeground(Color.WHITE);
		infoLbl.setFont(new Font("Tahoma", Font.ITALIC, 14));
		infoLbl.setBounds(349, 724, 626, 16);
		frmNewWorld.getContentPane().add(infoLbl);
		
		csrystalsTextField = new JTextField();
		csrystalsTextField.setBounds(378, 223, 30, 22);
		frmNewWorld.getContentPane().add(csrystalsTextField);
		csrystalsTextField.setColumns(10);
		
		grubsTextField = new JTextField();
		grubsTextField.setColumns(10);
		grubsTextField.setBounds(378, 305, 30, 22);
		frmNewWorld.getContentPane().add(grubsTextField);
		
		spaceTextField = new JTextField();
		spaceTextField.setColumns(10);
		spaceTextField.setBounds(378, 375, 30, 22);
		frmNewWorld.getContentPane().add(spaceTextField);
		
		PopplersTextField = new JTextField();
		PopplersTextField.setColumns(10);
		PopplersTextField.setBounds(378, 445, 30, 22);
		frmNewWorld.getContentPane().add(PopplersTextField);
		
		smigglesTextField = new JTextField();
		smigglesTextField.setColumns(10);
		smigglesTextField.setBounds(378, 531, 30, 22);
		frmNewWorld.getContentPane().add(smigglesTextField);
		
		BombsTextField = new JTextField();
		BombsTextField.setColumns(10);
		BombsTextField.setBounds(378, 595, 30, 22);
		frmNewWorld.getContentPane().add(BombsTextField);
		
		calceraTextField = new JTextField();
		calceraTextField.setColumns(10);
		calceraTextField.setBounds(849, 323, 30, 22);
		frmNewWorld.getContentPane().add(calceraTextField);
		
		nztTextField = new JTextField();
		nztTextField.setColumns(10);
		nztTextField.setBounds(850, 437, 30, 22);
		frmNewWorld.getContentPane().add(nztTextField);
		
		JLabel messageLabel = new JLabel("            ");
		messageLabel.setVerticalTextPosition(SwingConstants.TOP);
		messageLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		messageLabel.setForeground(Color.RED);
		messageLabel.setBounds(578, 521, 397, 157);
		frmNewWorld.getContentPane().add(messageLabel);
		
		JLabel lblNewLabel_7 = new JLabel("$1000");
		lblNewLabel_7.setFont(new Font("OCR A Extended", Font.PLAIN, 30));
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(12, 13, 139, 66);
		frmNewWorld.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setText("$" +Integer.toString(crew.getMoney()));
		
		
		JButton kalaxianButton = new JButton("Buy");
		kalaxianButton.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		kalaxianButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		kalaxianButton.setForeground(Color.GREEN);
		kalaxianButton.setOpaque(false);
		kalaxianButton.setBackground(Color.YELLOW);
		kalaxianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				quantity = Integer.parseInt(csrystalsTextField.getText());
				}
				catch(NumberFormatException err){
					messageLabel.setText("Please enter valid integer");
					return;
				}
				KalaxianCrystals crystals = new KalaxianCrystals(quantity);
				if (crew.getMoney() >= crystals.getPrice() * crystals.getQuantity() && quantity >0) {
					

					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/cash_reg.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception n){}
				
				game.buyItems(crystals, crystals.getQuantity());
				screen.refreshFoodList();
				screen.refreshMoney();
				lblNewLabel_7.setText("$" + Integer.toString(crew.getMoney()));
				messageLabel.setText("<html>" + Integer.toString(crew.getFoodItem("Kalaxian Crystals").getQuantity())+ " Kalaxian Crystals have been <br>added to the ship stock");// if dont have enough money then display that we are out of money.
				

				}	
				else if(quantity <=0) {
					messageLabel.setText("Please enter a valid input!!");
				}
				else if (crew.getMoney() <= 0){
					messageLabel.setText("You dont have enough money");
				}
				else {
					messageLabel.setText("<html> Too many items,<br> you need more money!!</html>");
				}
			}
		});
		kalaxianButton.setBounds(429, 222, 96, 30);
		frmNewWorld.getContentPane().add(kalaxianButton);
		
		JButton grubsButton = new JButton("Buy");
		grubsButton.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		grubsButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		grubsButton.setForeground(Color.GREEN);
		grubsButton.setOpaque(false);
		grubsButton.setBackground(Color.YELLOW);
		grubsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					quantity = Integer.parseInt(grubsTextField.getText());
					}
					catch(NumberFormatException err){
						messageLabel.setText("Please enter valid integer");
						return;
					}
				AlienGrubs grubs = new AlienGrubs(quantity);
				if (crew.getMoney() >= grubs.getPrice() * grubs.getQuantity() && quantity >0) {
					
					

					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/cash_reg.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception n){}
					game.buyItems(grubs, grubs.getQuantity());
					screen.refreshFoodList();
					screen.refreshMoney();
					messageLabel.setText("<html>" + Integer.toString(crew.getFoodItem("Alien Grubs").getQuantity())+"\n"+" Alien Grubs have been <br>added to the ship stock");// if dont have enough money then display that we are out of money.
					lblNewLabel_7.setText("$" + Integer.toString(crew.getMoney()));

					}	
				else if(quantity <=0) {
					messageLabel.setText("         Please enter a valid input!!");
				}
					else if (crew.getMoney() <= 0){
						messageLabel.setText("         You dont have enough money");
					}
					else {
						messageLabel.setText("         Too many Items, you need more money!!");
					}
			}
				
		});
		grubsButton.setBounds(429, 299, 96, 30);
		frmNewWorld.getContentPane().add(grubsButton);
		
		JLabel lblPhos = new JLabel("Phos400");
		lblPhos.setForeground(Color.WHITE);
		lblPhos.setToolTipText("");//have to fill this 
		lblPhos.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblPhos.setBounds(581, 339, 100, 37);
		frmNewWorld.getContentPane().add(lblPhos);
		
		JButton spacettiosButton = new JButton("Buy");
		spacettiosButton.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		spacettiosButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		spacettiosButton.setForeground(Color.GREEN);
		spacettiosButton.setOpaque(false);
		spacettiosButton.setBackground(Color.YELLOW);
		spacettiosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					quantity = Integer.parseInt(spaceTextField.getText());
					}
					catch(NumberFormatException err){
						messageLabel.setText("Please enter valid integer");
						return;
					}
				Spaceettios crystals = new Spaceettios(quantity);
				if (crew.getMoney() >= crystals.getPrice() * crystals.getQuantity() && quantity >0) {
					
					

					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/cash_reg.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception n){}
					game.buyItems(crystals, crystals.getQuantity());
					screen.refreshFoodList();
					screen.refreshMoney();
					messageLabel.setText("<html>" + Integer.toString(crew.getFoodItem("SpaceettiO's").getQuantity())+"\n"+ " SpaceettiO's have been <br>added to the ship stock" );// if dont have enough money then display that we are out of money.
					lblNewLabel_7.setText("$" + Integer.toString(crew.getMoney()));

					}	
				else if(quantity <=0) {
					messageLabel.setText("Please enter a valid input!!");
				}
					else if (crew.getMoney() <= 0){
						messageLabel.setText("You dont have enough money");
					}
					else {
						messageLabel.setText("Too many Items, you need more money!!");
					}
				}

			}
		);
		spacettiosButton.setBounds(429, 374, 96, 25);
		frmNewWorld.getContentPane().add(spacettiosButton);
		
		JButton poplersButton = new JButton("Buy");
		poplersButton.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		poplersButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		poplersButton.setForeground(Color.GREEN);
		poplersButton.setOpaque(false);
		poplersButton.setBackground(Color.YELLOW);
		poplersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				quantity = Integer.parseInt(PopplersTextField.getText());
				}
				catch(NumberFormatException err){
					messageLabel.setText("Please enter valid integer");
					return;
				}
				Popplers crystals = new Popplers(quantity);
				if (crew.getMoney() >= crystals.getPrice() * crystals.getQuantity() && quantity >0) {
					

					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/cash_reg.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception n){}
					
					game.buyItems(crystals, crystals.getQuantity());
					screen.refreshFoodList();
					screen.refreshMoney();
					messageLabel.setText("<html>" +Integer.toString(crew.getFoodItem("Popplers").getQuantity())+"\n"+" Popplers have been <br>added to the ship stock");// if dont have enough money then display that we are out of money.
					lblNewLabel_7.setText("$" + Integer.toString(crew.getMoney()));

					}	
				else if(quantity <=0) {
					messageLabel.setText("Please enter a valid input!!");
				}
					else if (crew.getMoney() <= 0){
						messageLabel.setText("You dont have enough money");
					}
					else {
						messageLabel.setText("Too many Items, you need more money!!");
					}

				
			}
		});
		poplersButton.setBounds(429, 444, 96, 25);
		frmNewWorld.getContentPane().add(poplersButton);
		
		JButton smigglesButton = new JButton("Buy");
		smigglesButton.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		smigglesButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		smigglesButton.setForeground(Color.GREEN);
		smigglesButton.setOpaque(false);
		smigglesButton.setBackground(Color.YELLOW);
		smigglesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					quantity = Integer.parseInt(smigglesTextField.getText());
					}
					catch(NumberFormatException err){
						messageLabel.setText("Please enter valid integer");
						return;
					}
				StrawberrySmiggles crystals = new StrawberrySmiggles(quantity);
				if (crew.getMoney() >= crystals.getPrice() * crystals.getQuantity() && quantity >0) {
					

					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/cash_reg.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception n){}
					
					game.buyItems(crystals, crystals.getQuantity());
					screen.refreshFoodList();
					screen.refreshMoney();
					messageLabel.setText("<html>" + Integer.toString(crew.getFoodItem("Strawberry Smiggles").getQuantity())+ " Strawberry Smiggles have been <br>added to the ship stock");// if dont have enough money then display that we are out of money.
					lblNewLabel_7.setText("$" + Integer.toString(crew.getMoney()));

					}	
				else if(quantity <=0) {
					messageLabel.setText("Please enter a valid input!!");
				}
					else if (crew.getMoney() <= 0){
						messageLabel.setText("You dont have enough money");
					}
					else {
						messageLabel.setText("Too many Items, you need more money!!");
					}

			}
		});
		smigglesButton.setBounds(429, 530, 100, 25);
		frmNewWorld.getContentPane().add(smigglesButton);
		
		JButton nuetrinoBombs = new JButton("Buy");
		nuetrinoBombs.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		nuetrinoBombs.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		nuetrinoBombs.setForeground(Color.GREEN);
		nuetrinoBombs.setOpaque(false);
		nuetrinoBombs.setBackground(Color.YELLOW);
		nuetrinoBombs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				quantity = Integer.parseInt(textField_5.getText());
				try {
					quantity = Integer.parseInt(BombsTextField.getText());
					}
					catch(NumberFormatException err){
						messageLabel.setText("Please enter valid integer");
						return;
					}
				NeutrinoBombs crystals = new NeutrinoBombs(quantity);
//				crew.addingFood(crystals, crystals.getQuantity());
				if (crew.getMoney() >= crystals.getPrice() * crystals.getQuantity() && quantity >0) {
					
					

					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/cash_reg.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception n){}
					
					game.buyItems(crystals, crystals.getQuantity());
					screen.refreshFoodList();
					screen.refreshMoney();
					messageLabel.setText("<html>" + Integer.toString(crew.getFoodItem("Neutrino Bombs").getQuantity())+ " Neutrino Bombs have been <br>added to the ship stock");// if dont have enough money then display that we are out of money.
					lblNewLabel_7.setText("$" + Integer.toString(crew.getMoney()));

					}	
				else if(quantity <=0) {
					messageLabel.setText("Please enter a valid input!!");
				}
					else if (crew.getMoney() <= 0){
						messageLabel.setText("You dont have enough money");
					}
					else {
						messageLabel.setText("Too many Items, you need more money!!");
					}

			}
		});
		nuetrinoBombs.setBounds(429, 594, 100, 25);
		frmNewWorld.getContentPane().add(nuetrinoBombs);
		
		r89TextField = new JTextField();
		r89TextField.setColumns(10);
		r89TextField.setBounds(849, 223, 30, 22);
		frmNewWorld.getContentPane().add(r89TextField);
		
		JButton r89Button = new JButton("Buy");
		r89Button.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		r89Button.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		r89Button.setForeground(Color.GREEN);
		r89Button.setOpaque(false);
		r89Button.setBackground(Color.YELLOW);
		r89Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					quantity = Integer.parseInt(r89TextField.getText());
					}
					catch(NumberFormatException err){
						messageLabel.setText("Please enter valid integer");
						return;
					}
				R89 crystals = new R89(quantity);
				if (crew.getMoney() >= crystals.getPrice() * crystals.getQuantity() && quantity >0) {
					

					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/cash_reg.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception n){}
					
					game.buyItems(crystals, crystals.getQuantity());
					screen.refreshMedicineList();
					screen.refreshMoney();
					messageLabel.setText("<html>" + Integer.toString(crew.getMedicine("R89").getQuantity())+ " R89 have been <br>added to the ship stock");// if dont have enough money then display that we are out of money.
					lblNewLabel_7.setText("$" + Integer.toString(crew.getMoney()));

					}	
				else if(quantity <=0) {
					messageLabel.setText("Please enter a valid input!!");
				}
					else if (crew.getMoney() <= 0){
						messageLabel.setText("You dont have enough money");
					}
					else {
						messageLabel.setText("Too many Items, you need more money!!");
					}

			}
		});
		r89Button.setBounds(891, 222, 84, 25);
		frmNewWorld.getContentPane().add(r89Button);
		
		JButton calceraphosbutton = new JButton("Buy");
		calceraphosbutton.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		calceraphosbutton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		calceraphosbutton.setForeground(Color.GREEN);
		calceraphosbutton.setOpaque(false);
		calceraphosbutton.setBackground(Color.YELLOW);
		calceraphosbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					quantity = Integer.parseInt(calceraTextField.getText());
					}
					catch(NumberFormatException err){
						messageLabel.setText("Please enter valid integer");
						return;
					}
				CalceraPhos400 crystals = new CalceraPhos400(quantity);
				if (crew.getMoney() >= crystals.getPrice() * crystals.getQuantity() && quantity >0) {
					

					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/cash_reg.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception n){}
					
					game.buyItems(crystals, crystals.getQuantity());
					screen.refreshMedicineList();
					screen.refreshMoney();
					messageLabel.setText("<html>" + Integer.toString(crew.getMedicine("Calcera Phos400").getQuantity())+ " Calcera Phos400 have been <br>added to the ship stock");// if dont have enough money then display that we are out of money.
					lblNewLabel_7.setText("$" + Integer.toString(crew.getMoney()));
					}
				else if(quantity <=0) {
					messageLabel.setText("Please enter a valid input!!");
				}
				
					else if (crew.getMoney() <= 0){
						messageLabel.setText("You dont have enough money");
					}
					else {
						messageLabel.setText("Too many Items, you need more money!!");
					}
				
			}
		});
		calceraphosbutton.setBounds(891, 323, 84, 25);
		frmNewWorld.getContentPane().add(calceraphosbutton);
		
		JButton nztButton = new JButton("Buy");
		nztButton.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		nztButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		nztButton.setForeground(Color.GREEN);
		nztButton.setOpaque(false);
		nztButton.setBackground(Color.YELLOW);
		nztButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					quantity = Integer.parseInt(nztTextField.getText());
					}
					catch(NumberFormatException err){
						messageLabel.setText("Please enter valid integer");
						return;
					}
				NZT48 crystals = new NZT48(quantity);
				if (crew.getMoney() >= crystals.getPrice() * crystals.getQuantity() && quantity >0) {
					

					try {
				    	InputStream wavFile = Sound.class.getResourceAsStream("/image/cash_reg.wav");
				    	InputStream bufferedIn = new BufferedInputStream(wavFile);
				    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
				    	
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioStream);
				        clip.start();
					
				    	
					} catch(Exception n){}
					
					
					game.buyItems(crystals, crystals.getQuantity());
					screen.refreshMedicineList();
					screen.refreshMoney();
					lblNewLabel_7.setText("$" + Integer.toString(crew.getMoney()));
					messageLabel.setText("<html>" + Integer.toString(crew.getMedicine("NZT48").getQuantity())+" NZT48 have been <br>added to the ship stock");// if dont have enough money then display that we are out of money.
					

					}	
				else if(quantity <=0) {
					messageLabel.setText("Please enter a valid input!!");
				}
					else if (crew.getMoney() <= 0){
						messageLabel.setText("You dont have enough money");
					}
					else {
						messageLabel.setText("Too many Items, you need more money!!");
					}

			}
		});
		nztButton.setBounds(896, 434, 79, 25);
		frmNewWorld.getContentPane().add(nztButton);
		
		JLabel lblNewLabel_1 = new JLabel("Crystals");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblNewLabel_1.setBounds(12, 247, 126, 30);
		frmNewWorld.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_9 = new JLabel("Smiggles");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("OCR A Extended", Font.BOLD, 17));
		lblNewLabel_9.setBounds(12, 546, 151, 25);
		frmNewWorld.getContentPane().add(lblNewLabel_9);
		
		
	}
}
