package eu.lucid.config;

import org.springframework.beans.factory.annotation.Value;

public class Message {

	@Value("${messages.login.successful}")
	public String loginSuccess;

	@Value("${messages.login.null}")
	public String loginNull;

	@Value("${messages.login.fail}")
	public String loginFail;

	@Value("${messages.login.already}")
	public String loginAlready;

}
