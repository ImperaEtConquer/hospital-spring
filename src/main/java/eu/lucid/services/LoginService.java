package eu.lucid.services;

import java.time.Instant;
import java.util.Date;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.config.Message;
import eu.lucid.domain.Staff;
import eu.lucid.domain.User;
import eu.lucid.repositories.StaffRepository;
import eu.lucid.repositories.UserRepository;
import eu.lucid.rest.PatientDTO;
import eu.lucid.rest.request.LoginDTO;
import eu.lucid.rest.response.StaffDTO;
import eu.lucid.utils.DateUtils;
import eu.lucid.utils.EncryptUtils;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private Message message;

	public void login(LoginDTO loginDTO) throws LoginException {
		User user = userRepository.findByLogin(loginDTO.getLogin());
		if (user == null) {
			throw new LoginException(message.loginNull);
		}
		if (!user.getPassword().equals(EncryptUtils.encryptPassword(loginDTO.getPassword()))) {
			throw new LoginException(message.loginFail);
		}
	}

	public String register(StaffDTO staffDTO) {
		return null;
	}

	private boolean isExists(User user) {
		return (userRepository.findByLogin(user.getLogin()) != null);
	}

}
