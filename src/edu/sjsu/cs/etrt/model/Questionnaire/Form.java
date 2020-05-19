package edu.sjsu.cs.etrt.model.Questionnaire;

import edu.sjsu.cs.etrt.model.Patient.*;
import edu.sjsu.cs.etrt.model.Project.*;
//import UI.UIPanel;

public abstract class Form {//implements Comparable<Form>{
	private String[] questionList;		//25 questions per questionnaire form
	private String[] answerList;			//THI = 3; TFI = 10	//second index which returns value
	private int score;			//initialized to 0
	//private Treatment treatmentNum;		//treatment number assigned
	private Patient patient;					//patient object
	
	
	/**
	 * Creates a new visit based on the patient, doctor name, 
	 * and time and date. Also generates a visit number.
	 * @param patient object of patient
	 * @param questionList questionList of form
	 * @param answerList answerList of form
	 * @param score score of form
	 * @param t enumeration treatment of form
	 */
	public Form(Patient patient, String[] questionList, String[] answerList, int score) {
		this.patient = patient;
		this.questionList = questionList;
		this.answerList = answerList;	
		this.score = score;
		//this.treatmentNum = t;
	}
	
	/**
	 * get patient of form
	 * @return patient object
	 */
	public Patient getPatient() {
		return patient;
	}
	
	
	/**
	 * set questions based on index
	 * @param q question index
	 * @param s question string
	 */
	public void setQuestion(int q, String s) {
		this.questionList[q] = s;
	}
	
	
	/**
	 * get question based on index
	 * @param q question index
	 * @return question string
	 */
	public String getQuestion(int q) {
		return questionList[q];
	}
	
	/**
	 * return questionList size
	 * @return length of questionList
	 */
	public int getQuestionSize() {
		return questionList.length;
	}
	
	/**
	 * set answers based on index
	 * @param q index of answer
	 * @param s answer string
	 */
	public void setAnswer(int q, String s) {
		this.answerList[q] = s;
	}
	
	/**
	 * get answer string based on index
	 * @param q = answer number
	 * @return answer string
	 */
	public String getAnswer(int q) {
		return answerList[q];
	}
	
	/**
	 * return answerList size
	 * @return length of answerList
	 */
	public int getAnswerSize() {
		return answerList.length;
	}
	
	
	
	/**
	 * set score per question
	 * @param score value
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	
	/**
	 * get score
	 * @return score value
	 */
	public int getScore() {
		return this.score;
	}	

		
	/**
	 * set treatment based on category
	 */
	public void setTreatment() {
		switch(getPatient().getCategoryNum()) {
		case category0:
		case category1:
		case category2:
		case category3:
		case category4:
		}
				
	}
	
	/**
	 * set category based on score
	 */
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
	
	/**
	 * check whether form is THI or TFI
	 * @return boolean if THI
	 */
	public abstract boolean THI();
}
