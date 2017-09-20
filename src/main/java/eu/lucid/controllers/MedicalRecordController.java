package eu.lucid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import eu.lucid.domain.MedicalRecord;
import eu.lucid.services.MedicalRecordService;

@Controller
public class MedicalRecordController {

	@Autowired
	private MedicalRecordService medicalRecordService;

	@RequestMapping(value = { "/record/{id}" }, method = RequestMethod.GET)
	public ModelAndView getMedicalRecord(@PathVariable Long id) {
		return null;
	}

	@RequestMapping(value = { "/record/{id}" }, method = RequestMethod.POST)
	public ModelAndView addMedicalRecord(@PathVariable Long id, @ModelAttribute MedicalRecord medicalRecord) {
		return null;
	}

	@RequestMapping(value = { "/record/{id}" }, method = RequestMethod.DELETE)
	public ModelAndView deleteMedicalRecord(@PathVariable Long id) {
		return null;
	}

	@RequestMapping(value = { "/record/{id}" }, method = RequestMethod.PUT)
	public ModelAndView updateMedicalRecord(@PathVariable Long id, @ModelAttribute MedicalRecord medicalRecord) {
		return null;
	}
}
