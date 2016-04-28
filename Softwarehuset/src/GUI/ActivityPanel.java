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
		gbc.weighty = 1;
        gbc.gridx = 1; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
		
		this.add(new Label("Activity"));
	}

}
