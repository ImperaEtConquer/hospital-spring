package eu.lucid.services;

import javax.security.auth.login.LoginException;
import javax.security.auth.message.AuthException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.config.Message;
import eu.lucid.domain.Staff;
import eu.lucid.domain.User;
import eu.lucid.repositories.StaffRepository;
import eu.lucid.repositories.UserRepository;
import eu.lucid.rest.LoginDTO;
import eu.lucid.rest.StaffDTO;

@Service
public class LoginService {

	private final UserRepository userRepository;

	private final StaffRepository staffRepository;

	private final Message message;

	private final ConverterService converterService;

	@Autowired
	public LoginService(UserRepository userRepository, StaffRepository staffRepository, Message message,
			ConverterService converterService) {
		this.userRepository = userRepository;
		this.staffRepository = staffRepository;
		this.message = message;
		this.converterService = converterService;
	}

	public void login(LoginDTO loginDTO) throws LoginException {
		User user = userRepository.findByLogin(loginDTO.getLogin());
		if (user == null) {
			throw new LoginException(message.loginNull);
		}
		if (!user.getPassword().equals(converterService.encryptPassword(loginDTO.getPassword()))) {
			throw new LoginException(message.loginFail);
		}
	}

	public void register(StaffDTO staffDTO) throws AuthException {
		Staff staff = converterService.convertStaffDTOtoStaff(staffDTO);
		if (isExists(staff.getUser())) {
			throw new AuthException(message.registerFail);
		}
		staffRepository.save(staff);
	}

	public StaffDTO getUserByLogin(String login) {
		Staff staff = userRepository.findByLogin(login).getStaff();
		StaffDTO staffDTO = converterService.convertStaffToStaffDTO(staff);
		return staffDTO;
	}

	private boolean isExists(User user) {
		return (userRepository.findByLogin(user.getLogin()) != null);
	}

}
