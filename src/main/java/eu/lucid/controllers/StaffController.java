package eu.lucid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import eu.lucid.dto.PatientDTO;
import eu.lucid.dto.UserDTO;
import eu.lucid.services.PatientService;
import eu.lucid.services.StaffService;

@Controller
public class StaffController {
	
	@Autowired
	private StaffService staffService;

	@RequestMapping(value = { "/staff/{id}" }, method = RequestMethod.GET)
	public ModelAndView getStaff(@PathVariable Long id) {
		return null;
	}

	@RequestMapping(value = { "/staff/{id}" }, method = RequestMethod.POST)
	public ModelAndView addStaff(@PathVariable Long id, @ModelAttribute UserDTO userDTO) {
		return null;
	}

	@RequestMapping(value = { "/staff/{id}" }, method = RequestMethod.DELETE)
	public ModelAndView deleteStaff(@PathVariable Long id) {
		return null;
	}

	@RequestMapping(value = { "/staff/{id}" }, method = RequestMethod.PUT)
	public ModelAndView updateStaff(@PathVariable Long id, @ModelAttribute UserDTO userDTO) {
		return null;
	}
}
