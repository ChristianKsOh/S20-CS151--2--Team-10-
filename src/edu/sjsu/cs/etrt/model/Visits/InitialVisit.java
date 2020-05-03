package edu.sjsu.cs.etrt.model.Visits;

import edu.sjsu.cs.etrt.model.Project.Patient;


public class InitialVisit extends Visit{
	public InitialVisit(Patient patient, String doctor, int month, int day, int year, int hour, int minutes, boolean isPM) {
		super(patient,doctor,month,day,year,hour,minutes,isPM);
	}

	@Override
	public boolean initialVisit() {
		return true;
	}
	
}