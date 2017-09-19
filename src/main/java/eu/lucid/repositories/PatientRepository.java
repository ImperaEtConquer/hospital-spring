package eu.lucid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.lucid.domain.Patient;
import java.lang.Long;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
}
