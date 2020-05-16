package Project;

import java.util.LinkedList;


public class PatientQueue {

	private LinkedList<Patient> patientQueue;
	
	/**
	 * Constructor for queue;
	 */
	public PatientQueue()
	{
		patientQueue=new LinkedList<Patient>();
	}
	
	/**
	 * Enqueues a patient
	 * @param patient
	 */
	public void enqueue(Patient p)
	{
		patientQueue.add(p);
	}
	
	
	/**
	 * Dequeues a patient
	 * @return
	 */
	public Patient dequeue()
	{
		return patientQueue.getFirst();
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
