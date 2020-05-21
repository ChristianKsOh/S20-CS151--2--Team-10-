package edu.sjsu.cs.etrt.controller;

import java.util.ArrayList;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Patient.Treatment;
import edu.sjsu.cs.etrt.view.UI.PatientView;

public class PatientController {
	private Patient model;
	private PatientView view;
	boolean edit;
	
	/**
	 * Initializes the model and view of PatientList.
	 * @param patient Patient model class.
	 * @param systemController SystemController holding this object.
	 * @param n Index of patient within the list.
	 */
	public PatientController(Patient patient, SystemController systemController, int n)
	{
		patient.setPatientID(n);
		model = patient;
		this.view=new PatientView(this,systemController);
		edit=false;
		
	}
	
	/**
	 * Initializes the model and view of PatientList. Allows editing upon opening.
	 * @param patient Patient model class.
	 * @param systemController SystemController holding this object.
	 * @param n Index of patient within the list.
	 * @param edit Allow editing upon opening.
	 */
	public PatientController(Patient patient, SystemController systemController, int n, boolean edit)
	{
		patient.setPatientID(n);
		model = patient;
		this.view=new PatientView(this,systemController, edit);
		this.edit=edit;
		
	}
	
	/**
	 * Return the patient ID.
	 * @return Patient index within the list
	 */
	public int getThisPatientId() {
		return model.getPatientID();
	}
	
	/**
	 * Returns the most recent TFI score.
	 * @return TFI score.
	 */
	public int getScoreTFI() {
		return model.getScoreTFI();
	}
	
	/**
	 * Update the patient's TFI score.
	 * @param score TFI score.
	 */
	public void addScoreTFI(int score) {
		model.addScoreTFI(score);
	}
	
	/**
	 * Returns an ArrayList of all the TFI scores.
	 * @return ArrayList of all the TFI scores.
	 */
	public ArrayList<Integer> getTFIHistory(){
		return model.getScoreTFIHistory();
	}
	
	/**
	 * Returns the most recent THI score.
	 * @return THI score.
	 */
	public int getScoreTHI() {
		return model.getScoreTHI();
	}
	
	/**
	 * Update the patient's THI score.
	 * @param score THI score.
	 */
	public void addScoreTHI(int score) {
		model.addScoreTHI(score);
	}
	
	/**
	 * Returns an ArrayList of all the THI scores.
	 * @return ArrayList of all the THI scores.
	 */
	public ArrayList<Integer> getTHIHistory(){
		return model.getScoreTHIHistory();
	}
	
	/**
	 * Get the patient's first name.
	 * @return First name.
	 */
	public String getFirstName() {
		return model.getFirstName();
	}
	
	/**
	 * Set the patient's first name.
	 * @param s First name.
	 */
	public void setFirstName(String s) {
		model.setFirstName(s);
	}
	
	/**
	 * Get the patient's last name.
	 * @return Last name.
	 */
	public String getLastName() {
		return model.getLastName();
	}
	
	/**
	 * Set the patient's last name.
	 * @param s Last name.
	 */
	public void setLastName(String s) {
		model.setLastName(s);
	}
	
	/**
	 * Get the patient's middle initial.
	 * @return Middle initial.
	 */
	public String getMiddleInitial() {
		return model.getMiddleInitial();
	}
	
	/**
	 * Set the patient's middle initial.
	 * @param s Middle initial without the dot.
	 */
	public void setMiddleInitial(String s) {
		model.setMiddleInitial(s);
	}
	
	/**
	 * Get the registration date of the patient as a string.
	 * @return String of registration date.
	 */
	public String getRegistrationDate() {
		return model.getRegistrationDate();
	}
	
	/**
	 * Set the registration date of the patient as a string.
	 * @param s String of registration date.
	 */
	public void setRegistrationDate(String s) {
		model.setRegistrationDate(s);
	}
	
	/**
	 * Get the patient's gender.
	 * @return Gender
	 */
	public String getGender() {
		return model.getGender();
	}
	
	/**
	 * Set the patient's gender.
	 * @param s Gender
	 */
	public void setGender(String s) {
		model.setGender(s);
	}
	
	/**
	 * Get the patient's birth date as a String.
	 * @return String of birth date.
	 */
	public String getDateOfBirth() {
		return model.getDateOfBirth();
	}
	
	/**
	 * Set the patient's birth date as a String.
	 * @param s String of birth date.
	 */
	public void setDateOfBirth(String s) {
		model.setDateOfBirth(s);
	}
	
