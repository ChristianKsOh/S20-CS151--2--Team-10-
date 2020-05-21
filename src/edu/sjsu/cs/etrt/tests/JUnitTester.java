package edu.sjsu.cs.etrt.tests;

import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.model.Patient.Address;
import edu.sjsu.cs.etrt.model.Patient.Demographics;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Patient.Treatment;
import edu.sjsu.cs.etrt.model.Visits.DateAndTime;
import edu.sjsu.cs.etrt.model.Visits.FollowUpVisit;
import edu.sjsu.cs.etrt.model.Visits.Visit;
import junit.framework.TestCase;

public class JUnitTester  extends TestCase{
	
	/**
	 * All base panels and frames open smoothly.
	 */
	public void test1() {
		SystemController system=new SystemController();
		try {
			system.openPatientList();
			system.openRegistry();
			system.openSystem();
			system.openVisitCreate();
			system.openVisitQueue();
			assertTrue(true);
		}catch(Exception e) {
			assertTrue(false);
		}
	}
	
	/**
	 * Add and open patient page runs smoothly.
	 */
	public void test2() {
		SystemController system=new SystemController();
		Patient p=new Patient("Kyle","Ant","","7/16/65","male","3/20/2010","14081234567","123456789","987654321","54354",Treatment.Grade0,0,new Address("1234 roadcreek court","","San Jose","CA","99999","USA"),new Demographics("Teacher","legal","BA","Math Teacher"));
		try {
			system.getPatientList().addPatient(p);
			system.openForm(p);
			system.openPatient(p.getPatientID());
			system.openPatient(p.getPatientID(), true);
			system.openPatient(p.getPatientID(), false);
			system.openGraph(p);
			assertTrue(true);
		}catch(Exception e) {
			assertTrue(false);
		}
	}
	
	/**
	 * Add and open Visit page runs smoothly.
	 */
	public void test3() {
		SystemController system=new SystemController();
		Patient p=new Patient("Kyle","Ant","","7/16/65","male","3/20/2010","14081234567","123456789","987654321","54354",Treatment.Grade0,0,new Address("1234 roadcreek court","","San Jose","CA","99999","USA"),new Demographics("Teacher","legal","BA","Math Teacher"));
		Visit v=new FollowUpVisit(p,"Doctor",4,20,2020,3,30,DateAndTime.PM,"note");
		try {
			system.getVisitQueue().enqueue(v);
			system.openVisitQueue();
			system.openVisit(v);
			assertTrue(true);
		}catch(Exception e) {
			assertTrue(false);
		}
	}
	
	/**
	 * VisitQueue adds, removes, and peeks as intended.
	 */
	public void test4() {
		SystemController system=new SystemController();
		Patient p=new Patient("Kyle","Ant","","7/16/65","male","3/20/2010","14081234567","123456789","987654321","54354",Treatment.Grade0,0,new Address("1234 roadcreek court","","San Jose","CA","99999","USA"),new Demographics("Teacher","legal","BA","Math Teacher"));
		Visit v=new FollowUpVisit(p,"Doctor",4,20,2020,3,30,DateAndTime.PM,"note");
		
		system.getVisitQueue().enqueue(v);
		if(system.getVisitQueue().size()!=1) assertTrue(false);
		Visit x=system.getVisitQueue().peek();
		
		if(x.compareTo(v)!=0) assertTrue(false);
		if(system.getVisitQueue().size()!=1) assertTrue(false);
		
		system.getVisitQueue().dequeue();
		if(system.getVisitQueue().size()!=0) assertTrue(false);
		
		assertTrue(true);
	}
	
	/**
	 * PatientList adds, removes and retrieves as intended.
	 */
	public void test5() {
		SystemController system=new SystemController();
		Patient p=new Patient("Kyle","Ant","","7/16/65","male","3/20/2010","14081234567","123456789","987654321","54354",Treatment.Grade0,0,new Address("1234 roadcreek court","","San Jose","CA","99999","USA"),new Demographics("Teacher","legal","BA","Math Teacher"));
		
		system.getPatientList().addPatient(p);
		if(system.getPatientList().getSize()!=1) assertTrue(false);
		
		Patient x=system.getPatientList().getPatient(p.getPatientID());
		if(x.compareTo(p)!=0) assertTrue(false);
		if(system.getPatientList().getSize()!=1) assertTrue(false);
		
		system.getPatientList().removePatient(0);
		if(system.getPatientList().getSize()!=0) assertTrue(false);
		
		assertTrue(true);
	}
}
