package eu.lucid.rest.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class LoginDTO {

	@Email
	@NotNull
	@Size(min = 5, max = 30)
	private String login;

	@NotNull
	@Size(min = 6, max = 30)
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
