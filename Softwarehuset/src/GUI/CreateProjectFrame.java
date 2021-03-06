package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import code.Model;

public class CreateProjectFrame extends JFrame {
	
	private CreateProjectPanel cPP;

	//a frame for when creating a new project
	public CreateProjectFrame(Model model, ButtonListener bL) {

		this.setSize(450, 250);
		this.setLocationRelativeTo(null);
		this.setTitle("Create Project");

		cPP = new CreateProjectPanel(model, bL);


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
