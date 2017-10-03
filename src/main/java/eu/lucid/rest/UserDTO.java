package eu.lucid.rest;

import javax.validation.constraints.NotNull;
import eu.lucid.domain.Speciality;
import eu.lucid.domain.User;
import eu.lucid.utils.DateUtils;

public class UserDTO {

	private Long id;

	@NotNull
	private String login;

	@NotNull
	private String password;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String birthDate;

	@NotNull
	private String speciality;

	public UserDTO(User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.firstName = user.getStaff().getFirstName();
		this.lastName = user.getStaff().getLastName();
		this.birthDate = DateUtils.DateToString(user.getStaff().getBirthDate());
		this.speciality = user.getStaff().getSpeciality().toString();
	}

	public UserDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getSpeciality() {
		return speciality;
	}

	public Speciality getSpecialityAsEnum() {
		return speciality.equals("DOCTOR") ? Speciality.DOCTOR : Speciality.NURSE;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "UserDTO [login=" + login + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthDate=" + birthDate + ", speciality=" + speciality + "]";
	}

}
