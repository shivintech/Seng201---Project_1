package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import sound.Sound;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
/**
 * The first screen of the game.
 * 
 *
 */
public class MainScreen {

	private JFrame frmRocketManagerMain;
	private GuiManager manager;
	private setupscreen setup;
	private InputStream wavFile1;
	private InputStream bufferedIn;
	private AudioInputStream audioStream;
	private Clip clip1;
	
	public MainScreen(GuiManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmRocketManagerMain.setVisible(true);
	}
	
	/**
	 * closes Window.
	 */
	public void closeWindow() {
		frmRocketManagerMain.dispose();
		
	}
	/** 
	 * Closes the main Screen 
	 */
	public void finishedWindow() {
		manager.closeMainScreen(this);
	}

	/**
	 * Launch the application.
	 */
	

	public void launchScreen() {
		manager.launchSetupScreen(wavFile1, bufferedIn, audioStream, clip1);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiManager manager = new GuiManager();
					MainScreen window = new MainScreen(manager);
					window.frmRocketManagerMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Background Sound from - soundbible.com by Daniel Simon
	 */
	private void initialize() {
		frmRocketManagerMain = new JFrame();
		frmRocketManagerMain.setResizable(false);
		frmRocketManagerMain.setTitle("Odyssey Main Screen");
		frmRocketManagerMain.getContentPane().setBackground(Color.GRAY);
		frmRocketManagerMain.getContentPane().setLayout(null);
		
		
		try {
	    	wavFile1 = Sound.class.getResourceAsStream("/image/creepy-background-daniel_simon.wav");
	    	bufferedIn = new BufferedInputStream(wavFile1);
	    	audioStream = AudioSystem.getAudioInputStream(bufferedIn);
	    	
	        clip1 = AudioSystem.getClip();
	        clip1.open(audioStream);
	        clip1.start();
    	
		} catch(Exception n){}
	
	
		
		JButton btnNewButton_2 = new JButton("PLAY");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(220, 20, 60)));
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setForeground(new Color(220, 20, 60));
		btnNewButton_2.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 30));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					launchScreen();
					finishedWindow();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/image/b.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(210, 25, 563, 204);
		frmRocketManagerMain.getContentPane().add(lblNewLabel);
		btnNewButton_2.setBackground(Color.YELLOW);
		btnNewButton_2.setBounds(414, 423, 191, 55);
		frmRocketManagerMain.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("QUIT");
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(220, 20, 60)));
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setForeground(new Color(220, 20, 60));
		btnNewButton_5.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 30));
		btnNewButton_5.setBackground(Color.YELLOW);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
			}
		});
		btnNewButton_5.setBounds(414, 491, 191, 37);
		frmRocketManagerMain.getContentPane().add(btnNewButton_5);
		/** 
		 * Main Screen Image from - http://vvzhishaji.com/dead-space-wallpaper-1/
		 */
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainScreen.class.getResource("/image/final.jpg")));
		lblNewLabel_2.setBounds(0, 0, 992, 753);
		frmRocketManagerMain.getContentPane().add(lblNewLabel_2);
		frmRocketManagerMain.setBounds(100, 100, 992, 753);
		frmRocketManagerMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}