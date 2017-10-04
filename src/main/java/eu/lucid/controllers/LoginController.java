package eu.lucid.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.lucid.rest.UserDTO;
import eu.lucid.rest.response.GeneralResponseDTO;
import eu.lucid.services.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private HttpSession httpSession;

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public GeneralResponseDTO<?> login(UserDTO user) {
		return null;
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public GeneralResponseDTO<?> logout() {
		return null;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public GeneralResponseDTO<?> register(@Valid UserDTO user, BindingResult bindingResult) {
		return null;
	}

	@RequestMapping(value = { "/profile" }, method = RequestMethod.POST)
	public GeneralResponseDTO<?> getProfile() {
		return null;
	}

}
