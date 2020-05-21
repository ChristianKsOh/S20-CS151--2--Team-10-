package edu.sjsu.cs.etrt.app;

import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.model.Patient.Address;
import edu.sjsu.cs.etrt.model.Patient.Demographics;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Patient.Treatment;
import edu.sjsu.cs.etrt.model.Visits.DateAndTime;
import edu.sjsu.cs.etrt.model.Visits.FollowUpVisit;

public class eTRT {
	
	/**
	 * Runs the program.
	 * @param args Required.
	 */
	public static void main(String[] args) {
		SystemController system=new SystemController();
		
		Patient p=new Patient("Max","Johnson","T","4/5/88","male","2/2/2000","18883664342","123456789","987654321","12345",Treatment.Grade0,4,new Address("1234 roadcreek court","333 creekcourt road","San Jose","CA","99999","USA"),new Demographics("Doctor","legal","PhD",""));
		Patient p2=new Patient("Kyle","Ant","","7/16/65","male","3/20/2010","14081234567","123456789","987654321","54354",Treatment.Grade0,0,new Address("1234 roadcreek court","","San Jose","CA","99999","USA"),new Demographics("Teacher","legal","BA","Math Teacher"));
		
		p.addScoreTFI(200);
		p.addScoreTFI(180);
		
		p.addScoreTHI(50);
		p.addScoreTHI(80);
		
		p2.addScoreTFI(150);
		p2.addScoreTFI(175);
		
		p2.addScoreTHI(15);
		p2.addScoreTHI(40);
		
		system.getPatientList().addPatient(p);
		system.getPatientList().addPatient(p2);
		
		system.getVisitQueue().enqueue(new FollowUpVisit(p,"Jones",4,28,2020,3,30,DateAndTime.PM,"Frequent ringing in ears"));
		system.getVisitQueue().enqueue(new FollowUpVisit(p2,"Smith",5,16,2020,5,30,DateAndTime.AM,""));
		
		system.openSystem();
	}
}
