package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Questionnaire.Form;
import edu.sjsu.cs.etrt.model.Visits.*;
import edu.sjsu.cs.etrt.view.UI.VisitView;

public class VisitController {
	private Visit model;
	private VisitView view;
	private SystemController system;
	
	/**
	 * Initializes the controller with the model and view. 
	 * @param visit Visit model class.
	 * @param system SystemController holding this object.
	 */
	public VisitController(Visit visit,SystemController system) {
		this.system=system;
		model=visit;
		view=new VisitView(this,system);
	}
	
	/**
	 * Return the object of the patient in the visit.
	 * @return patient object.
	 */
	public Patient getPatient() {
		return model.getPatient();
	}
	
	/**
	 * Return the object of the form in the visit.
	 * @return form object.
	 */
	public Form getForm() {
		return model.getForm();
	}
	
	/**
	 * Return the doctor's name.
	 * @return doctor's name.
	 */
	public String getDoctorName() {
		return model.getDoctorName();
	}
	
	/**
	 * Get the date of the visit.
	 * @return date of visit.
	 */
	public String getDate() {
		return model.getDate();
	}
	
	/**
	 * Get the time of the visit.
	 * @return time of visit.
	 */
	public String getTime() {
		return model.getTime();
	}
	
	/**
	 * Get the full DateAndTime object.
	 * @return DateAndTime object.
	 */
	public DateAndTime getDateAndTimeObject() {
		return model.getDateAndTime();
	}
	
	/**
	 * Retrieve the visit number of the Visit.
	 * @return visit number.
	 */
	public int getVisitNumber() {
		return model.getVisitNumber();
	}
	
	/**
	 * Retrieve special notes of the Visit.
	 * @return special note.
	 */
	public String getSpecialNote() {
		return model.getSpecialNote();
	}
	
	/**
	 * Return a direct reference to the model. Used in view.
	 * @return Visit object associated with the controller.
	 */
	public Visit getModel() {
		return model;
	}
	
	/**
	 * Changes the date of the visit.
	 * @param month Month of a int.
	 * @param day Day as an int.
	 * @param year Year as an int.
	 */
	public void setVisitDate(int month, int day, int year) {
		model.setDate(month, day, year);
		view.refresh();
	}
	
	/**
	 * Changes the time of the visit.
	 * @param hour Hour as an int.
	 * @param minutes Minuts as an int.
	 * @param isPM Use DtateAndTime static variables.
	 */
	public void setVisitTime(int hour, int minutes, boolean isPM) {
		model.setTime(hour, minutes, isPM);
		view.refresh();
	}
	
	/**
	 * Change the doctor of the visit.
	 * @param doctorName new doctor's name
	 */
	public void setVisitDoctor(String doctorName) {
		model.changeDoctor(doctorName);
		view.refresh();
	}
	
	/**
	 * Add a special note to the visit. Special note is 
	 * initially blank.
	 * @param note Special note text.
	 */
	public void setVisitSpecialNote(String note) {
		model.addSpecialNote(note);
		view.refresh();
	}
	
	/**
	 * Retrieve the UI view panel.
	 * @return view's JPanel.
	 */
	public JPanel getViewPanel() {
		return view.generateUI();
	}
	
	/**
	 * Updates the JFrame for any changes in the view.
	 */
	public void refreshFrame(){
		system.refreshFrame();
	}
	
	/**
	 * Opens Patient view of this visit's patient.
	 */
	public void openPatient() {
		system.openPatient(model.getPatient().getPatientID());	
	}
}
