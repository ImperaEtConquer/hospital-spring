package eu.lucid.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import eu.lucid.domain.User;
import eu.lucid.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private HttpSession httpSession;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView getHome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		return new ModelAndView("login", "user", new User());
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView login(User user) {
		ModelAndView modelAndView = new ModelAndView();
		if (loginService.isLoginSuccessful(user)) {
			httpSession.setAttribute("user", user);
			modelAndView.setViewName("index");
		} else {
			modelAndView.addObject("user", new User());
			modelAndView.addObject("error", "error");
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public ModelAndView getRegisterPage() {
		return new ModelAndView("registration", "user", new User());
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public ModelAndView register(User user) {
		loginService.registerUser(user);
		return new ModelAndView("index");
	}
}
