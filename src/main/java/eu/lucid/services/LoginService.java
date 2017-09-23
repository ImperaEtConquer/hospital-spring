package eu.lucid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.domain.User;
import eu.lucid.repositories.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	public boolean isLoginSuccessful(User user) {
		User userFromDB = userRepository.findByLogin(user.getLogin());
		if (userFromDB == null) {
			return false;
		}
		if (!userFromDB.getPassword().equals(user.getPassword())) {
			return false;
		}
		return true;
	}
	
	public void registerUser(User user) {
		userRepository.save(user);
	}
}
