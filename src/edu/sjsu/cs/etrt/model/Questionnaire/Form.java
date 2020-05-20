package edu.sjsu.cs.etrt.model.Questionnaire;

import edu.sjsu.cs.etrt.model.Patient.*;
//import UI.UIPanel;

public abstract class Form {
	private int THIscore;	//store THIscore		
	private int TFIscore;	//store TFIscore
	private Patient patient;	//patient object
	//private Treatment treatmentNum;		//treatment number assigned
	
	
	/**
	 * Creates a new visit based on the patient, doctor name, 
	 * and time and date. Also generates a visit number.
	 * @param patient object of patient
	 * @param questionList questionList of form
	 * @param answerList answerList of form
	 * @param score score of form
	 * @param t enumeration treatment of form
	 */
	public Form(Patient patient, int thiscore, int tfiscore) {
		this.patient = patient;	
		this.THIscore = thiscore;
		this.TFIscore = tfiscore;
	}
	
	/**
	 * get patient of form
	 * @return patient object
	 */
	public Patient getPatient() {
		return patient;
	}
	
	/**
	 * set THI score of patient
	 * @param score value
	 */
	public void setTHIScore(int s) {
		this.getPatient().addScoreTHI(s);
	}
	
	/**
	 * get THI patient score
	 * 
	 */
	
	public int getTHIScore() {
		return this.getPatient().getScoreTHI();
	}	
	
	
	/**
	 * set TFIscore of patient
	 * @param score value
	 */
	public void setTFIScore(int s) {
		this.getPatient().addScoreTFI(s);
	}
	
	/**
	 * get TFIScore
	 * @return score value
	 */ 
	public int getTFIScore() {
		return this.getPatient().getScoreTFI();
	}	
	
	/**
	 * set treatment based on category
	 */
	/*
	public void setTreatment() {
		switch(getPatient().getCategoryNum()) {
		case category0:
		case category1:
		case category2:
		case category3:
		case category4:
		}
				
	}
	*/
	
	/**
	 * set category based on score
	 */
	/*
	public void setCategory(int score) {		
		//total possible = 350 / 5 = 70
		if(score <= 70) {
			getPatient().setCategoryNum(Category.category0); 
		}
		else if (score <= 140) {
			getPatient().setCategoryNum(Category.category1);
		}
		else if(score <= 210) {
			getPatient().setCategoryNum(Category.category2);
		}
		else if(score <= 280)
		{
			getPatient().setCategoryNum(Category.category3);
		}
		else {
			getPatient().setCategoryNum(Category.category4);
		}
	}
	*/
	
	/**
	 * check whether form is THI or TFI
	 * @return boolean if THI
	 */
	public abstract boolean THI();
}
