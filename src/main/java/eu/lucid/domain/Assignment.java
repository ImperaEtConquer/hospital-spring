package eu.lucid.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "assignment")
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assignmentId;

	@Enumerated(EnumType.STRING)
	private AssignmentType assignmentType;

	private String information;

	private Date assignedAt;

	private Date finishedAt;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private MedicalRecord medicalRecord;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Staff doctor;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Staff performer;

	public Long getId() {
		return assignmentId;
	}

	public void setId(Long id) {
		this.assignmentId = id;
	}

	public AssignmentType getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(AssignmentType assignmentType) {
		this.assignmentType = assignmentType;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Date getAssignedAt() {
		return assignedAt;
	}

	public void setAssignedAt(Date assignedAt) {
		this.assignedAt = assignedAt;
	}

	public Date getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(Date finishedAt) {
		this.finishedAt = finishedAt;
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

	public Staff getPerformer() {
		return performer;
	}

	public void setPerformer(Staff performer) {
		this.performer = performer;
	}

}
