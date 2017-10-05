package eu.lucid.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Message {

	@Value("${messages.login.successful}")
	public String loginSuccess;

	@Value("${messages.login.null}")
	public String loginNull;

	@Value("${messages.login.fail}")
	public String loginFail;

	@Value("${messages.login.already}")
	public String loginAlready;

	@Value("${messages.logout.fail}")
	public String notLogged;

	@Value("${messages.logout.successful}")
	public String logoutSuccess;

	@Value("${messages.logout.fail}")
	public String logoutFail;

	@Value("${messages.register.fail}")
	public String registerFail;

	@Value("${messages.register.successful}")
	public String registerSuccess;

	@Value("%{message.user.update.successful}")
	public String userUpdateSuccess;

	@Value("%{message.user.delete.successful}")
	public String userDeleteSuccess;

}
