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

	private final PatientRepository patientRepository;

	private final ConverterService converterService;

	@Autowired
	public PatientService(PatientRepository patientRepository, ConverterService converterService) {
		super();
		this.patientRepository = patientRepository;
		this.converterService = converterService;
	}

	public PatientDTO findOne(Long id) {
		Patient patient = patientRepository.findOne(id);
		return converterService.convertPatientToPatientDTO(patient);
	}

	public void registerPatient(PatientDTO patientDTO) {
		Patient patient = converterService.convertPatientDTOtoPatient(patientDTO);
		patientRepository.save(patient);
	}

	public List<PatientDTO> findAll() {
		List<PatientDTO> patientsDTOlist = new ArrayList<>();
		for (Patient patient : patientRepository.findAll()) {
			PatientDTO patientDTO = converterService.convertPatientToPatientDTO(patient);
			patientsDTOlist.add(patientDTO);
		}
		return patientsDTOlist;
	}
}
