package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.Model;

public class AbsenceTimePanel extends JPanel {

	private Model model;
	private ButtonListener bL;
	private AbsenceFrame aF;
	private JLabel name;
	private JTextField courseTime, sickTime, vaTime, otherTime;

	//adding absence time
	public AbsenceTimePanel(Model model, ButtonListener bL, AbsenceFrame aF) {
		this.model = model;
		this.bL = bL;
		this.aF = aF;
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		// Employee's name
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		if(model.getCurrentEmployee()== null){
			JOptionPane.showMessageDialog(aF, "You cannot add absence time as a guest");
			aF.saveTime();
		} else {
			name = new JLabel("Absence for "+model.getCurrentEmployee().getName());
		
		this.add(name, gbc);
		
		// add Course time + label
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel course = new JLabel("Course: ");
		this.add(course, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.LINE_END;
		gbc.gridheight = 1;
		courseTime = new JTextField("0");
		this.add(courseTime, gbc);
		
		// add sickness time + label
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel sick = new JLabel("Sickness: ");
		this.add(sick, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		sickTime = new JTextField("0");
		this.add(sickTime, gbc);
		
		// add vacation time + label
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel va = new JLabel("Vacation: ");
		this.add(va, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		vaTime = new JTextField("0");
		this.add(vaTime, gbc);
		
		// add other time + label
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JLabel other = new JLabel("Other: ");
		this.add(other, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		otherTime = new JTextField("0");
		this.add(otherTime, gbc);
		
		//add save button
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		JButton addTime = new JButton("Confirm Absence");
		addTime.addActionListener(bL);
		this.add(addTime, gbc);
		}
	}
	
	public double getCourseTime() {
		System.out.println("courseTime: "+courseTime.getText());
		double t = 0;
		try {
			System.out.println("courseTime: "+courseTime.getText());
			t = Double.parseDouble(courseTime.getText());
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(aF,"The course time has to be a double.");
		}
		return t;
	}

	public double getSickTime() {
		double t = 0;
		try {
			t = Double.parseDouble(sickTime.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(aF,"The sickness time has to be a double.");
		}
		return t;
	}

	public double getVaTime() {
		double t = 0;
		try {
			t = Double.parseDouble(vaTime.getText());
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(aF,"The vacation time has to be a double.");
		}
		return t;
	}

	public double getOtherTime() {
		double t = 0;
		try {
			t = Double.parseDouble(otherTime.getText());
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(aF,"The other time has to be a double.");
		}
		return t;
	}

}
