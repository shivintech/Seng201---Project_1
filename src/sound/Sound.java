package sound;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;



import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;


import java.io.*;
import java.net.URL;
import java.awt.Window.Type;

/**
 * 
 * This class provides the functionality  in window builder to play sounds.
 * The below code was taken from stackoverflow.com
 *
 */
public class Sound {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	Clip clip;
	public Sound() {
		initialize();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**
		 * Launch Rocket sound - www.soundbible.com
		 */
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
			    	InputStream wavFile = Sound.class.getResourceAsStream("/image/launchw.wav");
			    	InputStream bufferedIn = new BufferedInputStream(wavFile);
			    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
			    	
			        clip = AudioSystem.getClip();
			        clip.open(audioStream);
			        clip.start();
				
			    	
				} catch(Exception e){}
		}
				 		
			
		});
		btnNewButton.setBounds(30, 26, 114, 25);
		frame.getContentPane().add(btnNewButton);
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sound window = new Sound();
					window.frame.setVisible(true);
				} catch (Exception e) {
									}
			}
		});
	}
}