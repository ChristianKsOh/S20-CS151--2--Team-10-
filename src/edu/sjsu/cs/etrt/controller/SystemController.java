package edu.sjsu.cs.etrt.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs.etrt.view.UI.PatientView;
import edu.sjsu.cs.etrt.view.UI.SystemView;
import edu.sjsu.cs.etrt.view.UI.VisitCreateView;
import edu.sjsu.cs.etrt.model.Patient.Address;
import edu.sjsu.cs.etrt.model.Patient.Category;
import edu.sjsu.cs.etrt.model.Patient.Demographics;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Questionnaire.Form;
import edu.sjsu.cs.etrt.model.System.System;
import edu.sjsu.cs.etrt.model.Visits.Visit;

public class SystemController{
	private System model;
	private SystemView view;
	private JFrame frame;
	private VisitCreateView create;
	
	public SystemController(JFrame UI) {
		frame=UI;
		model=new System(this);
		view=new SystemView(this);
		this.create=new VisitCreateView(this);

	}
	
	/**
	 * Open registry to register a new patient
	 */
	public void openRegistry() {
		updateFrame(model.getRegistry().getViewPanel());
	}
	
	/**
	 * OPen a list of all Visits
	 * @return visitqueue
	 */
	public void openVisitQueue() {
		updateFrame(model.getVisitQueue().getViewPanel());
	}
	
	public boolean openVisit(Visit visit) {
		if(visit!=null) {
			updateFrame(new VisitController(visit,this).getViewPanel());
			return true;
		} 
		return false;
	}
	
	public void openVisitCreate() {
		updateFrame(create.generateUI());
	}
	
	/**
	 * Open a list of all Patients
	 * @return patientList
	 */
	public void openPatientList() {
		updateFrame(model.getPatientList().getViewPanel());
	}
	
	public boolean openPatient(int num) {
		Patient patient=model.getPatientList().getPatient(num);
		if(patient!=null) {
			updateFrame(new PatientController(patient,this, num).getViewPanel());
			return true;
		} 
		return false;
	}
	
	public boolean openPatient(int num, boolean edit) {
		Patient patient=model.getPatientList().getPatient(num);
		if(patient!=null) {
			updateFrame(new PatientController(patient,this,num,edit).getViewPanel());
			return true;
		} 
		return false;
	}
	
	/**
	 * Open Form
	 */
	public void openTFI(Patient p, Form f) {
		FormController form = new FormController(p,f,this,true);
		form.getViewPanel();
	}
	
	public void openTHI(Patient p, Form f) {
		FormController form = new FormController(p,f,this,false);
		form.getViewPanel();
	}
	
	public void openSystem() {
		updateFrame(getViewPanel());
	}
	
	public VisitQueueController getVisitQueue() {
		return model.getVisitQueue();
	}
	
	public PatientListController getPatientList() {
		return model.getPatientList();
	}
	
	public JPanel getViewPanel() {
		return view.generateUI();
	}
	
	public void updateFrame(JPanel panel) {
		frame.setContentPane(panel);
		refreshFrame();
	}
	
	public void refreshFrame() {
		frame.revalidate();
		frame.pack();
	}
}