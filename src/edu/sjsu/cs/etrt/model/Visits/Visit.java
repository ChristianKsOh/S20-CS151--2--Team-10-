package Visits;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Project.Patient;
import UI.UIPanel;

public abstract class Visit implements Comparable<Visit>, UIPanel{
	private DateAndTime dateAndTime;
	private int visitNumber;
	private Patient patient;
	private String doctor;
	
	/**
	 * Creates a new visit based on the patient, doctor name, 
	 * and time and date. Also generates a visit number.
	 * @param patient Object of patient
	 * @param doctor doctor name
	 * @param date date of visit
	 * @param time time of visit
	 */
	public Visit(Patient patient, String doctor, int month, int day, int year, int hour, int minute, boolean dateAndTimePeriod) {
		this.patient=patient;
		this.doctor=doctor;
		dateAndTime=new DateAndTime(month,day,year,hour,minute,dateAndTimePeriod);
		this.visitNumber=Math.abs(patient.hashCode()+doctor.hashCode()+dateAndTime.hashCode())/100;
	}
	
	/**
	 * Return the object of the patient in the visit.
	 * @return patient object.
	 */
	public Patient getPatient() {
		return patient;
	}
	
	/**
	 * Return the doctor's name.
	 * @return doctor's name.
	 */
	public String getDoctorName() {
		return doctor;
	}
	
	/**
	 * Get the date of the visit.
	 * @return date of visit.
	 */
	public String getDate() {
		return dateAndTime.getMonth()
				+"/"+dateAndTime.getDay()
				+"/"+dateAndTime.getYear();
	}
	
	/**
	 * Get the time of the visit.
	 * @return time of visit.
	 */
	public String getTime() {
		return dateAndTime.getHour()
				+":"+dateAndTime.getMinutes()
				+" "+dateAndTime.getPeriod();
	}
	
	/**
	 * Get the full DateAndTime object.
	 * @return DateAndTime object.
	 */
	public DateAndTime getDateAndTime() {
		return dateAndTime;
	}
	
	/**
	 * Retrieve the visit number of the Visit.
	 * @return visit number.
	 */
	public int getVisitNumber() {
		return visitNumber;
	}
	
	/**
	 * Changes the date of the visit.
	 * @param d new date.
	 */
	public void setDate(int month, int day, int year) {
		dateAndTime.setDate(month, day, year);
	}
	
	/**
	 * Changes the time of the visit.
	 * @param t new time.
	 */
	public void setTime(int hour, int minutes, boolean isPM) {
		dateAndTime.setTime(hour, minutes, isPM);
	}
	
	/**
	 * Change the doctor of the visit.
	 * @param doctorName new doctor's name
	 */
	public void changeDoctor(String doctorName) {
		doctor=doctorName;
	}
	
	/**
	 * Compares the Visit based on time and date.
	 */
	public int compareTo(Visit that) {
			if(this.getDateAndTime().compareTo(that.getDateAndTime())==0) {
				if(this.getDate().compareTo(that.getDoctorName())==0) {
					if(this.getPatient().compareTo(that.getPatient())==0) {
						return 0;
					}
					return this.getPatient().compareTo(that.getPatient());
				}
				return this.getDate().compareTo(that.getDoctorName());
			}
			return this.getDateAndTime().compareTo(that.getDateAndTime());
		}
	
	@Override
	public JPanel generateUI() {
		JPanel main=new JPanel();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		
		String dateString=getDate()+" ("+getTime()+")";
		JTextArea date=new JTextArea(dateString);
		date.setEditable(false);
		date.setFont(new Font(dateString,Font.PLAIN,20));
		
		String numberString=visitNumber+"";
		JTextArea number=new JTextArea(numberString);
		number.setEditable(false);
		number.setFont(new Font(numberString,Font.PLAIN,20));
		
		JPanel header=new JPanel();
		header.add(new JPanel());
		header.add(date);
		header.add(new JPanel());
		header.add(number);
		header.add(new JPanel());
		
		//Patient and ID (link to patient?)
		//Doctor name
		//Reason/Special notes
		
		return main;
	}
	
	/**
	 * Returns whether visit is an initial visit.
	 * @return boolean statement of whether the visit is an initial visit
	 */
	public abstract boolean initialVisit();
}
