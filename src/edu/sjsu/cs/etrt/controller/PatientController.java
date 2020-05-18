package edu.sjsu.cs.etrt.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.Category;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.view.UI.PatientView;

public class PatientController {
	private Patient model;
	private PatientView view;
	private SystemController systemController;
	
	public PatientController(Patient patient, PatientView view, SystemController systemController)
	{
		model = patient;
		this.view=view;
		
	}
	
	public void updatePatients()
	{
		view.refresh();
	}
	
	public String getFirstName() {
		return model.getFirstName();
	}
	
	public void setFirstName(String s) {
		model.setFirstName(s);
	}
	
	public String getLastName() {
		return model.getLastName();
	}
	
	public void setLastName(String s) {
		model.setLastName(s);
	}
	
	public String getMiddleInitial() {
		return model.getMiddleInitial();
	}
	
	public void setMiddleInitial(String s) {
		model.setMiddleInitial(s);
	}
	
	public String getRegistrationDate() {
		return model.getRegistrationDate();
	}
	
	public void setRegistrationDate(String s) {
		model.setRegistrationDate(s);
	}
	
	public String getGender() {
		return model.getGender();
	}
	
	public void setGender(String s) {
		model.setGender(s);
	}
	
	public String getDateOfBirth() {
		return model.getDateOfBirth();
	}
	
	public void setDateOfBirth(String s) {
		model.setDateOfBirth(s);
	}
	
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}
	
	public void setPhoneNumber(String s) {
		model.setPhoneNumber(s);
	}
	
	public String getSocialID() {
		return model.getSocialID();
	}
	
	public void setSocialId(String s) {
		model.setSocialID(s);
	}
	
	public String getInsuranceID() {
		return model.getInsuranceID();
	}
	
	public void setInsuranceID(String s) {
		model.setInsuranceID(s);
	}
	
	public String getOrderNumber() {
		return model.getOrderNumber();
	}
	
	public void setOrderNumber(String s) {
		model.setOrderNumber(s);;
	}
	
	public Category getCategory() {
		return model.getCategoryNum();
	}
	
	public void setCategory(Category s) {
		model.setCategoryNum(s);;
	}
	
	public int getVisitNumber() {
		return model.getVisitNumber();
	}
	
	public void setVisitNumber(int s) {
		model.setVisitNumber(s);
	}
	//Address Information
	public void setStreet1(String s)
	{
		model.setStreet1(s);
	}
	
	public String getStreet1() {
		return model.getStreet1();
	}
	
	public void setStreet2(String s) {
		model.setStreet2(s);
	}

	public String getStreet2() {
		return model.getStreet2();
	}
	
	public String getCity()
	{
		return model.getCity();
	}
	
	public void setCity(String s)
	{
		model.setCity(s);
	}
	
	public String getState()
	{
		return model.getState();
	}
	
	public void setState(String s)
	{
		model.setState(s);
	}
	
	public String getZip()
	{
		return model.getZip();
	}
	
	public void setZip(String s)
	{
		model.setZip(s);
	}
	
	public String getCountry()
	{
		return model.getCountry();
	}
	
	public void setCountry(String s)
	{
		model.setCountry(s);
	}
	//Demographic
	public String getWorkStatus()
	{
		return model.getWorkStatus();
	}
	
	public void setWorkStatus(String s)
	{
		model.setWorkStatus(s);
	}
	
	public String getEducationalDegree()
	{
		return model.getEducationalDegree();
	}
	
	public void setEducationalDegree(String s)
	{
		model.setEducationalDegree(s);
	}

	public String getNotes()
	{
		return model.getNotes();
	}
	
	public void setNotes(String s)
	{
		model.setNotes(s);
	}

	public String getOccupation()
	{
		return model.getOccupation();
	}
	
	public void setOccupation(String s)
	{
		model.setOccupation(s);
	}

	
	//Back to System GUI
	/*
	class SystemButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//switch to system GUI somehow
			try
			{
				
			}
			catch() {
				
			}
		}
	}*/
}
