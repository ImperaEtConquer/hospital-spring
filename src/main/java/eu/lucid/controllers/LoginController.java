package eu.lucid.controllers;

import java.util.stream.Collectors;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.lucid.config.Message;
import eu.lucid.rest.request.LoginDTO;
import eu.lucid.rest.response.GeneralResponseDTO;
import eu.lucid.rest.response.StaffDTO;
import eu.lucid.rest.response.Status;
import eu.lucid.services.LoginService;
import eu.lucid.utils.BindingUtils;
import eu.lucid.utils.SessionUtils;
import groovy.lang.Binding;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private SessionUtils sessionUtils;

	@Autowired
	private Message message;

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public GeneralResponseDTO<?> login(@Valid LoginDTO userDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return BindingUtils.getErrorResponse(bindingResult);
		}
		if (sessionUtils.isUserLoggedIn()) {
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.loginAlready);
		}
		try {
			loginService.login(userDTO);
			sessionUtils.getSession().setAttribute("user", userDTO);
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, message.loginSuccess);
		} catch (LoginException e) {
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, e.getMessage());
		}
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public GeneralResponseDTO<?> logout() {
		if (!sessionUtils.isUserLoggedIn()) {
			new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.loginFail);
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, message.loginSuccess);
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public GeneralResponseDTO<?> register(@Valid StaffDTO staffDTO) {
		loginService.register(staffDTO);
		return null;
	}

	@RequestMapping(value = { "/profile" }, method = RequestMethod.POST)
	public GeneralResponseDTO<?> getProfile() {
		return null;
	}

}
