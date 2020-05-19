package edu.sjsu.cs.etrt.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs.etrt.view.UI.PatientView;
import edu.sjsu.cs.etrt.view.UI.SystemView;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Questionnaire.Form;
import edu.sjsu.cs.etrt.model.System.System;
import edu.sjsu.cs.etrt.model.Visits.Visit;

public class SystemController{
	private System model;
	private SystemView view;
	private JFrame frame;
	
	public SystemController(JFrame UI) {
		frame=UI;
		model=new System(this);
		view=new SystemView(this);
	}
	
	/**
	 * Open registry to register a new patient
	 */
	public void openRegistry() {
		
	}
	
	/**
	 * OPen a list of all Visits
	 * @return visitqueue
	 */
	public void openVisitQueue() {
		updateFrame(model.getVisitQueue().getViewPanel());
	}
	
	public boolean openVisit(int visitNumber) {
		Visit visit=model.getVisitQueue().getVisit(visitNumber);
		if(visit!=null) {
			updateFrame(new VisitController(visit,this).getViewPanel());
			return true;
		} 
		return false;
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
			updateFrame(new PatientController(patient,this).getViewPanel());
			return true;
		} 
		return false;
	}
	
	/**
	 * Open Questionnaire
	 * @param f Questionnaire Form Object
	 */
	public void openQuestionnaire() {
		
	}
	
	public void openSystem() {
		updateFrame(getViewPanel());
	}
	
	public VisitQueueController getVisitQueue() {
		return model.getVisitQueue();
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