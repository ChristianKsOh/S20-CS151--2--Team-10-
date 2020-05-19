package edu.sjsu.cs.etrt.view.UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.sjsu.cs.etrt.controller.VisitQueueController;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Visits.FollowUpVisit;

public class VisitCreateView extends UIPanel{
	private VisitQueueController controller;
	private boolean incomplete;
	private boolean patientDoesntExist;
	
	/**
	 * The view seen by the user and Used in the JFrame.
	 * @param ctrl Reference for editing and JFrame.
	 */
	public VisitCreateView(VisitQueueController ctrl) {
		controller=ctrl;
		incomplete=false;
		patientDoesntExist=false;
	}

	@Override
	/**
	 * Builds the JPanel view.
	 */
	public void refresh() {
		//Reset main panel
		main.removeAll();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		
		JTextArea header=new JTextArea("Create a new Visit");
		header.setEditable(false);
		header.setFont(new Font("Create a new Visit",Font.PLAIN,28));
		header.setMaximumSize(new Dimension(230,30));
		
		//Input for Date of appointment
		JPanel datePanel=new JPanel();
		datePanel.setLayout(new BoxLayout(datePanel,BoxLayout.X_AXIS));
		
		JTextArea dateHeader=new JTextArea("Date (mm/dd/yyyy): ");
		dateHeader.setEditable(false);
		dateHeader.setFont(new Font("Date (mm/dd/yyyy): ",Font.PLAIN,18));
		dateHeader.setMaximumSize(new Dimension(200,30));
		
		JComboBox<Integer> monthMenu=new JComboBox<Integer>();
		for(int i=1;i<13;i++) {
			monthMenu.addItem(i);
		}
		JComboBox<Integer> dayMenu=new JComboBox<Integer>();
		for(int i=1;i<32;i++) {
			dayMenu.addItem(i);
		}
		JTextField yearInput=new JTextField();
		yearInput.setColumns(4);
		
		datePanel.add(dateHeader);
		datePanel.add(monthMenu);
		datePanel.add(dayMenu);
		datePanel.add(yearInput);
		
		//Time of appointment in header
		//Clicking the text opens the edit fields
		//If-statement prints the time
		//Else-statement displays inputs and submit button for changing
		JPanel timePanel=new JPanel();
		timePanel.setLayout(new BoxLayout(timePanel,BoxLayout.X_AXIS));
		
		JTextArea timeHeader=new JTextArea("Time: ");
		timeHeader.setEditable(false);
		timeHeader.setFont(new Font("Time: ",Font.PLAIN,18));
		timeHeader.setMaximumSize(new Dimension(80,30));
		
		JComboBox<Integer> hourMenu=new JComboBox<Integer>();
		for(int i=1;i<13;i++) {
			hourMenu.addItem(i);
		}
		
		JComboBox<Integer> minuteMenu=new JComboBox<Integer>();
		for(int i=0;i<60;i++) {
			minuteMenu.addItem(i);
		}
		
		JComboBox<String> period=new JComboBox<String>();
		period.addItem("AM");
		period.addItem("PM");
		
		timePanel.add(timeHeader);
		timePanel.add(hourMenu);
		timePanel.add(minuteMenu);
		timePanel.add(period);
		
		
		//Patient
		JPanel patientPanel=new JPanel();
		patientPanel.setLayout(new BoxLayout(patientPanel,BoxLayout.X_AXIS));
		
		JTextArea patientHeader=new JTextArea("Patient name: ");
		patientHeader.setEditable(false);
		patientHeader.setFont(new Font("Patient name: ",Font.PLAIN,18));
		patientHeader.setMaximumSize(new Dimension(120,30));
		
		JTextField patientInput=new JTextField();
		patientInput.setColumns(15);
		
		patientPanel.add(patientHeader);
		patientPanel.add(patientInput);

		
		//Doctor name
		//Clicking the text opens the edit fields
		//If-statement prints the doctor name
		//Else-statement displays inputs and submit button for changing
		JPanel doctorPanel=new JPanel();
		doctorPanel.setLayout(new BoxLayout(doctorPanel,BoxLayout.X_AXIS));
		
		JTextArea doctorHeader=new JTextArea("Doctor name: ");
		doctorHeader.setEditable(false);
		doctorHeader.setFont(new Font("Doctor name: ",Font.PLAIN,18));
		doctorHeader.setMaximumSize(new Dimension(120,30));
		
		JTextField doctorInput=new JTextField();
		doctorInput.setColumns(15);
		
		doctorPanel.add(doctorHeader);
		doctorPanel.add(doctorInput);
		
		
		//Reason/Special notes
		//Clicking the text opens the edit fields
		//If-statement prints the special note
		//Else-statement displays inputs and submit button for changing
		JPanel notePanel=new JPanel();
		notePanel.setLayout(new BoxLayout(notePanel,BoxLayout.X_AXIS));
		
		JTextArea noteHeader=new JTextArea("Special notes (optional): ");
		noteHeader.setEditable(false);
		noteHeader.setFont(new Font("Special notes (optional): ",Font.PLAIN,18));
		
		JTextField noteInput=new JTextField();
		noteInput.setColumns(15);
		
		notePanel.add(noteHeader);
		notePanel.add(noteInput);
		
		
		//Text if fields are incomplete
		String errorText="Error: Not all fields were filled out. Please try again.";
		int fontLength=330;
		if(patientDoesntExist) {
			errorText="Error: Patient not found. Please try again.";
			fontLength=265;
		}
		JTextArea incompleteText=new JTextArea(errorText);
		incompleteText.setEditable(false);
		incompleteText.setFont(new Font(errorText,Font.PLAIN,14));
		incompleteText.setMaximumSize(new Dimension(fontLength,20));
		
		
		//Cancel and submit buttons
		JPanel buttons=new JPanel();
		JButton cancelButton=new JButton("Cancel");
		cancelButton.addActionListener(event->{
			main.removeAll();
			incomplete=false;
			controller.reopenVisitQueueView();
		});
		JButton submit=new JButton("Create Visit!");
		submit.addActionListener(event->{
			try {
				int year=Integer.parseInt(yearInput.getText());
			}catch(NumberFormatException e) {}
			
			if(monthMenu.getSelectedIndex()==0
			||dayMenu.getSelectedIndex()==0
			||yearInput.getText().length()==4
			||hourMenu.getSelectedIndex()==0
			||minuteMenu.getSelectedIndex()==0
			||doctorInput.getText().isEmpty()) {
				incomplete=true;
				refresh();
				controller.refreshFrame();
			//}else if() { //patient doesn't exist
				//patientDoesntExist=true;
				//refresh();
				//controller.refreshFrame();
			}else {
				incomplete=false;
				//Visit visit=new FollowUpVisit(patient, doctor, month, day, year, hour, minute, dateAndTimePeriod, notes)
				//int visitNumber=visit.getVisitNumber();
				//controller.enqueue(visit);			
				//controller.updateFrame(controller.getVisit(visitNumber).getViewPanel());
			}
		});
		buttons.add(cancelButton);
		buttons.add(submit);
		
		main.add(header);
		main.add(Box.createRigidArea(new Dimension(0, 5)));	//padding
		main.add(datePanel);
		main.add(timePanel);
		main.add(patientPanel);
		main.add(doctorPanel);
		main.add(notePanel);
		main.add(buttons);
		if(incomplete) {
			main.add(incompleteText);
		}
	}
	
}
