package edu.sjsu.cs.etrt.view.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.sjsu.cs.etrt.controller.SystemController;

public class SystemView extends UIPanel{
	private final int MAIN_LENGTH=400;
	private final int MAIN_HEIGHT=550;
	private SystemController controller;
	private boolean patientError;
	private boolean visitError;
	
	/**
	 * The view seen by the user and Used in the JFrame.
	 * @param ctrl Reference for editing and JFrame.
	 */
	public SystemView(SystemController ctrl) {
		controller=ctrl;
		patientError=false;
		visitError=false;
	}

	@Override
	/**
	 * Builds the JPanel view.
	 */
	public void refresh() {
		main.removeAll();
		
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		main.setPreferredSize(new Dimension(MAIN_LENGTH,MAIN_HEIGHT));
		
	//Header that says System//
		
		JPanel header=new JPanel();
		header.setMaximumSize(new Dimension(MAIN_LENGTH,20));
		JTextArea headerText=new JTextArea("System");
		headerText.setFont(new Font("System",Font.PLAIN,28));
		headerText.setEditable(false);
		header.add(headerText);
		
		
	//Panel that contains the Registry and Form buttons//
		
		JPanel registryAndForm=new JPanel();
		registryAndForm.setPreferredSize(new Dimension(MAIN_LENGTH,100));
		registryAndForm.setMaximumSize(new Dimension(MAIN_LENGTH,100));
		registryAndForm.setLayout(new GridLayout(1,3));
		
		//Registry Button
		JButton registry=new JButton("Registry");
		registry.addActionListener(event->{
			
		});
		
		//Form button
		JButton form=new JButton("Form");
		form.addActionListener(event->{
			
		});
		registryAndForm.add(registry);
		registryAndForm.add(new JPanel());
		registryAndForm.add(form);
		
		
	//Bordered section for patient info//
		
		JPanel patients=new JPanel();
		patients.setLayout(new BoxLayout(patients,BoxLayout.Y_AXIS));
		patients.setBorder(BorderFactory.createLineBorder(Color.black));
		patients.setMaximumSize(new Dimension(MAIN_LENGTH-10,MAIN_HEIGHT));
		
		//Header for the panel
		String PHText="Patient________________________________________";
		JTextArea patientHeader=new JTextArea(PHText);
		patientHeader.setFont(new Font(PHText,Font.PLAIN,18));
		patientHeader.setEditable(false);
		patientHeader.setMaximumSize(new Dimension(MAIN_LENGTH,30));
		
		//Button to open PatientQueue
		JButton patientQueue=new JButton("Open Full Patient List");
		patientQueue.setMaximumSize(new Dimension(MAIN_LENGTH,50));
		patientQueue.setPreferredSize(new Dimension(MAIN_LENGTH,50));
		patientQueue.setAlignmentX(JButton.CENTER_ALIGNMENT);
		patientQueue.addActionListener(event->{
			controller.openPatientList();
		});
		
		//Panel that contains textInput to open selected patient page
		JPanel patientDirect=new JPanel();
		patientDirect.setLayout(new BoxLayout(patientDirect,BoxLayout.X_AXIS));
		
		//Header and instructions during error
		String patientDirectHeaderText="Open patient page by patient number.";
		if(patientError) {
			patientDirectHeaderText="Error opening page. Please enter exact patient number.";
		}
		JTextArea patientDirectHeader=new JTextArea(patientDirectHeaderText);
		patientDirectHeader.setFont(new Font(patientDirectHeaderText,Font.PLAIN,14));
		patientDirectHeader.setEditable(false);
		patientDirectHeader.setMaximumSize(new Dimension(MAIN_LENGTH,20));
		//Text Field
		JTextField patientInput=new JTextField();
		patientInput.setMaximumSize(new Dimension(MAIN_LENGTH,25));
		//Submit button
		JButton patientSubmit=new JButton("Submit");
		patientSubmit.addActionListener(event->{
			try {
				if(controller.openPatient(Integer.parseInt(patientInput.getText()))) {
					visitError=false;
					patientError=false;
				}else {
					patientError=true;
					refresh();
					controller.refreshFrame();
				}
			}catch(NumberFormatException e) {
				patientError=true;
				refresh();
				controller.refreshFrame();
			}
		});
		patientDirect.add(patientInput);
		patientDirect.add(patientSubmit);
		
		//Adding patient info components together
		patients.add(patientHeader);
		patients.add(Box.createRigidArea(new Dimension(0, 10)));	//padding
		patients.add(patientQueue);
		patients.add(Box.createRigidArea(new Dimension(0, 10)));	//padding
		patients.add(patientDirectHeader);
		patients.add(patientDirect);
		
	//Bordered section for visit info//	
		
		JPanel visits=new JPanel();
		visits.setLayout(new BoxLayout(visits,BoxLayout.Y_AXIS));
		visits.setBorder(BorderFactory.createLineBorder(Color.black));
		visits.setMaximumSize(new Dimension(MAIN_LENGTH-10,MAIN_HEIGHT));
		
		//Header for the panel
		String VHText="Visits_________________________________________";
		JTextArea visitHeader=new JTextArea(VHText);
		visitHeader.setFont(new Font(PHText,Font.PLAIN,18));
		visitHeader.setEditable(false);
		visitHeader.setMaximumSize(new Dimension(MAIN_LENGTH,30));
		
		//Button to open PatientQueue
		JButton visitQueue=new JButton("Open Full Visit List");
		visitQueue.setMaximumSize(new Dimension(MAIN_LENGTH,50));
		visitQueue.setPreferredSize(new Dimension(MAIN_LENGTH,50));
		visitQueue.setAlignmentX(JButton.CENTER_ALIGNMENT);
		visitQueue.addActionListener(event->{
			controller.openVisitQueue();
			visitError=false;
			patientError=false;
		});
		
		//Panel that contains textInput to open selected patient page
		JPanel visitDirect=new JPanel();
		visitDirect.setLayout(new BoxLayout(visitDirect,BoxLayout.X_AXIS));
		
		//Header and instructions during error
		String visitDirectHeaderText="Open visit page by visit number.";
		if(visitError) {
			visitDirectHeaderText="Error opening page. Please reenter visit number.";
		}
		JTextArea visitDirectHeader=new JTextArea(visitDirectHeaderText);
		visitDirectHeader.setFont(new Font(visitDirectHeaderText,Font.PLAIN,14));
		visitDirectHeader.setEditable(false);
		visitDirectHeader.setMaximumSize(new Dimension(MAIN_LENGTH,20));
		//Text Field
		JTextField visitInput=new JTextField();
		visitInput.setMaximumSize(new Dimension(MAIN_LENGTH,25));
		//Submit button
		JButton visitSubmit=new JButton("Submit");
		visitSubmit.addActionListener(event->{
			try {
				if(controller.openVisit(Integer.parseInt(visitInput.getText()))) {
					visitError=false;
					patientError=false;
				}else {
					visitError=true;
					refresh();
					controller.refreshFrame();
				}
			}catch(NumberFormatException e) {
				visitError=true;
				refresh();
				controller.refreshFrame();
			}
		});
		visitDirect.add(visitInput);
		visitDirect.add(visitSubmit);
		
		//Adding patient info components together
		visits.add(visitHeader);
		visits.add(Box.createRigidArea(new Dimension(0, 10)));	//padding
		visits.add(visitQueue);
		visits.add(Box.createRigidArea(new Dimension(0, 10)));	//padding
		visits.add(visitDirectHeader);
		visits.add(visitDirect);
		
	//Compiling all components onto main panel//
		main.add(header);
		main.add(registryAndForm);
		main.add(Box.createRigidArea(new Dimension(0, 30)));	//padding
		main.add(patients);
		main.add(Box.createRigidArea(new Dimension(0, 30)));	//padding
		main.add(visits);
		main.add(Box.createRigidArea(new Dimension(0, 10)));	//padding
	}
	
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		SystemView system=new SystemView(new SystemController(frame));
		
		frame.add(system.generateUI());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
