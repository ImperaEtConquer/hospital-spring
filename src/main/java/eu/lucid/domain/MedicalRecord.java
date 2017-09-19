package eu.lucid.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "medical_record")
public class MedicalRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "medical_record_id")
	private Long medicalRecordId;

	private Date registeredAt;

	private Date finishedAt;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Patient patient;

	@OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
	private List<Diagnosis> diagnoses;

	@OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
	private List<Assignment> assignments;

	public Long getId() {
		return medicalRecordId;
	}

	public void setId(Long id) {
		this.medicalRecordId = id;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Date getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(Date finishedAt) {
		this.finishedAt = finishedAt;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Diagnosis> getDiagnoses() {
		return diagnoses;
	}

	public void setDiagnoses(List<Diagnosis> diagnoses) {
		this.diagnoses = diagnoses;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

}
