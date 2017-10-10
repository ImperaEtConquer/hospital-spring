package eu.lucid.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.lucid.domain.Speciality;
import eu.lucid.rest.StaffDTO;

@Service
public class SessionService {

	@Autowired
	private HttpSession httpSession;

	public HttpSession getSession() {
		return httpSession;
	}

	public StaffDTO getUser() {
		return (StaffDTO) httpSession.getAttribute("user");
	}

	public void addOrUpdateUser(StaffDTO staffDTO) {
		httpSession.setAttribute("user", staffDTO);
	}

	public void destroy() {
		httpSession.invalidate();
	}

	public boolean isUserLoggedIn() {
		return httpSession.getAttribute("user") != null;
	}

	public boolean isUserDoctor() {
		StaffDTO staffDTO = (StaffDTO) httpSession.getAttribute("user");
		return staffDTO.getSpeciality().equals(Speciality.DOCTOR.toString());
	}
}
