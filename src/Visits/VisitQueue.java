package Visits;

import java.util.Iterator;
import java.util.Queue;
import java.util.TreeMap;

import Project.Patient;

public class VisitQueue {
	private TreeMap<DateAndTime,Visit> schedule;
	private int size;
	
	/**
	 * Initializes an instance of VisitQueue.
	 */
	public VisitQueue() {
		size=0;
		schedule=new TreeMap<DateAndTime,Visit>();
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
		schedule.put(v.getDateAndTime(),v);
	}
	
	/**
	 * Removes the earliest instance of Visit in the queue.
	 * @return The earliest Visit in the queue.
	 */
	public Visit dequeue() {
		return schedule.remove(schedule.firstKey());
	}
	
	/**
	 * Get a Visit based on the visit number.
	 * @param visitNum visit number
	 * @return Visit object.
	 */
	public Visit getVisit(int visitNum) {
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
	public Visit removeVisit(int visitNum) {
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
		return size;
	}
	
	/**
	 * Returns status of am empty queue.
	 * @return whether the queue is empty.
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * Returns an Iterator for this class.
	 * @return Iterator object
	 */
	public Iterator<Visit> iterator(){
		return schedule.values().iterator();
	}
	
	public TreeMap<DateAndTime,Visit> getSchedule(){
		return new TreeMap<DateAndTime,Visit>(schedule);
	}
}
