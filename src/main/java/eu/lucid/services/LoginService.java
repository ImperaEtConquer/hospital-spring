package eu.lucid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.domain.User;
import eu.lucid.dto.UserDTO;
import eu.lucid.repositories.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

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
		User user = new User.Builder().login(credentials.getLogin()).password(credentials.getPassword()).build();
		if (!isExists(user)) {
			userRepository.save(user);
			return true;
		}
		return false;
	}

	private boolean isExists(User user) {
		return (userRepository.findByLogin(user.getLogin()) != null);
	}

}
