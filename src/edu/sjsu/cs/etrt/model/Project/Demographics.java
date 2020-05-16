package Project;
public class Demographics {
	private String occupation;
	private String workStatus;
	private String educationalDegree;
	private String notes;
	
	public Demographics(String o, String wS, String eD, String n)
	{
		occupation=o;
		workStatus=wS;
		educationalDegree=eD;
		notes=n;
	}
	
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getEducationalDegree() {
		return educationalDegree;
	}

	public void setEducationalDegree(String educationalDegree) {
		this.educationalDegree = educationalDegree;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Updates the demographics for the patient
	 * @param
	 */
	public void updateDemopgraphics(String o, String wS, String eD, String n)
	{
		occupation=o;
		workStatus=wS;
		educationalDegree=eD;
		notes=n;
	}
	
}
