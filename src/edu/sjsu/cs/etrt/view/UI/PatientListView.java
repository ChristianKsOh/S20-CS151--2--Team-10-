
package edu.sjsu.cs.etrt.view.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import edu.sjsu.cs.etrt.controller.PatientListController;
import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.model.Patient.PatientList;

public class PatientListView extends UIPanel{
	
	private PatientListController patientQ;
	private int num;
	private SystemController systemCtrl;
	
	public PatientListView(PatientListController p, SystemController systemCtrl) {
		patientQ=p;
		this.systemCtrl=systemCtrl;
	}
	
	public void refresh()
	{
		main.removeAll();
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.setSize(1000,800);
		JPanel panel=new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		JLabel header = new JLabel("(Last Name), (First Name) ( Middle Initial) (Birthday)");
		header.setFont (header.getFont ().deriveFont (32.0f));
		header.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		mainPanel.add(header);
		JButton removePatient[] = new JButton[patientQ.getSize()];
		JButton editPatient[] = new JButton[patientQ.getSize()];
		JLabel patientLabel;
		for(int counter = 0; counter<patientQ.getSize();counter++)
		{
			c.gridy=counter;
			c.gridx=0;
			c.gridwidth=2;
			patientLabel = new JLabel("ID: "+ counter+ " "+patientQ.getPatient(counter).getLastName()+", " + patientQ.getPatient(counter).getFirstName()+" " + patientQ.getPatient(counter).getMiddleInitial()+
					" "+ patientQ.getPatient(counter).getDateOfBirth());
			patientLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			patientLabel.setFont (patientLabel.getFont ().deriveFont (16.0f));
			removePatient[counter] = new JButton("Remove Patient");
			num=counter;
			removePatient[counter].addActionListener(event->{
				//REMOVES PATIENT
				int i;
				for(i =0; i < removePatient.length;i++)
				{
					if(event.getSource()==removePatient[i])
					{
						break;
					}
				}
				patientQ.removePatient(i);
				//ADD A PAGE REFRESH AFTER DELETING PATIENT SOME HOW
			});
			panel.add(patientLabel,c);
			c.gridwidth=1;
			c.gridx=2;
			panel.add(removePatient[counter],c);
			editPatient[counter]=new JButton("Edit Patient");
			editPatient[counter].addActionListener(event->{
				int i;
				for(i=0;i<editPatient.length;i++)
				{
					if(event.getSource()==editPatient[i])
						break;
				}
				//Gets the right patient and needs to open PatientView
				patientQ.getPatient(i);
			});
			c.gridx=3;
			panel.add(editPatient[counter],c);
			
		}
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setPreferredSize(new Dimension(350,400));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		mainPanel.add(scrollPane);
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.X_AXIS));
		
		JButton back = new JButton("System Return");
		back.addActionListener(event->{
			//GO BACK TO SYSTEM
			systemCtrl.openSystem();
		});
		
		panelButtons.add(back);
		panelButtons.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		mainPanel.add(panelButtons);
		main.add(mainPanel);
	}
	
	public JPanel generateUI() {
		refresh();
		return main;
	}
	
	public int getNum()
	{
		return num;
	}
	/**
	void addPatientListListener(ActionListener listenForAddPatientButton)
	{
		addPatient.addActionListener(listenForAddPatientButton);
	}
	
	void removePatientListener(ActionListener listenForRemovePatientButton)
	{
		removePatient.addActionListener(listenForRemovePatientButton);
	}
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, message);
	}**/
}
