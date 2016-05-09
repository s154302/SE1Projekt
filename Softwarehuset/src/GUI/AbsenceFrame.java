package GUI;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import code.Model;

public class AbsenceFrame extends JFrame {
	
	
	private AbsencePanel aP;
	private AbsenceTimePanel aTP;
	private Model model;
	private ButtonListener bL;

	//frame for when one wants to check or add absence time
	public AbsenceFrame(Model model, ButtonListener bL) {
		this.model= model;
		this.bL = bL;

		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setTitle("Absence");

		aP = new AbsencePanel(model, bL, this);


		this.add(aP,BorderLayout.CENTER);
		showIt();
	}

	public void showIt() {
		this.setVisible(true);
	}

	
	public AbsencePanel getAbsencePanel() {
		return aP;
	}
	
	public AbsenceTimePanel getAbsenceTimePanel() {
		return aTP;
	}
	
	public void update(){
		this.revalidate();
	}

	public void addTime() {
		this.remove(aP);
		aTP = new AbsenceTimePanel(model, bL, this);
		this.add(aTP,BorderLayout.CENTER);
		this.update();
	}
	
	public void saveTime() {
		
		this.remove(aTP);
		aP.updateList();
		this.add(aP,BorderLayout.CENTER);
		this.update();
	}




}
