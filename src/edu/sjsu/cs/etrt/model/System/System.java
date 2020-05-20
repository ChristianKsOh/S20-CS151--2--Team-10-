package edu.sjsu.cs.etrt.model.System;

import javax.swing.JFrame;

import edu.sjsu.cs.etrt.controller.FormController;
import edu.sjsu.cs.etrt.controller.PatientListController;
import edu.sjsu.cs.etrt.controller.RegistryController;
import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.controller.VisitQueueController;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Questionnaire.Form;

public class System {
	private VisitQueueController visits;
	private PatientListController patients;
	private RegistryController registry;
	
	public System(SystemController system) {
		visits=new VisitQueueController(system);
		patients=new PatientListController(system);
		registry=new RegistryController(patients,visits,system);
	}
	
	/**
	 * open registry to register a new patient
	 */
	public RegistryController getRegistry() {
		return registry;
	}
	
	/**
	 * Return VisitQueue instance for editing.
	 * @return visitqueue
	 */
	public VisitQueueController getVisitQueue() {
		return visits;
	}
	
	
	/**
	 * Returns PatientQueue instance for editing.
	 * @return patientqueue
	 */
	public PatientListController getPatientList() {
		return patients;
	}
}
