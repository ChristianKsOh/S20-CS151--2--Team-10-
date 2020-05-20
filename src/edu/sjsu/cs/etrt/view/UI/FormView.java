package edu.sjsu.cs.etrt.view.UI;
import edu.sjsu.cs.etrt.controller.FormController;
import edu.sjsu.cs.etrt.controller.PatientController;
import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.model.Questionnaire.*;
import edu.sjsu.cs.etrt.model.Patient.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class FormView extends UIPanel{
	//controller instance
	private FormController fCtrl;		//form cntrl
	private PatientController pCtrl;	//patient ctrl?
	private SystemController systemCtrl;	//systemCtrl
	boolean displayForm;		//display form based on boolean
	
	//instance of Form - default THI display
	public FormView(FormController fCtrl, SystemController system)
	{
		this.fCtrl=fCtrl;
		systemCtrl=system;
		this.displayForm = false;		//false default
	}
	
	//instance of Form - set parameter boolean b - change to TFI: set true
	public FormView(FormController fCtrl, SystemController system, boolean b)
	{
		this.fCtrl=fCtrl;
		systemCtrl=system;
		this.displayForm = b;
	}
	
	
	@Override
	public void refresh() {
		//frame
		JFrame frame = new JFrame("Questionnaire Form");	
		
		//scroll pane
		JScrollPane scrollPane=new JScrollPane();
				
		//panels
		JPanel panelCont = new JPanel();		//container panel		
		JPanel THIpanel = new JPanel();			//panel store THI questions
		JPanel TFIpanel = new JPanel();			//panel store TFI questions
				
		JPanel panelHead = new JPanel();		//container panel for header
		JPanel THIheader = new JPanel();		//header panel
		JPanel TFIheader = new JPanel();
		
		JPanel footCont = new JPanel();			//foot container: submit, reset, next questionnaire
		JPanel THIfoot = new JPanel(new GridLayout());			
		JPanel TFIfoot = new JPanel(new GridLayout());
				
		//JLabel titles
		JLabel title1 = new JLabel("Tinnitus Handicap Inventory");
		JLabel title2 = new JLabel("Tinnitus Functional Index");
					
		//buttons 
		JButton THItoTFI = new JButton("Move to TFI Questionnaire");	//switch from THI > TFI
		JButton TFItoTHI = new JButton("Move to THI Questionnaire");	//switch from TFI > THI
		JButton THIsubmit = new JButton("Submit");		//submit result
		JButton TFIsubmit = new JButton("Submit");		
		JButton THIreset = new JButton("Reset");		//reset questionnaire
		JButton TFIreset = new JButton("Reset");
				
		//JLabels for questions
		JLabel[] THIquestions = new JLabel[] { 
		new JLabel("1. Because of your tinnitus, " + 
				"is it difficult for you to concentrate?"),
		new JLabel("2. Does the loudness of your tinnitus make it difficult " + 
				"for you to hear people?"),
		new JLabel("3. Does your tinnitus make you angry?"),
		new JLabel("4. Does your tinnitus make you feel confused?"),
		new JLabel("5. Because of your tinnitus, do you feel desperate?"),
		new JLabel("6.Do you complain a great deal about your tinnitus?"),
		new JLabel("7. Because of your tinnitus, do you have trouble falling to sleep at night?"),
		new JLabel("8. Do you feel as though you cannot escape your tinnitus?"),
		new JLabel("9. Does your tinnitus interefere with your ability to enjoy social activities?"),
		new JLabel("10. Because of your tinnitus, do you feel frustrated?"),
		new JLabel("11. Because of your tinnitus, do you feel that you have a terrible disease?"),
		new JLabel("12. Does your tinnitus make it difficult for you to enjoy life?"),
		new JLabel("13. Does your tinnitus interfere with your job or household responsibilities?"),
		new JLabel("14. Because of your tinnitus, do you find that you are often irritable?"),
		new JLabel("15. Because of your tinnitus, is it difficult for you to read?"),
		new JLabel("16. Does your tinnitus make you upset?"),
		new JLabel("17. Do you feel that your tinnitus problem has placed more stress on your " 
				+ "relationships with members of your family and friends?"),
		new JLabel("18. Do you find it difficult to focus your attention away from your "
				+ "tinnitus and on other things?"),
		new JLabel("19. Do you feel that you have no control over your tinnitus?"),
		new JLabel("20. Because of your tinnitus, do you often feel tired?"),
		new JLabel("21. Because of your tinnitus, do you feel depressed?"),
		new JLabel("22. Does your tinnitus make you feel anxious?"),
		new JLabel("23. Do you feel that you can no longer cope with tinnitus?"),
		new JLabel("24. Does your tinnitus get worse when you are under stress?"),
		new JLabel("25. Does your tinnitus make you feel insecure?")};
		
		JLabel[] TFIquestions = new JLabel[] {
		new JLabel("1. What percentage of your time were you consciously AWARE OF your tinnitus?"),
		new JLabel("2. How STRONG or LOUD was your tinnitus?"),
		new JLabel("3. What percentage of your time awake were you ANNOYED by your tinnitus?"),
		new JLabel("4. Did you feel IN CONTROL in regards to your tinnitus?"),
		new JLabel("5. How easy was it for you to COPE with your tinnitus?"),
		new JLabel("6. How easy was it for you to IGNORE your tinnitus?"),
		new JLabel("7. Your ability to CONCENTRATE?"),
		new JLabel("8. Your ability to THINK CLEARLY?"),
		new JLabel("9. Your ability to FOCUS ATTENTION on other things besides your tinnitus?"),
		new JLabel("10. How often did your tinnitus make it difficult to FALL ASLEEP or STAY ASLEEP?"),
		new JLabel("11. How often did your tinnitus cause you difficulty in getting AS MUCH SLEEP"
				+ "as you needed?"),
		new JLabel("12. How much of the time did your tinnitus keep you from SLEEPING as DEEPLY"
				+ "or as PEACEFULLY as you would have liked?"),
		new JLabel("13. Your ability to HEAR CLEARLY?"),
		new JLabel("14. Your ability to UUNDERSTAND PEOPLE who are talking?"),
		new JLabel("15. Your ability to FOLLOW CONVERSATIONS in a group or at meetings?"),
		new JLabel("16. Your QUIET RESTING ACTIVITIES?"),
		new JLabel("17. Your ability to RELAX?"),
		new JLabel("18. Your ability to enjoy 'PEACE AND QUIET'?"),
		new JLabel("19. Your enjoyment of SOCIAL ACTIVITIES?"),
		new JLabel("20. Your ENJOYMENT OF LIFE?"),
		new JLabel("21. Your RELATIONSHIPS with family, friends, and other people?"),
		new JLabel("22. How often did you tinnitus cause you to have difficulty performing your"
				+ "WORK OR OTHER TASKS?"),
		new JLabel("23. How ANXIOUS or WORRIED has your tinnitus made you feel?"),
		new JLabel("24. How BOTHERED or UPSET have you been because of your tinnitus?"),
		new JLabel("25. How DEPRESSED were you because of your tinnitus?")};
		
		//3 buttons: 25 questions
		JRadioButton[][] THIanswers = new JRadioButton[25][3];	
		String[] THIlabel = new String[] { "No(0)", "Sometimes(2)", "Yes(4)" };
		//12 buttons: 25 questions
		JRadioButton[][] TFIanswers = new JRadioButton[25][11];		
		//25 groups of 3 or 10
		ButtonGroup[] THIanswerGroup = new ButtonGroup[25];		
		ButtonGroup[] TFIanswerGroup = new ButtonGroup[25];
	
		//card layout manager initialization
		CardLayout c = new CardLayout();
		CardLayout c1 = new CardLayout();		//for header
		CardLayout c2 = new CardLayout();		//for foot
		//set layouts	
		panelCont.setLayout(c);
		panelHead.setLayout(c1);
		footCont.setLayout(c2);
			
		//controller = ctrl;
		THIpanel.setLayout(new GridBagLayout());		//grid bag layout
		TFIpanel.setLayout(new GridBagLayout());		//grid bag layout #2
		GridBagConstraints gbc = new GridBagConstraints();		//constraints
				
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
			
		//intermediary random******************************
		//line
		gbc.gridx = 0;
		gbc.gridy = 0;
	
		JButton THIrandom = new JButton("Lazy Press");
		JButton TFIrandom = new JButton("Lazy Press");
		THIpanel.add(THIrandom, gbc);
		TFIpanel.add(TFIrandom, gbc);
		
		gbc.insets = new Insets(5, 5, 5 ,5);	//top, left, right, bot dimensions
		//parse through questions - same for both THI and TFI
		for(int i=0;i<25;i++) {
			//grid coordinates
			gbc.gridx = 0;
			gbc.gridy = i+1;
			THIpanel.add(THIquestions[i], gbc);
			TFIpanel.add(TFIquestions[i], gbc);
			//make a new group
			THIanswerGroup[i] = new ButtonGroup();
			TFIanswerGroup[i] = new ButtonGroup();

			//THI - 3 answers
			for(int j=0;j<3;j++) {
				//grid coordinates
				gbc.gridx = j+1;
				gbc.gridy = i+1;	
				THIanswers[i][j] = new JRadioButton(THIlabel[j]);
				THIpanel.add(THIanswers[i][j], gbc);		//add to panel
				THIanswers[i][j].setSelected(false);	//set to initially false
				THIanswerGroup[i].add(THIanswers[i][j]); //add 3 to group
			}	
					
					
			//TFI - 10 answers
			for(int k=0;k<11;k++) {
				gbc.gridx = k+1;
				gbc.gridy = i+1;
				if(i == 0 || i == 2)		//percentages for q1 and q3 
					TFIanswers[i][k] = new JRadioButton("" + (k*10) + "%");
				else
					TFIanswers[i][k] = new JRadioButton("" + k);
				
				TFIanswers[i][k].setSelected(false);
						
				TFIpanel.add(TFIanswers[i][k], gbc);
				TFIanswerGroup[i].add(TFIanswers[i][k]); //add 10 to group		
			}
		}	//end for loop
				
		//add buttons to end of page respectively
		THIfoot.add(THIsubmit);
		THIfoot.add(THIreset);
		TFIfoot.add(TFIsubmit);
		TFIfoot.add(TFIreset);
		
		//message prompt
		String empty = "";
		//create and align text/edit text properties
		JTextField THImessage = new JTextField(empty);
		THImessage.setFont(new Font("Arial", Font.BOLD, 20));
		THImessage.setBackground(Color.WHITE);
		THImessage.setHorizontalAlignment(JTextField.CENTER);
		JTextField TFImessage = new JTextField(empty);
		TFImessage.setFont(new Font("Arial", Font.BOLD, 20));
		TFImessage.setBackground(Color.WHITE);
		TFImessage.setHorizontalAlignment(JTextField.CENTER);
		THImessage.setEditable(false);
		TFImessage.setEditable(false);
		//add message to foots
		THIfoot.add(THImessage);
		TFIfoot.add(TFImessage);
				
		//add two instances of questionnaires to panel container
		panelCont.add(THIpanel, "1");
		panelCont.add(TFIpanel, "2");
		panelHead.add(THIheader, "1");
		panelHead.add(TFIheader, "2");
		footCont.add(THIfoot, "1");
		footCont.add(TFIfoot, "2");
				
		//show THI first
		if(displayForm == false) {
			c.show(panelCont, "1");
			c1.show(panelHead, "1");
			c2.show(footCont, "1");
		}
		else {
			c.show(panelCont, "2");
			c1.show(panelHead, "2");
			c2.show(footCont, "2");
		}
			
		
		//***************************ACTION LISTENERS*********************************
		//questionnaire switch when button pressed
		THItoTFI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c.show(panelCont, "2");
				c1.show(panelHead, "2");
				c2.show(footCont, "2");
			}
		});	
		//reverse questionnaire switch when button pressed
		TFItoTHI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c.show(panelCont, "1");
				c1.show(panelHead, "1");
				c2.show(footCont, "1");
			}
		});
		
		
		//************************************submit button for questionnaire
		THIsubmit.addActionListener(new ActionListener() {
			int count = 0;	//local count
			int score = 0;	//local score
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int p=0;p<25;p++) {
					for(int f=0;f<3;f++) {
						if(THIanswers[p][f].isSelected()) {
							count++;	//increment count
							score += f * 2;		//multiply
						}
					}
				}
				//if all questions have been answered
				if(count == 25) {
					fCtrl.setScoreTHI(score);
					TFImessage.setText("Submitted successfully! Total: " + fCtrl.getScoreTHI());
					//reset count and score
					count = score = 0;
				}
				else {
					THImessage.setText("Missing answer(s).");
					count = score = 0;
				}
			}
		});
		//submission for questionnaire - replication of THIsubmit
		TFIsubmit.addActionListener(new ActionListener() {
			int count = 0;
			int score = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int p=0;p<25;p++) {
					for(int f=0;f<11;f++) {
						if(TFIanswers[p][f].isSelected()) {
							count++;	//increment count
							score += f;		//additive
						}
					}
				}
				
				//if at least 19 questions have been answered
				if(count >= 19) {
					fCtrl.setScoreTFI(score);
					TFImessage.setText("Submitted successfully! Total: " + fCtrl.getScoreTFI());
					//reset count and score
					count = score = 0;
				}
				else {
					TFImessage.setText("Answer at least 19 questions.");
					count = score = 0;
				}
			}
		});
		
		//*********************************remove everything THI
		THIreset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(int p=0;p<25;p++) {
					THIanswerGroup[p].clearSelection();
				}
				THImessage.setText(empty);
			}
		});
		//*********************************TFI
		TFIreset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(int p=0;p<25;p++) {
					TFIanswerGroup[p].clearSelection();
				}
				TFImessage.setText(empty);
			}
		});
		
		//*********************************random generation
		THIrandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();
				for(int p=0;p<25;p++) {
					int r = rand.nextInt(3);
					THIanswers[p][r].setSelected(true);
				}
			}
		});
		
		TFIrandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();
				for(int p=0;p<25;p++) {
					int r = rand.nextInt(11);
					TFIanswers[p][r].setSelected(true);
				}
			}
		});
		
		
		//Given panelCont a scroll bar
		scrollPane.add(panelCont);
		scrollPane.setViewportView(panelCont);
		scrollPane.getVerticalScrollBar().setUnitIncrement(5);
		//set border layout
		frame.setLayout(new BorderLayout());
		//add panels to frame
		frame.add(panelHead, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(footCont, BorderLayout.SOUTH);
		
						
		frame.pack();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
