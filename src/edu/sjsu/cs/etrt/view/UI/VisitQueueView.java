package edu.sjsu.cs.etrt.view.UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.sjsu.cs.etrt.controller.VisitController;
import edu.sjsu.cs.etrt.controller.VisitQueueController;
import edu.sjsu.cs.etrt.model.Visits.Visit;
import edu.sjsu.cs.etrt.model.Visits.VisitQueue;

public class VisitQueueView extends UIPanel {
	
	private VisitQueueController controller;
	
	/**
	 * The view seen by the user and Used in the JFrame.
	 * @param ctrl Reference for editing and JFrame.
	 */
	public VisitQueueView(VisitQueueController ctrl) {
		controller=ctrl;
	}
	
	@Override
	/**
	 * Builds the JPanel view.
	 */
	public void refresh() {
		main.removeAll();
		JPanel content=new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		//Create back button and add buttons
		JPanel buttons=new JPanel();
		buttons.setLayout(new BoxLayout(buttons,BoxLayout.X_AXIS));
		JButton backButton=new JButton("Back");
		backButton.addActionListener(event->{
			controller.openSystemView();
		});
		content.add(backButton);
		
		JButton add=new JButton("+Create a new Visit");
		add.addActionListener(event-> {
			controller.openVisitCreateView();
		});
		
		buttons.add(backButton);
		buttons.add(add);
		content.add(buttons);		
		
		content.add(Box.createRigidArea(new Dimension(0, 5)));
		
		//Header
		JTextArea header=new JTextArea("Visits (Date and Time : Doctor)");
		header.setEditable(false);
		header.setFont(new Font("Visits (Date and Time : Doctor)",Font.PLAIN,20));
		header.setMaximumSize(new Dimension(280,30));
		content.add(header);
		
		//Print each visit in order
		for(Visit visit:controller.iterator()) {
			JPanel visitPanel=new JPanel();
			visitPanel.setMaximumSize(new Dimension(350,30));
			String s=visit.getDate()+" ("+visit.getTime()+") : Dr. "+visit.getDoctorName();
			JTextArea text=new JTextArea(s);
			text.setEditable(false);
			text.setFont(new Font(s,Font.PLAIN,20));
			text.addMouseListener(new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					controller.openVisit(visit);
				}
				public void mouseClicked(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				
			});
			visitPanel.add(text);
			content.add(visitPanel);
		}
		
		//Add scroll bar
		JScrollPane scroll = new JScrollPane(content);
		scroll.setPreferredSize(new Dimension(350,400));
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 30, 300, 50);
        scroll.getVerticalScrollBar().setUnitIncrement(5);
        
        //Add to frame
        main.add(scroll);
	}
}
