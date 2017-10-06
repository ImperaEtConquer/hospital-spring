package eu.lucid.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.lucid.config.Message;
import eu.lucid.rest.StaffDTO;
import eu.lucid.rest.response.GeneralResponseDTO;
import eu.lucid.rest.response.Status;
import eu.lucid.services.LoginService;
import eu.lucid.services.StaffService;
import eu.lucid.services.BindingService;
import eu.lucid.services.SessionService;

@RestController
public class ProfileController {

	private final LoginService loginService;

	private final StaffService staffService;

	private final SessionService sessionService;

	private final BindingService bindingService;

	private final Message message;

	@Autowired
	public ProfileController(LoginService loginService, StaffService staffService, SessionService sessionService, BindingService bindingService, Message message) {
		this.loginService = loginService;
		this.staffService = staffService;
		this.sessionService = sessionService;
		this.bindingService = bindingService;
		this.message = message;
	}

	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public GeneralResponseDTO<?> getProfile() {
		if (sessionService.isUserLoggedIn()) {
			return new GeneralResponseDTO<>().buildWithData(sessionService.getUser());
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.notLogged);
	}

	@RequestMapping(value = { "/profile" }, method = RequestMethod.PUT)
	public GeneralResponseDTO<?> updateProfile(@Valid StaffDTO staffDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return bindingService.getErrorResponse(bindingResult);
		}
		if (sessionService.isUserLoggedIn()) {
			staffService.updateProfile(staffDTO);
			sessionService.addOrUpdateUser(staffDTO.getLoginDTO(), loginService);
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, message.userUpdateSuccess);
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.notLogged);
	}

	@RequestMapping(value = { "/profile" }, method = RequestMethod.DELETE)
	public GeneralResponseDTO<?> deleteProfile() {
		if (sessionService.isUserLoggedIn()) {
			staffService.deleteProfile(sessionService.getUser());
			sessionService.destroy();
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, message.userDeleteSuccess);
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.notLogged);
	}
}
