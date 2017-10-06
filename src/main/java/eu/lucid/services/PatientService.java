package eu.lucid.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.domain.Patient;
import eu.lucid.repositories.PatientRepository;
import eu.lucid.rest.PatientDTO;
import eu.lucid.services.DateService;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DateService dateService;

	public void registerPatient(PatientDTO patientDTO) {
		Patient patient = new Patient.Builder().firstName(patientDTO.getFirstName()).lastName(patientDTO.getLastName())
				.birthDate(dateService.StringToDate(patientDTO.getBirthDate())).build();
		patientRepository.save(patient);
	}

	public List<PatientDTO> findAll() {
		List<PatientDTO> patientsDTO = new ArrayList<>();
		for (Patient patient : patientRepository.findAll()) {
			patientsDTO.add(new PatientDTO(patient));
		}
		return patientsDTO;
	}
}
