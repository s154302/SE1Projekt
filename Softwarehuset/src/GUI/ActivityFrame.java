package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import code.Activity;
import code.Model;

public class ActivityFrame extends JFrame {
	private Model model;
	private Frame f;
	private ButtonListener bL;

	private EditActivityPanel eAP;
	private Activity activity;
	private ShowActivityPanel sAP;

	public ActivityFrame(Model model, Frame f, Activity activity) {

		this.model = model;
		this.bL = f.getButtonListener();
		this.f = f;
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);

		this.activity = activity;
		if (activity != null) {
			this.setTitle(activity.getName());
		}

		sAP = new ShowActivityPanel(model, f, activity);

		this.add(sAP, BorderLayout.CENTER);

		showIt();
		this.toFront();
	}

	public void showIt() {
		this.setVisible(true);
	}

	public void editActivity() {
		this.remove(sAP);
		eAP = new EditActivityPanel(model, bL, activity);
		this.add(eAP, BorderLayout.CENTER);
		this.toFront();
		revalidate();
		
		
	}

	public void showActivity() {
		this.remove(eAP);
		sAP = new ShowActivityPanel(model, f, activity);
		this.add(sAP, BorderLayout.CENTER);
	}
	
	public ShowActivityPanel getShowActivityPanel() {
		return this.sAP;
	}

	public EditActivityPanel getEditActivityPanel() {
		return eAP;
	}
	
}
