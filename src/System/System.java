package System;
import UI.SystemUI;
import Visits.Visit;
import Patients.Patient;
import Questionnaire.Form;

public abstract class System {
	
	/**
	 * open registry to register a new patient
	 */
	public void openRegistry() {
		
	}
	
	/**
	 * open Visits of Patient
	 * @param p Patient object
	 */
	public void openVisits(Patient p) {
		
	}
	
	/**
	 * update the Visits of a Patient
	 * @param v Visit object
	 */
	public void updateVisits(Visit v) {
	
	}
	
	/**
	 * remove a Visit from a Patient
	 * @param v Visit Object
	 */
	public void removeVisits(Visit v) {
		
	}
	
	/**
	 * update Patient info
	 * @param p Patient Object
	 */
	public void updatePatient(Patient p) {
		
	}
	
	/**
	 * open Questionnaire
	 * @param f Questionnaire Form Object
	 */
	public void openQuestionnaire(Form f) {
		
	}
	
	/**
	 * delete a Patient from PatientQueue
	 * @param p Patient Object
	 */
	public void deletePatient(Patient p) {
		
	}
	
	/**
	 * acquire a Patient from PatientQueue
	 * @param p Patient Object
	 */
	public void getPatient(Patient p) {
		
	}
}
