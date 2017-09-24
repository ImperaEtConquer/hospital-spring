package eu.lucid.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patientId;

	private String firstName;

	private String lastName;

	private Date birthDate;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<MedicalRecord> medicalRecords;
	
	public Patient() {
	}

	public Long getId() {
		return patientId;
	}

	public void setId(Long id) {
		this.patientId = id;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public static class Builder {
		private Long patientId;
		private String firstName;
		private String lastName;
		private Date birthDate;
		private List<MedicalRecord> medicalRecords;

		public Builder patientId(Long patientId) {
			this.patientId = patientId;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder birthDate(Date birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Builder medicalRecords(List<MedicalRecord> medicalRecords) {
			this.medicalRecords = medicalRecords;
			return this;
		}

		public Patient build() {
			return new Patient(this);
		}
	}

	private Patient(Builder builder) {
		this.patientId = builder.patientId;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.birthDate = builder.birthDate;
		this.medicalRecords = builder.medicalRecords;
	}
}
