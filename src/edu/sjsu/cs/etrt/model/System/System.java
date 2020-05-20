package edu.sjsu.cs.etrt.model.System;

import edu.sjsu.cs.etrt.controller.PatientListController;
import edu.sjsu.cs.etrt.controller.RegistryController;
import edu.sjsu.cs.etrt.controller.SystemController;
import edu.sjsu.cs.etrt.controller.VisitQueueController;

public class System {
	private VisitQueueController visits;
	private PatientListController patients;
	private RegistryController registry;
	
	/**
	 * Main system that holds and uses all controllers.
	 * @param system SystemController hold this model to initializes other controllers.
	 */
	public System(SystemController system) {
		visits=new VisitQueueController(system);
		patients=new PatientListController(system);
		registry=new RegistryController(patients,visits,system);
	}
	
	/**
	 * Return RegistryController for editing.
	 * @return RegistryController object.
	 */
	public RegistryController getRegistry() {
		return registry;
	}
	
	/**
	 * Return VisitQueueController for editing.
	 * @return VisitQueueController object.
	 */
	public VisitQueueController getVisitQueue() {
		return visits;
	}
	
	
	/**
	 * Returns PatientQueueController for editing.
	 * @return PatientQueueController object.
	 */
	public PatientListController getPatientList() {
		return patients;
	}
}
