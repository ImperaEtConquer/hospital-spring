package eu.lucid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.lucid.config.Message;
import eu.lucid.rest.ProfileDTO;
import eu.lucid.rest.response.GeneralResponseDTO;
import eu.lucid.rest.response.Status;
import eu.lucid.services.SessionService;
import eu.lucid.services.StaffService;

@RestController
public class StaffController {

	private final SessionService sessionService;

	private final StaffService staffService;

	private final Message message;

	@Autowired
	public StaffController(SessionService sessionService, StaffService staffService, Message message) {
		this.sessionService = sessionService;
		this.staffService = staffService;
		this.message = message;
	}

	@RequestMapping(value = { "/staff" }, method = RequestMethod.GET)
	public GeneralResponseDTO<?> getAllStaff() {
		if (sessionService.isUserLoggedIn()) {
			return new GeneralResponseDTO<>().buildWithData(staffService.findAll());
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.notLogged);
	}

	@RequestMapping(value = { "/staff/{id}" }, method = RequestMethod.GET)
	public GeneralResponseDTO<?> getStaffById(@PathVariable Long id) {
		if (sessionService.isUserLoggedIn()) {
			ProfileDTO profile = staffService.findOne(id);
			if (profile != null) {
				return new GeneralResponseDTO<>().buildWithData(profile);
			} else {
				return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, "not found");
			}
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, message.notLogged);
	}
}
