package Visits;

import javax.swing.JPanel;
import Project.Patient;
import UI.UIPanel;

public class InitialVisit extends Visit{
	public InitialVisit(Patient patient, String doctor, int month, int day, int year, int hour, int minutes, boolean isPM) {
		super(patient,doctor,month,day,year,hour,minutes,isPM);
	}

	@Override
	public boolean initialVisit() {
		return true;
	}
	
}