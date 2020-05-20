package edu.sjsu.cs.etrt.model.Register;

//import edu.sjsu.cs.etrt.model.Visits.InitialVisit;
import edu.sjsu.cs.etrt.model.Visits.Visit;
import edu.sjsu.cs.etrt.model.Visits.VisitQueue;
import edu.sjsu.cs.etrt.controller.PatientController;
import edu.sjsu.cs.etrt.controller.PatientListController;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Patient.PatientList;

public class Registry {
	PatientListController patientListCtrl;		//patient list of patient
	PatientController patientCtrl;				//controller of patient
	VisitQueue vQueue;		//visit queue of patient
	Visit visit;		//visit of patient: convert to InitialVisit?
	
	//constructor - no visit queue
	public Registry(PatientListController p) {
		this.patientListCtrl = p;		//acquire patientList
		//this.vQueue = new VisitQueue();	
	}
	
	public Patient getPatient() {
		return patientListCtrl.getPatient(patientListCtrl.getSize());
	}
	
	/**
	 * insert new patient
	 */
	public void addPatientToList(Patient p) {
		patientListCtrl.addPatient(p);
	}
	
	public void setRegDate(String s) {
		getPatient().setRegistrationDate(s);
	}
	
	public void setDOB(String s) {
		getPatient().setDateOfBirth(s);
	}
	
	public void setPhone(String s) {
		getPatient().setPhoneNumber(s);
	}
	
	public void setGender(String s) {
		getPatient().setGender(s);
	}
	
	public void setSID(String s) {
		getPatient().setSocialID(s);
	}
	
	
	public void setCategory(int i) {
		getPatient().setTreatmentNum(patientCtrl.getTreatment());
	} 
	
	public void setInsurance(String s) {
		getPatient().setInsuranceID(s);
	}
	
	public void setVisitNum(int i) {
		getPatient().setVisitNumber(i);
	}
	
	/*
	public void setScoreTFI(int i) {
		getPatient().setScoreTFI(i);
	}
	
	public void setScoreTHI(int i) {
		getPatient().setScoreTHI(i);
	}
	*/
	
	public void setStreet1(String s) {
		getPatient().setStreet1(s);
	}
	
	public void setCity(String s) {
		getPatient().setCity(s);
	}
	
	public void setState(String s) {
		getPatient().setState(s);
	}
	
	public void setZIP(String s) {
		getPatient().setZip(s);
	}
	
	public void setCountry(String s) {
		getPatient().setCountry(s);;
	}
	
	public void setWork(String s) {
		getPatient().setWorkStatus(s);
	}
	
	public void setDegree(String s) {
		getPatient().setEducationalDegree(s);
	}
	
	public void setOccupation(String s) {
		getPatient().setOccupation(s);
	}
	
	public void setNotes(String s) {
		getPatient().setNotes(s);
	}
	
}
	
	/**
	 * insert new visit into queue
	 */
	/*
	public void insertInitialVisit() {
		this.vQueue.add(visit);
	}
	*/
	
	
	
	
	
