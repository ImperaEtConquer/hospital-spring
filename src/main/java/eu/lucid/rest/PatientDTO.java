package eu.lucid.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import eu.lucid.domain.MedicalRecord;
import eu.lucid.domain.Patient;

public class PatientDTO {

	private Long id;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String birthDate;

	private List<MedicalRecord> medicalRecords;

	public PatientDTO() {
	}

	public PatientDTO(Patient patient) {
		this.id = patient.getId();
		this.firstName = patient.getFirstName();
		this.lastName = patient.getLastName();
		//this.birthDate = DateService.DateToString(patient.getBirthDate());
		this.medicalRecords = patient.getMedicalRecords();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

}
