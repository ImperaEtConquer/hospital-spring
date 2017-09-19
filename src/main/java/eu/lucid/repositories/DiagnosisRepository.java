package eu.lucid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.lucid.domain.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long>{

}
