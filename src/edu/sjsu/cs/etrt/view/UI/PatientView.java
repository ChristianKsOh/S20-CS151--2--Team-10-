package edu.sjsu.cs.etrt.view.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Project.Patient;

public class PatientView extends UIPanel{
	
	private Patient patient;
	
	public PatientView()
	{
	
	}
	//Displays patient data
	public void refresh()
	{
		main.removeAll();
		
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JPanel pane = new JPanel();
		JLabel header= new JLabel(patient.getFirstName()+" " + patient.getMiddleInitial() + " " + patient.getLastName());
		header.setFont (header.getFont ().deriveFont (32.0f));
		mainPanel.add(header, BorderLayout.NORTH);
		
		
		JLabel label;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		label = new JLabel("Basic Information");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(label, c);

		label = new JLabel("Gender: " + patient.getGender());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(label, c);

		label = new JLabel("Phone Number: " patient.getPhoneNumber());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		pane.add(label, c);
		
		
		label = new JLabel("Date of Birth: " + patient.getDateOfBrith());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		pane.add(label, c);

		label = new JLabel("Registration Date: " + patient.getRegistrationDate());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(label, c);
		
		label = new JLabel("Category: " + patient.getCategory());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		pane.add(label, c);

		label = new JLabel("Social Id: " + patient.getSocialID());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(label, c);

		label = new JLabel("Insurance Id: " + patient.getInsuranceID());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 1;
		c.gridy = 3;
		pane.add(label, c);
		
		label = new JLabel("Visit Number: " patient.getVisitNumber());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 2;
		c.gridy = 3;
		pane.add(label, c);
		
		label = new JLabel("Address");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(label, c);
		
		label = new JLabel("Demographics");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 2;
		c.gridy = 4;
		pane.add(label, c);
		
		label = new JLabel(patient.getPatientAddress().getStreet1()+patient.getPatientAddress().getStreet2());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 5;
		pane.add(label, c);
		
		
		label = new JLabel("Job Status: " + patient.getPatientDemographic().getWorkStatus());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 2;
		c.gridy = 5;
		pane.add(label, c);
		
		label = new JLabel("Occupation: " + patient.getPatientDemographic().getOccupation());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 3;
		c.gridy = 5;
		pane.add(label, c);
		
		label = new JLabel("City: " + patient.getPatientAddress().getCity()+" State:" + patient.getPatientAddress().getState());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 6;
		pane.add(label, c);
		
		label = new JLabel("Zip: " + patient.getPatientAddress().getZip()+" Country: "+patient.getPatientAddress().getCountry());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 1;
		c.gridy = 6;
		pane.add(label, c);
		
		label = new JLabel("Education: " patient.getPatientDemographic().getEducationalDegree());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 2;
		c.gridy = 6;
		pane.add(label, c);
		
		label = new JLabel("Additional Notes: " patient.getPatientDemographic().getNotes());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 7;
		pane.add(label, c);
		
		mainPanel.add(pane,BorderLayout.CENTER);
		
		JButton button = new JButton("System");
		mainPanel.add(button,BorderLayout.SOUTH);
		
		main.add(mainPanel);	
	}
	void systemReturnListener(ActionListener ListenForSystemButton)
	{
		button.addActionListener(ListenForSystemButton);
	}
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, message);
	}
	

}
