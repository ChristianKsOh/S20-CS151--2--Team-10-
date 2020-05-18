package edu.sjsu.cs.etrt.model.Visits;

import edu.sjsu.cs.etrt.model.Project.Patient;


public class InitialVisit extends Visit{
	
	/**
	 * An appointment that must be created when adding a new patient.
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
	public InitialVisit(Patient patient, String doctor, int month, int day, int year, int hour, int minutes, boolean dateAndTimePeriod, String notes) {
		super(patient,doctor,month,day,year,hour,minutes,dateAndTimePeriod,notes);
	}

	@Override
	public boolean initialVisit() {
		return true;
	}
	
}