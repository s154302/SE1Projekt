package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import code.Activity;
import code.Model;

public class ActivityFrame extends JFrame{
	private Model model;
	private ButtonListener bL;
	private Frame f;

	private EditActivityPanel eAP;
	private Activity activity;
	private ShowActivityPanel sAP;
	
	public ActivityFrame(Model model, Frame f, Activity activity){

		this.model = model;
		this.bL = f.getButtonListener(); 
		this.f = f;
	this.setSize(400, 300);
	this.setLocationRelativeTo(null);

	this.activity = activity;
	if(activity != null) {
		this.setTitle(activity.getName());
	}
	
	sAP = new ShowActivityPanel(model, f);

	this.add(sAP);


	showIt();
}

public void showIt() {
	this.setVisible(true);
}

public void editActivity(){

	this.remove(sAP);
	eAP = new EditActivityPanel(model, bL);
	this.add(eAP,BorderLayout.CENTER);
}

public void showActivity(){
	this.remove(eAP);
	sAP = new ShowActivityPanel(model,f);
	this.add(sAP,BorderLayout.CENTER);
}


}
