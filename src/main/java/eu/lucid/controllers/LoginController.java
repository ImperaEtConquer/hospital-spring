package eu.lucid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import eu.lucid.dto.CredentialsDTO;
import eu.lucid.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView getHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView login(@RequestBody CredentialsDTO credentialsDTO) {
		ModelAndView modelAndView = new ModelAndView();
		String login = credentialsDTO.getLogin();
		String password = credentialsDTO.getPassword();
		if (loginService.isLoginSuccessful(login, password)) {
			modelAndView.setViewName("index");
		}
		else {
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public ModelAndView getRegisterPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
}
