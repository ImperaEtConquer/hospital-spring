package eu.lucid.dto;

import java.util.Date;
import java.util.GregorianCalendar;

import eu.lucid.domain.Speciality;

public class UserDTO {
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String speciality;

	public UserDTO() {
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

	public Date getBirthDateAsDate() {
		String[] data = birthDate.split("-");
		int year = Integer.valueOf(data[0]);
		int month = Integer.valueOf(data[1]);
		int day = Integer.valueOf(data[2]);
		return new GregorianCalendar(year, month-1, day).getTime();
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
