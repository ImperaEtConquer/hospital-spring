package eu.lucid.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long diagnosisId;

	private String information;

	private Date registeredAt;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private MedicalRecord medicalRecord;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Staff doctor;

	public Long getId() {
		return diagnosisId;
	}

	public void setId(Long id) {
		this.diagnosisId = id;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Staff getDoctor() {
		return doctor;
	}

	public void setDoctor(Staff doctor) {
		this.doctor = doctor;
	}

}
