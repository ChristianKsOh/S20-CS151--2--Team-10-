package edu.sjsu.cs.etrt.tests;

import edu.sjsu.cs.etrt.controller.PatientController;
import edu.sjsu.cs.etrt.controller.PatientListController;
import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.controller.VisitController;
import edu.sjsu.cs.etrt.model.Patient.Address;
import edu.sjsu.cs.etrt.model.Patient.Demographics;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Patient.PatientList;
import edu.sjsu.cs.etrt.model.Patient.Treatment;
import edu.sjsu.cs.etrt.model.Questionnaire.Form;
import edu.sjsu.cs.etrt.model.Register.Registry;
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
	
	/**
	 * Registry adds and retrieves just like PatientList would
	 */
	public void test6() {
		PatientList list=new PatientList();
		Patient p=new Patient("Kyle","Ant","","7/16/65","male","3/20/2010","14081234567","123456789","987654321","54354",Treatment.Grade0,0,new Address("1234 roadcreek court","","San Jose","CA","99999","USA"),new Demographics("Teacher","legal","BA","Math Teacher"));
		Patient toBeRegistered=new Patient("Max","Johnson","T","4/5/88","male","2/2/2000","18883664342","123456789","987654321","12345",Treatment.Grade0,4,new Address("1234 roadcreek court","333 creekcourt road","San Jose","CA","99999","USA"),new Demographics("Doctor","legal","PhD",""));
		
		list.addPatient(p);
		list.addPatient(toBeRegistered);
		
		SystemController system=new SystemController();
		Registry r=new Registry(new PatientListController(system));
		
		r.addPatientToList(p);
		if(r.getPatient().compareTo(list.getPatient(0))!=0) assertTrue(false);
		
		r.addPatientToList(toBeRegistered);
		if(r.getPatient().compareTo(list.getPatient(1))!=0) assertTrue(false);
		
		assertTrue(true);
	}
	
	/**
	 * Deep checks PatientController's variables matches Patient's variables.
	 * Also check variables are initialized properly (not null).
	 */
	public void test7() {
		Patient p=new Patient("Kyle","Ant","","7/16/65","male","3/20/2010","14081234567","123456789","987654321","54354",Treatment.Grade0,0,new Address("1234 roadcreek court","","San Jose","CA","99999","USA"),new Demographics("Teacher","legal","BA","Math Teacher"));
		PatientController ctrl=new PatientController(p,new SystemController(),5);
		
		assertTrue((p.getCity().equals(ctrl.getCity())
				&&p.getCountry().equals(ctrl.getCountry())
				&&p.getDateOfBirth().equals(ctrl.getDateOfBirth())
				&&p.getEducationalDegree().equals(ctrl.getEducationalDegree())
				&&p.getFirstName().equals(ctrl.getFirstName())
				&&p.getGender().equals(ctrl.getGender())
				&&p.getInsuranceID().equals(ctrl.getInsuranceID())
				&&p.getLastName().equals(ctrl.getLastName())
				&&p.getMiddleInitial().equals(ctrl.getMiddleInitial())
				&&p.getNotes().equals(ctrl.getNotes())
				&&p.getOccupation().equals(ctrl.getOccupation())
				&&p.getOrderNumber().equals(ctrl.getOrderNumber())
				&&p.getPatientID()==ctrl.getThisPatientId())
				&&p.getPhoneNumber().equals(ctrl.getPhoneNumber())
				&&p.getRegistrationDate().equals(ctrl.getRegistrationDate())
				&&p.getScoreTFI()==ctrl.getScoreTFI()
				&&p.getScoreTFIHistory().equals(ctrl.getTFIHistory())
				&&p.getScoreTHI()==ctrl.getScoreTHI()
				&&p.getScoreTHIHistory().equals(ctrl.getTHIHistory())
				&&p.getSocialID().equals(ctrl.getSocialID())
				&&p.getState().equals(ctrl.getState())
				&&p.getStreet1().equals(ctrl.getStreet1())
				&&p.getStreet2().equals(ctrl.getStreet2())
				&&p.getTreatmentNum().equals(ctrl.getTreatment())
				&&p.getVisitNumber()==ctrl.getVisitNumber()
				&&p.getWorkStatus().equals(ctrl.getWorkStatus())
				&&p.getZip().equals(ctrl.getZip()));
	}
	
	/**
	 * Deep checks VisitController's variables matches Visit's variables
	 */
	public void test8() {
		SystemController system=new SystemController();
		Patient p=new Patient("Kyle","Ant","","7/16/65","male","3/20/2010","14081234567","123456789","987654321","54354",Treatment.Grade0,0,new Address("1234 roadcreek court","","San Jose","CA","99999","USA"),new Demographics("Teacher","legal","BA","Math Teacher"));
		Visit v=new FollowUpVisit(p,"Doctor",4,20,2020,3,30,DateAndTime.PM,"note");
		VisitController ctrl=new VisitController(v,system);
		
		assertTrue(v.getDate().equals(ctrl.getDate())
				&&v.getDateAndTime().compareTo(ctrl.getDateAndTimeObject())==0
				&&v.getDoctorName().equals(ctrl.getDoctorName())
				&&(v.getForm()==null&&ctrl.getForm()==null)
				&&v.getPatient().equals(ctrl.getPatient())
				&&v.getSpecialNote().equals(ctrl.getSpecialNote())
				&&v.getTime().equals(ctrl.getTime())
				&&v.getVisitNumber()==ctrl.getVisitNumber());
	}
	
	/**
	 * Checks Form updates Patient correctly
	 */
	public void test9() {
		Patient p=new Patient("Kyle","Ant","","7/16/65","male","3/20/2010","14081234567","123456789","987654321","54354",Treatment.Grade0,0,new Address("1234 roadcreek court","","San Jose","CA","99999","USA"),new Demographics("Teacher","legal","BA","Math Teacher"));
		Form f=new Form(p);
		p.addScoreTFI(100);
		p.addScoreTHI(100);
		
		f.setScoreTFI(80);
		f.setScoreTHI(80);
		
		assertTrue(p.getScoreTFI()==80&&p.getScoreTHI()==80);
	}
}
