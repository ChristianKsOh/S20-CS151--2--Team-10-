package edu.sjsu.cs.etrt.model.Questionnaire;
import edu.sjsu.cs.etrt.model.Project.Patient;
import edu.sjsu.cs.etrt.model.Project.Treatment;

public class THI extends Form{
	
	public THI (Patient patient, String[][] questionList, int[][] answerList, int score, Treatment t) {
		super(patient, questionList, answerList, score, t);
		
		answerList = new int[25][3];
	}
	
	public void makeForm(){
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
		setQuestion(16, "Do you feel that your tinnitus problem has placed more stress on your" 
		+ "relationships with members of your family and friends?");
		setQuestion(17, "Do you find it difficult to focus your attention away from your"
		+ "tinnitus and on other things?");
		setQuestion(18, "Do you feel that you have no control over your tinnitus?");
		setQuestion(19, "Because of your tinnitus, do you often feel tired?");
		setQuestion(20, "Because of your tinnitus, do you feel depressed?");
		setQuestion(21, "Does your tinnitus make you feel anxious?");
		setQuestion(22, "Do you feel that you can no longer cope with tinnitus?");
		setQuestion(23, "Does your tinnitus get worse when you are under stress?");
		setQuestion(24, "Does your tinnitus make you feel insecure?");
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
