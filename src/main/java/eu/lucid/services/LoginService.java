package eu.lucid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.domain.User;
import eu.lucid.repositories.StaffRepository;
import eu.lucid.repositories.UserRepository;

@Service
public class LoginService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private UserRepository userRepository;

	public boolean isLoginSuccessful(String login, String password) {
		User user = userRepository.findByLogin(login);
		if (user == null) {
			return false;
		}
		if (!user.getPassword().equals(password)) {
			return false;
		}
		return true;
	}
}
