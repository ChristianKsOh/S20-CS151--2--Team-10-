package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Visits.Visit;
import edu.sjsu.cs.etrt.model.Visits.VisitQueue;
import edu.sjsu.cs.etrt.view.UI.VisitQueueView;

public class VisitQueueController {
	private VisitQueue model;
	private VisitQueueView view;
	
	/**
	 * Initializes the model and view of VisitQueue.
	 * @param system SystemController holding this object.
	 */
	public VisitQueueController(SystemController system) {
		this.model=new VisitQueue();
		this.view=new VisitQueueView(this,system);
	}
	
	/**
	 * Add a Visit into the queue in the correctly
	 *  ordered location.
	 * @param v object of Visit
	 */
	public void enqueue(Visit v) {
		model.enqueue(v);
		view.refresh();
	}
	
	/**
	 * Removes the earliest instance of Visit in the queue.
	 * @return The earliest Visit in the queue.
	 */
	public Visit dequeue() {
		Visit v=model.dequeue();
		view.refresh();
		return v;
	}
	
	/**
	 * Get a Visit based on index.
	 * @param index visit number
	 * @return Visit object.
	 */
	public Visit getVisit(int index) {
		return model.getVisit(index);
	}
	
	/**
	 * Remove a Visit.
	 * @param v Visit.
	 */
	public void removeVisit(Visit v) {
		model.removeVisit(v);
		view.refresh();
	}
	
	/**
	 * Returns the latest Visit without removing.
	 * @return Latest visit.
	 */
	public Visit peek() {
		return model.peek();
	}
	
	/**
	 * Gives the size of the queue.
	 * @return size
	 */
	public int size() {
		return model.size();
	}
	
	/**
	 * Returns whether queue is empty.
	 * @return Whether queue is empty or not.
	 */
	public boolean isEmpty() {
		return model.isEmpty();
	}
	
	/**
	 * Returns an iterator of the queue's values.
	 * @return Iterator of the queue's values.
	 */
	public Iterable<Visit> iterator(){
		return model.iterator();
	}
	
	/**
	 * Retrieve the UI view panel.
	 * @return View's JPanel.
	 */
	public JPanel getViewPanel() {
		return view.generateUI();
	}
}
