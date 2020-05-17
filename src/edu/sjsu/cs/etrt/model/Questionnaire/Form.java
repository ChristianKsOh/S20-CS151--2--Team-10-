package edu.sjsu.cs.etrt.model.Questionnaire;

import edu.sjsu.cs.etrt.model.Project.Category;
import edu.sjsu.cs.etrt.model.Project.Treatment;
import edu.sjsu.cs.etrt.model.Project.Patient;
//import UI.UIPanel;

public abstract class Form {//implements Comparable<Form>{
	private String[][] questionList = new String[25][1];		//25 questions per questionnaire form
	private int[][] answerList;			//THI = 3; TFI = 10	//second index which returns value
	private int score = 0;			//initialized to 0
	private Treatment treatmentNum;		//treatment number assigned
	private Patient patient;					//patient object
	
	
	/**
	 * Creates a new visit based on the patient, doctor name, 
	 * and time and date. Also generates a visit number.
	 * @param patient Object of patient
	 * @param questionList questionList of form
	 * @param answerList answerList of form
	 * @param score score of form
	 * @param t enum treatment of form
	 */
	public Form(Patient patient, String[][] questionList, int[][] answerList, int score, Treatment t) {
		this.patient = patient;
		this.questionList = questionList;
		this.answerList = answerList;	
		this.score = score;
		this.treatmentNum = t;
	}
	
	
	/**
	 * Displays Questions for the Users to answer
	 * @param q question array size
	 * @return String of question
	 */
	public void setQuestion(int q, String s) {
		this.questionList[q][0] = s;
	}
	
	
	/**
	 * Displays Questions for the Users to answer
	 * @param q = question number
	 * @return String of question
	 */
	public String displayQuestion(int q) {
		//System.out.println(questionList[q][0]);
		return questionList[q][0];
	}
	
	/**
	 * set score based per question
	 * @param score value
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	
	/**
	 * get score of form
	 * @return 
	 */
	public int getScore() {
		return this.score;
	}
	
	
	/**
	 * check if answer has been marked for question and return value
	 * @return index of marked answer
	 */
	public int markedAnswer() {
		for(int i=0;i<answerList.length;i++)
			if(answerList[0][i] == 1)
				return i;
			
		return 0;
	}
	
	
	/**
	 * get Patient filling out questionnaire
	 * @return
	 */
	public Patient getPatient() {
		return patient;
	}
	
	
	/**
	 * Set treatment based on questionnaire score
	 */
	public void setTreatment() {
		if(getScore() <= 16) {
			this.treatmentNum = Treatment.Grade0;
		}
		else if (getScore() <= 36) {
			this.treatmentNum = Treatment.Grade1;
		}
		else if(getScore() <= 56) {
			this.treatmentNum = Treatment.Grade2;
		}
		else if(getScore() <= 76)
		{
			this.treatmentNum = Treatment.Grade3;
		}
		else {
			this.treatmentNum = Treatment.Grade4;
		}		
	}
	
	/**
	 * Set Category based on treatment value from questionnaire
	 * -test switch statement
	 */
	public void setCategory() {
		switch(this.treatmentNum) {
		case Grade0:
			getPatient().setCategoryNum(Category.category0);
			break;
		case Grade1:
			getPatient().setCategoryNum(Category.category1);
		case Grade2:
			getPatient().setCategoryNum(Category.category2);
			break;
		case Grade3:
			getPatient().setCategoryNum(Category.category3);
			break;
		case Grade4:
			getPatient().setCategoryNum(Category.category4);
			break;
		}
			
	}
	
	
	/**
	 * compare form results?
	 */
	/*
	public int compareTo(Form that) {
		if(this.treatmentNum == that.treatmentNum) {
			return 0;
		}
		
		return 1;
	}
	*/
	
	/**
	 * Returns whether form is of THI
	 * @return boolean statement of whether visit is THI
	 */
	public abstract boolean THI();
}
