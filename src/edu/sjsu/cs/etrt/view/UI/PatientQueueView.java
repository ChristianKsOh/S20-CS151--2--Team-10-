import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PatientQueueView {
	
	private PatientQueue patientQ;
	
	public PatientQueueView(PatientQueue p) {
		patientQ=p;
	}
	
	public void refresh()
	{
		main.removeAll();
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel header = new JLabel("(Last Name), (First Name) ( Middle Initial) (Birthday)");
		panel.add(header);
		for(int counter = 0; counter<patientQ.size();counter++)
		{
			JLabel patientLabel = new JLabel(patientQ.getPatient(counter).getLastName()+", " + patientQ.getPatient(counter).getFirstName()+" "patientQ.getPatient(counter).getMiddleInitial()+
					patientQ.getPatient(counter).getDateOfBirth());
			panel.add(patientLabel);
			
		}
		main.add(panel);
	}

}
