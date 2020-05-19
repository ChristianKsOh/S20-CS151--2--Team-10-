package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Visits.DateAndTime;
import edu.sjsu.cs.etrt.model.Visits.FollowUpVisit;
import edu.sjsu.cs.etrt.model.Visits.InitialVisit;
import edu.sjsu.cs.etrt.model.Visits.Visit;
import edu.sjsu.cs.etrt.model.Visits.VisitQueue;
import edu.sjsu.cs.etrt.view.UI.VisitCreateView;
import edu.sjsu.cs.etrt.view.UI.VisitQueueView;

public class VisitQueueController {
	private VisitQueue model;
	private VisitQueueView view;
	private SystemController system;
	private VisitCreateView create;
	
	/**
	 * Initials the model and view of VisitQueue.
	 * @param system SystemController holding this object.
	 */
	public VisitQueueController(SystemController system) {
		this.system=system;
		this.model=new VisitQueue();
		this.view=new VisitQueueView(this);
		this.create=new VisitCreateView(this);
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
	 * Get a Visit based on the visit number.
	 * @param visitNum visit number
	 * @return Visit object.
	 */
	public Visit getVisit(int visitNum) {
		return model.getVisit(visitNum);
	}
	
	/**
	 * Remove a Visit based on the visit number.
	 * @param visitNum visit number
	 */
	public void removeVisit(int visitNum) {
		model.removeVisit(visitNum);
		view.refresh();
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
	 * @return view's JPanel.
	 */
	public JPanel getViewPanel() {
		return view.generateUI();
	}
	
	/**
	 * Open System's view on the frame.
	 */
	public void openSystemView() {
		system.openSystem();
	}
	
	/**
	 * Open VisitCreate's view on the frame.
	 */
	public void openVisitCreateView() {
		system.updateFrame(create.generateUI());
	}
	
	/**
	 * Reopens VisitQueue's view on the frame. Used by VisitCreateView.
	 */
	public void reopenVisitQueueView() {
		system.openVisitQueue();
	}
	
	public void openVisit(Visit v) {
		system.openVisit(v.getVisitNumber());
	}
	
	/**
	 * Updates JFrame to the provided JPanel. Used by VisitView.
	 * @param panel JPanel to be opened.
	 */
	public void updateFrame(JPanel panel) {
		system.updateFrame(panel);
	}

	/**
	 * Updates the JFrame for any changes in the view.
	 */
	public void refreshFrame() {
		system.refreshFrame();
	}
}
