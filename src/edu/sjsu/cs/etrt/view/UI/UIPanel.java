package edu.sjsu.cs.etrt.view.UI;

import javax.swing.JPanel;

public abstract class UIPanel{
	protected JPanel main;
	
	/**
	 * A basis for the view classes.
	 */
	public UIPanel() {
		main=new JPanel();
	}
	
	/**
	 * Generate a JPanel UI for SystemUI to display.
	 * @return JPanel for the UI.
	 */
	public JPanel generateUI() {
		refresh();
		return main;
	}
	
	/**
	 * Refreshes the panel.
	 */
	public abstract void refresh();
}
