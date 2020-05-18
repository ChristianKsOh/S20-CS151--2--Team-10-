package edu.sjsu.cs.etrt.model.Visits;

import java.util.TreeMap;

import edu.sjsu.cs.etrt.controller.VisitController;

public class VisitQueue {
	private TreeMap<DateAndTime,VisitController> schedule;
	
	/**
	 * Initializes an instance of VisitQueue.
	 */
	public VisitQueue() {
		schedule=new TreeMap<DateAndTime,VisitController>();
	}
	
	/**
	 * Add a Visit into the queue in the correctly
	 *  ordered location.
	 * @param v object of Visit
	 */
	public void add(VisitController v) {
		enqueue(v);
	}
	
	/**
	 * Add a Visit to the end of the queue. 
	 * Reorders if necessary based on date and time.
	 * @param v object of Visit
	 */
	public void enqueue(VisitController v) {
		schedule.put(v.getDateAndTimeObject(),v);
	}
	
	/**
	 * Removes the earliest instance of Visit in the queue.
	 * @return The earliest Visit in the queue.
	 */
	public VisitController dequeue() {
		return schedule.remove(schedule.firstKey());
	}
	
	/**
	 * Get a Visit based on the visit number.
	 * @param visitNum visit number
	 * @return Visit object.
	 */
	public VisitController getVisit(int visitNum) {
		for(DateAndTime key:schedule.keySet()) {
			if(schedule.get(key).getVisitNumber()==visitNum) {
				return schedule.get(key);
			}
		}return null;
	}
	
	/**
	 * Remove a Visit based on the visit number.
	 * @param visitNum visit number
	 * @return Visit object.
	 */
	public VisitController removeVisit(int visitNum) {
		for(DateAndTime key:schedule.keySet()) {
			if(schedule.get(key).getVisitNumber()==visitNum) {
				return schedule.remove(key);
			}
		}return null;
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
	public Iterable<VisitController> iterator(){
		return schedule.values();
	}
	
	/**
	 * Returns the full schedule.
	 * @return TreeMap<DateAndTime,Visit> of the schedule.
	 */
	public TreeMap<DateAndTime,VisitController> getSchedule(){
		return new TreeMap<DateAndTime,VisitController>(schedule);
	}
}
