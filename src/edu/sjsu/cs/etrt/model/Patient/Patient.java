package edu.sjsu.cs.etrt.model.Patient;

import java.util.ArrayList;

public class Patient implements Comparable<Patient>{
	
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String registrationDate;
	private String gender;
	private String dateOfBirth;
	private String phoneNumber;
	private String socialID;
	private String insuranceID;
	private String orderNumber;
	private Treatment treatmentNum;
	private int visitNumber;
	private ArrayList<Integer> scoresTFI;
	private ArrayList<Integer> scoresTHI;
	private Address patientAddress;
	private Demographics patientDemographic;
	private int patientID;
	public Patient()
	{
		scoresTFI=new ArrayList<Integer>();
		scoresTHI=new ArrayList<Integer>();
		this.firstName="NA";
		this.lastName="NA";
		this.middleInitial="NA";
		this.registrationDate="NA";
		this.gender="NA";
		this.dateOfBirth="NA";
		this.phoneNumber="NA";
		this.socialID="NA";
		this.insuranceID="NA";
		this.orderNumber="NA";
		this.treatmentNum=treatmentNum.Grade0;
		this.visitNumber=0;
		Address a = new Address("NA","NA","NA","NA","NA","NA");
		this.patientAddress=a;
		Demographics d= new Demographics("NA","NA","NA","NA");
		this.patientDemographic=d;
	}
	
	/**
	 * Initializes an instance of patient.
	 * @param n First name.
	 * @param l Last name.
	 * @param mi Middle initial.
	 * @param r Registration date as a String.
	 * @param g Gender.
	 * @param d Date of birth as a String.
	 * @param p Phone number as a String.
	 * @param s Social ID as a String.
	 * @param i Insurance ID as a String.
	 * @param o Order number as a String.
	 * @param c Treatment.
	 * @param v Visit number.
	 * @param pA Address object.
	 * @param pD Demographics object.
	 */
	public Patient(String n, String l, String mi, String r, String g, String d, String p, String s, String i, String o, Treatment c, int v, Address pA, Demographics pD)
	{
		scoresTFI=new ArrayList<Integer>();
		scoresTHI=new ArrayList<Integer>();
		this.firstName=n;
		this.lastName=l;
		this.middleInitial=mi;
		this.registrationDate=r;
		this.gender=g;
		this.dateOfBirth=d;
		this.phoneNumber=p;
		this.socialID=s;
		this.insuranceID=i;
		this.orderNumber=o;
		this.treatmentNum=c;
		this.visitNumber=v;
		this.patientAddress=pA;
		this.patientDemographic=pD;
	}
	
	/**
	 * Returns an ArrayList of all the TFI scores.
	 * @return ArrayList of all the TFI scores.
	 */
	public ArrayList<Integer> getScoreTFIHistory()
	{
		return scoresTFI;
	}
	
	/**
	 * Update the patient's TFI score.
	 * @param tfi TFI score.
	 */
	public void addScoreTFI(int tfi) {
		scoresTFI.add(tfi);
	}
	
	/**
	 * Returns the most recent TFI score.
	 * @return TFI score.
	 */
	public int getScoreTFI() {
		if(scoresTFI.size()==0) {
			return 0;
		}
		return scoresTFI.get(scoresTFI.size()-1);
	}
	
	/**
	 * Returns an ArrayList of all the THI scores.
	 * @return ArrayList of all the THI scores.
	 */
	public ArrayList<Integer> getScoreTHIHistory() {
		return scoresTHI;
	}
	
	/**
	 * Update the patient's THI score.
	 * @param thi THI score.
	 */
	public void addScoreTHI(int thi) {
		scoresTHI.add(thi);
	}
	
	/**
	 * Returns the most recent THI score.
	 * @return THI score.
	 */
	public int getScoreTHI() {
		if(scoresTHI.size()==0) {
			return 0;
		}
		return scoresTHI.get(scoresTHI.size()-1);
	}
	
	/**
	 * Get the patient's first name.
	 * @return First name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the patient's first name.
	 * @param firstName First name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get the patient's middle initial.
	 * @return Middle initial.
	 */
	public String getMiddleInitial() {
		return middleInitial;
	}

	/**
	 * Set the patient's middle initial.
	 * @param middleInitial Middle initial without the dot.
	 */
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	/**
	 * Get the patient's last name.
	 * @return Last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the patient's last name.
	 * @param lastName Last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Returns the patient's Address.
	 * @return Address object.
	 */
	public Address getPatientAddress() {
		return patientAddress;
	}

