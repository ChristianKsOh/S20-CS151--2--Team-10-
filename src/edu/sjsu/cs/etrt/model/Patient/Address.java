package edu.sjsu.cs.etrt.model.Patient;
public class Address {
	
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	/**
	 * Address of the patient.
	 * @param s1 Street.
	 * @param s2 Secondary street (optional). Leave blank if not applicable.
	 * @param c City.
	 * @param s State.
	 * @param z Zip code.
	 * @param country Country.
	 */
	public Address(String s1, String s2, String c, String s, String z, String country)
	{
		street1=s1;
		street2=s2;
		city=c;
		state=s;
		zip=z;
		this.country=country;
	}
	
	/**
	 * Get the street of the address.
	 * @return s Street of the address.
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * Set the street of the address.
	 * @param street1 Street of the address.
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	
	/**
	 * Get the second street of the address if applicable.
	 * @return Street of the address. Leave blank if not applicable.
	 */
	public String getStreet2() {
		return street2;
	}
	
	/**
	 * Set the second street of the address if applicable.
	 * @param street2 Street of the address. Blank if not applicable.
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	
	/**
	 * Get the city of the address.
	 * @return City of the address.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city of the address.
	 * @param city City of the address.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get the state of the address.
	 * @return State of the address.
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the state of the address.
	 * @param state State of the address.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Get the zip code of the address as a String.
	 * @return Zip code of address.
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Set the zip code of the address as a String.
	 * @param zip Zip code of address.
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Get the country of the address.
	 * @return Country of the address.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set the country of the address.
	 * @param country Country of the address.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Updates all variables for the address
	 * @param s1 Street.
	 * @param s2 Secondary street (optional). Leave blank if not applicable.
	 * @param c City.
	 * @param s State.
	 * @param z Zip code.
	 * @param country Country.
	 */
	public void updateAddress(String s1, String s2, String c, String s, String z, String country)
	{
		street1=s1;
		street2=s2;
		city=c;
		state=s;
		zip=z;
		this.country=country;
	}

}
