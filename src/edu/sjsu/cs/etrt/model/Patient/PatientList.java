package edu.sjsu.cs.etrt.model.Patient;

import java.util.LinkedList;

public class PatientList {
private LinkedList<Patient> patientQueue;
	/**
	 * Constructor for queue.
	 */
	public PatientList()
	{
		patientQueue=new LinkedList<Patient>();
	}
	
	/**
	 * Adds patient onto the list.
	 * @param p Patient.
	 */
	public void addPatient(Patient p)
	{
		p.setPatientID(patientQueue.size());
		patientQueue.add(p);
	}
	
	/**
	 * Removes  patient from the list.
	 * @param num Index of patient.
	 * @return Patient removed.
	 */
	public Patient remove(int num)
	{
		return patientQueue.remove(num);
	}
	
	/**
	 * Returns the size of the lsit.
	 * @return Size of list.
	 */
	public int size()
	{
		return patientQueue.size();
	}
	
	/**
	 * Get patient without removing.
	 * @param num Index of patient.
	 * @return Patient.
	 */
	public Patient getPatient(int num)
	{
		return patientQueue.get(num);
	}
}
