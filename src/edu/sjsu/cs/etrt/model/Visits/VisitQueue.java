package edu.sjsu.cs.etrt.model.Visits;

import java.util.TreeMap;
import java.util.TreeSet;

import edu.sjsu.cs.etrt.controller.VisitController;

public class VisitQueue {
	private TreeSet<Visit> schedule;
	
	/**
	 * Initializes an instance of VisitQueue.
	 */
	public VisitQueue() {
		schedule=new TreeSet<Visit>();
	}
	
	/**
	 * Add a Visit into the queue in the correctly
	 *  ordered location.
	 * @param v object of Visit
	 */
	public void add(Visit v) {
		enqueue(v);
	}
	
	/**
	 * Add a Visit to the end of the queue. 
	 * Reorders if necessary based on date and time.
	 * @param v object of Visit
	 */
	public void enqueue(Visit v) {
		schedule.add(v);
	}
	
	/**
	 * Removes the earliest instance of Visit in the queue.
	 * @return The earliest Visit in the queue.
	 */
	public Visit dequeue() {
		Visit v=schedule.first();
		schedule.remove(0);
		return v;
	}
	
	/**
	 * Returns the latest Visit without removing
	 * @return Latest Visit
	 */
	public Visit peek() {
		if(schedule.size()!=0) {
			return schedule.first();
		}return null;
	}
	
	/**
	 * Get a Visit based on index.
	 * @param visitNum visit number
	 * @return Visit object.
	 */
	public Visit getVisit(int index) {
		int i=0;
		for(Visit visit:schedule) {
			if(i==index) {
				return visit;
			}
			i++;
		}return null;
	}
	
	/**
	 * Remove a Visit based on index.
	 * @param visitNum visit number
	 * @return Visit object.
	 */
	public Visit removeVisit(int index) {
		int i=0;
		for(Visit visit:schedule) {
			if(i==index) {
				Visit v=visit;
				schedule.remove(visit);
				return v;
			}
			i++;
		}return null;
	}
	
	public void removeVisit(Visit visit) {
		schedule.remove(visit);
	}
	
	/**
	 * Gives the size of the queue.
	 * @return size
	 */
	public int size() {
		return schedule.size();
	}
	
	/**
	 * Returns status of am empty queue.
	 * @return whether the queue is empty.
	 */
	public boolean isEmpty() {
		return schedule.size()==0;
	}
	
	/**
	 * Returns an Iterator for this class.
	 * @return Iterator object
	 */
	public Iterable<Visit> iterator(){
		return schedule;
	}
}
