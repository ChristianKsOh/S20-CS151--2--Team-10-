package edu.sjsu.cs.etrt.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs.etrt.view.UI.GraphView;
import edu.sjsu.cs.etrt.view.UI.SystemView;
import edu.sjsu.cs.etrt.view.UI.VisitCreateView;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.System.System;
import edu.sjsu.cs.etrt.model.Visits.Visit;

public class SystemController{
	private System model;
	private SystemView view;
	private JFrame frame;
	private VisitCreateView create;
	
	/**
	 * The controller for System's model and view. This is the 
	 * main controller of the whole program. It also initializes 
	 * and opens a new window.
	 */
	public SystemController() {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		model=new System(this);
		view=new SystemView(this);
		this.create=new VisitCreateView(this);
		
		this.openSystem();
	}
	
	/**
	 * Open registry to register a new patient
	 */
	public void openRegistry() {
		updateFrame(model.getRegistry().getViewPanel());
	}
	
	/**
	 * Open a list of all Visits
	 */
	public void openVisitQueue() {
		updateFrame(model.getVisitQueue().getViewPanel());
	}
	
	/**
	 * Opens the UI of a Visit on the frame given a Visit object.
	 * @param visit Visit object to be opened.
	 * @return Success of opening view.
	 */
	public boolean openVisit(Visit visit) {
		if(visit!=null) {
			updateFrame(new VisitController(visit,this).getViewPanel());
			return true;
		} 
		return false;
	}
	
	/**
	 * Opens the visit create UI on the frame.
	 */
	public void openVisitCreate() {
		updateFrame(create.generateUI());
	}
	
	/**
	 * Open a list of all Patients
	 */
	public void openPatientList() {
		updateFrame(model.getPatientList().getViewPanel());
	}
	
	/**
	 * Opens the UI of the patient based on the index of the patient in the list.
	 * @param num Patient number.
	 * @return Success of opening UI.
	 */
	public boolean openPatient(int num) {
		Patient patient=model.getPatientList().getPatient(num);
		if(patient!=null) {
			updateFrame(new PatientController(patient,this, num).getViewPanel());
			return true;
		} 
		return false;
	}
	
	/**
	 * Opens the UI of the patient based on the index of the patient in the list. 
	 * Gives the option of enabling editing.
	 * @param num Patient number.
	 * @param edit Allow editing upon opening view.
	 * @return Success of opening UI.
	 */
	public boolean openPatient(int num, boolean edit) {
		Patient patient=model.getPatientList().getPatient(num);
		if(patient!=null) {
			updateFrame(new PatientController(patient,this,num,edit).getViewPanel());
			return true;
		} 
		return false;
	}
	
	/**
	 * Opens a graph of the patient's THI/TFI results over time in 
	 * a new window.
	 * @param p Patient of the patient to be viewed.
	 */
	public void openGraph(Patient p) {
		GraphView graph=new GraphView(p);
		graph.open();
	}
	
	/**
	 * Opens the UI of Form for a specific patient.
	 * @param p Patient using the form.
	 */
	public void openForm(Patient p) {
		FormController form = new FormController(p,this);
		form.getViewPanel();
	}
	
	/**
	 * Opens the UI of System in the frame.
	 */
	public void openSystem() {
		updateFrame(getViewPanel());
	}
	
	/**
	 * Returns the instance of VisitQueueController
	 * @return VisitQueueController
	 */
	public VisitQueueController getVisitQueue() {
		return model.getVisitQueue();
	}
	
	/**
	 * Returns the instance of PatientListController.
	 * @return PatientListController
	 */
	public PatientListController getPatientList() {
		return model.getPatientList();
	}
	
	/**
	 * Generate System's UI panel.
	 * @return JPanel of Sysem's View.
	 */
	public JPanel getViewPanel() {
		return view.generateUI();
	}
	
	/**
	 * Change the frame's view with a different panel.
	 * @param panel JPnael of new View.
	 */
	public void updateFrame(JPanel panel) {
		frame.setContentPane(panel);
		refreshFrame();
	}
	
	/**
	 * Refresh the frame after an update in the panel.
	 */
	public void refreshFrame() {
		frame.revalidate();
		frame.pack();
	}
}