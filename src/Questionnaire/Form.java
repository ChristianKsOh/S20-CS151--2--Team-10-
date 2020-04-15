package Questionnaire;

import Project.Category;
import UI.UIPanel;

/**
 * describe Treatment protocol based on Category 
 * of given Questionnaires
 */
enum Treatment {
	ZERO, ONE, TWO, THREE, FOUR;
}


public abstract class Form implements Comparable, UIPanel{
	private String questionList[][];
	private int score;
	private Category categoryNum;
	
	
	/**
	 * Displays Questions for the Users
	 * @param Type type of Questionnaire based on boolean value
	 */
	public void displayQuestions(boolean Type) {
		
	}
	
	/**
	 * Set score based on Questionnaire results
	 * @param score Questionnaire score
	 */
	public void setScore(int score) {
		
	}
	
	/**
	 * Set category of tinnitus based on Questionnaire results
	 * @param c Category enumeration object
	 */
	public void setCategoryNum(Category c) {
		
	}
	
	/**
	 * Set Treatment results 
	 * @param t Treatment enumeration object
	 */
	public void setTreatment(Treatment t) {
		
	}
	
	/**
	 * Compares the Questionnaire Forms
	 */
	public int compareTo(Object o) {
		
	}
	
	
}
