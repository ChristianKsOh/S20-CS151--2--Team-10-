import Project.PatientList;
package edu.sjsu.cs.etrt.controller;

public class PatientListController {
	private PatientList model;
	private PatientForm patientForm;
	private PatientListView view;
	public PatientListController(PatientList p, PatientListView v, PatientForm pf) {
		this.model=p;
		this.patientForm = pf;
		this.view = v;
		this.view.addPatientListListener(new PatientListListener());
		this.view.RemovePatientListListener(new PatientList2Listener());
	}
	//Add patient
	class PatientListListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Patient p;
			try {
				//needs to switch to Form controller and GUI
			}
			catch()
			{
				view.displayErrorMessage("Fill out form");
			}
		}
	}
	//Remove Patient
	class PatientList2Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				model.remove(view.getNum());
				view.refresh();
			}
			catch()
			{
				view.displayErrorMessage("You done broke it");
			}
		}
	}
}
