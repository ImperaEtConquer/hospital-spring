package eu.lucid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.lucid.rest.PatientDTO;
import eu.lucid.services.PatientService;

public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = { "/patients" }, method = RequestMethod.POST)
	public String addPatient(PatientDTO patientDTO) {
		patientService.registerPatient(patientDTO);
		return "redirect:/";
	}
}
