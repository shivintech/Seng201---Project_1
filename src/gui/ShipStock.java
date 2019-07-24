package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import gameengine.GameEnvironment;
//import main.*;
import sound.Sound;
import spaceship.SpaceShip;
import items.Items;
import units.Crew;
import units.CrewMember;

import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
/**
 * The screen that displays the Food and medicine inventory to the player. 
 *
 */
public class ShipStock {
	private GuiManager manager;
	private JFrame frame;
	private Crew  crew;
	private SpaceShip ship;
	private GameEnvironment ge;
	private ThirdScreen screen;
	private CrewMember member;
	private JLabel foodLabel;
	private JLabel medicineLabel;
	/**
	 * Launches the application.
	 */

	/**
	 * Creates the application.
	 */
	public ShipStock() {
		initialize();
	}
	public ShipStock(GuiManager manager, GameEnvironment ge, Crew crew, SpaceShip ship, ThirdScreen screen, CrewMember member) {
		this.manager = manager;
		this.ge = ge;
		this.crew = crew;
		this.ship = ship;
		this.screen = screen;
		this.member = member;
		initialize();
	}
	
	/**
	 * Notifies the player when crew member has run out of actions.
	 */
	public void showTheMessage() {
		JOptionPane.showMessageDialog(null, "No actions remaining");
	}
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 704, 800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel quantityLabel = new JLabel("Quantity");
		quantityLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 21));
		quantityLabel.setForeground(Color.CYAN);
		quantityLabel.setBounds(27, 104, 109, 51);
		frame.getContentPane().add(quantityLabel);
		
		
		
		JLabel headingLabel = new JLabel("Food / Medicines ");
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingLabel.setFont(new Font("OCR A Extended", Font.BOLD, 32));
		headingLabel.setVerticalAlignment(SwingConstants.TOP);
		headingLabel.setForeground(Color.CYAN);
		headingLabel.setBounds(12, 11, 662, 80);
		frame.getContentPane().add(headingLabel);
		
		JLabel infoLabel1 = new JLabel("* Each click will consume 1 item. ");
		infoLabel1.setFont(new Font("OCR A Extended", Font.ITALIC, 18));
		infoLabel1.setForeground(Color.WHITE);
		infoLabel1.setVerticalAlignment(SwingConstants.TOP);
		infoLabel1.setBounds(12, 689, 447, 32);
		frame.getContentPane().add(infoLabel1);
		
		JLabel infoLabel2 = new JLabel("* Items will disappear when none left to consume.");
		infoLabel2.setForeground(Color.WHITE);
		infoLabel2.setFont(new Font("OCR A Extended", Font.ITALIC, 18));
		infoLabel2.setBounds(12, 711, 557, 16);
		frame.getContentPane().add(infoLabel2);
		JLabel itemLabel = new JLabel("Item");
		itemLabel.setForeground(Color.CYAN);
		itemLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		itemLabel.setBounds(267, 104, 109, 51);
		frame.getContentPane().add(itemLabel);
		
		
		
		createFoodLabels();
		
	}
	/** Generates labels/buttons to consume food/medicine when an item is bought or found
	 * Eating Sound reference - http://soundbible.com/suggest.php?q=eating+&x=0&y=0
	 */
	public void createFoodLabels() { 
		int count =90;
		ArrayList<Items> itemList = new ArrayList<>();
			itemList.addAll(crew.getFoodList());
			itemList.addAll(crew.getMedicineList());
		for (Items food: itemList) {
			
			int y = 207;
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setBounds(16, 100 +  count , 807, 57);
			panel.setVisible(true);
			panel.setLayout(null);
			
			JLabel eachitemLabel = new JLabel("each item ");
			eachitemLabel.setVerticalAlignment(SwingConstants.TOP);
			eachitemLabel.setForeground(Color.WHITE);
			eachitemLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
			eachitemLabel.setBounds(0, 13, 539, 40);
			panel.add(eachitemLabel);
			eachitemLabel.setText("   " + food.getQuantity() +  "                " + food.getName() );
			eachitemLabel.setVisible(true);
			
			
				
				JButton consumeBtn = new JButton("Consume ");
				consumeBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (member.getNumberOfActions()>0) {
							
							try {
						    	InputStream wavFile = Sound.class.getResourceAsStream("/image/eating.wav");
						    	InputStream bufferedIn = new BufferedInputStream(wavFile);
						    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
						    	
						        Clip clip = AudioSystem.getClip();
						        clip.open(audioStream);
						        clip.start();
							
						    	
							} catch(Exception n){}
						ge.consume(member, food, 1);
						if (food.getQuantity()<1) {
							panel.setVisible(false);
						}
						screen.refreshFoodList();
						screen.refreshMedicineList();
						screen.refreshNumberOfActions(crew.getCrewList().indexOf(member));
						eachitemLabel.setText("   " + food.getQuantity() +  "                " + food.getName());
						screen.getHungerBarList().get(crew.getCrewList().indexOf(member)).setValue(member.getHunger());
						screen.getHungerBarList().get(crew.getCrewList().indexOf(member)).setString(member.getHunger() + "%");
						screen.getHealthBarList().get(crew.getCrewList().indexOf(member)).setValue(member.getHealth());
						screen.getHealthBarList().get(crew.getCrewList().indexOf(member)).setString(member.getHealth()+"%");
					}
						else {
							showTheMessage();
						}
					}
					
				});
				consumeBtn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
				consumeBtn.setOpaque(false);
				consumeBtn.setBackground(Color.WHITE);
				consumeBtn.setForeground(Color.GREEN);
				consumeBtn.setVisible(true);
				consumeBtn.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
				consumeBtn.setBounds(550, 13 , 87, 25);
				panel.add(consumeBtn);
				frame.getContentPane().add(panel);
				
				count += 50;
		
		}
		

		frame.revalidate();
		frame.repaint();

		
		
}
	
}
