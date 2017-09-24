package eu.lucid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import eu.lucid.dto.PatientDTO;
import eu.lucid.services.PatientService;

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = { "/patients/{id}" }, method = RequestMethod.GET)
	public ModelAndView getPatient(@PathVariable Long id) {
		return null;
	}

	@RequestMapping(value = { "/patients/{id}" }, method = RequestMethod.POST)
	public ModelAndView addPatient(@PathVariable Long id, @ModelAttribute PatientDTO patientDTO) {
		return null;
	}

	@RequestMapping(value = { "/patients/{id}" }, method = RequestMethod.DELETE)
	public ModelAndView deletePatient(@PathVariable Long id) {
		return null;
	}

	@RequestMapping(value = { "/patients/{id}" }, method = RequestMethod.PUT)
	public ModelAndView updatePatient(@PathVariable Long id, @ModelAttribute PatientDTO patientDTO) {
		return null;
	}
}
