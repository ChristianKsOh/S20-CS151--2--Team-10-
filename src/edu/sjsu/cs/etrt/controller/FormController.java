package edu.sjsu.cs.etrt.controller;

import edu.sjsu.cs.etrt.model.Patient.*;
import edu.sjsu.cs.etrt.model.Questionnaire.*;
import edu.sjsu.cs.etrt.model.Visits.Visit;
import edu.sjsu.cs.etrt.view.UI.FormView;
import edu.sjsu.cs.etrt.view.UI.PatientView;
import edu.sjsu.cs.etrt.view.UI.VisitView;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormController {
	//instances of model, view, and system
	private Form model;
	private FormView view;
	private SystemController system;
	
	//set controller handler
	public FormController(Form form, FormView view, SystemController system)
	{
		model = form;
		this.view=view;
		this.system=system;
	}
	
	//controller call view create form
	public void createForm()
	{
		view.refresh();
	}
	
	
	//model conversion of methods
	public Patient getPatient() {
		return model.getPatient();
	}
	
	public void setQuestion(int q, String s) {
		model.setQuestion(q, s);
	}
	
	public String getQuestion(int q) {
		return model.getQuestion(q);
	}
	
	public int getQuestionSize() {
		return model.getQuestionSize();
	}
	
	public void setAnswer(int q, String s) {
		model.setAnswer(q, s);
	}
	
	public String getAnswer(int q) {
		return model.getAnswer(q);
	}
	
	
	public int getAnswerSize() {
		return model.getAnswerSize();
	}
	
	public void setScore(int score) {
		model.setScore(score);
	}
	
	public int getScore() {
		return model.getScore();
	}	

	public void setTreatment() {
		switch(model.getPatient().getCategoryNum()) {
		case category0:
		case category1:
		case category2:
		case category3:
		case category4:
		}
				
	}
	
	/**
	 * set category based on score
	 */
	public void setCategory(int score) {		
		//total possible = 350 / 5 = 70
		if(score <= 70) {
			model.getPatient().setCategoryNum(Category.category0); 
		}
		else if (score <= 140) {
			model.getPatient().setCategoryNum(Category.category1);
		}
		else if(score <= 210) {
			model.getPatient().setCategoryNum(Category.category2);
		}
		else if(score <= 280)
		{
			model.getPatient().setCategoryNum(Category.category3);
		}
		else {
			model.getPatient().setCategoryNum(Category.category4);
		}
	}
	
	
	public Form getModel() {
		return model;
	}

}
