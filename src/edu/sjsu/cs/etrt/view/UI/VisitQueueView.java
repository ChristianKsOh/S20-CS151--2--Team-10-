package edu.sjsu.cs.etrt.view.UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.sjsu.cs.etrt.controller.VisitController;
import edu.sjsu.cs.etrt.controller.VisitQueueController;
import edu.sjsu.cs.etrt.model.Visits.VisitQueue;

public class VisitQueueView extends UIPanel {
	private JPanel main;
	private VisitQueue schedule;
	private VisitQueueController controller;
	
	public VisitQueueView(VisitQueueController ctrl) {
		controller=ctrl;
		main=new JPanel();
	}
	
	public void setQueue(VisitQueue schedule) {
		this.schedule=schedule;
	}
	
	public void refresh() {
		JPanel content=new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		JButton backButton=new JButton("Back");
		backButton.addActionListener(event->{
			//return to SystemUI
		});
		content.add(backButton);
		
		JTextArea header=new JTextArea("Visits (Date and Time : Visit Number)");
		header.setEditable(false);
		header.setFont(new Font("Visits (Date and Time : Visit Number)",Font.PLAIN,20));
		content.add(header);
		
		for(VisitController visit:schedule.iterator()) {
			JPanel visitPanel=new JPanel();
			String s=visit.getDate()+" ("+visit.getTime()+") : "+visit.getVisitNumber();
			JTextArea text=new JTextArea(s);
			text.setEditable(false);
			text.setFont(new Font(s,Font.PLAIN,20));
			text.addMouseListener(new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					controller.updateFrame(visit.getViewPanel());
				}
				public void mouseClicked(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				
			});
			visitPanel.add(text);
			content.add(visitPanel);
		}
		
		JScrollPane scroll = new JScrollPane(content);
		scroll.setPreferredSize(new Dimension(350,400));
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 30, 300, 50);
        scroll.getVerticalScrollBar().setUnitIncrement(5);
    	main.removeAll();
        main.add(scroll);
        
	}
	
	public JPanel generateUI() {
		refresh();
		return main;
	}
}
