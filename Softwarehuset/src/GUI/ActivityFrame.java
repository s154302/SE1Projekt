package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import code.Model;

public class ActivityFrame extends JFrame{
	private Model model;
	private ButtonListener bL;
	private Frame f;
	private EditActivityPanel aP;
	
	public ActivityFrame(Model model, Frame f){
		this.model = model;
		this.bL = f.getButtonListener(); 
		this.f = f;
	this.setSize(400, 300);
	this.setLocationRelativeTo(null);
	this.setTitle(f.getProjectPanel().getTableListener().getActivity().getName());
	
	ShowActivityPanel sAP = new ShowActivityPanel(model, f);
	this.add(sAP);


	showIt();
}

public void showIt() {
	this.setVisible(true);
}

public void editActivity(){
	aP = new EditActivityPanel(model, bL);
	this.add(aP,BorderLayout.CENTER);
}


}
