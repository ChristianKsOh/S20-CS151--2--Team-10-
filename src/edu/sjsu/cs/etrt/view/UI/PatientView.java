package edu.sjsu.cs.etrt.view.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

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
	public void refresh()
	{
		main.removeAll();
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setSize(1000, 800);
		JPanel panel = new JPanel();
		JLabel header= new JLabel(patientCtrl.getFirstName()+" " + patientCtrl.getMiddleInitial() + " " + patientCtrl.getLastName());
		header.setFont (header.getFont ().deriveFont (32.0f));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(header, BorderLayout.NORTH);
		
		//Basic Information + Id stuff section
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		JLabel label;
		JLabel basicHeader = new JLabel("Basic Information");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady=50;
		c.gridwidth=8;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(basicHeader, c);
		c.ipady=0;
		c.gridwidth=1;
		
		label = new JLabel("Gender: ");
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
		
		label = new JLabel("Date of Birth: ");
		JTextArea tDoB = new JTextArea(patientCtrl.getDateOfBirth());
		tDoB.setEditable(edit);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 1;
		panel.add(label, c);
		c.gridx=5;
		panel.add(tDoB,c);

		label = new JLabel("Regisration Date: ");
		JTextArea tRegDate = new JTextArea(patientCtrl.getRegistrationDate());
		tRegDate.setEditable(edit);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 6;
		c.gridy = 1;
		panel.add(label, c);
		c.gridx=7;
		panel.add(tRegDate,c);
		

		label = new JLabel("Social Id:");
		JTextArea tSocialId = new JTextArea(patientCtrl.getSocialID());
		tSocialId.setEditable(edit);
		c.gridy=2;
		c.gridx = 0;
		panel.add(label, c);
		c.gridx=1;
		panel.add(tSocialId,c);

		label = new JLabel("Insurance Id: ");
		JTextArea tInsuranceId = new JTextArea(patientCtrl.getInsuranceID());
		tInsuranceId.setEditable(edit);
		c.gridx = 2;
		panel.add(label, c);
		c.gridx=3;
		panel.add(tInsuranceId,c);
		
		
		label = new JLabel("Visit Number: ");
		JTextArea tVisitNum = new JTextArea("" + patientCtrl.getVisitNumber());
		tVisitNum.setEditable(false);
		c.gridx = 4;
		panel.add(label, c);
		c.gridx=5;
		panel.add(tVisitNum,c);
		
		//new row
		label= new JLabel("Category: ");
		JTextArea tCategory = new JTextArea(""+patientCtrl.getCategory());
		tCategory.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 3;
		c.gridx = 0;
		panel.add(label, c);
		c.gridx=1;
		panel.add(tCategory,c);

		
		label = new JLabel("TFI Score: ");
		JTextArea tScoreTFI = new JTextArea("" + patientCtrl.getScoreTFI());
		tVisitNum.setEditable(false);
		c.gridx = 2;
		panel.add(label, c);
		c.gridx=3;
		panel.add(tScoreTFI,c);
		
		label = new JLabel("THI Score: ");
		JTextArea tScoreTHI = new JTextArea("" + patientCtrl.getScoreTHI());
		tVisitNum.setEditable(false);
		c.gridx = 4;
		panel.add(label, c);
		c.gridx=5;
		panel.add(tScoreTHI,c);
		
		//Start of Address Section(Left Side)
		label = new JLabel("Address");
		c.ipady=50;
		c.gridwidth=1;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(label, c);
		//Start of Demographics section(Right side)
		label = new JLabel("Demographics");
		c.gridx = 4;
		panel.add(label, c);
		c.ipady=0;
		c.gridwidth=1;
				
		
		//new row
		label = new JLabel("Street: ");
		JTextArea tStreet = new JTextArea(patientCtrl.getStreet1() +" " + patientCtrl.getStreet2());
		tStreet.setEditable(edit);
		c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(label,c);
		c.gridwidth=3;
		c.gridx=1;
		panel.add(tStreet, c);
		c.gridwidth=1;
		
		label = new JLabel("Work Status: ");
		JTextArea tWorkStatus = new JTextArea(patientCtrl.getWorkStatus());
		tWorkStatus.setEditable(edit);
		c.gridwidth=1;
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
		
		//new row
		label = new JLabel("City: ");
		JTextArea tCity = new JTextArea(patientCtrl.getCity());
		tCity.setEditable(edit);
		c.gridx = 0;
		c.gridy = 6;
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
		
		//new Row
		
		label = new JLabel("Zip: ");
		JTextArea tZip = new JTextArea(patientCtrl.getZip());
		tZip.setEditable(edit);
		c.gridx = 0;
		c.gridy=7;
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
		
		label = new JLabel("Additional Notes: ");
		JTextArea tNotes = new JTextArea(patientCtrl.getNotes());
		tNotes.setEditable(edit);
		c.gridx = 0;
		c.gridy = 8;
		panel.add(label, c);
		c.ipady=3;
		c.ipadx=8;
		c.gridy=9;
		panel.add(tNotes,c);
		
		mainPanel.add(panel,BorderLayout.CENTER);
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.X_AXIS));
		//Button to return back to systems
		JButton systemButton = new JButton("System");
		systemButton.addActionListener(event->{
			systemCtrl.openSystem();
		});
		panelButtons.add(systemButton);
		if(edit)
		{
			//refresh this page after submit or go back to system
			JButton submitButton = new JButton("Submit");
			submitButton.addActionListener(event->{
				edit=false;
				patientCtrl.setRegistrationDate(tRegDate.getText());
				patientCtrl.setDateOfBirth(tDoB.getText());
				patientCtrl.setPhoneNumber(tPhoneNumber.getText());
				patientCtrl.setGender(tGender.getText());
				patientCtrl.setSocialId(tSocialId.getText());
				int i=Integer.parseInt(tCategory.getText());
				patientCtrl.setCategory(patientCtrl.getCategory().intToCategory(i));
				patientCtrl.setInsuranceID(tInsuranceId.getText());
				i=Integer.parseInt(tVisitNum.getText());
				patientCtrl.setVisitNumber(i);
				i=Integer.parseInt(tScoreTFI.getText());
				patientCtrl.setScoreTFI(i);
				i=Integer.parseInt(tScoreTHI.getText());
				patientCtrl.setScoreTHI(i);
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
				
				systemCtrl.refreshFrame();
			});
			panelButtons.add(submitButton);
			
		}
		else
		{
			//Refresh this page with edit set to true;
			JButton editButton = new JButton("Edit");
			editButton.addActionListener(event->{
				edit=true;
				panel.revalidate();
				systemCtrl.refreshFrame();
			});	
			panelButtons.add(editButton);
		}
		mainPanel.add(panelButtons, BorderLayout.SOUTH);
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
