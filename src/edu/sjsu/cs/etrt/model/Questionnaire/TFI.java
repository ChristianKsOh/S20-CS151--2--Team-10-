package edu.sjsu.cs.etrt.model.Questionnaire;
import edu.sjsu.cs.etrt.model.Patient.*;
import javax.swing.JPanel;


public class TFI extends Form {
	
	public TFI (Patient patient, int score) {
		super(patient, score );
	}
	
	
	@Override
	public boolean THI() {
		return false;
	}
	

}
