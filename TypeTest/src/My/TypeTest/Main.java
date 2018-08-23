package My.TypeTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Main {

	private static JPanel panel;
	private static JLabel label;
	private static JTextPane text;
	private static JTextField writing;
	private static String [] book = new String[25];
	private static int correctWords = 0;
	private static int countChar = 0;
	private static int countWords = 0;
	private static boolean typeStarted = false;
	private static double startTime = 0.0;
	private static double endTime = 0.0;

	public static void main(String [] args) {
		JFrame window = new JFrame("TypeTest");
		window.setPreferredSize(new Dimension(400,400));
		window.setMaximumSize(new Dimension(400,400));
		window.setMinimumSize(new Dimension(400,400));

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		//window.setLocationRelativeTo(null); 

		panel = new JPanel(new GridBagLayout()); 
		window.add(panel);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);

		text = new JTextPane();
		readFile("mybook.txt");
		setTextField();
		//text.setLineWrap(true);
		//text.setWrapStyleWord(true);
		text.setPreferredSize(new Dimension(200,150));
		text.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(text, c);

		writing = new JTextField(10);
		writing.addKeyListener(new KeyPress());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(writing, c);


		window.setVisible(true);

	}

	public static void readFile(String fileName) {
		Scanner in;
		try{
			in = new Scanner(new File(fileName));
		}
		catch(Exception e){return;}
		int i = 0;
		while(in.hasNextLine()) {
			Scanner in2 = new Scanner(in.nextLine());
			while(in2.hasNext()) {
				String line = in2.next();
				book[i] = line;
				i++;
			}
		}

		in.close();

	}

	public static void setTextField() {
		String textOut="";
		for(int i = 0;i < book.length;i++) {
			textOut=textOut+" "+book[i];
		}
		text.setText(textOut);
	}

	public static void getHighScore(double timediff, int words) {
		JFrame highScore = new JFrame("HighScore");
		highScore.setPreferredSize(new Dimension(350,200));
		highScore.setMaximumSize(new Dimension(350,200));
		highScore.setMinimumSize(new Dimension(350,200));

		highScore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		highScore.setResizable(false);


		JPanel panel2 = new JPanel(new GridBagLayout());
		highScore.add(panel2);
		GridBagConstraints c2 = new GridBagConstraints();
		c2.insets = new Insets(10,10,10,10);

		label = new JLabel("Congratulations, you have finished the TypeTest!");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.gridx = 0;
		c2.gridy = 0;
		panel2.add(label, c2);
		
		JTextField time = new JTextField();
		double wordsPerMinute = (timediff/words)*60000;
		String out = "Words Per Minute was: " + wordsPerMinute;
		time.setText(out);
		time.setEditable(false);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.gridx = 0;
		c2.gridy = 1;
		panel2.add(time, c2);

		highScore.setVisible(true);
	}
	
	public static void setColour(boolean colour, int charCount, int wordCount) {
		SimpleAttributeSet attrs = new SimpleAttributeSet();
		SimpleAttributeSet attrs2 = new SimpleAttributeSet();
		StyleConstants.setForeground(attrs, Color.decode("#228B22"));
		StyleConstants.setForeground(attrs2, Color.decode("#8B0000"));

		StyledDocument sdoc = text.getStyledDocument();
		
		if(colour) {
			sdoc.setCharacterAttributes(charCount, book[wordCount].length() + 1, attrs, false);
		} else {
			sdoc.setCharacterAttributes(charCount, book[wordCount].length() + 1, attrs2, false);
		}
	}
	

	static class KeyPress implements KeyListener{

		public void keyPressed(KeyEvent k) {
			if(!typeStarted) {
				typeStarted = true;
				startTime = System.currentTimeMillis();
			}
			
			
			if(countWords < book.length) {
				String temp = writing.getText().trim();
				if(k.getKeyCode() == 32) {
					if(!temp.equals(" ")) {
						if(temp.equals(book[countWords])) {	
							setColour(true,countChar,countWords);
							countChar += temp.length() + 1;
							correctWords++;
							countWords++;
							writing.setText("");
							if(countWords == book.length) {
								endTime = System.currentTimeMillis(); 
								writing.setEditable(false);
								System.out.println("You are finished with the game");
								getHighScore(endTime-startTime,correctWords);
							}
						} else {
							setColour(false,countChar,countWords);
							System.out.println("Wrong");
						}
					}	
				}

			} else {
				writing.setEditable(false);
				System.out.println("You are finished with the game");
			}
		}

		public void keyReleased(KeyEvent k) {

		}

		public void keyTyped(KeyEvent k) {

		}


	}


}
