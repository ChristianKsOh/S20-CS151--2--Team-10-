
package edu.sjsu.cs.etrt.controller;

import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Patient.PatientList;
import edu.sjsu.cs.etrt.view.UI.PatientListView;

public class PatientListController {
	private PatientList model;
	private PatientListView view;
	public PatientListController(PatientList p, PatientListView v) {
		this.model=p;
		this.view = v;
	}
	
	public void removePatient(int num)
	{
		model.remove(num);
	}
	
	public Patient getPatient(int num)
	{
		return model.getPatient(num);
	}
	
	public int getSize()
	{
		return model.size();
	}
	//Add patient
	/**
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
	}**/
}
