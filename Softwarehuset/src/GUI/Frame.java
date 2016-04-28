package GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

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
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = c.FIRST_LINE_START;
		
		// adding project Panel
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(projectPanel, c);
		
		// adding activity panel
		c.gridx = 1;
		c.gridy = 0;
		this.add(activityPanel, c);
		
		// adding button panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		this.add(buttonPanel, c);
		
		
		
	}
	
	public void showIt(){
		this.setVisible(true);
	}

}
