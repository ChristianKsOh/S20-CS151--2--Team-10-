package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.*;
import edu.sjsu.cs.etrt.model.Questionnaire.*;
import edu.sjsu.cs.etrt.view.UI.FormView;

public class FormController {
	//instances of model, view, and system
	private Patient model;		//patient model
	private FormView view;
	private SystemController system;
	boolean displayType;
	private Patient patient;
	
	//form, controller, type
	public FormController(Patient p, SystemController s) {
		this.model = p;
		//this.patient = p;
		this.view = new FormView(this, s);
		this.system = s;
		this.displayType = false;
	}
	
	//form, controller, type
	public FormController(Patient p, SystemController s, boolean b) {
		this.model = p;
		//this.patient = p;
		this.view = new FormView(this, s);
		this.system = s;
		this.displayType = b;
	}
	
	//overwrite patient
	public void setScoreTHI(int s) {
		model.setScoreTHI(s);
	}
	
	public int getScoreTHI() {
		return model.getScoreTHI();
	}
	
	public void setScoreTFI(int s) {
		model.setScoreTFI(s);
	}
	
	public int getScoreTFI() {
		return model.getScoreTFI();
	}
	
	public JPanel getViewPanel()
	{
		return view.generateUI();
	}
	
	
	/**
	 * Updates the JFrame for any changes in the view.
	 */
	public void refreshFrame(){
		system.refreshFrame();
	}
	
	/**
	 * Opens the VisitQueue view in the JFrame.
	 */
	public void openVisitQueueView() {
		//system.openVisitQueue();
	}
	
	

}
