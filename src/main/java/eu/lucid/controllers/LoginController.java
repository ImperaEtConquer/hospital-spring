package eu.lucid.controllers;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.lucid.config.Message;
import eu.lucid.rest.UserDTO;
import eu.lucid.rest.response.GeneralResponseDTO;
import eu.lucid.rest.response.Status;
import eu.lucid.services.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private Message message;

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public GeneralResponseDTO<?> login(UserDTO userDTO) {
		if(httpSession.getAttribute("user") != null) {
			
		}
		try {
			loginService.login(userDTO);
		} catch (LoginException e) {
			new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, e.getMessage());
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, message.loginSuccess);
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public GeneralResponseDTO<?> logout() {
		if (httpSession.getAttribute("user") != null) {
			new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, "something wrong");
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, "something wrong");
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
