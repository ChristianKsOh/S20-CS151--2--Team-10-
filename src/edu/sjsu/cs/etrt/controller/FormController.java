package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.*;
import edu.sjsu.cs.etrt.view.UI.FormView;

public class FormController {
	//instances of model, view, and system
	private Patient model;		//patient model
	private FormView view;
	private SystemController system;
	//patient, s
	public FormController(Patient p, SystemController s) {
		this.model = p;
		this.view = new FormView(this, s);
		this.system = s;
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
	
	public void openView() {
		system.openPatient(model.getVisitNumber());
	}
	//return name
	public String getName(){
		return model.getFirstName() + model.getLastName();
	}
	
	public int getVisitNumber() {
		return model.getVisitNumber();
	}
	
	
	

}
