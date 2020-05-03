package edu.sjsu.cs.etrt.model.Visits;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeMap;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.sjsu.cs.etrt.model.Project.Patient;
import edu.sjsu.cs.etrt.view.UI.UIPanel;

public class VisitQueue implements UIPanel{
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

	@Override
	public JPanel generateUI() {
		JPanel main=new JPanel();
		
		JPanel content=new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		JPanel visitUI;
		boolean openVisit=false;
		
		for(DateAndTime key:schedule.keySet()) {
			JPanel visit=new JPanel();
			String s=schedule.get(key).getDate()+" ("+schedule.get(key).getTime()+") : "+schedule.get(key).getVisitNumber();
			JTextArea text=new JTextArea(s);
			text.setEditable(false);
			text.setFont(new Font(s,Font.PLAIN,20));
			visit.add(text);
			visit.addMouseListener(new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					//visitUI=schedule.get(key).generateUI();
					//openVisit=true;
					
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			content.add(visit);
		}
		
		JScrollPane scroll = new JScrollPane(content);
		//scroll.setPreferredSize(new Dimension(350,500));
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 30, 300, 50);
        
        main.add(scroll);
		
		return main;
	}
	
	public static void main(String[] args) {
		VisitQueue q=new VisitQueue();
		q.enqueue(new InitialVisit(new Patient(),"doctor",4,20,2020,3,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",5,20,2020,3,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",6,20,2020,3,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,2,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,3,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",10,20,2020,3,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,1,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,5,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,6,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,7,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,9,30,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,3,31,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,3,32,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,3,33,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,3,34,DateAndTime.PM));
		q.enqueue(new InitialVisit(new Patient(),"doctor",7,20,2020,3,35,DateAndTime.PM));
		
		JFrame frame=new JFrame();
		frame.add(q.generateUI());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
