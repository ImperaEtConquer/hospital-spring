package eu.lucid.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.lucid.rest.PatientDTO;
import eu.lucid.rest.response.GeneralResponseDTO;
import eu.lucid.rest.response.Status;
import eu.lucid.services.PatientService;
import eu.lucid.services.SessionService;

@RestController
public class PatientController {

	private final SessionService sessionService;

	private final PatientService patientService;

	@Autowired
	public PatientController(SessionService sessionService, PatientService patientService) {
		this.sessionService = sessionService;
		this.patientService = patientService;
	}

	@RequestMapping(value = { "/patients" }, method = RequestMethod.GET)
	public GeneralResponseDTO<?> getAllPatients() {
		if (sessionService.isUserLoggedIn()) {
			return new GeneralResponseDTO<>().buildWithData(patientService.findAll());
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, "not logged");
	}

	@RequestMapping(value = { "/patients" }, method = RequestMethod.POST)
	public GeneralResponseDTO<?> registerNewPatient(@Valid @RequestBody PatientDTO patientDTO,
			BindingResult bindingResult) {
		if (sessionService.isUserLoggedIn()) {
			if (bindingResult.hasErrors()) {
				return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, "incorrect input");
			}
			patientService.registerPatient(patientDTO);
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, "new patient registered");
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, "not logged");
	}

	@RequestMapping(value = { "/patients" }, method = RequestMethod.PUT)
	public GeneralResponseDTO<?> updatePatient(@Valid @RequestBody PatientDTO patientDTO, BindingResult bindingResult) {
		if (sessionService.isUserLoggedIn()) {
			if (bindingResult.hasErrors()) {
				return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, "incorrect input");
			}
			if (patientService.findOne(patientDTO.getId()) == null) {
				return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, "not found");
			}
			patientService.updatePatient(patientDTO);
			return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.OK, "patient has been changed");
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, "not logged");
	}

	@RequestMapping(value = { "/patients/{id}" }, method = RequestMethod.GET)
	public GeneralResponseDTO<?> getPatientById(@PathVariable Long id) {
		if (sessionService.isUserLoggedIn()) {
			PatientDTO patientDTO = patientService.findOne(id);
			if (patientDTO != null) {
				return new GeneralResponseDTO<>().buildWithData(patientDTO);
			} else {
				return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, "not found");
			}
		}
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, "not logged");
	}

}
