package edu.sjsu.cs.etrt.model.Questionnaire;
import edu.sjsu.cs.etrt.model.Patient.*;
import javax.swing.JPanel;


public class TFI extends Form {
	
	public TFI (Patient patient, String[] questionList, String[] answerList, int score) {
		super(patient, questionList, answerList, score );
	}
	
	
	@Override
	public boolean THI() {
		return false;
	}
	

}
