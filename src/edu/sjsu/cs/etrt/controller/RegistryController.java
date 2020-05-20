package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Patient.PatientList;
import edu.sjsu.cs.etrt.model.Register.Registry;
import edu.sjsu.cs.etrt.model.Visits.VisitQueue;
import edu.sjsu.cs.etrt.view.UI.RegistryView;

public class RegistryController {
	private Registry model;		//model
	private RegistryView view;	//view
	private SystemController system;	//system
	
	public RegistryController(PatientListController list, SystemController ctrl) {
		model=new Registry(list);
		system=ctrl;
		view=new RegistryView(list,system);
	}
	
	//insert a new Patient
	public void addPatientToList(Patient p) {
		system.getPatientList().addPatient(p);
	}
	
	public void openSystem()
	{
		system.openSystem();
	}	
	
	public JPanel getViewPanel() {
		return view.generateUI();
	}
}
