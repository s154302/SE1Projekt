package GUI;

import java.awt.Color;
import java.awt.Label;

import javax.swing.JPanel;

public class ProjectPanel extends JPanel {
	
	public ProjectPanel(Frame f){
		this.setBackground(Color.BLUE);
		
		this.add(new Label("Project"));
	}

}
