
package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Patient.PatientList;
import edu.sjsu.cs.etrt.view.UI.PatientListView;

public class PatientListController {
	private PatientList model;
	private PatientListView view;
	
	/**
	 * Initializes the model and view of PatientList.
	 * @param ctrl SystemController holding this object.
	 */
	public PatientListController(SystemController ctrl) {
		this.model=new PatientList();
		this.view = new PatientListView(this,ctrl);
	}
	
	/**
	 * Remove a patient from the list based on index.
	 * @param num Patient index.
	 */
	public void removePatient(int num)
	{
		model.remove(num);
	}
	
	/**
	 * Get a patient from the list based on index.
	 * @param num Patient index.
	 * @return Patient at the index.
	 */
	public Patient getPatient(int num)
	{
		return model.getPatient(num);
	}
	
	/**
	 * Add a patient onto the list.
	 * @param p Patient to be added.
	 */
	public void addPatient(Patient p)
	{
		model.addPatient(p);
	}
	
	/**
	 * Gives the size of the list.
	 * @return Size.
	 */
	public int getSize()
	{
		return model.size();
	}
	
	/**
	 * Retrieve the UI view panel.
	 * @return View's JPanel.
	 */
	public JPanel getViewPanel() {
		return view.generateUI();
	}
}
