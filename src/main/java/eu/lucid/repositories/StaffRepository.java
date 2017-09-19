package eu.lucid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.lucid.domain.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{

}
