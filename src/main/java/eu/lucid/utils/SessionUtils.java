package eu.lucid.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionUtils {

	@Autowired
	private HttpSession httpSession;

	public HttpSession getSession() {
		return httpSession;
	}

	public boolean isUserLoggedIn() {
		return httpSession.getAttribute("user") != null;
	}
}
