package Visits;

import Project.Patient;
import UI.UIPanel;

public abstract class Visit implements Comparable, UIPanel{
	private String date;
	private String time;
	private int visitNumber;
	private Patient patient;
	private String doctor;
	
	/**
	 * Creates a new visit based on the patient, doctor name, 
	 * and time and date. Also generates a visit number.
	 * @param patient Object of patient
	 * @param doctor doctor name
	 * @param date date of visit
	 * @param time time of visit
	 */
	public Visit(Patient patient, String doctor, String date, String time) {
		
	}
	
	/**
	 * Return the object of the patient in the visit.
	 * @return patient object.
	 */
	public Patient getPatient() {
		
	}
	
	/**
	 * Return the doctor's name.
	 * @return doctor's name.
	 */
	public String getDoctorName() {
		
	}
	
	/**
	 * Get the date of the visit.
	 * @return date of visit.
	 */
	public String getDate() {
		
	}
	
	/**
	 * Get the time of the visit.
	 * @return time of visit.
	 */
	public String getTime() {
		
	}
	
	/**
	 * Retrieve the visit number of the Visit.
	 * @return visit number.
	 */
	public int getVisitNumber() {
		
	}
	
	/**
	 * Changes the date of the visit.
	 * @param d new date.
	 */
	public void setDate(String d) {
		
	}
	
	/**
	 * Changes the time of the visit.
	 * @param t new time.
	 */
	public void setTime(String t) {
		
	}
	
	/**
	 * Change the doctor of the visit.
	 * @param doctorName new doctor's name
	 */
	public void changeDoctor(String doctorName) {
		
	}
	
	/**
	 * Compares the Visit based on time and date.
	 */
	public int compareTo(Object o) {
		
	}
	
	/**
	 * Returns whether visit is an initial visit.
	 * @return boolean statement of whether the visit is an initial visit
	 */
	public abstract boolean initialVisit();
}
