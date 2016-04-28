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
		this.setLayout(new BorderLayout());
//		gbc.anchor = gbc.FIRST_LINE_START;
//		
//		// adding project Panel
//		gbc.fill = GridBagConstraints.VERTICAL;
//        gbc.gridx = 0; 
//        gbc.gridy = 0;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 2;
//        gbc.fill = GridBagConstraints.BOTH;
		this.add(projectPanel, "West");
		
//		// adding activity panel
//        gbc.gridx = 1; 
//        gbc.gridy = 0;
//        gbc.gridwidth = 2;
//        gbc.gridheight = 1;
//        gbc.fill = GridBagConstraints.BOTH;
		this.add(activityPanel, "Center");
		
//		// adding button panel
//        gbc.gridx = 1; 
//        gbc.gridy = 1;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 1;
//        gbc.fill = GridBagConstraints.BOTH;
		this.add(buttonPanel, "South");
		
		
		
	}
	
//	private JPanel gbcComponent(int x, int y, int w, int h){
//
//        gbc.gridx = x; 
//        gbc.gridy = y;
//        gbc.gridwidth = w;
//        gbc.gridheight = h;
//        gbc.fill = GridBagConstraints.BOTH;
//        JPanel panel = new JPanel();
//        JTextField text = new JTextField("(" + w + ", " + h + ")");
//        panel.setBorder(new TitledBorder("(" + x + ", " + y + ")"));        
//        panel.add(text);
//        return panel;
//
//    }
	
	public void showIt(){
		this.setVisible(true);
	}

}
