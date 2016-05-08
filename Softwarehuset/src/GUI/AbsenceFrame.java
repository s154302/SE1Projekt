package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import code.Model;

public class AbsenceFrame extends JFrame {
	
	
	private AbsencePanel aP;

	public AbsenceFrame(Model model, ButtonListener bL) {

		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setTitle("Absence");

		aP = new AbsencePanel(model, bL);


		this.add(aP,BorderLayout.CENTER);
		showIt();
	}

	public void showIt() {
		this.setVisible(true);
	}

	
	public AbsencePanel getAbsencePanel() {
		return aP;
	}

}
