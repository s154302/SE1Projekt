package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import code.Model;

public class CreateProjectFrame extends JFrame {

	public CreateProjectFrame(Model model) {
		this.setSize(400, 250);
		this.setLocation(100, 50);
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Create Project");
		CreateProjectPanel cPP = new CreateProjectPanel(model);
		this.add(cPP,BorderLayout.CENTER);
		showIt();
	}

	public void showIt() {
		this.setVisible(true);
	}
}
