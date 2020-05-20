package edu.sjsu.cs.etrt.model.Patient;

import java.util.ArrayList;

public class Patient implements Comparable{
	
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
	private Category categoryNum;
	private int visitNumber;
	private ArrayList<Integer> scoresTFI;
	private ArrayList<Integer> scoresTHI;
	private Address patientAddress;
	private Demographics patientDemographic;
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
		this.categoryNum=categoryNum.category0;
		this.visitNumber=0;
		Address a = new Address("NA","NA","NA","NA","NA");
		this.patientAddress=a;
		Demographics d= new Demographics("NA","NA","NA","NA");
		this.patientDemographic=d;
	}
	public Patient(String n, String l, String mi, String r, String g, String d, String p, String s, String i, String o, Category c, int v, Address pA, Demographics pD)
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
		this.categoryNum=c;
		this.visitNumber=v;
		this.patientAddress=pA;
		this.patientDemographic=pD;
	}
	
	public ArrayList<Integer> getScoreTFIHistory()
	{
		return scoresTFI;
	}
	public void addScoreTFI(int tfi) {
		scoresTFI.add(tfi);
	}
	public int getScoreTFI() {
		if(scoresTFI.size()==0) {
			return 0;
		}
		return scoresTFI.get(scoresTFI.size()-1);
	}
	public ArrayList<Integer> getScoreTHIHistory() {
		return scoresTHI;
	}
	public void addScoreTHI(int thi) {
		scoresTHI.add(thi);
	}
	public int getScoreTHI() {
		if(scoresTHI.size()==0) {
			return 0;
		}
		return scoresTHI.get(scoresTHI.size()-1);
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getPatientAddress() {
		return patientAddress;
	}

	
	public void setPatientAddress(Address patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getStreet1()
	{
		return this.patientAddress.getStreet1();
	}
	
	public void setStreet1(String s)
	{
		this.patientAddress.setStreet1(s);
	}
	
	public String getCity()
	{
		return this.patientAddress.getCity();
	}
	
	public void setCity(String s)
	{
		this.patientAddress.setCity(s);
	}
	
	public String getState()
	{
		return this.patientAddress.getState();
	}
	
	public void setState(String s)
	{
		this.patientAddress.setState(s);
	}
	
	public String getZip()
	{
		return this.patientAddress.getZip();
	}
	
	public void setZip(String s)
	{
		this.patientAddress.setZip(s);
	}
	
	public String getCountry()
	{
		return this.patientAddress.getCountry();
	}
	
	public void setCountry(String s)
	{
		this.patientAddress.setCountry(s);
	}
	
	public Demographics getPatientDemographic() {
		return patientDemographic;
	}
	

	public void setPatientDemographic(Demographics patientDemographic) {
		this.patientDemographic = patientDemographic;
	}
	
	public String getWorkStatus()
	{
		return this.patientDemographic.getWorkStatus();
	}
	
	public void setWorkStatus(String s)
	{
		this.patientDemographic.setWorkStatus(s);
	}
	
	public String getEducationalDegree()
	{
		return this.patientDemographic.getEducationalDegree();
	}
	
	public void setEducationalDegree(String s)
	{
		this.patientDemographic.setEducationalDegree(s);
	}

	public String getNotes()
	{
		return this.patientDemographic.getNotes();
	}
	
	public void setNotes(String s)
	{
		this.patientDemographic.setNotes(s);
	}

	public String getOccupation()
	{
		return this.patientDemographic.getOccupation();
	}
	
	public void setOccupation(String s)
	{
		this.patientDemographic.setOccupation(s);
	}


	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBrith) {
		this.dateOfBirth = dateOfBrith;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSocialID() {
		return socialID;
	}

	public void setSocialID(String socialID) {
		this.socialID = socialID;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Category getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(Category categoryNum) {
		this.categoryNum = categoryNum;
	}

	public int getVisitNumber() {
		return visitNumber;
	}

	public void setVisitNumber(int visitNumber) {
		this.visitNumber = visitNumber;
	}
	
	/**
	 * Updates a patient's profile
	 * @param name, date, gender, birth, number, social, insurance, category, visit
	 */
	public void updateProfile(String n, String l, String mi, String r, String g, String d, String p, String s, String i, String o, Category c, int v, Address pA, Demographics pD)
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
		this.categoryNum=c;
		this.visitNumber=v;
		this.patientAddress=pA;
		this.patientDemographic=pD;
	}

	/**
	 * Compares different Patients
	 */
	public int compareTo(Object o) {
		return 0;
		
	}
	
}
