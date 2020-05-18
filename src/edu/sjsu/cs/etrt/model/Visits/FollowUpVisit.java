package edu.sjsu.cs.etrt.model.Visits;

import edu.sjsu.cs.etrt.model.Project.Patient;

public class FollowUpVisit extends Visit{
	
	/**
	 * Used when creating a visit in VisitQueue for patients that already exist.
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
	public FollowUpVisit(Patient patient, String doctor, int month, int day, int year, int hour, int minutes, boolean dateAndTimePeriod, String notes) {
		super(patient,doctor,month,day,year,hour,minutes,dateAndTimePeriod, notes);
	}

	@Override
	public boolean initialVisit() {
		return false;
	}
}
