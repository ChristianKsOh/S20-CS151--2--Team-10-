package edu.sjsu.cs.etrt.view.UI;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.sjsu.cs.etrt.controller.VisitController;
import edu.sjsu.cs.etrt.controller.VisitQueueController;

public class VisitView extends UIPanel{
	private VisitController controller;
	private VisitQueueController back;
	private JPanel main;
	
	private boolean editDate;
	private boolean editTime;
	private boolean editDoctor;
	private boolean editNote;
	
	/**
	 * 
	 * @param ctrl Reference for editing and JFrame.
	 * @param queueCtrl Reference for the back button.
	 */
	public VisitView(VisitController ctrl, VisitQueueController queueCtrl) {
		controller=ctrl;
		back=queueCtrl;
		main=new JPanel();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		editDate=false;
		editTime=false;
		editDoctor=false;
		editNote=false;
	}
	
	@Override
	public void refresh() {
		//Reset main panel
		main.removeAll();
		JPanel blankPanel=new JPanel();
		
		//Create header: date and visit number
		JPanel header=new JPanel();
		header.add(blankPanel);
		
		//Date of appointment in header
		//Clicking the text opens the edit fields
		//If-statement prints the date
		//Else-statement displays inputs and submit button for changing
		if(editDate==false) {
			JTextArea date=new JTextArea();
			String dateString=controller.getDate();
			date.setText(dateString);
			date.setEditable(false);
			date.setFont(new Font(dateString,Font.PLAIN,28));
			date.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					editDate=true;
					refresh();
					controller.refreshFrame();
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				
			});
			
