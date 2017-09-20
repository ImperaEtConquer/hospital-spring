package eu.lucid.controllers;

import eu.lucid.domain.Assignment;
import eu.lucid.domain.AssignmentType;
import eu.lucid.domain.MedicalRecord;
import eu.lucid.domain.Patient;
import eu.lucid.domain.Staff;
import eu.lucid.repositories.AssignmentRepository;
import eu.lucid.repositories.DiagnosisRepository;
import eu.lucid.repositories.MedicalRecordRepository;
import eu.lucid.repositories.PatientRepository;
import eu.lucid.repositories.StaffRepository;
import eu.lucid.repositories.UserRepository;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public String test() {
		
		Patient patient = patientRepository.findOne(1L);
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setPatient(patient);
		medicalRecord.setRegisteredAt(Date.from(Instant.now()));
		
		Staff staff = staffRepository.findOne(1L);
		Assignment assignment = new Assignment();
		assignment.setDoctor(staff);
		assignment.setInformation("Aspirin");
		assignment.setAssignmentType(AssignmentType.MEDICAMENTS);
		assignment.setPerformer(staff);
		
		List<Assignment> assignments = new ArrayList<>();
		assignments.add(assignment);
		medicalRecord.setAssignments(assignments);

		medicalRecordRepository.save(medicalRecord);
		return "Done";
	}
}
