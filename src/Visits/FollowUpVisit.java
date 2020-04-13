package Visits;

import javax.swing.JPanel;

public class FollowUpVisit extends Visit{

	public FollowUpVisit(Patient patient, String doctor, String date, String time) {
		super(patient,doctor,date,time);
	}

	@Override
	public JPanel generateUI() {
		
	}

	@Override
	public String typeOfVisit() {
		
	}
}
