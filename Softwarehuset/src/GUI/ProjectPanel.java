package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;

import javax.swing.JPanel;

public class ProjectPanel extends JPanel {
	
	public ProjectPanel(Frame f){
		this.setBackground(Color.BLUE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weighty = 1;
        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
		
		this.add(new Label("Project"));
	}

}
