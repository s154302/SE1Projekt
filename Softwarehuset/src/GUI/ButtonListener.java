package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Model;

public class ButtonListener implements ActionListener {

	private Model model;
	private CreateProjectFrame cPF;

	public ButtonListener(Model model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		switch (actionCommand) {
		case "Create Project":
			this.cPF = new CreateProjectFrame(model, this);
			break;
			
		case "Confirm":
			break;

		case "Cancel":
			this.cPF.setVisible(false);
			this.cPF.dispose();
			break;
			
		}

	}

}
