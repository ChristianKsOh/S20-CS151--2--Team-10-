package edu.sjsu.cs.etrt.model.Register;

import edu.sjsu.cs.etrt.controller.PatientListController;
import edu.sjsu.cs.etrt.model.Patient.Patient;
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
	 * set treatment number of patient object
	 * @param t Treatment num
	 */
	public void setTreatment(Treatment t) {
		getPatient().setTreatmentNum(t);
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
	 * set insurance number of patient object
	 * @param s String text
	 */
	public void setInsurance(String s) {
		getPatient().setInsuranceID(s);
	}
	
	/**
	 * set visit number of patient object
	 * @param i visit number
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




