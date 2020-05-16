package Project;

public class Patient implements Comparable{
	
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String registrationDate;
	private String gender;
	private String dateOfBrith;
	private String phoneNumber;
	private String socialID;
	private String insuranceID;
	private String orderNumber;
	private Category categoryNum;
	private int visitNumber;
	private Address patientAddress;
	private Demographics patientDemographic;
	
	public Patient(String n, String l, String mi, String r, String g, String d, String p, String s, String i, String o, Category c, int v, Address pA, Demographics pD)
	{
		this.firstName=n;
		this.lastName=l;
		this.middleInitial=mi;
		this.registrationDate=r;
		this.gender=g;
		this.dateOfBrith=d;
		this.phoneNumber=p;
		this.socialID=s;
		this.insuranceID=i;
		this.orderNumber=o;
		this.categoryNum=c;
		this.visitNumber=v;
		this.patientAddress=pA;
		this.patientDemographic=pD;
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

	public Demographics getPatientDemographic() {
		return patientDemographic;
	}

	public void setPatientDemographic(Demographics patientDemographic) {
		this.patientDemographic = patientDemographic;
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

	public String getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(String dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
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
		this.dateOfBrith=d;
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
