package eu.lucid.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.lucid.domain.Speciality;
import eu.lucid.rest.StaffDTO;
import eu.lucid.rest.request.LoginDTO;
import eu.lucid.services.LoginService;

@Component
public class SessionUtils {

	@Autowired
	private HttpSession httpSession;

	public HttpSession getSession() {
		return httpSession;
	}

	public StaffDTO getUser() {
		return (StaffDTO) httpSession.getAttribute("user");
	}

	public void addOrUpdateUser(LoginDTO loginDTO, LoginService loginService) {
		httpSession.setAttribute("user", loginService.getUser(loginDTO));
	}

	public void destroy() {
		httpSession.invalidate();
	}

	public boolean isUserLoggedIn() {
		return httpSession.getAttribute("user") != null;
	}

	public boolean isUserDoctor() {
		StaffDTO staffDTO = (StaffDTO) httpSession.getAttribute("user");
		return staffDTO.specialityAsEnum().equals(Speciality.DOCTOR);
	}
}
