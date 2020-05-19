package edu.sjsu.cs.etrt.model.Questionnaire;

import edu.sjsu.cs.etrt.model.Patient.*;
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
	 * make answerList based on form
	 * @param v THI or TFI
	 */
	public void makeAnswers(boolean thi) {
		//if THI
		if(thi == true) {
			setAnswerList(3);
			setAnswer(0, "Yes(4)");
			setAnswer(1, "Sometimes(2)");
			setAnswer(2, "No (0)");
		}
		else {	//if TFI
			int s = 11;
			setAnswerList(s);		//create answerList
			
			for(int i=0;i<s;i++)
				setAnswer(i, ""+i);	
		}
	}
	
	/**
	 * set up questions for form based on whether THI or TFI
	 */
	public void makeForm(boolean thi){
		setQuestionList();
		if(thi == true) {		//if thi == true
			setQuestion(0, "Because of your tinnitus, is it difficult for you to concentrate?");
			setQuestion(1, "Does the loudness of your tinnitus make it difficult for you to hear people?");
			setQuestion(2, "Does your tinnitus make you angry?");
			setQuestion(3, "Does your tinnitus make you feel confused?");
			setQuestion(4, "Because of your tinnitus, do you feel desperate?");
			setQuestion(5, "Do you complain a great deal about your tinnitus?");
			setQuestion(6, "Because of your tinnitus, do you have trouble falling to sleep at night?");
			setQuestion(7, "Do you feel as though you cannot escape your tinnitus?");
			setQuestion(8, "Does your tinnitus interefere with your ability to enjoy social activities?");
			setQuestion(9, "Because of your tinnitus, do you feel frustrated?");
			setQuestion(10, "Because of your tinnitus, do you feel that you have a terrible disease?");
			setQuestion(11, "Does your tinnitus make it difficult for you to enjoy life?");
			setQuestion(12, "Does your tinnitus interfere with your job or household responsibilities?");
			setQuestion(13, "Because of your tinnitus, do you find that you are often irritable?");
			setQuestion(14, "Because of your tinnitus, is it difficult for you to read?");
			setQuestion(15, "Does your tinnitus make you upset?");
			setQuestion(16, "Do you feel that your tinnitus problem has placed more stress on your " 
					+ "relationships with members of your family and friends?");
			setQuestion(17, "Do you find it difficult to focus your attention away from your "
					+ "tinnitus and on other things?");
			setQuestion(18, "Do you feel that you have no control over your tinnitus?");
			setQuestion(19, "Because of your tinnitus, do you often feel tired?");
			setQuestion(20, "Because of your tinnitus, do you feel depressed?");
			setQuestion(21, "Does your tinnitus make you feel anxious?");
			setQuestion(22, "Do you feel that you can no longer cope with tinnitus?");
			setQuestion(23, "Does your tinnitus get worse when you are under stress?");
			setQuestion(24, "Does your tinnitus make you feel insecure?");
		}
		else {		//if TFI
			setQuestion(0, "What percentage of your time were you consciously AWARE OF your tinnitus?");
			setQuestion(1, "How STRONG or LOUD was your tinnitus?");
			setQuestion(2, "What percentage of your time awake were you ANNOYED by your tinnitus?");
			setQuestion(3, "Did you feel IN CONTROL in regards to your tinnitus?");
			setQuestion(4, "How easy was it for you to COPE with your tinnitus?");
			setQuestion(5, "How easy was it for you to IGNORE your tinnitus?");
			setQuestion(6, "Your ability to CONCENTRATE?");
			setQuestion(7, "Your ability to THINK CLEARLY?");
			setQuestion(8, "Your ability to FOCUS ATTENTION on other things besides your tinnitus?");
			setQuestion(9, "How often did your tinnitus make it difficult to FALL ASLEEP or STAY ASLEEP?");
			setQuestion(10, "How often did your tinnitus cause you difficulty in getting AS MUCH SLEEP"
					+ "as you needed?");
			setQuestion(11, "How much of the time did your tinnitus keep you from SLEEPING as DEEPLY"
					+ "or as PEACEFULLY as you would have liked?");
			setQuestion(12, "Your ability to HEAR CLEARLY?");
			setQuestion(13, "Your ability to UUNDERSTAND PEOPLE who are talking?");
			setQuestion(14, "Your ability to FOLLOW CONVERSATIONS in a group or at meetings?");
			setQuestion(15, "Your QUIET RESTING ACTIVITIES?");
			setQuestion(16, "Your ability to RELAX?");
			setQuestion(17, "Your ability to enjoy 'PEACE AND QUIET'?");
			setQuestion(18, "Your enjoyment of SOCIAL ACTIVITIES?");
			setQuestion(19, "Your ENJOYMENT OF LIFE?");
			setQuestion(20, "Your RELATIONSHIPS with family, friends, and other people?");
			setQuestion(21, "How often did you tinnitus cause you to have difficulty performing your"
					+ "WORK OR OTHER TASKS?");
			setQuestion(22, "How ANXIOUS or WORRIED has your tinnitus made you feel?");
			setQuestion(23, "How BOTHERED or UPSET have you been because of your tinnitus?");
			setQuestion(24, "How DEPRESSED were you because of your tinnitus?");
		}
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
	 * set up new questionList
	 */
	public void setQuestionList() {
		questionList = new String[25];
	}
	
	/**
	 * initialize new answerList depending on size
	 * @param size amount of answers
	 */
	public void setAnswerList(int size) {
		answerList = new String[size];
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
