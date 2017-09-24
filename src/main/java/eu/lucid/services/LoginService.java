package eu.lucid.services;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.domain.Staff;
import eu.lucid.domain.User;
import eu.lucid.dto.UserDTO;
import eu.lucid.repositories.StaffRepository;
import eu.lucid.repositories.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StaffRepository staffRepository;

	public boolean isLoginSuccessful(UserDTO credentials) {
		User user = userRepository.findByLogin(credentials.getLogin());
		if (user == null) {
			return false;
		}
		if (!user.getPassword().equals(credentials.getPassword())) {
			return false;
		}
		return true;
	}

	public boolean registerUser(UserDTO credentials) {
		User user = new User.Builder()
				.login(credentials.getLogin())
				.password(credentials.getPassword())
				.registeredAt(Date.from(Instant.now()))
				.build();
		Staff staff = new Staff.Builder()
				.firstName(credentials.getFirstName())
				.lastName(credentials.getLastName())
				.birthDate(credentials.getBirthDateAsDate())
				.speciality(credentials.getSpecialityAsEnum())
				.user(user)
				.build();
		if (!isExists(user)) {
			staffRepository.save(staff);
			return true;
		}
		return false;
	}

	private boolean isExists(User user) {
		return (userRepository.findByLogin(user.getLogin()) != null);
	}

}
