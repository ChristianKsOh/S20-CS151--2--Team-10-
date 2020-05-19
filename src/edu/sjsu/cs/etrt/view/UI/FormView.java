package edu.sjsu.cs.etrt.view.UI;
import edu.sjsu.cs.etrt.controller.FormController;
import edu.sjsu.cs.etrt.controller.PatientController;
import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.model.Questionnaire.*;
import edu.sjsu.cs.etrt.model.Patient.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormView extends UIPanel{
	//controller instance
	private FormController THICtrl;		//THI gets/sets 
	private FormController TFICtrl;		//TFI gets/sets 
	private SystemController systemCtrl;
	
	//instance of Form
	public FormView(FormController fCtrl, FormController fCtrl2, SystemController system)
	{
		this.THICtrl=fCtrl;
		this.TFICtrl=fCtrl2;
		systemCtrl=system;
	}
	
	//call new FormView
	@Override
	public void refresh() {
		//frame
		JFrame frame = new JFrame("Questionnaire Form");	
				
		//panels
		JPanel panelCont = new JPanel();		//container panel		
		JPanel THIpanel = new JPanel();			//panel store THI questions
		JPanel TFIpanel = new JPanel();			//panel store TFI questions
				
		JPanel panelHead = new JPanel();		//container panel for header
		JPanel THIheader = new JPanel();		//header panel
		JPanel TFIheader = new JPanel(new FlowLayout());
		JPanel foot = new JPanel();			//foot: submit, reset, next questionnaire
				
		//JLabel titles
		JLabel title1 = new JLabel("Tinnitus Handicap Inventory");
		JLabel title2 = new JLabel("Tinnitus Functional Index");
				
				
		//buttons 
		JButton THItoTFI = new JButton("Move to TFI Questionnaire");	//switch from THI > TFI
		JButton TFItoTHI = new JButton("Move to THI Questionnaire");	//switch from TFI > THI
		JButton submit = new JButton("Submit");		//submit result
		JButton reset = new JButton("Reset");		//reset questionnaire
				
		//JLabels & JButtonGroups
		JLabel[] THIquestions = new JLabel[25];
		JLabel[] TFIquestions = new JLabel[25];
		JRadioButton[] THIanswers = new JRadioButton[3];		//3 buttons for 25 questions
		//might do slider
		JRadioButton[] TFIanswers = new JRadioButton[11];		//10 buttons for 25 questions
		ButtonGroup[] THIanswerGroup = new ButtonGroup[25];		//25 groups of 3
		ButtonGroup[] TFIanswerGroup = new ButtonGroup[25];

				
				
		//card layout manager initialization
		CardLayout c = new CardLayout();
		CardLayout c1 = new CardLayout();		//for header
				
				
		panelCont.setLayout(c);
		panelHead.setLayout(c1);
				
		//controller = ctrl;
		THIpanel.setLayout(new GridBagLayout());		//grid bag layout
		TFIpanel.setLayout(new GridBagLayout());		//grid bag layout #2
		GridBagConstraints gbc = new GridBagConstraints();		//constraints
				
		//create list, make list
		THICtrl.setQuestionList();
		TFICtrl.setQuestionList();
		THICtrl.makeForm(true);		
		THICtrl.makeAnswers(true);	
		TFICtrl.makeForm(false);
		TFICtrl.makeAnswers(false);
				
		//gridBag fill constraints
		gbc.fill = GridBagConstraints.HORIZONTAL;
				
		//header
		title1.setFont(new Font("Arial", Font.BOLD, 30)); 
		title2.setFont(new Font("Arial", Font.BOLD, 30)); 
		//add to appropriate panels
		THIheader.add(Box.createRigidArea(new Dimension(175, 0)));		//set header dimensions
		THIheader.setLayout(new BoxLayout(THIheader, BoxLayout.LINE_AXIS));
		THIheader.add(title1);
		THIheader.add(Box.createRigidArea(new Dimension(375, 0)));
		THIheader.add(THItoTFI);
		TFIheader.setLayout(new BoxLayout(TFIheader, BoxLayout.LINE_AXIS));
		TFIheader.add(Box.createRigidArea(new Dimension(175, 0)));
		TFIheader.add(title2);
		TFIheader.add(Box.createRigidArea(new Dimension(415, 0)));
		TFIheader.add(TFItoTHI);
				
		gbc.insets = new Insets(5, 5, 5 ,5);	//top, left, right, bot
				
		//parse through questions - same for both THI and TFI
		for(int i=0;i<THICtrl.getQuestionSize();i++) {
			THIquestions[i] = new JLabel((i+1) + ". " + THICtrl.getQuestion(i));
			TFIquestions[i] = new JLabel((i+1) + ". " + TFICtrl.getQuestion(i));
			//grid coordinates
			gbc.gridx = 0;
			gbc.gridy = i+1;
			THIpanel.add(THIquestions[i], gbc);
			TFIpanel.add(TFIquestions[i], gbc);
			//make a new group
			THIanswerGroup[i] = new ButtonGroup();
			TFIanswerGroup[i] = new ButtonGroup();
					
			//THI - 3 answers
			for(int j=0;j<THICtrl.getAnswerSize();j++) {
				//grid coordinates
				gbc.gridx = j+1;
				gbc.gridy = i+1;
				THIanswers[j] = new JRadioButton(THICtrl.getAnswer(j));		//create new radiobutton
				THIanswers[j].setSelected(false);	//set to initially false
						
				THIpanel.add(THIanswers[j], gbc);		//add to panel
				THIanswerGroup[i].add(THIanswers[j]); //add 3 to group
			}	
					
					
			//TFI - 10 answers
			for(int k=0;k<TFICtrl.getAnswerSize();k++) {
				gbc.gridx = k+1;
				gbc.gridy = i+1;
				if(i == 0 || i == 2)		//percentages for q1 and q3
					TFIanswers[k] = new JRadioButton("" + (k*10) + "%");
				else
					TFIanswers[k] = new JRadioButton(TFICtrl.getAnswer(k));
				TFIanswers[k].setSelected(false);
						
				TFIpanel.add(TFIanswers[k], gbc);
				TFIanswerGroup[i].add(TFIanswers[k]); //add 10 to group
					
			}
		}	//end for loop
				
		//add buttons to end of page
		foot.add(submit);
		foot.add(reset);
				
		//add two instances of questionnaires to panel container
		panelCont.add(THIpanel, "1");
		panelCont.add(TFIpanel, "2");
		panelHead.add(THIheader, "1");
		panelHead.add(TFIheader, "2");
				
		//show THI first
		c.show(panelCont, "1");
		c1.show(panelHead, "1");
				
		//perform questionnaire switch when button pressed
		THItoTFI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c.show(panelCont, "2");
				c1.show(panelHead, "2");
			}
		});
				
		//reverse questionnaire switch when button pressed
		TFItoTHI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c.show(panelCont, "1");
				c1.show(panelHead, "1");
			}
		});
		//set border layout
		frame.setLayout(new BorderLayout());
		//add panels to frame
		frame.add(panelHead, BorderLayout.NORTH);
		frame.add(panelCont, BorderLayout.CENTER);
		frame.add(foot, BorderLayout.SOUTH);
						
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) throws Exception  {
		/*
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FormView();
			}
		});
		*/
		//refresh();
		
	 }
	
}