	/**
	 * Set the patient's Address.
	 * @param patientAddress Address object.
	 */
	public void setPatientAddress(Address patientAddress) {
		this.patientAddress = patientAddress;
	}

	/**
	 * Get the street of the address.
	 * @return Street of the address.
	 */
	public String getStreet1()
	{
		return this.patientAddress.getStreet1();
	}
	
	/**
	 * Set the street of the address.
	 * @param s Street of the address.
	 */
	public void setStreet1(String s)
	{
		this.patientAddress.setStreet1(s);
	}
	
	/**
	 * Get the second street of the address if applicable.
	 * @return Street of the address. Leave blank if not applicable.
	 */
	public String getStreet2()
	{
		return this.patientAddress.getStreet2();
	}
	
	/**
	 * Set the second street of the address if applicable.
	 * @param s Street of the address. Blank if not applicable.
	 */
	public void setStreet2(String s)
	{
		this.patientAddress.setStreet2(s);
	}
	
	/**
	 * Get the city of the address.
	 * @return City of the address.
	 */
	public String getCity()
	{
		return this.patientAddress.getCity();
	}
	
	/**
	 * Set the city of the address.
	 * @param s City of the address.
	 */
	public void setCity(String s)
	{
		this.patientAddress.setCity(s);
	}
	
	/**
	 * Get the state of the address.
	 * @return State of the address.
	 */
	public String getState()
	{
		return this.patientAddress.getState();
	}
	
	/**
	 * Set the state of the address.
	 * @param s State of the address.
	 */
	public void setState(String s)
	{
		this.patientAddress.setState(s);
	}
	
	/**
	 * Get the zip code of the address as a String.
	 * @return Zip code of address.
	 */
	public String getZip()
	{
		return this.patientAddress.getZip();
	}
	
	/**
	 * Set the zip code of the address as a String.
	 * @param s Zip code of address.
	 */
	public void setZip(String s)
	{
		this.patientAddress.setZip(s);
	}
	
	/**
	 * Get the country of the address.
	 * @return Country of the address.
	 */
	public String getCountry()
	{
		return this.patientAddress.getCountry();
	}
	
	/**
	 * Set the country of the address.
	 * @param s Country of the address.
	 */
	public void setCountry(String s)
	{
		this.patientAddress.setCountry(s);
	}
	
	/**
	 * Return the Demographic object of patient.
	 * @return Demographic object.
	 */
	public Demographics getPatientDemographic() {
		return patientDemographic;
	}
	
	/**
	 * Set the Demographic object of patient.
	 * @param patientDemographic Demographic object.
	 */
	public void setPatientDemographic(Demographics patientDemographic) {
		this.patientDemographic = patientDemographic;
	}
	
	/**
	 * Get the work status of patient.
	 * @return Work status.
	 */
	public String getWorkStatus()
	{
		return this.patientDemographic.getWorkStatus();
	}
	
	/**
	 * Set the work status of patient.
	 * @param s Work status.
	 */
	public void setWorkStatus(String s)
	{
		this.patientDemographic.setWorkStatus(s);
	}
	
	/**
	 * Get the educational degree of patient.
	 * @return Educational degree.
	 */
	public String getEducationalDegree()
	{
		return this.patientDemographic.getEducationalDegree();
	}
	
	/**
	 * Set the educational degree of patient.
	 * @param s Educational degree.
	 */
	public void setEducationalDegree(String s)
	{
		this.patientDemographic.setEducationalDegree(s);
	}

	/**
	 * Get any special notes on the patient.
	 * @return Notes.
	 */
	public String getNotes()
	{
		return this.patientDemographic.getNotes();
	}
	
	/**
	 * Set special notes on the patient.
	 * @param s Notes.
	 */
	public void setNotes(String s)
	{
		this.patientDemographic.setNotes(s);
	}

	/**
	 * Get occupation of patient.
	 * @return Occupation.
	 */
	public String getOccupation()
	{
		return this.patientDemographic.getOccupation();
	}
	
	/**
	 * Set occupation of patient.
	 * @param s Occupation.
	 */
	public void setOccupation(String s)
	{
		this.patientDemographic.setOccupation(s);
	}

