package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Patient.Treatment;
import edu.sjsu.cs.etrt.model.Register.Registry;
import edu.sjsu.cs.etrt.view.UI.RegistryView;

public class RegistryController {
	private Registry model;		//model
	private RegistryView view;	//view
	private SystemController system;	//system
	
	/**
	 * constructor for RegistryController; model creates a new Registry by passing PatientListController,
	 * system gets passed the SystemController (sys), and view creates a new RegistryView(RegistryController,
	 * SystemController)
	 * @param p PatientListController
	 * @param sys SystemController
	 */
	public RegistryController(PatientListController p, SystemController sys) {
		model=new Registry(p);
		system=sys;
		view=new RegistryView(this,sys);
	}
	
	/**
	 * add patient to patientList with model
	 * @param p Patient object
	 */
	public void addPatientToList(Patient p) {
		model.addPatientToList(p);
	}
	
	/**
	 * return size of model
	 * @return int model size
	 */
	public int getSize() {
		return model.getSize();
	}
	
	/**
	 * return patient of model
	 * @return Patient object
	 */
	public Patient getPatient() {
		return model.getPatient();
	}
	
	/**
	 * set first name of patient with model 
	 * @param s String text
	 */
	public void setFirstName(String s) {
		model.setFirstName(s);
	}
	
	/**
	 * set last name of patient with model 
	 * @param s String text
	 */
	public void setLastName(String s) {
		model.setLastName(s);
	}
	
	/**
	 * set middle name or initial of patient with model 
	 * @param s String text
	 */
	public void setMiddleInitial(String s) {
		model.setMiddleInitial(s);
	}
	
	/**
	 * set registration date of patient with model 
	 * @param s String text
	 */
	public void setRegDate(String s) {
		model.setRegDate(s);
	}
	
	/**
	 * set date of birth of patient with model 
	 * @param s String text
	 */
	public void setDOB(String s) {
		model.setDOB(s);
	}
	
	/**
	 * set phone number of patient with model 
	 * @param s String text
	 */
	public void setPhone(String s) {
		model.setPhone(s);
	}
	
	/**
	 * set gender of patient with model 
	 * @param s String text
	 */
	public void setGender(String s) {
		model.setGender(s);
	}
	
	/**
	 * set social ID of patient with model 
	 * @param s String text
	 */
	public void setSID(String s) {
		model.setSID(s);
	}
	
	/**
	 * get treatment of patient with model
	 * @return Treatment
	 */
	public Treatment getTreatment() {
		return model.getTreatment();
	}
	
	/**
	 * set THI score of patient with model 
	 * @return int THI score
	 */
	public int getScoreTHI() {
		return model.getScoreTHI();
	}
	
	/**
	 * set TFI score of patient with model 
	 * @return int TFI score
	 */
	public int getScoreTFI() {
		return model.getScoreTFI();
	}
	
	/**
	 * set treatment based on TFI and THI scores combined
	 */
	public void setTreatment() {
		model.setTreatment();
	}
	
	/**
	 * set insurance ID of patient with model 
	 * @param s String text
	 */
	public void setInsurance(String s) {
		model.setInsurance(s);
	}
	
	/**
	 * set visit number of patient to default 0 using model
	 */
	public void setVisitNum() {
		model.setVisitNum(0);
	}
	
	/**
	 * set street 1 of patient with model 
	 * @param s String text
	 */
	public void setStreet1(String s) {
		model.setStreet1(s);
	}
	
	/**
	 * set street 2 of patient with model 
	 * @param s String text
	 */
	public void setStreet2(String s) {
		model.setStreet2(s);
	}
	
	/**
	 * set city of patient with model 
	 * @param s String text
	 */
	public void setCity(String s) {
		model.setCity(s);
	}
	
	/**
	 * set state of patient with model 
	 * @param s String text
	 */
	public void setState(String s) {
		model.setState(s);
	}
	
	/**
	 * set ZIP of patient with model 
	 * @param s String text
	 */
	public void setZIP(String s) {
		model.setZIP(s);
	}
	
	/**
	 * set country of patient with model 
	 * @param s String text
	 */
	public void setCountry(String s) {
		model.setCountry(s);;
	}
	
	/**
	 * set work of patient with model 
	 * @param s String text
	 */
	public void setWork(String s) {
		model.setWork(s);
	}
	
	/**
	 * set educational degree of patient with model 
	 * @param s String text
	 */
	public void setDegree(String s) {
		model.setDegree(s);
	}
	
	/**
	 * set occupation of patient with model 
	 * @param s String text
	 */
	public void setOccupation(String s) {
		model.setOccupation(s);
	}
	
	/**
	 * set notes of patient with model 
	 * @param s String text
	 */
	public void setNotes(String s) {
		model.setNotes(s);
	}
	
	/**
	 * open system view back in main
	 */
	public void openSystem()
	{
		system.openSystem();
	}	
	
	/**
	 * Retrieve the UI view panel.
	 * @return View's JPanel.
	 */
	public JPanel getViewPanel() {
		return view.generateUI();
	}
}
