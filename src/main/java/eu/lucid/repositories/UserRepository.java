package eu.lucid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.lucid.domain.User;
import java.lang.String;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByLogin(String login);
}
