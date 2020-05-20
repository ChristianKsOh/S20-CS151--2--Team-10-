package edu.sjsu.cs.etrt.view.UI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import edu.sjsu.cs.etrt.controller.PatientController;
import edu.sjsu.cs.etrt.controller.PatientListController;
import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.model.Patient.Patient;

public class RegistryView extends UIPanel{
	private PatientController patientCtrl;
	private PatientListController patientListCtrl;
	private SystemController systemCtrl;
	private Boolean edit;
	
	public RegistryView(PatientListController p, SystemController ctrl)
	{
		this.patientListCtrl=p;
		systemCtrl=ctrl;
		edit = false;
	}
	
	public void refresh()
	{
		main.removeAll();
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setSize(1000, 800);
		JPanel panel = new JPanel();
		JLabel header= new JLabel("Patient Registration Form");
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
		
		//new row
		label= new JLabel("First Name: ");
		JTextArea tFirstName = new JTextArea("");
		tFirstName.setEditable(true);
		c.gridy=1;
		c.gridx=0;
		panel.add(label,c);
		c.gridx=1;
		panel.add(tFirstName,c);
		
		label= new JLabel("Middle Initial: ");
		JTextArea tMiddleInitial = new JTextArea("");
		tMiddleInitial.setEditable(true);
		c.gridx=2;
		panel.add(label,c);
		c.gridx=3;
		panel.add(tMiddleInitial,c);
		
		label=new JLabel("Last Name: ");
		JTextArea tLastName= new JTextArea("");
		tLastName.setEditable(true);
		c.gridx=4;
		panel.add(label,c);
		c.gridx=5;
		panel.add(tLastName,c);
		
		//new row
		label = new JLabel("Gender: ");
		JTextArea tGender = new JTextArea("");
		tGender.setEditable(true);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(label, c);
		c.gridx=1;
		c.gridy=1;
		panel.add(tGender,c);
		
		label = new JLabel("Phone Number: ");
		JTextArea tPhoneNumber = new JTextArea("");
		tPhoneNumber.setEditable(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		panel.add(label, c);
		c.gridx=3;
		panel.add(tPhoneNumber,c);
		
		label = new JLabel("Date of Birth: ");
		JTextArea tDoB = new JTextArea("");
		tDoB.setEditable(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		panel.add(label, c);
		c.gridx=5;
		panel.add(tDoB,c);

		label = new JLabel("Regisrtaion Date: ");
		JTextArea tRegDate = new JTextArea("");
		tRegDate.setEditable(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 6;
		panel.add(label, c);
		c.gridx=7;
		panel.add(tRegDate,c);
		
		//new Row
		label = new JLabel("Social Id:");
		JTextArea tSocialId = new JTextArea("");
		tSocialId.setEditable(true);
		c.gridy = 3;
		c.gridx = 0;
		panel.add(label, c);
		c.gridx=1;
		panel.add(tSocialId,c);

		label = new JLabel("Insurance Id: ");
		JTextArea tInsuranceId = new JTextArea("");
		tInsuranceId.setEditable(true);
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
		c.gridy = 4;
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
		c.gridy = 5;
		panel.add(label, c);
		//Start of Demographics section(Right side)
		label = new JLabel("Demographics");
		c.gridx = 4;
		panel.add(label, c);
		c.ipady=0;
		c.gridwidth=1;
				
		
		//new row
		label = new JLabel("Street: ");
		JTextArea tStreet = new JTextArea("");
		tStreet.setEditable(true);
		c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 6;
		panel.add(label,c);
		c.gridwidth=3;
		c.gridx=1;
		panel.add(tStreet, c);
		c.gridwidth=1;
		
		label = new JLabel("Work Status: ");
		JTextArea tWorkStatus = new JTextArea("");
		tWorkStatus.setEditable(true);
		c.gridwidth=1;
		c.gridx = 4;
		panel.add(label, c);
		c.gridx=5;
		panel.add(tWorkStatus,c);
		
		label = new JLabel("Occupation: ");
		JTextArea tOccupation = new JTextArea("");
		tOccupation.setEditable(true);
		c.gridx = 6;
		panel.add(label, c);
		c.gridx=7;
		panel.add(tOccupation,c);
		
		//new row
		label = new JLabel("City: ");
		JTextArea tCity = new JTextArea("");
		tCity.setEditable(true);
		c.gridx = 0;
		c.gridy = 7;
		panel.add(label, c);
		c.gridx=1;
		panel.add(tCity,c);
		
		label=new JLabel("State: ");
		JTextArea tState= new JTextArea("");
		tState.setEditable(true);
		c.gridx=2;
		panel.add(label,c);
		c.gridx=3;
		panel.add(tState,c);
		
		label = new JLabel("Education: ");
		JTextArea tEducationalDegree = new JTextArea("");
		tEducationalDegree.setEditable(true);
		c.gridx = 4;
		panel.add(label, c);
		c.gridx=5;
		panel.add(tEducationalDegree,c);
		
		//new Row
		
		label = new JLabel("Zip: ");
		JTextArea tZip = new JTextArea("");
		tZip.setEditable(true);
		c.gridx = 0;
		c.gridy=8;
		panel.add(label, c);
		c.gridx=1;
		panel.add(tZip,c);
				
			
		label =new JLabel("Country: ");
		JTextArea tCountry = new JTextArea("");
		tCountry.setEditable(true);
		c.gridx = 2;
		panel.add(label, c);
		c.gridx=3;
		panel.add(tCountry,c);
		
		label = new JLabel("Additional Notes: ");
		JTextArea tNotes = new JTextArea("");
		tNotes.setEditable(edit);
		c.gridx = 0;
		c.gridy = 9;
		panel.add(label, c);
		c.ipady=3;
		c.ipadx=8;
		c.gridy=10;
		panel.add(tNotes,c);
		
		mainPanel.add(panel,BorderLayout.CENTER);
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.X_AXIS));
		//Button to return back to systems
		JButton systemButton = new JButton("System");
		systemButton.addActionListener(event->{
			systemCtrl.refreshFrame();
		});
		panelButtons.add(systemButton);
		JButton submitButton = new JButton("Submit");
		//NEEDS TO GET BACK TO THE SYSTEM
		submitButton.addActionListener(event->{
			Patient p = new Patient();
			patientListCtrl.addPatient(p);
			patientListCtrl.getPatient(patientListCtrl.getSize()).setRegistrationDate(tRegDate.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setDateOfBirth(tDoB.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setPhoneNumber(tPhoneNumber.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setGender(tGender.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setSocialID(tSocialId.getText());
			int i=Integer.parseInt(tCategory.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setCategoryNum(patientCtrl.getCategory().intToCategory(i));
			patientListCtrl.getPatient(patientListCtrl.getSize()).setInsuranceID(tInsuranceId.getText());
			i=Integer.parseInt(tVisitNum.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setVisitNumber(i);
			i=Integer.parseInt(tScoreTFI.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).addScoreTFI(i);
			i=Integer.parseInt(tScoreTHI.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).addScoreTHI(i);
			//Address
			patientListCtrl.getPatient(patientListCtrl.getSize()).setStreet1(tStreet.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setCity(tCity.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setState(tState.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setZip(tZip.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setCountry(tCountry.getText());
			//Demographics
			patientListCtrl.getPatient(patientListCtrl.getSize()).setWorkStatus(tWorkStatus.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setEducationalDegree(tEducationalDegree.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setOccupation(tOccupation.getText());
			patientListCtrl.getPatient(patientListCtrl.getSize()).setNotes(tNotes.getText());
		});
		panelButtons.add(submitButton);
			
	
		mainPanel.add(panelButtons, BorderLayout.SOUTH);
		main.add(mainPanel);	
	}
}