	/**
	 * Get the registration date of the patient as a string.
	 * @return String of registration date.
	 */
	public String getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Set the registration date of the patient as a string.
	 * @param registrationDate String of registration date.
	 */
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Get the patient's gender.
	 * @return Gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set the patient's gender.
	 * @param gender Gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Get the patient's birth date as a String.
	 * @return String of birth date.
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Set the patient's birth date as a String.
	 * @param dateOfBirth String of birth date.
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Get the patient's birth date as a String.
	 * @return String of birth date.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set the patient's birth date as a String.
	 * @param phoneNumber String of birth date.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Get the patient's social ID as a String.
	 * @return String of social ID.
	 */
	public String getSocialID() {
		return socialID;
	}

	/**
	 * Set the patient's social ID as a String.
	 * @param socialID String of social ID.
	 */
	public void setSocialID(String socialID) {
		this.socialID = socialID;
	}
	
	/**
	 * Get the patient's insurance ID as a String.
	 * @return String of insurance ID.
	 */
	public String getInsuranceID() {
		return insuranceID;
	}

	/**
	 * Set the patient's insurance ID as a String.
	 * @param insuranceID String of insurance ID.
	 */
	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}

	/**
	 * Get the patient's order number as a String.
	 * @return String of order number.
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Set the patient's order number as a String.
	 * @param orderNumber String of order number.
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * Get the Treatment of the patient.
	 * @return Treatment.
	 */
	public Treatment getTreatmentNum() {
		return treatmentNum;
	}

	/**
	 * Set the Treatment of the patient.
	 * @param treatNum Treatment.
	 */
	public void setTreatmentNum(Treatment treatNum) {
		this.treatmentNum = treatNum;
	}

	/**
	 * Get the visit number of the patient.
	 * @return Visit number.
	 */
	public int getVisitNumber() {
		return visitNumber;
	}

	/**
	 * Set the visit number of the patient.
	 * @param visitNumber Visit number.
	 */
	public void setVisitNumber(int visitNumber) {
		this.visitNumber = visitNumber;
	}
	
	/**
	 * Return the patient ID.
	 * @return Patient index within the list
	 */
	public int getPatientID() {
		return patientID;
	}
	
	/**
	 * Sets the patient ID.
	 * @param id Index of patient in the list.
	 */
	public void setPatientID(int id) {
		patientID=id;
	}
	
	/**
	 * Updates a patient's profile
	 * @param n First name.
	 * @param l Last name.
	 * @param mi Middle initial.
	 * @param r Registration date as a String.
	 * @param g Gender.
	 * @param d Date of birth as a String.
	 * @param p Phone number as a String.
	 * @param s Social ID as a String.
	 * @param i Insurance ID as a String.
	 * @param o Order number as a String.
	 * @param c Treatment.
	 * @param v Visit number.
	 * @param pA Address object.
	 * @param pD Demographics object.
	 */
	public void updateProfile(String n, String l, String mi, String r, String g, String d, String p, String s, String i, String o, Treatment c, int v, Address pA, Demographics pD)
	{
		this.firstName=n;
		this.lastName=l;
		this.middleInitial=mi;
		this.registrationDate=r;
		this.gender=g;
		this.dateOfBirth=d;
		this.phoneNumber=p;
		this.socialID=s;
		this.insuranceID=i;
		this.orderNumber=o;
		this.treatmentNum=c;
		this.visitNumber=v;
		this.patientAddress=pA;
		this.patientDemographic=pD;
	}

	@Override
	/**
	 * Compares name, ID, orderNumber, and visitNumber.
	 */
	public int compareTo(Patient o) {
		if(firstName.compareTo(o.firstName)==0) {
			if(lastName.compareTo(o.lastName)==0) {
				if(middleInitial.compareTo(o.middleInitial)==0) {
					if(socialID.compareTo(o.socialID)==0) {
						if(insuranceID.compareTo(o.insuranceID)==0) {
							if(orderNumber.compareTo(o.orderNumber)==0) {
								if(visitNumber==o.visitNumber) {
									return 0;
								}return (int)Math.signum(visitNumber-o.visitNumber);
							}return orderNumber.compareTo(o.orderNumber);
						}return insuranceID.compareTo(o.insuranceID);
					}return socialID.compareTo(o.socialID);
				}return middleInitial.compareTo(o.middleInitial);
			}return lastName.compareTo(o.lastName);
		}return firstName.compareTo(o.firstName);
	}
}
