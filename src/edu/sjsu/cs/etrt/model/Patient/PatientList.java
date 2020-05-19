package edu.sjsu.cs.etrt.model.Patient;

import java.util.LinkedList;

import edu.sjsu.cs.etrt.controller.PatientController;

public class PatientList {
private LinkedList<Patient> patientQueue;
	private PatientController patientCtrl;
	/**
	 * Constructor for queue;
	 */
	public PatientList()
	{
		patientQueue=new LinkedList<Patient>();
	}
	
	/**
	 * Enqueues a patient
	 * @param patient
	 */
	public void addPatient(Patient p)
	{
		patientQueue.add(p);
	}
	
	
	/**
	 * Dequeues a patient
	 * @return
	 */
	public Patient remove(int num)
	{
		return patientQueue.remove(num);
	}
	
	/**
	 * Returns the size of the queue
	 * @return
	 */
	public int size()
	{
		return patientQueue.size();
	}
	
	public Patient getPatient(int num)
	{
		return patientQueue.get(num);
	}
}