			header.add(date);
		}else {
			JPanel editPanel=new JPanel();
			editPanel.setLayout(new BoxLayout(editPanel,BoxLayout.X_AXIS));
			
			JComboBox month=new JComboBox();
			for(int i=1;i<13;i++) {
				month.addItem(i);
			}
			
			JComboBox day=new JComboBox();
			for(int i=1;i<32;i++) {
				day.addItem(i);
			}
			
			JTextField yearInput=new JTextField();
			yearInput.setColumns(4);
			
			JButton submit=new JButton("Update");
			submit.addActionListener(event->{
				int year;
				if(yearInput.getText()=="") {
					year=controller.getDateAndTimeObject().getYear();
				}else {
					year=Integer.parseInt(yearInput.getText());
				}
				controller.setVisitDate((int)month.getItemAt(month.getSelectedIndex()),
										(int)day.getItemAt(day.getSelectedIndex()),
										year);
				editDate=false;
				refresh();
				controller.refreshFrame();
			});
			
			JButton cancel=new JButton("Cancel");
			cancel.addActionListener(event->{
				editDate=false;
				refresh();
				controller.refreshFrame();
			});
			
			editPanel.add(month);
			editPanel.add(day);
			editPanel.add(yearInput);
			editPanel.add(cancel);
			editPanel.add(submit);
			
			header.add(editPanel);
		}
		
		//Time of appointment in header
		//Clicking the text opens the edit fields
		//If-statement prints the time
		//Else-statement displays inputs and submit button for changing
		if(editTime==false) {
			JTextArea time=new JTextArea();
			String timeString="("+controller.getTime()+")";
			time.setText(timeString);
			time.setEditable(false);
			time.setFont(new Font(timeString,Font.PLAIN,28));
			time.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					editTime=true;
					refresh();
					controller.refreshFrame();
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				
			});
		
			header.add(time);
		}else {
			JPanel editPanel=new JPanel();
			editPanel.setLayout(new BoxLayout(editPanel,BoxLayout.X_AXIS));
			
			JComboBox hour=new JComboBox();
			for(int i=1;i<13;i++) {
				hour.addItem(i);
			}
			
			JComboBox minutes=new JComboBox();
			for(int i=0;i<60;i++) {
				minutes.addItem(i);
			}
			
			JComboBox period=new JComboBox();
			period.addItem("AM");
			period.addItem("PM");
			
			JButton submit=new JButton("Update");
			submit.addActionListener(event->{
				boolean isPM;
				if(period.getItemAt(period.getSelectedIndex()).equals("PM")) {
					isPM=true;
				}else {
					isPM=false;
				}
				controller.setVisitTime((int)hour.getItemAt(hour.getSelectedIndex()), 
										(int)minutes.getItemAt(minutes.getSelectedIndex()),
										isPM);
				editTime=false;
				refresh();
				controller.refreshFrame();
			});
			
			JButton cancel=new JButton("Cancel");
			cancel.addActionListener(event->{
				editTime=false;
				refresh();
				controller.refreshFrame();
			});
			
			editPanel.add(hour);
			editPanel.add(minutes);
			editPanel.add(period);
			editPanel.add(cancel);
			editPanel.add(submit);
			
			header.add(editPanel);
		}
		
		//Visit number in the header (unchangable)
		String numberString=controller.getVisitNumber()+"";
		JTextArea number=new JTextArea(numberString);
		number.setEditable(false);
		number.setFont(new Font(numberString,Font.PLAIN,28));
		
		//Finish adding header items
		header.add(blankPanel);
		header.add(number);
		header.add(blankPanel);
		main.add(header);
		
		
		//Patient and ID (link to patient?)
		JTextArea patientText=new JTextArea("Patient: "+controller.getPatient().getName());
		patientText.setEditable(false);
		patientText.setFont(new Font("Patient: "+controller.getPatient().getName(),Font.PLAIN,20));
		patientText.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//main.removeAll();
				//controller.updateFrame(controller.getPatient().getViewPanel());
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
		});
		
		main.add(patientText);
		
		//Doctor name
		//Clicking the text opens the edit fields
		//If-statement prints the doctor name
		//Else-statement displays inputs and submit button for changing
		if(editDoctor==false) {
			JTextArea doctorText=new JTextArea("Doctor: "+controller.getDoctorName());
			doctorText.setEditable(false);
			doctorText.setFont(new Font("Doctor: "+controller.getDoctorName(),Font.PLAIN,20));
			doctorText.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					editDoctor=true;
					refresh();
					controller.refreshFrame();
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				
			});
			
			main.add(doctorText);
		}else {
			JPanel editPanel=new JPanel();
			editPanel.setLayout(new BoxLayout(editPanel,BoxLayout.X_AXIS));
			
			JTextField doctorInput=new JTextField(controller.getDoctorName());
			doctorInput.setColumns(15);
			
			JButton submit=new JButton("Update");
			submit.addActionListener(event->{
				controller.setvisitDoctor(doctorInput.getText());
				editDoctor=false;
				refresh();
				controller.refreshFrame();
			});
			
			JButton cancel=new JButton("Cancel");
			cancel.addActionListener(event->{
				editDoctor=false;
				refresh();
				controller.refreshFrame();
			});
			
			editPanel.add(doctorInput);
			editPanel.add(cancel);
			editPanel.add(submit);
			
			main.add(editPanel);
		}
		main.add(blankPanel);
		
		//Reason/Special notes
		//Clicking the text opens the edit fields
		//If-statement prints the special note
		//Else-statement displays inputs and submit button for changing
		if(editNote==false) {
			JTextArea noteText=new JTextArea("Special Notes: "+controller.getSpecialNote());
			noteText.setEditable(false);
			noteText.setFont(new Font("Special Notes: "+controller.getSpecialNote(),Font.PLAIN,20));
			noteText.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					editNote=true;
					refresh();
					controller.refreshFrame();
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				
			});

			main.add(noteText);
		}else {
			JPanel editPanel=new JPanel();
			editPanel.setLayout(new BoxLayout(editPanel,BoxLayout.X_AXIS));
			
			JTextField noteInput=new JTextField(controller.getSpecialNote());
			noteInput.setColumns(15);
			
			JButton submit=new JButton("Update");
			submit.addActionListener(event->{
				controller.setVisitSpecialNote(noteInput.getText());
				editNote=false;
				refresh();
				controller.refreshFrame();
			});
			
			JButton cancel=new JButton("Cancel");
			cancel.addActionListener(event->{
				editNote=false;
				refresh();
				controller.refreshFrame();
			});
			
			editPanel.add(noteInput);
			editPanel.add(cancel);
			editPanel.add(submit);
			
			main.add(editPanel);
		}
		
		//Delete Visit button
		JButton deleteButton=new JButton("Cancel Appointment");
		deleteButton.addActionListener(event->{
			back.removeVisit(controller.getVisitNumber());
			main.removeAll();
			controller.updateFrame(back.getViewPanel());
		});
		
		//Back button to return to Queue
		JButton backButton=new JButton("Back");
		backButton.addActionListener(event->{
			editDoctor=false;
			editNote=false;
			main.removeAll();
			controller.updateFrame(back.getViewPanel());
		});
		JPanel buttons=new JPanel();
		buttons.add(deleteButton);
		buttons.add(blankPanel);
		buttons.add(backButton);
		
		main.add(blankPanel);
		main.add(buttons);
	}
	
	@Override
	public JPanel generateUI() {
		refresh();
		return main;
	}
}
