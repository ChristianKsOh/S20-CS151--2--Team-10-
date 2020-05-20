package edu.sjsu.cs.etrt.model.Visits;

import edu.sjsu.cs.etrt.model.Patient.Patient;

public abstract class Visit implements Comparable<Visit>{
	private DateAndTime dateAndTime;
	private int visitNumber;
	private Patient patient;
	private String doctor;
	private String specialNote;
	
	/**
	 * Creates a new visit based on the patient, doctor name, 
	 * and time and date. Also generates a visit number.
	 * @param patient Patient object.
	 * @param doctor Doctor name.
	 * @param month Month of the appointment.
	 * @param day Day of the appointment.
	 * @param year Year of the appointment in yyyy format.
	 * @param hour Hour of the time of the appointment.
	 * @param minutes Minutes of the time of the appointment.
	 * @param dateAndTimePeriod time period of the appointment. Use DateAndTime.AM or DateAndTime.PM.
	 * @param notes Any (optional) special notes given when initializing visit.
	 */
	public Visit(Patient patient, String doctor, int month, int day, int year, int hour, int minute, boolean dateAndTimePeriod, String notes) {
		this.patient=patient;
		this.doctor=doctor;
		this.dateAndTime=new DateAndTime(month,day,year,hour,minute,dateAndTimePeriod);
		patient.setVisitNumber(patient.getVisitNumber()+1);
		visitNumber=patient.getVisitNumber();
		this.specialNote=notes;
	}
	
	/**
	 * Return the object of the patient in the visit.
	 * @return patient object.
	 */
	public Patient getPatient() {
		return patient;
	}
	
	/**
	 * Return the doctor's name.
	 * @return doctor's name.
	 */
	public String getDoctorName() {
		return doctor;
	}
	
	/**
	 * Get the date of the visit.
	 * @return date of visit.
	 */
	public String getDate() {
		return dateAndTime.getMonth()
				+"/"+dateAndTime.getDay()
				+"/"+dateAndTime.getYear();
	}
	
	/**
	 * Get the time of the visit.
	 * @return time of visit.
	 */
	public String getTime() {
		String minutes="";
		if(dateAndTime.getMinutes()<10) {
			minutes+=0;
		}
		minutes+=dateAndTime.getMinutes();
		
		return dateAndTime.getHour()
				+":"+minutes
				+" "+dateAndTime.getPeriod();
	}
	
	/**
	 * Get the full DateAndTime object.
	 * @return DateAndTime object.
	 */
	public DateAndTime getDateAndTime() {
		return dateAndTime;
	}
	
	/**
	 * Retrieve the visit number of the Visit.
	 * @return visit number.
	 */
	public int getVisitNumber() {
		return visitNumber;
	}
	
	/**
	 * Retrieve special notes of the Visit.
	 * @return special note.
	 */
	public String getSpecialNote() {
		return specialNote;
	}
	
	/**
	 * Changes the date of the visit.
	 * @param d new date.
	 */
	public void setDate(int month, int day, int year) {
		dateAndTime.setDate(month, day, year);
	}
	
	/**
	 * Changes the time of the visit.
	 * @param t new time.
	 */
	public void setTime(int hour, int minutes, boolean isPM) {
		dateAndTime.setTime(hour, minutes, isPM);
	}
	
	/**
	 * Change the doctor of the visit.
	 * @param doctorName new doctor's name
	 */
	public void changeDoctor(String doctorName) {
		doctor=doctorName;
	}
	
	/**
	 * Add a special note to the visit. Special note is 
	 * initially blank.
	 * @param note Special note text.
	 */
	public void addSpecialNote(String note) {
		specialNote=note;
	}
	
	/**
	 * Compares the Visit based on time and date, doctor, and patient.
	 */
	public int compareTo(Visit that) {
			if(this.getDateAndTime().compareTo(that.getDateAndTime())==0) {
				if(this.getDoctorName().compareTo(that.getDoctorName())==0) {
					if(this.getPatient().compareTo(that.getPatient())==0) {
						return 0;
					}
					return this.getPatient().compareTo(that.getPatient());
				}
				return this.getDate().compareTo(that.getDoctorName());
			}
			return this.getDateAndTime().compareTo(that.getDateAndTime());
		}
	
	/**
	 * Returns whether visit is an initial visit.
	 * @return boolean statement of whether the visit is an initial visit
	 */
	public abstract boolean initialVisit();
}
