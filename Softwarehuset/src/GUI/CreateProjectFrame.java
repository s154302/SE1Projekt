package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import code.Model;

public class CreateProjectFrame extends JFrame {
	
	private CreateProjectPanel cPP;

	public CreateProjectFrame(Model model, ButtonListener bL) {

		this.setSize(400, 250);
		this.setLocation(100, 50);
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Create Project");

		CreateProjectPanel cPP = new CreateProjectPanel(model, bL);


		this.add(cPP,BorderLayout.CENTER);
		showIt();
	}

	public void showIt() {
		this.setVisible(true);
	}

	
	public CreateProjectPanel getCreateProjectPanel() {
		return cPP;
	}
}
