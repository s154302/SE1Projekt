package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import code.Model;

public class ActivityFrame extends JFrame{
	private Model model;
	
	public ActivityFrame(Model model, ButtonListener bL){
		this.model = model;
	this.setSize(400, 300);
	this.setLocation(100, 50);
//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Edit Activity");

	ActivityEditPanel aP = new ActivityEditPanel(model, bL);


	this.add(aP,BorderLayout.CENTER);
	showIt();
}

public void showIt() {
	this.setVisible(true);
}


}
