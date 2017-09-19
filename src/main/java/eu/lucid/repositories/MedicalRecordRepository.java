package eu.lucid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.lucid.domain.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long>{

}
