package edu.sjsu.cs.etrt.model.Questionnaire;
import edu.sjsu.cs.etrt.model.Patient.*;

public class THI extends Form{
	
	public THI (Patient patient, int score) {
		super(patient, score);
	}
	
	
	/**
	 * score multiplier for scoring value
	 * @param p points scored per question
	 */
	void scoreMultiplier(int p) {
		setScore(getScore() + 2*p);
	}
	
	//true version of THI
	@Override
	public boolean THI() {
		return true;
	}
	

}
