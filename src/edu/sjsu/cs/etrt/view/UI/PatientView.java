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
import javax.swing.JTextArea;

import Patient.Patient;
import edu.sjsu.cs.etrt.controller.PatientController;
import edu.sjsu.cs.etrt.controller.SystemController;

public class PatientView extends UIPanel{
	
	private PatientController patientCtrl;
	private SystemController systemCtrl;
	private Boolean edit;
	
	public PatientView(PatientController p, SystemController ctrl)
	{
		this.patientCtrl=p;
		systemCtrl=ctrl;
		edit = false;
	}
	//Displays patient data
	//TO DO: Add an edit feature and someway to restore data into model
	public void refresh()
	{
		main.removeAll();
		main.pack();
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		JLabel header= new JLabel(patientCtrl.getFirstName()+" " + patientCtrl.getMiddleInitial() + " " + patientCtrl.getLastName());
		header.setFont (header.getFont ().deriveFont (32.0f));
		mainPanel.add(header, BorderLayout.NORTH);
		
		//Basic Information + Id stuff section
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		JLabel label;
		JTextArea basicHeader = new JTextArea("Basic Information");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady=50;
		c.gridwidth(8);
		c.gridx = 0;
		c.gridy = 0;
		panel.add(basicHeader, c);
		c.ipady=0;
		c.gridwidth(0);
		
		label = new JLabel("Gender: ")
		JTextArea tGender = new JTextArea(patientCtrl.getGender());
		tGender.setEditable(edit);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(label, c);
		c.gridx=1;
		c.gridy=1;
		panel.add(tGender,c);
		
		label = new JLabel("Phone Number: ");
		JTextArea tPhoneNumber = new JTextArea(patientCtrl.getPhoneNumber());
		tPhoneNumber.setEditable(edit);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		panel.add(label, c);
		c.gridx=3;
		panel.add(tPhoneNumber,c);
		
		label = new JLabe("Date of Birth: ")
		JTextArea tDoB = new JTextArea(patientCtrl.getDateOfBrith());
		tDoB.setEditable(edit);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 1;
		panel.add(label, c);
		c.gridx=5;
		panel.add(tDoB,c);

		label = new JLabel("Regisrtaion Date: ");
		JTextArea tRegDate = new JTextArea(patientCtrl.getRegistrationDate());
		tRegDate.setEditable(edit);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 6;
		c.gridy = 1;
		panel.add(label, c);
		c.gridx=7;
		panel.add(tRegDate,c);
		
		label= new JLabe("Category: ");
		JTextArea tCategory = new JTextArea(patientCtrl.getCategory());
		tCategory.setEditable(edit);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 2;
		c.gridx = 0;
		panel.add(label, c);
		c.gridx=1;
		panel.add(tCategory,c);

		label = new JLabel("Social Id:");
		JTextArea tSocialId = new JTextArea(patientCtrl.getSocialID());
		tSocialId.setEditable(edit);
		c.gridx = 2;
		panel.add(label, c);
		c.gridx=3;
		panel.add(tSocialId,c);

		label = new JLabel("Insurance Id: ");
		JTextArea tInsuranceId = new JTextArea(patientCtrl.getInsuranceID());
		tInsuranceId.setEditable(edit);
		c.gridx = 4;
		panel.add(label, c);
		c.gridx=5;
		panel.add(tInsuranceId,c);
		
		label = new JLabel("Visit Number: ");
		JTextArea tVisitNum = new JTextArea(patientCtrl.getVisitNumber());
		tVisitNum.setEditable(edit);
		c.gridx = 6;
		panel.add(label, c);
		c.gridx=7;
		panel.add(tVisitNum,c);
		
		//Start of Address Section(Left Side)
		label = new JLabel("Address");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.ipady=50;
		c.gridwidth=4;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(label, c);
		//Start of Demographics section(Right side)
		label = new JLabel("Demographics");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 3;
		c.gridy = 3;
		panel.add(label, c);
		c.ipady=0;
		c.gridwidth=1;
		
		//Start row 4
		JTextArea tStreet = new JTextArea(patientCtrl.getStreet1() +" " patientCtrl.getStreet2());
		tStreet.setEditable(edit);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth=4;
		panel.add(label, c);
		
		label = new JLabe("Work Status: ")
		JTextArea tWorkStatus = new JTextArea(patientCtrl.getWorkStatus());
		tWorkStatus.setEditable(edit);
		c.gridwdith=1;
		c.gridx = 4;
		panel.add(label, c);
		c.gridx=5;
		panel.add(tWorkStatus,c);
		
		label = new JLabel("Occupation: ");
		JTextArea tOccupation = new JTextArea(patientCtrl.getOccupation());
		tOccupation.setEditable(edit);
		c.gridx = 6;
		panel.add(label, c);
		c.gridx=7;
		panel.add(tOccupation,c);
		
		//Start row 5
		label = new JLabel("City: ");
		JTextArea tCity = new JTextArea(patientCtrl.getCity());
		tCity.setEditable(edit);
		c.gridx = 0;
		c.gridy = 5;
		panel.add(label, c);
		c.gridx=1;
		panel.add(tCity,c);
		
		label=new JLabel("State: ");
		JTextArea tState= new JTextArea(patientCtrl.getState());
		tState.setEditable(edit);
		c.gridx=2;
		panel.add(label,c);
		c.gridx=3;
		panel.add(tState,c);
		
		label = new JLabel("Education: ");
		JTextArea tEducationalDegree = new JTextArea(patientCtrl.getEducationalDegree());
		tEducationalDegree.setEditable(edit);
		c.gridx = 4;
		panel.add(label, c);
		c.gridx=5;
		panel.add(tEducationalDegree,c);
		
		//Start row 6
		
		label = new JLabel("Zip: ");
		JTextArea tZip = new JTextArea(patientCtrl.getZip());
		tZip.setEditable(edit);
		c.gridx = 0;
		c.gridy=6;
		panel.add(label, c);
		c.gridx=1;
		panel.add(tZip,c);
				
			
		label =new JLabel("Country: ");
		JTextArea tCountry = new JTextArea(patientCtrl.getCountry());
		tCountry.setEditable(edit);
		c.gridx = 2;
		panel.add(label, c);
		c.gridx=3;
		panel.add(tCountry,c);
		
		label = new JLabel("Additional Notes: ")
		JTextArea tNotes = new JTextArea(patientCtrl.getNotes());
		tNotes.setEditable(edit);
		c.gridx = 0;
		c.gridy = 7;
		panel.add(label, c);
		c.ipady=3;
		c.ipadx=8;
		c.gridy=8;
		panel.add(tNotes,c);
		
		mainPanel.add(panel,BorderLayout.CENTER);
		
		//Button to return back to systems
		JButton systemButton = new JButton("System");
		systemButton.addActionListener(event->{
			systemCtrl.refreshFrame();
		});
		mainPanel.add(systemButton,BorderLayout.SOUTH);
		if(edit)
		{
			JButton submitButton = new JButton("Submit");
			submitButton.addActionListener(event->{
				edit=false;
				patientCtrl.setRegistrationDate(tRegDate.getText());
				patientCtrl.setDateOfBirth(tDoB.getText());
				patientCtrl.setPhoneNumber(tPhoneNumber.getText());
				patientCtrl.setGender(tGender.getText());
				patientCtrl.setSocialID(tSocialId.getText());
				patientCtrl.setCategory((int)tCategory.getText());
				patientCtrl.setInsuranceID(tInsuranceId.getText());
				patientCtrl.setVisitNumber(tVisitNum.getText());
				//Address
				patientCtrl.setStreet1(tStreet.getText());
				patientCtrl.setCity(tCity.getText());
				patientCtrl.setState(tState.getText());
				patientCtrl.setZip(tZip.getText());
				patientCtrl.setCountry(tCountry.getText());
				//Demographics
				patientCtrl.setWorkStatus(tWorkStatus.getText());
				patientCtrl.setEducationalDegree(tEducationalDegree.getText());
				patientCtrl.setOccupation(tOccupation.getText());
				patientCtrl.setNotes(tNotes.getText());
				
				refresh();
			});
			mainPanel.add(submitButton,BorderLayout.SOUTH);
			
		}
		else
		{
			JButton editButton = new JButton("Edit");
			editButton.addActionListener(event->{
				edit=true;
				refresh();
			});	
			mainPanel.add(editButton, BorderLayout.SOUTH);
		}
		
		
		main.add(mainPanel);	
	}
	/*
	void systemReturnListener(ActionListener ListenForSystemButton)
	{
		button.addActionListener(ListenForSystemButton);
	}
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, message);
	}
	*/

}
