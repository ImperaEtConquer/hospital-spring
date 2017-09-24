package eu.lucid.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import eu.lucid.dto.UserDTO;
import eu.lucid.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private HttpSession httpSession;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView getHome() {
		return (httpSession.getAttribute("user") != null) ? new ModelAndView("index")
				: new ModelAndView("login", "user", new UserDTO());
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView login(UserDTO user) {
		ModelAndView modelAndView = new ModelAndView();
		if (loginService.isLoginSuccessful(user)) {
			httpSession.setAttribute("user", user);
			modelAndView.setViewName("index");
		} else {
			modelAndView.addObject("user", new UserDTO());
			modelAndView.addObject("error", "error");
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public ModelAndView getRegisterPage() {
		return new ModelAndView("registration", "user", new UserDTO());
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public ModelAndView register(UserDTO user) {
		loginService.registerUser(user);
		httpSession.setAttribute("user", user);
		return new ModelAndView("index");
	}
}
