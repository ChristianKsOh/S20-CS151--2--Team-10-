import javax.swing.JFrame;
import javax.swing.JPanel;


import edu.sjsu.cs.etrt.view.UI.PatientView;

public class PatientController {
	private Patient model;
	private PatientView view;
	
	public PatientController(Patient patient, PatientView view)
	{
		model = patient;
		this.view=view;
		this.view.systemReturnListeners(new SystemButtonListener())
	}
	
	public void updatePatients()
	{
		view.refresh();
	}
	
	//Back to System GUI
	class SystemButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//switch to system GUI somehow
			try
			{
				
			}
			catch() {
				
			}
		}
	}
	
}
