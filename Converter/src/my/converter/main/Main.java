package my.converter.main;

import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main {


	public static void main(String[] args) {
		
		Window frame = new Window(); // construct Window object
		
		frame.setPreferredSize(new Dimension(300,300));
		frame.setMaximumSize(new Dimension(300,300));
		frame.setMinimumSize(new Dimension(300,300));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/* make sure that we stop the threads in the game operations */
		frame.setResizable(false); /* make sure that we can not resize the window */
		frame.setLocationRelativeTo(null);/* having the window set to the middle */
		frame.setVisible(true);             // ask it to become visible

	}	
}
