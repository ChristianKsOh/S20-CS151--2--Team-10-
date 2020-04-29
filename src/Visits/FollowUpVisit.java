package Visits;

import javax.swing.JPanel;
import Project.Patient;
import UI.UIPanel;

public class FollowUpVisit extends Visit{

	public FollowUpVisit(Patient patient, String doctor, String date, String time) {
		super(patient,doctor,date,time);
	}

	@Override
	public JPanel generateUI() {
		
	}

	@Override
	public boolean initialVisit() {
		return false;
	}
}
