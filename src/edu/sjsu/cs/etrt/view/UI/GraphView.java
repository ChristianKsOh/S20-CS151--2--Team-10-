package edu.sjsu.cs.etrt.view.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs.etrt.controller.PatientController;
import edu.sjsu.cs.etrt.controller.SystemController;

public class GraphView{
	private PatientController patient;
	private SystemController system;
	private final int LENGTH=600;
	private final int HEIGHT=600;
	
	/**
	 * Pops-up a window displaying linear graphs of the patient's 
	 * THI and TFI progress.
	 * @param patient PatientController of the patient.
	 * @param system SystemController for changes outside of this class.
	 */
	public GraphView(PatientController patient,SystemController system) {
		this.patient=patient;
		this.system=system;
	}

	/**
	 * Creates a new window alongs with the view.
	 */
	public void open() {
		JFrame frame=new JFrame("Patient Graph");
		
		JPanel content=new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		content.setPreferredSize(new Dimension(LENGTH,HEIGHT));
		content.setMaximumSize(new Dimension(LENGTH,HEIGHT));
		
		JPanel THIGraph=new JPanel() {
			public void paintComponent(Graphics g) {
				Graphics2D g2d=(Graphics2D)g;
				
				//Header
				g2d.drawString("THI Results", 275, 15);
				
				//Build Graph Base
				g2d.setColor(Color.black);
				g2d.drawLine(100, 25, 100, 275);	//y-length: 250
				g2d.drawLine(100, 275, 500, 275);	//x-length: 400
				
				//Graph lines
				g2d.setColor(Color.lightGray);
				for(int i=25;i<275;i+=25) {
					g2d.drawLine(100,i,500,i);
				}
				for(int i=125;i<500;i+=25) {
					g2d.drawLine(i,25,i,275);
				}
				
				//Graph numbers
				for(int i=0;i<=10;i++) {	//Vertical lines
					g2d.drawString(10*i+"", 100, 25*(10-i)+25);
				}
				for(int i=0;i<=16;i++) {	//Horizontal lines
					g2d.drawString(i+"", 25*i+100, 275);
				}
				
				//Axis Header
				g2d.setColor(Color.black);
				g2d.drawString("Score", 50, 150);
				g2d.drawString("Visit Number", 285, 290);
				
				
				//Plot and connecting lines
				g2d.setColor(Color.black);
				int prevX=0;
				int prevY=0;
				for(int i=0;i<patient.getTHIHistory().size();i++) {
					int x=25*(i+1)+100;
					int y=(int)(2.5*(100-patient.getTHIHistory().get(i)))+25;	//2.5=250/100
					g2d.fillOval(x-2, y-2, 5, 5);
					if(i!=0) {
						g2d.drawLine(prevX, prevY, x, y);
					}
					prevX=x;
					prevY=y;
				}
				
			}
		};
		
		JPanel TFIGraph=new JPanel() {
			public void paintComponent(Graphics g) {
				Graphics2D g2d=(Graphics2D)g;
				
				//Header
				g2d.drawString("THI Results", 275, 15);
				
				//Build Graph Base
				g2d.setColor(Color.black);
				g2d.drawLine(100, 25, 100, 275);	//y-length: 250
				g2d.drawLine(100, 275, 500, 275);	//x-length: 400
				
				//Graph lines
				g2d.setColor(Color.lightGray);
				for(int i=25;i<275;i+=25) {
					g2d.drawLine(100,i,500,i);
				}
				for(int i=125;i<500;i+=25) {
					g2d.drawLine(i,25,i,275);
				}
				
				//Graph numbers
				for(int i=0;i<=10;i++) {	//Vertical lines
					g2d.drawString(10*i+"", 100, 25*(10-i)+25);
				}
				for(int i=0;i<=16;i++) {	//Horizontal lines
					g2d.drawString(i+"", 25*i+100, 275);
				}
				
				//Axis Header
				g2d.setColor(Color.black);
				g2d.drawString("Score", 50, 150);
				g2d.drawString("Visit Number", 285, 290);
				
				
				//Plot and connecting lines
				g2d.setColor(Color.black);
				int prevX=0;
				int prevY=0;
				for(int i=0;i<patient.getTFIHistory().size();i++) {
					int x=25*(i+1)+100;
					int y=(int)((250-patient.getTFIHistory().get(i)))+25;	//1=250/250
					g2d.fillOval(x-2, y-2, 5, 5);
					if(i!=0) {
						g2d.drawLine(prevX, prevY, x, y);
					}
					prevX=x;
					prevY=y;
				}
				
			}
		};
		
		THIGraph.setPreferredSize(new Dimension(LENGTH,HEIGHT/2));
		THIGraph.setMaximumSize(new Dimension(LENGTH,HEIGHT/2));
		TFIGraph.setPreferredSize(new Dimension(LENGTH,HEIGHT/2));
		TFIGraph.setMaximumSize(new Dimension(LENGTH,HEIGHT/2));
		
		content.add(THIGraph);
		content.add(TFIGraph);
		frame.add(content);
		frame.pack();
		frame.setVisible(true);
		
	}
}
