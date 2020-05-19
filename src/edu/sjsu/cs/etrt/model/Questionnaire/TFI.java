package edu.sjsu.cs.etrt.model.Questionnaire;
import edu.sjsu.cs.etrt.model.Patient.*;
import edu.sjsu.cs.etrt.model.Project.*;
import javax.swing.JPanel;


public class TFI extends Form {
	
	public TFI (Patient patient, String[] questionList, String[] answerList, int score) {
		super(patient, questionList, answerList, score );
	}
	
	
	/**
	 * set up answers for THI
	 */
	public void makeAnswers() {
		for(int i=0;i<11;i++)
			setAnswer(i, ""+i);		//lazy casting...
	}
	
	public void makeForm(){
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
	
	@Override
	public boolean THI() {
		return false;
	}
	

}
