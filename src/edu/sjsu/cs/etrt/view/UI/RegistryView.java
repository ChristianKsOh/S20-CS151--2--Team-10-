package edu.sjsu.cs.etrt.view.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import edu.sjsu.cs.etrt.controller.RegistryController;
import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.model.Patient.Patient;


public class RegistryView extends UIPanel{
	private RegistryController regCtrl;
	private SystemController systemCtrl;
	
	/**
	 * constructor for RegistryView (RegistryController, SystemController) - uses RegistryController 
	 * to manipulate PatientListController in system
	 * @param r	RegistryController
	 * @param ctrl SystemController
	 */
	public RegistryView(RegistryController r, SystemController ctrl)
	{	
		this.regCtrl=r;		
		systemCtrl=ctrl;
	}
	
	/**
	 * refresh panel; creation of visualization of view and panel
	 */
		public void refresh()
		{
			main.removeAll();
			JPanel mainPanel=new JPanel();
			mainPanel.setLayout(new BorderLayout());
			//mainPanel.setSize(1000, 400);
			JPanel panel = new JPanel();
			JLabel header= new JLabel("Patient Form");
			header.setFont(header.getFont ().deriveFont (32.0f));
			header.setHorizontalAlignment(SwingConstants.CENTER);
			mainPanel.add(header, BorderLayout.NORTH);
			
			//Basic Information + Id stuff section
			panel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(10,10,10,10);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.ipady=50;
			c.gridwidth=4;
			c.gridx = 0;
			c.gridy = 0;		//LEVEL 0
			JLabel label;
			JLabel basicHeader = new JLabel("Basic Information");
			panel.add(basicHeader, c);
			c.gridx = 4;
			basicHeader = new JLabel("Private Information");
			panel.add(basicHeader, c);
			
			c.ipady=0;			
			c.gridwidth=1;
			c.weightx = 0.5;
			
			label = new JLabel("First Name: ");
			JTextArea tFirst = new JTextArea("");
			tFirst.setBackground(Color.WHITE);
			
			c.gridy = 1;		//LEVEL 1
			c.gridx = 0;
			c.fill = GridBagConstraints.HORIZONTAL;
			panel.add(label, c);
			c.gridx = 1;
			panel.add(tFirst, c);
			
			label = new JLabel("Last Name: ");
			JTextArea tLast = new JTextArea("");
			tLast.setBackground(Color.WHITE);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 2;
			panel.add(label, c);
			c.gridx = 3;
			panel.add(tLast, c);
			
			label = new JLabel("Treatment: ");
			JTextArea tTreatment = new JTextArea("grade0");
			tTreatment.setEditable(false);
			c.fill = GridBagConstraints.HORIZONTAL;
			
			tTreatment.setBackground(Color.WHITE);
			c.gridx = 4;
			//c.gridy = 1;
			panel.add(label, c);
			c.gridx=5;
			panel.add(tTreatment,c);

			label = new JLabel("Registration Date: ");
			JTextArea tRegDate = new JTextArea("");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 6;
			//c.gridy = 1;
			panel.add(label, c);
			c.gridx=7;
			panel.add(tRegDate,c);
			
			c.gridy = 2;		//LEVEL 2
			label = new JLabel("Middle Initial: ");
			JTextArea tMid = new JTextArea("");
			c.gridx = 0;
			panel.add(label,c);
			c.gridx = 1;
			panel.add(tMid,c);
			
			
			label = new JLabel("Social ID:");
			JTextArea tSocialId = new JTextArea("");
			
			tSocialId.setBackground(Color.WHITE);
			c.gridx=4;
			panel.add(label, c);
			c.gridx=5;
			panel.add(tSocialId,c);
			
			label = new JLabel("Insurance ID: ");
			JTextArea tInsuranceId = new JTextArea("");
			
			tInsuranceId.setBackground(Color.WHITE);
			c.gridx = 6;
			panel.add(label, c);
			c.gridx=7;
			panel.add(tInsuranceId,c);
			
			
			c.gridy = 3;		//LEVEL 3
			label = new JLabel("Gender: ");
			JTextArea tGender = new JTextArea("");
			c.fill = GridBagConstraints.HORIZONTAL;
			
			tGender.setBackground(Color.WHITE);
			c.gridx = 0;
			panel.add(label, c);
			c.gridx=1;
			//c.gridy=1;
			panel.add(tGender,c);
			
			label = new JLabel("Phone Number: ");
			JTextArea tPhoneNumber = new JTextArea("");
			c.fill = GridBagConstraints.HORIZONTAL;
			
			tPhoneNumber.setBackground(Color.WHITE);
			c.weightx = 0.5;
			c.gridx = 2;
			//c.gridy = 1;
			panel.add(label, c);
			c.gridx=3;
			panel.add(tPhoneNumber,c);

			label= new JLabel("DOB: ");
			JTextArea tDoB = new JTextArea("");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 4;
			panel.add(label, c);
			c.gridx=5;
			panel.add(tDoB,c);

			
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
			label = new JLabel("Street 1: ");
			JTextArea tStreet1 = new JTextArea("");
			
			tStreet1.setBackground(Color.WHITE);
			c.weightx=0.5;
			c.gridx = 0;
			c.gridy = 5;
			panel.add(label,c);
			c.gridwidth=3;
			c.gridx=1;
			panel.add(tStreet1, c);
			c.gridwidth=1;
			
			label = new JLabel("Work Status: ");
			JTextArea tWorkStatus = new JTextArea("");
			
			tWorkStatus.setBackground(Color.WHITE);
			c.gridwidth=1;
			c.gridx = 4;
			panel.add(label, c);
			c.gridx=5;
			panel.add(tWorkStatus,c);
			
			label = new JLabel("Occupation: ");
			JTextArea tOccupation = new JTextArea("");
			
			tOccupation.setBackground(Color.WHITE);
			c.gridx = 6;
			panel.add(label, c);
			c.gridx=7;
			panel.add(tOccupation,c);
			
			//new row
			label = new JLabel("Street 2: ");
			JTextArea tStreet2 = new JTextArea("");
			
			tStreet2.setBackground(Color.WHITE);
			c.weightx=0.5;
			c.gridx = 0;
			c.gridy = 6;
			panel.add(label,c);
			c.gridwidth=3;
			c.gridx=1;
			panel.add(tStreet2, c);
			c.gridwidth=1;
			
			label = new JLabel("Education: ");
			JTextArea tEducationalDegree = new JTextArea("");
			
			tEducationalDegree.setBackground(Color.WHITE);
			c.gridx = 4;
			panel.add(label, c);
			c.gridx=5;
			panel.add(tEducationalDegree,c);
			
			
			//new row
			label = new JLabel("City: ");
			JTextArea tCity = new JTextArea("");
			
			tCity.setBackground(Color.WHITE);
			c.gridx = 0;
			c.gridy = 7;
			panel.add(label, c);
			c.gridx=1;
			panel.add(tCity,c);
			
			label=new JLabel("State: ");
			JTextArea tState= new JTextArea("");
			
			tState.setBackground(Color.WHITE);
			c.gridx=2;
			panel.add(label,c);
			c.gridx=3;
			panel.add(tState,c);
			
			//new Row
			
			label = new JLabel("Zip: ");
			JTextArea tZip = new JTextArea("");
			
			tZip.setBackground(Color.WHITE);
			c.gridx = 0;
			c.gridy=8;
			panel.add(label, c);
			c.gridx=1;
			panel.add(tZip,c);
					
				
			label =new JLabel("Country: ");
			JTextArea tCountry = new JTextArea("");
			
			tCountry.setBackground(Color.WHITE);
			c.gridx = 2;
			panel.add(label, c);
			c.gridx=3;
			panel.add(tCountry,c);
			
			
			label = new JLabel("Additional Notes: ");
			JTextArea tNotes = new JTextArea("");
			
			tNotes.setBackground(Color.WHITE);
			c.gridx = 0;
			c.gridy = 9;
			panel.add(label, c);
			c.gridwidth=8;
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
				systemCtrl.openSystem();
			});
			panelButtons.add(systemButton);
			
			JButton submitButton = new JButton("Submit");
			submitButton.addActionListener(event->{
				//check for empty mandatory fields
				if(tFirst.getText().equals("")||tLast.getText().equals("")
					|| tRegDate.getText().equals("") || tDoB.getText().equals("")
					|| tPhoneNumber.getText().equals("") || tGender.getText().equals("")
					|| tSocialId.getText().equals("") || tInsuranceId.getText().equals("")
					|| tStreet1.getText().equals("") || tCity.getText().equals("")
					|| tState.getText().equals("") || tZip.getText().equals("")
					|| tCountry.getText().equals("")) {
					System.out.println("Please enter in all fields besides Demographics.");
				}
				else {
					//create a new patient 
					Patient p = new Patient();
					//add patient to list
					regCtrl.addPatientToList(p);
					//Set basic information of newly created Patient object
					regCtrl.setFirstName(tFirst.getText());
					regCtrl.setMiddleInitial(tMid.getText());
					regCtrl.setLastName(tLast.getText());
					regCtrl.setRegDate(tRegDate.getText());
					regCtrl.setDOB(tDoB.getText());
					regCtrl.setPhone(tPhoneNumber.getText());
					regCtrl.setGender(tGender.getText());
					regCtrl.setSID(tSocialId.getText());
					regCtrl.setInsurance(tInsuranceId.getText());
					regCtrl.setVisitNum();
					regCtrl.setTreatment();
					//Address
					regCtrl.setStreet1(tStreet1.getText());
					regCtrl.setStreet2(tStreet2.getText());
					regCtrl.setCity(tCity.getText());
					regCtrl.setState(tState.getText());
					regCtrl.setZIP(tZip.getText());
					regCtrl.setCountry(tCountry.getText());
					//Demographics
					regCtrl.setWork(tWorkStatus.getText());
					regCtrl.setDegree(tEducationalDegree.getText());
					regCtrl.setOccupation(tOccupation.getText());
					regCtrl.setNotes(tNotes.getText());
					
					regCtrl.openSystem();
				}
				
			});
				
			panelButtons.add(submitButton);
				
			//add panels/add to main panel
			mainPanel.add(panelButtons, BorderLayout.SOUTH);
			JScrollPane scrollPane = new JScrollPane(panel);
			scrollPane.setPreferredSize(new Dimension(1000,400));
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.getVerticalScrollBar().setUnitIncrement(10);
			mainPanel.add(scrollPane);
			main.add(mainPanel);	
		}


}

