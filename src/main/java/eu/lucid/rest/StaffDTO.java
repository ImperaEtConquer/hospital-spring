package eu.lucid.rest;

import javax.validation.constraints.NotNull;

public class StaffDTO {

	private Long staffId;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String birthDate;

	@NotNull
	private String speciality;

	@NotNull
	private String login;

	@NotNull
	private String password;

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
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

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
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

	public static class Builder {
		private Long staffId;
		private String firstName;
		private String lastName;
		private String birthDate;
		private String speciality;
		private String login;
		private String password;

		public Builder staffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder birthDate(String birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Builder speciality(String speciality) {
			this.speciality = speciality;
			return this;
		}

		public Builder login(String login) {
			this.login = login;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public StaffDTO build() {
			StaffDTO staffDTO = new StaffDTO();
			staffDTO.staffId = staffId;
			staffDTO.firstName = firstName;
			staffDTO.lastName = lastName;
			staffDTO.birthDate = birthDate;
			staffDTO.speciality = speciality;
			staffDTO.login = login;
			staffDTO.password = password;
			return staffDTO;
		}
	}
}
