
package edu.sjsu.cs.etrt.view.UI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PatientListView {
	
	private PatientQueue patientQ;
	
	public PatientListView(PatientQueue p) {
		patientQ=p;
	}
	
	public void refresh()
	{
		main.removeAll();
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel header = new JLabel("(Last Name), (First Name) ( Middle Initial) (Birthday)");
		panel.add(header);
		for(int counter = 0; counter<patientQ.size();counter++)
		{
			JLabel patientLabel = new JLabel(patientQ.getPatient(counter).getLastName()+", " + patientQ.getPatient(counter).getFirstName()+" "patientQ.getPatient(counter).getMiddleInitial()+
					patientQ.getPatient(counter).getDateOfBirth());
			panel.add(patientLabel);
			
		}
		JButton addPatient = new JButton("Add Patient");
		main.add(panel);
	}
	
	public JPanel generateUI() {
		refresh();
		return main;
	}
	
	void addPatientListListener(ActionListener listenForAddPatientButton)
	{
		addPatient.addActionListener(listenForAddPatientButton);
	}
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, message);
	}
}
