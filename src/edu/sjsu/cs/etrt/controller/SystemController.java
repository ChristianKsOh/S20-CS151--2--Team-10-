package edu.sjsu.cs.etrt.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs.etrt.view.UI.SystemView;
import edu.sjsu.cs.etrt.model.Questionnaire.Form;
import edu.sjsu.cs.etrt.model.System.PatientQueueController;
import edu.sjsu.cs.etrt.model.System.Registry;
import edu.sjsu.cs.etrt.model.System.System;

public class SystemController{
	private System model;
	private SystemView view;
	private JFrame frame;
	
	public SystemController(JFrame UI) {
		frame=UI;
		model=new System(UI);
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
	
	
	/**
	 * Open a list of all Patients
	 * @return patientqueue
	 */
	public void openPatientQueue() {
		
	}
	
	/**
	 * Open Questionnaire
	 * @param f Questionnaire Form Object
	 */
	public void openQuestionnaire() {
		
	}
	
	public VisitQueueController getVisitQueue() {
		return model.getVisitQueue();
	}
	
	public JPanel getViewPanel() {
		return view.generateUI();
	}
	
	private void updateFrame(JPanel panel) {
		frame.setContentPane(panel);
		refreshFrame();
	}
	
	public void refreshFrame() {
		frame.revalidate();
		frame.pack();
	}
}