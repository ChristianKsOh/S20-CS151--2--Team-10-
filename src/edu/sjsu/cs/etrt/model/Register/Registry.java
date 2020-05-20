package edu.sjsu.cs.etrt.model.Register;

//import edu.sjsu.cs.etrt.model.Visits.InitialVisit;
import edu.sjsu.cs.etrt.model.Visits.Visit;
import edu.sjsu.cs.etrt.model.Visits.VisitQueue;
import edu.sjsu.cs.etrt.controller.PatientController;
import edu.sjsu.cs.etrt.controller.PatientListController;
import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.controller.VisitQueueController;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Patient.PatientList;
import edu.sjsu.cs.etrt.model.Patient.Treatment;

public class Registry {
	PatientListController patientListCtrl;		//patient list of patient
	
	/**
	 * registry constructor with PatientListController
	 * @param p PatientListController object
	 */
	public Registry(PatientListController p) {
		patientListCtrl = p;		//acquire patientList		
	}
	
	/**
	 * returns patientList size-1 to avoid NullPointer
	 * @return patientList size
	 */
	public int getSize() {
		return patientListCtrl.getSize()-1;
	}
	
	/**
	 * return patient object w/ index based on size
	 * @return patient object
	 */
	public Patient getPatient() {
		return patientListCtrl.getPatient(getSize());
	}
	
	/**
	 * add patient to patientList
	 * @param p patientObject
	 */
	public void addPatientToList(Patient p) {
		patientListCtrl.addPatient(p);
	}
	
	/**
	 * set first name of patient object
	 * @param s String text
	 */
	public void setFirstName(String s) {
		getPatient().setFirstName(s);
	}
	
	/**
	 * set last name of patient object
	 * @param s String text
	 */
	public void setLastName(String s) {
		getPatient().setLastName(s);
	}
	
	/**
	 * set middle name of patient object
	 * @param s String text
	 */
	public void setMiddleInitial(String s) {
		getPatient().setMiddleInitial(s);
	}
	
	/**
	 * set registration date of patient object
	 * @param s String text
	 */
	public void setRegDate(String s) {
		getPatient().setRegistrationDate(s);
	}
	
	/**
	 * set date of birth of patient object
	 * @param s String text
	 */
	public void setDOB(String s) {
		getPatient().setDateOfBirth(s);
	}
	
	/**
	 * set phone of patient object
	 * @param s String text
	 */
	public void setPhone(String s) {
		getPatient().setPhoneNumber(s);
	}
	
	/**
	 * set gender patient object
	 * @param s String text
	 */
	public void setGender(String s) {
		getPatient().setGender(s);
	}
	
	/**
	 * set social id of patient object
	 * @param s String text
	 */
	public void setSID(String s) {
		getPatient().setSocialID(s);
	}
	
	/**
	 * get treatment number of patient object
	 * @return Treatment enum
	 */
	public Treatment getTreatment() {
		return getPatient().getTreatmentNum();
	}
	
	/**
	 * set firstName of patient object
	 * @return int THI score
	 */
	public int getScoreTHI() {
		return getPatient().getScoreTHI();
	}
	
	/**
	 * get TFI score of patient object
	 * @return int TFI score
	 */
	public int getScoreTFI() {
		return getPatient().getScoreTFI();
	}
	
	/**
	 * set treatment based on TFI and THI scores combined
	 */
	public void setTreatment() {
		int sum = getScoreTHI() + getScoreTFI();		//add two scores
		//base treatment on accumulated sum = max total = 350
		if(sum <= 70)
			getPatient().setTreatmentNum(Treatment.Grade0);
		else if(sum <= 140)
			getPatient().setTreatmentNum(Treatment.Grade1);
		else if(sum <= 210) 
			getPatient().setTreatmentNum(Treatment.Grade2);
		else if(sum <= 280)
			getPatient().setTreatmentNum(Treatment.Grade3);
		else
			getPatient().setTreatmentNum(Treatment.Grade4);
	}
	
	/**
	 * set insurance number of patient object
	 * @param s String text
	 */
	public void setInsurance(String s) {
		getPatient().setInsuranceID(s);
	}
	
	/**
	 * set visit number of patient object
	 * @param s String text
	 */
	public void setVisitNum(int i) {
		getPatient().setVisitNumber(i);
	}
	
	/**
	 * set first address of patient object
	 * @param s String text
	 */
	public void setStreet1(String s) {
		getPatient().setStreet1(s);
	}
	
	/**
	 * set second address of patient object
	 * @param s String text
	 */
	public void setStreet2(String s) {
		getPatient().setStreet2(s);
	}
	
	/**
	 * set city of patient object
	 * @param s String text
	 */
	public void setCity(String s) {
		getPatient().setCity(s);
	}

	/**
	 * set state of patient object
	 * @param s String text
	 */
	public void setState(String s) {
		getPatient().setState(s);
	}
	
	/**
	 * set ZIP of patient object
	 * @param s String text
	 */
	public void setZIP(String s) {
		getPatient().setZip(s);
	}
	
	/**
	 * set country of patient object
	 * @param s String text
	 */
	public void setCountry(String s) {
		getPatient().setCountry(s);;
	}
	
	/**
	 * set work status of patient object
	 * @param s String text
	 */
	public void setWork(String s) {
		getPatient().setWorkStatus(s);
	}
	
	/**
	 * set educational degree of patient object
	 * @param s String text
	 */
	public void setDegree(String s) {
		getPatient().setEducationalDegree(s);
	}
	
	/**
	 * set occupation of patient object
	 * @param s String text
	 */
	public void setOccupation(String s) {
		getPatient().setOccupation(s);
	}
	
	/**
	 * set notes of patient object 
	 * @param s String text
	 */
	public void setNotes(String s) {
		getPatient().setNotes(s);
	}
	
}




