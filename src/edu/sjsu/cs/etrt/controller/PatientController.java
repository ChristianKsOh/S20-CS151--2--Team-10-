import javax.swing.JFrame;
import javax.swing.JPanel;


import edu.sjsu.cs.etrt.view.UI.PatientView;

public class PatientController {
	private Patient model;
	private PatientView view;
	
	public PatientController(Patient patient)
	{
		model = patient;
	}
}
