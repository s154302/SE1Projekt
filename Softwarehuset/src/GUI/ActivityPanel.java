package GUI;

import java.awt.Color;
import java.awt.Label;

import javax.swing.JPanel;

public class ActivityPanel extends JPanel {
	
	public ActivityPanel(Frame f){
		this.setBackground(Color.RED);
		
		this.add(new Label("Activity"));
	}

}
