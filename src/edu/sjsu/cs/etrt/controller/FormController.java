package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.model.Patient.*;
import edu.sjsu.cs.etrt.model.Questionnaire.*;
import edu.sjsu.cs.etrt.view.UI.FormView;

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
	public void createForm(){
		view.refresh();
	}
	
	//model conversion of methods
	public Patient getPatient() {
		return model.getPatient();
	}
	
	public void makeForm(boolean thi) {
		model.makeForm(thi);
	}
	
	public void makeAnswers(boolean thi) {
		model.makeAnswers(thi);
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
	
	public void setQuestionList() {
		model.setQuestionList();
	}
	
	public void setAnswerList(int size) {
		model.setAnswerList(size);
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
		model.setTreatment();
	}
	
	public void setCategory(int score) {		
		model.setCategory(score);
	}
	
	public Form getModel() {
		return model;
	}
	
	public JPanel getViewPanel() {
		return view.generateUI();
	}

}
