package eu.lucid.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eu.lucid.rest.PatientDTO;
import eu.lucid.rest.UserDTO;
import eu.lucid.services.LoginService;
import eu.lucid.services.PatientService;

@Controller
public class MainController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private HttpSession httpSession;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String getHome(ModelMap model) {
		if (httpSession.getAttribute("user") == null) {
			return "redirect:/login";
		}
		model.addAttribute("patient", new PatientDTO());
		model.addAttribute("patients", patientService.findAll());
		return "index";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("user", new UserDTO());
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(UserDTO user, ModelMap model) {
		if (loginService.isLoginSuccessful(user)) {
			httpSession.setAttribute("user", loginService.getUser(user));
			return "redirect:/";
		} else {
			model.addAttribute("user", new UserDTO());
			return "login";
		}
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String getRegisterPage(ModelMap model) {
		model.addAttribute("user", new UserDTO());
		return "registration";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String register(@Valid UserDTO user, BindingResult bindingResult, ModelMap model) {
		if (loginService.registerUser(user)) {
			httpSession.setAttribute("user", loginService.getUser(user));
			return "redirect:/";
		} else {
			model.addAttribute("user", new UserDTO());
			return "registration";
		}
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public String getRegisterPage(@RequestParam String searchdata, ModelMap model) {
		System.out.println(searchdata);
		return "redirect:/";
	}

}
