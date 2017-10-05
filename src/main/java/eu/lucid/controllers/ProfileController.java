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
import eu.lucid.utils.BindingUtils;
import eu.lucid.utils.SessionUtils;

@RestController
public class ProfileController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private StaffService staffService;

	@Autowired
	private SessionUtils sessionUtils;

	@Autowired
	private Message message;

	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public GeneralResponseDTO<?> getProfile() {
		if (sessionUtils.isUserLoggedIn()) {
			return new GeneralResponseDTO<>().buildWithData(sessionUtils.getUser());
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.notLogged);
	}

	@RequestMapping(value = { "/profile" }, method = RequestMethod.PUT)
	public GeneralResponseDTO<?> updateProfile(@Valid StaffDTO staffDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return BindingUtils.getErrorResponse(bindingResult);
		}
		if (sessionUtils.isUserLoggedIn()) {
			staffService.updateProfile(staffDTO);
			sessionUtils.addOrUpdateUser(staffDTO.getLoginDTO(), loginService);
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, message.userUpdateSuccess);
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.notLogged);
	}

	@RequestMapping(value = { "/profile" }, method = RequestMethod.DELETE)
	public GeneralResponseDTO<?> deleteProfile() {
		if (sessionUtils.isUserLoggedIn()) {
			staffService.deleteProfile(sessionUtils.getUser());
			sessionUtils.destroy();
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, message.userDeleteSuccess);
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.notLogged);
	}
}
