package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	
	public ButtonPanel(Frame f){
		System.out.println("button");
		this.setBackground(Color.GREEN);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
        
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
		this.add(new JButton("Button1"), gbc);
		
        gbc.gridx = 2; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
		this.add(new JButton("Button2"), gbc);
		
        gbc.gridx = 3; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
		this.add(new JButton("Button3"), gbc);
		
	}

}