	/**
	 * Get the patient's birth date as a String.
	 * @return String of birth date.
	 */
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}
	
	/**
	 * Set the patient's birth date as a String.
	 * @param s String of birth date.
	 */
	public void setPhoneNumber(String s) {
		model.setPhoneNumber(s);
	}
	
	/**
	 * Get the patient's social ID as a String.
	 * @return String of social ID.
	 */
	public String getSocialID() {
		return model.getSocialID();
	}
	
	/**
	 * Set the patient's social ID as a String.
	 * @param s String of social ID.
	 */
	public void setSocialId(String s) {
		model.setSocialID(s);
	}
	
	/**
	 * Get the patient's insurance ID as a String.
	 * @return String of insurance ID.
	 */
	public String getInsuranceID() {
		return model.getInsuranceID();
	}

	/**
	 * Set the patient's insurance ID as a String.
	 * @param s String of insurance ID.
	 */
	public void setInsuranceID(String s) {
		model.setInsuranceID(s);
	}
	
	/**
	 * Get the patient's order number as a String.
	 * @return String of order number.
	 */
	public String getOrderNumber() {
		return model.getOrderNumber();
	}
	
	/**
	 * Set the patient's order number as a String.
	 * @param s String of order number.
	 */
	public void setOrderNumber(String s) {
		model.setOrderNumber(s);;
	}
	
	/**
	 * Get the Treatment of the patient.
	 * @return Treatment.
	 */
	public Treatment getTreatment() {
		return model.getTreatmentNum();
	}

	/**
	 * Set the Treatment of the patient.
	 * @param s Treatment.
	 */
	public void setTreatment(Treatment s) {
		model.setTreatmentNum(s);;
	}
	
	/**
	 * Get the visit number of the patient.
	 * @return Visit number.
	 */
	public int getVisitNumber() {
		return model.getVisitNumber();
	}
	
	/**
	 * Set the visit number of the patient.
	 * @param s Visit number.
	 */
	public void setVisitNumber(int s) {
		model.setVisitNumber(s);
	}
	
	//Address Information
	/**
	 * Set the street of the address.
	 * @param s Street of the address.
	 */
	public void setStreet1(String s)
	{
		model.setStreet1(s);
	}
	
	/**
	 * Get the street of the address.
	 * @return s Street of the address.
	 */
	public String getStreet1() {
		return model.getStreet1();
	}
	
	/**
	 * Set the second street of the address if applicable.
	 * @param s Street of the address. Leave blank if not applicable.
	 */
	public void setStreet2(String s)
	{
		model.setStreet2(s);
	}
	
	/**
	 * Get the second street of the address if applicable.
	 * @return Street of the address. Blank if not applicable.
	 */
	public String getStreet2() {
		return model.getStreet2();
	}
	
	/**
	 * Get the city of the address.
	 * @return City of the address.
	 */
	public String getCity()
	{
		return model.getCity();
	}
	
	/**
	 * Set the city of the address.
	 * @param s City of the address.
	 */
	public void setCity(String s)
	{
		model.setCity(s);
	}
	
	/**
	 * Get the state of the address.
	 * @return State of the address.
	 */
	public String getState()
	{
		return model.getState();
	}
	
	/**
	 * Set the state of the address.
	 * @param s State of the address.
	 */
	public void setState(String s)
	{
		model.setState(s);
	}
	
	/**
	 * Get the zip code of the address as a String.
	 * @return Zip code of address.
	 */
	public String getZip()
	{
		return model.getZip();
	}
	
	/**
	 * Set the zip code of the address as a String.
	 * @param s Zip code of address.
	 */
	public void setZip(String s)
	{
		model.setZip(s);
	}
	
	/**
	 * Get the country of the address.
	 * @return Country of the address.
	 */
	public String getCountry()
	{
		return model.getCountry();
	}
	
	/**
	 * Set the country of the address.
	 * @param s Country of the address.
	 */
	public void setCountry(String s)
	{
		model.setCountry(s);
	}
	
	//Demographic
	/**
	 * Get the work status of patient.
	 * @return Work status.
	 */
	public String getWorkStatus()
	{
		return model.getWorkStatus();
	}
	
	/**
	 * Set the work status of patient.
	 * @param s Work status.
	 */
	public void setWorkStatus(String s)
	{
		model.setWorkStatus(s);
	}
	
	/**
	 * Get the educational degree of patient.
	 * @return Educational degree.
	 */
	public String getEducationalDegree()
	{
		return model.getEducationalDegree();
	}
	
	/**
	 * Set the educational degree of patient.
	 * @param s Educational degree.
	 */
	public void setEducationalDegree(String s)
	{
		model.setEducationalDegree(s);
	}
	
	/**
	 * Get any special notes on the patient.
	 * @return Notes.
	 */
	public String getNotes()
	{
		return model.getNotes();
	}
	
	/**
	 * Set special notes on the patient.
	 * @param s Notes.
	 */
	public void setNotes(String s)
	{
		model.setNotes(s);
	}

	/**
	 * Get occupation of patient.
	 * @return Occupation.
	 */
	public String getOccupation()
	{
		return model.getOccupation();
	}
	
	/**
	 * Set occupation of patient.
	 * @param s Occupation.
	 */
	public void setOccupation(String s)
	{
		model.setOccupation(s);
	}
	
	/**
	 * Retrieve the UI view panel.
	 * @return View's JPanel.
	 */
	public JPanel getViewPanel()
	{
		return view.generateUI();
	}
}
