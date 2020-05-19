package edu.sjsu.cs.etrt.controller;

import javax.swing.JPanel;

import edu.sjsu.cs.etrt.view.UI.RegistryView;

public class RegistryController {
	private RegistryView view;
	private SystemController system;
	
	public RegistryController(PatientListController list,SystemController ctrl) {
		system=ctrl;
		view=new RegistryView(list,system);
	}
	
	public JPanel getViewPanel() {
		return view.generateUI();
	}
}
