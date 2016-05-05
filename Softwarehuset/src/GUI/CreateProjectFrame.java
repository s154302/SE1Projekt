package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import code.Model;

public class CreateProjectFrame extends JFrame {
<<<<<<< HEAD
	
	private CreateProjectPanel cPP;

	public CreateProjectFrame(Model model, ButtonListener bL) {
=======

	public CreateProjectFrame(Model model) {
>>>>>>> Emilie
		this.setSize(400, 250);
		this.setLocation(100, 50);
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Create Project");
<<<<<<< HEAD
		CreateProjectPanel cPP = new CreateProjectPanel(model, bL);
=======
		CreateProjectPanel cPP = new CreateProjectPanel(model);
>>>>>>> Emilie
		this.add(cPP,BorderLayout.CENTER);
		showIt();
	}

	public void showIt() {
		this.setVisible(true);
	}
<<<<<<< HEAD
	
	public CreateProjectPanel getCreateProjectPanel() {
		return cPP;
	}
=======
>>>>>>> Emilie
}
