package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;

import javax.swing.JPanel;

public class ActivityPanel extends JPanel {
	
	public ActivityPanel(Frame f){ 
		this.setBackground(Color.RED);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 3;
		
        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
		this.add(new Label("Activity"), gbc);
		
        gbc.gridx = 0; 
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        this.add(new Label("Activity2"), gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        this.add(new Label("Activity3"), gbc);
		
		
	}

}
