package eu.lucid.services;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.domain.Staff;
import eu.lucid.domain.User;
import eu.lucid.repositories.StaffRepository;
import eu.lucid.repositories.UserRepository;
import eu.lucid.rest.UserDTO;
import eu.lucid.utils.DateUtils;
import eu.lucid.utils.EncryptUtils;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StaffRepository staffRepository;

	public boolean isLoginSuccessful(UserDTO userDTO) {
		User user = userRepository.findByLogin(userDTO.getLogin());
		if (user == null) {
			return false;
		}
		if (!user.getPassword().equals(EncryptUtils.encryptPassword(userDTO.getPassword()))) {
			return false;
		}
		return true;
	}

	public boolean registerUser(UserDTO userDTO) {
		User user = new User.Builder()
				.login(userDTO.getLogin())
				.password(EncryptUtils.encryptPassword(userDTO.getPassword()))
				.registeredAt(Date.from(Instant.now()))
				.build();
		Staff staff = new Staff.Builder()
				.firstName(userDTO.getFirstName())
				.lastName(userDTO.getLastName())
				.birthDate(DateUtils.StringToDate(userDTO.getBirthDate()))
				.speciality(userDTO.getSpecialityAsEnum())
				.user(user).build();
		if (!isExists(user)) {
			staffRepository.save(staff);
			return true;
		}
		return false;
	}
	
	public UserDTO getUser(UserDTO userDTO) {
		User user = userRepository.findByLogin(userDTO.getLogin());
		return new UserDTO(user);
	}

	private boolean isExists(User user) {
		return (userRepository.findByLogin(user.getLogin()) != null);
	}

}
