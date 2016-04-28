package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Frame extends JFrame{
	
	private ProjectPanel projectPanel;
	private ActivityPanel activityPanel;
	private ButtonPanel buttonPanel;

	public Frame(){

		//constructing frame
		this.setSize(600,500);
		this.setLocation(100,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Software Huset");	
		
		//making the panels to the frame
		projectPanel = new ProjectPanel(this);
		activityPanel = new ActivityPanel(this);
		buttonPanel = new ButtonPanel(this);

		// setting up the layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		// adding project Panel
        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 6;
		this.add(projectPanel, gbc);
		
		// adding activity panel
        gbc.gridx = 2; 
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 5;
		this.add(activityPanel, gbc);
		
		// adding button panel
        gbc.gridx = 2; 
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
		this.add(buttonPanel, gbc);
		
	}
	
	
	public void showIt(){
		this.setVisible(true);
	}

}
