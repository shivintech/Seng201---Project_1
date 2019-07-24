package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import gameengine.GameEnvironment;

import javax.swing.ImageIcon;

/**
 * 
 * The screen that appears when the game is finished or won. 
 *
 */
public class FinalScreen {

	private JFrame frame;
	private GameEnvironment ge;
	private GuiManager rm; 
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public FinalScreen() {
		initialize();
	}
	public FinalScreen(GuiManager rm, GameEnvironment ge) {
		this.ge = ge;
		this.rm = rm;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setBounds(100, 100, 1000, 800);
		
		JLabel gameOverNewLabel = new JLabel("GAME OVER ");
		gameOverNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverNewLabel.setVerticalAlignment(SwingConstants.TOP);
		gameOverNewLabel.setForeground(Color.RED);
		gameOverNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 52));
		gameOverNewLabel.setBounds(146, 13, 741, 78);
		frame.getContentPane().add(gameOverNewLabel);
		
		/**
		 * Lost Screen Image - https://ui-ex.com/download.html
		 * Winning Screen Rocket Image - http://school298.spb.ru/space-shuttle-wallpaper-widescreen/img625951432BF
		 */
		JLabel scoreLabel = new JLabel();
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ge.settingScore();
		if (ge.isGameWon()) {
			JLabel youWonLabel = new JLabel("You Won");
			youWonLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 44));
			youWonLabel.setHorizontalAlignment(SwingConstants.CENTER);
			youWonLabel.setForeground(Color.GREEN);
			youWonLabel.setBounds(248, 218, 471, 149);
			frame.getContentPane().add(youWonLabel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			scoreLabel.setForeground(Color.GREEN);
			scoreLabel.setText(Integer.toUnsignedString(ge.getScore()));
			scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel rogerLabel = new JLabel("");
			rogerLabel.setIcon(new ImageIcon(FinalScreen.class.getResource("/image/finalrocket.png")));
			rogerLabel.setBounds(780, 217, 202, 536);
			frame.getContentPane().add(rogerLabel);
		}
		else {
			JLabel lostLabel = new JLabel("You Lost");
			
			lostLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 44));
			lostLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lostLabel.setForeground(Color.RED);
			lostLabel.setBounds(248, 218, 471, 149);
			frame.getContentPane().add(lostLabel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			scoreLabel.setForeground(Color.RED);
			scoreLabel.setText(Integer.toUnsignedString(ge.getScore()));
			scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel imageLabel = new JLabel("");
		
			imageLabel.setIcon(new ImageIcon(FinalScreen.class.getResource("/image/r1.png")));
			imageLabel.setBounds(12, 276, 268, 477);
			frame.getContentPane().add(imageLabel);
			
			
		}
		scoreLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 55));
		scoreLabel.setVerticalAlignment(SwingConstants.TOP);
		scoreLabel.setBounds(320, 418, 338, 257);
		frame.getContentPane().add(scoreLabel);
		
		JLabel scoreDisplaylabel = new JLabel("  Score ");
		scoreDisplaylabel.setFont(new Font("OCR A Extended", Font.PLAIN, 55));
		scoreDisplaylabel.setForeground(Color.WHITE);
		scoreDisplaylabel.setBounds(338, 68, 320, 64);
		frame.getContentPane().add(scoreDisplaylabel);
		
		
		
		
	}
}
