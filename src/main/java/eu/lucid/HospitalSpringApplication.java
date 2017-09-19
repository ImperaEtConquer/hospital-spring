package eu.lucid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eu.lucid.repositories.UserRepository;

@SpringBootApplication
public class HospitalSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalSpringApplication.class, args);

	}
}
