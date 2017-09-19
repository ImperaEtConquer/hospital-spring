package eu.lucid.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private MedicalRecord medicalRecord;

}

enum AssignmentType {
	PROCEDURES, MEDICAMENTS, SURGERY;
}
