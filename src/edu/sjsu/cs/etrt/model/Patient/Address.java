package edu.sjsu.cs.etrt.model.Patient;
public class Address {
	
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	public Address(String s1, String s2, String c, String s, String z, String country)
	{
		street1=s1;
		street2=s2;
		city=c;
		state=s;
		zip=z;
		this.country=country;
	}
	
	public String getStreet1() {
		return street1;
	}


	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	
	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	/**
	 * Updates all variables for the address
	 * @param street1, street2, city, state, zip, country
	 * @return void
	 */
	public void updateAddress(String s1, String c, String s, String z, String country)
	{
		street1=s1;
		city=c;
		state=s;
		zip=z;
		this.country=country;
	}

}
