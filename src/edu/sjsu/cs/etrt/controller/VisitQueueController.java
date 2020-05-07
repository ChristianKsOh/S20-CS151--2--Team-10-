package edu.sjsu.cs.etrt.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Project.Patient;
import edu.sjsu.cs.etrt.model.Visits.DateAndTime;
import edu.sjsu.cs.etrt.model.Visits.InitialVisit;
import edu.sjsu.cs.etrt.model.Visits.Visit;
import edu.sjsu.cs.etrt.model.Visits.VisitQueue;
import edu.sjsu.cs.etrt.view.UI.VisitQueueView;

public class VisitQueueController {
	private VisitQueue model;
	private VisitQueueView view;
	private JFrame frame;
	
	public VisitQueueController(JFrame UI) {
		frame=UI;
		this.model=new VisitQueue();
		this.view=new VisitQueueView(this);
	}
	
	/**
	 * Add a Visit into the queue in the correctly
	 *  ordered location.
	 * @param v object of Visit
	 */
	public void enqueue(Visit v) {
		model.enqueue(new VisitController(v,this));
		view.setQueue(model);
		view.refresh();
	}
	
	/**
	 * Removes the earliest instance of Visit in the queue.
	 * @return The earliest Visit in the queue.
	 */
	public Visit dequeue() {
		Visit v=model.dequeue().getModel();
		view.setQueue(model);
		view.refresh();
		return v;
	}
	
	/**
	 * Get a Visit based on the visit number.
	 * @param visitNum visit number
	 * @return Visit object.
	 */
	public Visit getVisitIn(int visitNum) {
		return model.getVisit(visitNum).getModel();
	}
	
	/**
	 * Remove a Visit based on the visit number.
	 * @param visitNum visit number
	 * @return Visit object.
	 */
	public void removeVisit(int visitNum) {
		model.removeVisit(visitNum);
		view.setQueue(model);
		view.refresh();
	}
	
	/**
	 * Gives the size of the queue.
	 * @return size
	 */
	public int size() {
		return model.size();
	}
	
	public JPanel getViewPanel() {
		return view.generateUI();
	}
	
	public void updateFrame(JPanel panel) {
		frame.setContentPane(panel);
		refreshFrame();
	}
	
	public void refreshFrame() {
		frame.revalidate();
		frame.pack();
	}
	
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		VisitQueueController q=new VisitQueueController(frame);
		q.enqueue(new InitialVisit(new Patient("Steve"),"doctor",4,20,2020,3,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("Masd"),"doctor",5,20,2020,3,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("wrb"),"doctor",6,20,2020,3,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("zxc"),"doctor",7,20,2020,2,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("cvr"),"doctor",7,20,2020,3,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",10,20,2020,3,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",7,20,2020,1,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",7,20,2020,5,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",7,20,2020,6,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",7,20,2020,7,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",7,20,2020,9,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",7,20,2020,3,31,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",7,20,2020,3,32,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",7,20,2020,3,33,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",7,20,2020,3,34,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient("qwe"),"doctor",7,20,2020,3,35,DateAndTime.PM));
		
		
		frame.add(q.getViewPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
