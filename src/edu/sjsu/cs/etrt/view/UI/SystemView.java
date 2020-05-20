package edu.sjsu.cs.etrt.view.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.model.Patient.Address;
import edu.sjsu.cs.etrt.model.Patient.Category;
import edu.sjsu.cs.etrt.model.Patient.Demographics;
import edu.sjsu.cs.etrt.model.Patient.Patient;
import edu.sjsu.cs.etrt.model.Visits.DateAndTime;
import edu.sjsu.cs.etrt.model.Visits.InitialVisit;
import edu.sjsu.cs.etrt.model.Visits.Visit;

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
			controller.openRegistry();
		});
		registryAndForm.add(registry);
		
		
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
		String patientDirectHeaderText="Open patient page by name.";
		if(patientError) {
			patientDirectHeaderText="Error opening page. Please enter patient's full name.";
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
			boolean error=true;
			for(int i=0;i<controller.getPatientList().getSize();i++) {
				String patientName=controller.getPatientList().getPatient(i).getFirstName()+" ";
				if(!controller.getPatientList().getPatient(i).getMiddleInitial().equals("")) {
					patientName+=controller.getPatientList().getPatient(i).getMiddleInitial()+" ";
				}
				patientName+=controller.getPatientList().getPatient(i).getLastName();
				if(patientName.equalsIgnoreCase(patientInput.getText())) {
					if(controller.openPatient(i)) {
						visitError=false;
						patientError=false;
						error=false;
					}
				}
			}
			//Patient not found
			if(error) {
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
	 
		//Most recent appointment/visit
		JPanel recent=new JPanel();
		recent.setLayout(new BoxLayout(recent,BoxLayout.Y_AXIS));
		
		JTextArea recentHeader = new JTextArea("Latest visit:");
		recentHeader.setFont(new Font("Latest visit:",Font.PLAIN,14));
		recentHeader.setEditable(false);
		recentHeader.setMaximumSize(new Dimension(MAIN_LENGTH,20));
		
		Visit peeked=controller.getVisitQueue().peek();
		String s="";
		if(peeked!=null) {
			s=peeked.getDate()+" ("+peeked.getTime()+"):\n"+peeked.getPatient().getFirstName() +" "+peeked.getPatient().getLastName()+" with Dr. "+peeked.getDoctorName();
		}
		JTextArea recentText=new JTextArea(s);
		recentText.setEditable(false);
		recentText.setFont(new Font(s,Font.PLAIN,20));
		recentText.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.openVisit(peeked);
			}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
		});
		recent.add(recentHeader);
		recent.add(recentText);
		
		
		//Adding patient info components together
		visits.add(visitHeader);
		visits.add(Box.createRigidArea(new Dimension(0, 10)));	//padding
		visits.add(visitQueue);
		visits.add(Box.createRigidArea(new Dimension(0, 10)));	//padding
		visits.add(recent);
		
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		SystemController system=new SystemController(frame);
		Patient p=new Patient(0,0,"Kevin","Truong","T","4/5/20","male","2/2/2000","18883664342","123456789","insurance","12345",Category.category1,2,new Address("My house","Sand","CA","99999","USA"),new Demographics("Doctor","legal","PhD",""));
		Patient p2=new Patient(0,0,"Devin","Truong","","4/5/20","male","2/2/2000","18883664342","123456789","insurance","12345",Category.category1,0,new Address("My house","Sand","CA","99999","USA"),new Demographics("Doctor","legal","PhD",""));
		system.getPatientList().addPatient(p);
		system.getPatientList().addPatient(p2);
		system.getVisitQueue().enqueue(new InitialVisit(p,"Doctor",4,20,2020,3,30,DateAndTime.PM,"Notes"));
		system.getVisitQueue().enqueue(new InitialVisit(p2,"Smth",4,20,2020,3,30,DateAndTime.PM,"Notes"));
		system.openSystem();
		
	}
}
