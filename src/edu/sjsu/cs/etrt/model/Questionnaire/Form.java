package edu.sjsu.cs.etrt.model.Questionnaire;
import edu.sjsu.cs.etrt.model.Patient.*;

public class Form {
	private Patient patient;	//patient object
	
	/**
	 * Creates a new visit based on the patient, doctor name, 
	 * and time and date. Also generates a visit number.
	 * @param patient object of patient
	 */
	public Form(Patient patient) {
		this.patient = patient;	
	}
	
	/**
	 * get patient of form
	 * @return patient object
	 */
	public Patient getPatient() {
		return patient;
	}
	
	/**
<<<<<<< HEAD
	 * set score of form
	 * @param s score object
=======
	 * set THI score of patient
	 * @param s score value
>>>>>>> branch 'master' of https://github.com/ChristianKsOh/S20-CS151--2--Team-10-.git
	 */
	public void setScoreTHI(int s) {
		patient.addScoreTHI(s);
	}
	
	/**
<<<<<<< HEAD
	 * get THI score of form
	 * @return int THI score
=======
	 * get THI patient score
	 * @return THI score.
>>>>>>> branch 'master' of https://github.com/ChristianKsOh/S20-CS151--2--Team-10-.git
	 */
	public int getScoreTHI() {
		return patient.getScoreTHI();
	}
		
	/**
	 * set TFI score of form
	 * @param s
	 */
	public void setScoreTFI(int s) {
		patient.addScoreTFI(s);
	}
	
	/**
	 * get TFI score of form
	 * @return int TFI score
	 */
	public int getScoreTFI() {
		return patient.getScoreTFI();
	}
		
	/**
	 * get name of patient of form; concatenate strings of first/middle/last name
	 * @return String name of patient
	 */
	public String getName(){
		return patient.getFirstName() + " "  + patient.getMiddleInitial() 
		+ " " + patient.getLastName();
	}
		
	/**
	 * get visit number of patient
	 * @return int Visit number
	 */
	public int getVisitNumber() {
		return patient.getVisitNumber();
	}
	
	
	/**
	 * set THI score of form to patient THI score
	 * @param thi score value
	 */
	public void setTHIScore(int thi) {
		this.getPatient().addScoreTFI(thi);
	}
	
	/**
	 * get THI score of patient
	 * @return int THI score of patient
	 */
	public int getTHIScore() {
		return this.getPatient().getScoreTHI();
	}	
	
	
	/**
	 * set TFIscore of patient
	 * @param tfi tfi score value
	 */
	public void setTFIScore(int tfi) {
		this.getPatient().addScoreTFI(tfi);
	}
	
	/**
	 * get TFIScore of patient
	 * @return int TFI score of patient
	 */ 
	public int getTFIScore() {
		return this.getPatient().getScoreTFI();
	}	
	
}
