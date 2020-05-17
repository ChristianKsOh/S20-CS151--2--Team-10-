package edu.sjsu.cs.etrt.controller;



import edu.sjsu.cs.etrt.model.Questionnaire.*;
import edu.sjsu.cs.etrt.model.Project.Patient;
import edu.sjsu.cs.etrt.model.Visits.*;
import edu.sjsu.cs.etrt.view.UI.VisitView;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormController {
	private Form model;
	//private FormView view;
	
	public FormController(Form form) {//, FormView view) {
		model=form;
		//this.view=new FormView();
	}
	
	/**
	 * return patient of form
	 * @return patient object
	 */
	public Patient getPatient() {
		return model.getPatient();
	}
	
	
	public Form getModel() {
		return model;
	}

}
