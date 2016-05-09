package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import code.Model;

public class CreateActivityFrame extends JFrame {

	private CreateActivityPanel cAP;
	private Frame f;

	//a frame for when creating an activity
	public CreateActivityFrame(Model model, ButtonListener bL, Frame f) {
		this.setSize(300, 400);
		this.f = f;
		this.setLocationRelativeTo(null);
		this.setTitle("Create Activity");

		cAP = new CreateActivityPanel(model, bL, f);

		this.add(cAP, BorderLayout.CENTER);
		showIt();
	}

	public void showIt() {
		this.setVisible(true);
	}

	public CreateActivityPanel getCreateActivityPanel() {
		return cAP;
	}

	public void setSelectedEmployees() {
		cAP.setEmployeesToActivity();
		this.revalidate();

	}

}
