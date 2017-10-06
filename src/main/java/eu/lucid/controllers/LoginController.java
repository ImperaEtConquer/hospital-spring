package eu.lucid.controllers;

import javax.security.auth.login.LoginException;
import javax.security.auth.message.AuthException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.lucid.config.Message;
import eu.lucid.rest.StaffDTO;
import eu.lucid.rest.request.LoginDTO;
import eu.lucid.rest.response.GeneralResponseDTO;
import eu.lucid.rest.response.Status;
import eu.lucid.services.BindingService;
import eu.lucid.services.LoginService;
import eu.lucid.services.SessionService;

@RestController
public class LoginController {

	private final LoginService loginService;

	private final SessionService sessionService;

	private final BindingService bindingService;

	private final Message message;

	@Autowired
	public LoginController(LoginService loginService, SessionService sessionService, BindingService bindingService, Message message) {
		this.loginService = loginService;
		this.sessionService = sessionService;
		this.bindingService = bindingService;
		this.message = message;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public GeneralResponseDTO<?> login(@Valid LoginDTO loginDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return bindingService.getErrorResponse(bindingResult);
		}
		if (sessionService.isUserLoggedIn()) {
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.loginAlready);
		}
		try {
			loginService.login(loginDTO);
			sessionService.addOrUpdateUser(loginDTO, loginService);
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, message.loginSuccess);
		} catch (LoginException e) {
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, e.getMessage());
		}
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public GeneralResponseDTO<?> logout() {
		if (!sessionService.isUserLoggedIn()) {
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.logoutFail);
		}
		sessionService.destroy();
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, message.logoutSuccess);
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public GeneralResponseDTO<?> register(@Valid StaffDTO staffDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return bindingService.getErrorResponse(bindingResult);
		}
		try {
			loginService.register(staffDTO);
		} catch (AuthException e) {
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, e.getMessage());
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, message.registerSuccess);
	}
}
