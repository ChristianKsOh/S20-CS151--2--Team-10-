package UI;

import javax.swing.JPanel;

public interface UIPanel {
	/**
	 * Generate a JPanel UI for SystemUI to display.
	 * @return JPanel object for the UI.
	 */
	public JPanel generateUI();
}
