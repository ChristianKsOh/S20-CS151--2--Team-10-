package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.*;
import edu.sjsu.cs.etrt.model.Questionnaire.*;
import edu.sjsu.cs.etrt.view.UI.FormView;

public class FormController {
	//instances of model, view, and system
	private Form model;
	private FormView view;
	private SystemController system;
	boolean displayType;
	private Patient patient;
	
	//form, controller, type
	public FormController(Patient p, Form f, SystemController s) {
		this.model = f;
		this.patient = p;
		this.view = new FormView(this, s);
		this.system = s;
		this.displayType = false;
	}
	
	//form, controller, type
	public FormController(Patient p, Form f, SystemController s, boolean b) {
		this.model = f;
		this.patient = p;
		this.view = new FormView(this, s);
		this.system = s;
		this.displayType = b;
	}
	
	//overwrite form methods
	public void setTHIScore(int s) {
		model.setTHIScore(s);
	}
	
	public int getTHIScore() {
		return model.getTHIScore();
	}
	
	public void setTFIScore(int s) {
		model.setTFIScore(s);
	}
	
	public int getTFIScore() {
		return model.getTFIScore();
	}
	
	public JPanel getViewPanel()
	{
		return view.generateUI();
	}
	

}
