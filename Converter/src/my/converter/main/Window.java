package my.converter.main;

import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame {
	private JPanel panel;
	private JLabel label;
	private JButton button;
	private JTextField number;
	private JTextField binText;
	private JTextField hexText;
	private JTextField octText;
	
	public Window() {
		super("Converter");
	    panel = new JPanel(new GridBagLayout()); 
	    add(panel);
	    GridBagConstraints c = new GridBagConstraints();
	    
	    button = new JButton("Convert");
	    button.addActionListener(new Action());
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 0;
	    panel.add(button, c);
	    
	    number = new JTextField(10);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 0;
	    panel.add(number, c);
	    
	    label = new JLabel("Binary:");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 1;
	    panel.add(label, c);
	    
	    label = new JLabel("Hex:");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 2;
	    panel.add(label, c);
	    
	    label = new JLabel("Octan:");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 3;
	    panel.add(label, c);
	    
	    binText = new JTextField(10);
	    binText.setEditable(false);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 1;
	    panel.add(binText, c);
	    
	    hexText = new JTextField(10);
	    hexText.setEditable(false);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 2;
	    panel.add(hexText, c);
	    
	    octText = new JTextField(10);
	    octText.setEditable(false);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 3;
	    panel.add(octText, c);
	}
	
	class Action implements ActionListener{
		public void actionPerformed(ActionEvent evt){
			Conv ny = new Conv();
			String hax = number.getText();
			String binary = ny.convertToBinary((Integer.parseInt(hax)));
			String hexa = ny.convertToHex((Integer.parseInt(hax)));
			String octa = ny.convertToOctan((Integer.parseInt(hax)));
			binText.setText(binary);
			hexText.setText(hexa);
			octText.setText(octa);
		}
	}
}


