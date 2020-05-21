package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.*;
import edu.sjsu.cs.etrt.view.UI.FormView;
import edu.sjsu.cs.etrt.model.Questionnaire.Form;

public class FormController {
	//instances of model, view, and system
	private Form model;		//Form model
	private FormView view;
	private SystemController system;
	
	/**
	 * FormController constructor consisting of manipulating Patient and SystemController
	 * @param p Patient object
	 * @param s SystemController
	 */
	public FormController(Patient p, SystemController s) {
		this.model = new Form(p);
		this.view = new FormView(this);
		this.system = s;
	}
	
	
	/**
	 * get patient using model
	 * @return patient object
	 */
	public Patient getPatient() {
		return model.getPatient();
	}
	
	/**
	 * set THI score of patient from parameter using model
	 * @param s int THI score
	 */
	public void setScoreTHI(int s) {
		model.setScoreTHI(s);
	}
		
	/**
	 * get score of THI of patient using model
	 * @return THI score
	 */
	public int getScoreTHI() {
		return model.getScoreTHI();
	}
		
	/**
	 * set score of TFI of patient from parameter using model
	 * @param s int TFI score
	 */
	public void setScoreTFI(int s) {
		model.setScoreTFI(s);
	}
		
	/**
	 * get score of TFI of patient using model
	 * @return int TFI score
	 */
	public int getScoreTFI() {
		return model.getScoreTFI();
	}
		
	/**
	 * get name of patient using model
	 * @return String name
	 */
	public String getName(){
		return model.getName();
	}
		
	/**
	 * get visit number of patient using model
	 * @return visit number
	 */
	public int getVisitNumber() {
		return model.getVisitNumber();
	}
	
	
	/**
	 * set THI score of patient from parameter using model
	 * @param thi score value
	 */
	public void setTHIScore(int thi) {
		model.setScoreTFI(thi);
	}
	
	/**
	 * get THI patient score using model
	 * @return thi score value
	 */
	public int getTHIScore() {
		return model.getScoreTHI();
	}	
	
	
	/**
	 * set TFIscore of patient from parameter using model
	 * @param s score value
	 */
	public void setTFIScore(int s) {
		model.setScoreTFI(s);
	}
	
	/**
	 * get TFIScore of patient using model 
	 * @return tfi score value
	 */ 
	public int getTFIScore() {
		return model.getScoreTFI();
	}	
	
	/**
	 * set treatment based on TFI and THI scores combined
	 */
	public void setTreatment() {
		model.setTreatment();
	}
	
	/**
	 * open patient from system using model and for index
	 */
	public void openView() {
		system.openPatient(model.getPatient().getPatientID());
	}
	
	/**
	 * view generation of panel refresh
	 * @return view generation of panel
	 */
	public JPanel getViewPanel()
	{
		return view.generateUI();
	}
		

}
