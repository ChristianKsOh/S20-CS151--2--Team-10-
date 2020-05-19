package edu.sjsu.cs.etrt.model.System;

import javax.swing.JFrame;

import edu.sjsu.cs.etrt.controller.PatientListController;
import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.controller.VisitQueueController;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Questionnaire.Form;

public class System {
	private VisitQueueController visits;
	private PatientListController patients;
	//private Registry
	private Form questionnaire;
	
	public System(SystemController system) {
		visits=new VisitQueueController(system);
		patients=new PatientListController();
		//Initialize registry
	}
	
	/**
	 * open registry to register a new patient
	 */
	public Registry getRegistry() {
		
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
	
	/**
	 * open Questionnaire
	 * @param f Questionnaire Form Object
	 */
	public Form openQuestionnaire(Form f) {
		return questionnaire;
	}
}
