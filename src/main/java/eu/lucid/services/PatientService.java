package eu.lucid.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.domain.Patient;
import eu.lucid.repositories.PatientRepository;
import eu.lucid.rest.PatientDTO;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ConverterService converterService;

	public void registerPatient(PatientDTO patientDTO) {
		Patient patient = converterService.DTOtoPatient(patientDTO);
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
