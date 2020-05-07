package edu.sjsu.cs.etrt.model.Project;

public class Patient implements Comparable{

	private String name;
	private String registrationDate;
	private String gender;
	private String dateOfBrith;
	private String phoneNumber;
	private String socialID;
	private String insuranceID;
	private String orderNumber;
	private Category categoryNum;
	private int visitNumber;
	
	public Patient(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Updates a patient's profile
	 * @param name, date, gender, birth, number, social, insurance, category, visit
	 */
	public void updateProfile()
	{
		
	}

	/**
	 * Compares different Patients
	 */
	public int compareTo(Object o) {
		
	}
	
}
