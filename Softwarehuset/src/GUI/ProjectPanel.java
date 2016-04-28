package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;

import javax.swing.JPanel;

public class ProjectPanel extends JPanel {
	
	public ProjectPanel(Frame f){ 
		this.setBackground(Color.BLUE);
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());

		gbc.weighty = 1;

        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
		this.add(new Label("Project"), gbc);
		
        gbc.gridx = 0; 
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        this.add(new Label("Project2"), gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        this.add(new Label("Project3"), gbc);
	}

}
