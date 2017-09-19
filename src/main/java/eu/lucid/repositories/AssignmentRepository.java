package eu.lucid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.lucid.domain.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}
