package edu.sjsu.cs.etrt.model.Patient;
public class Demographics {
	private String occupation;
	private String workStatus;
	private String educationalDegree;
	private String notes;
	
	/**
	 * Demographics of a patient.
	 * @param o Occupation.
	 * @param wS Work status.
	 * @param eD Educational degree.
	 * @param n Additional notes.
	 */
	public Demographics(String o, String wS, String eD, String n)
	{
		occupation=o;
		workStatus=wS;
		educationalDegree=eD;
		notes=n;
	}
	
	/**
	 * Get occupation of patient.
	 * @return Occupation.
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * Set occupation of patient.
	 * @param occupation Occupation.
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * Get the work status of patient.
	 * @return Work status.
	 */
	public String getWorkStatus() {
		return workStatus;
	}

	/**
	 * Set the work status of patient.
	 * @param workStatus Work status.
	 */
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	/**
	 * Get the educational degree of patient.
	 * @return Educational degree.
	 */
	public String getEducationalDegree() {
		return educationalDegree;
	}

	/**
	 * Set the educational degree of patient.
	 * @param educationalDegree Educational degree.
	 */
	public void setEducationalDegree(String educationalDegree) {
		this.educationalDegree = educationalDegree;
	}

	/**
	 * Get any special notes on the patient.
	 * @return Notes.
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Set special notes on the patient.
	 * @param notes Notes.
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Updates the demographics for the patient
	 * @param o Occupation.
	 * @param wS Work status.
	 * @param eD Educational degree.
	 * @param n Additional notes.
	 */
	public void updateDemopgraphics(String o, String wS, String eD, String n)
	{
		occupation=o;
		workStatus=wS;
		educationalDegree=eD;
		notes=n;
	}
	
}
