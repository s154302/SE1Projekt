package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Model;

public class ButtonListener implements ActionListener {

	Model model;

	public ButtonListener(Model model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		switch (actionCommand) {
		case "Create Project":
			CreateProjectFrame pF = new CreateProjectFrame(model);
			break;
			
		case "Confirm":

			break;

		case "Cancel":
			
			break;
			
		}

	}

}
