package eu.lucid.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicalRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Staff staff;

	private Patient patient;

	private List<Diagnosis> diagnoses;

	private List<Assignment> assignments;

	private LocalDate registeredAt;

}
