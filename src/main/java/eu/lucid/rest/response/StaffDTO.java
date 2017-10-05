package eu.lucid.rest.response;

import javax.validation.constraints.NotNull;

import eu.lucid.rest.request.LoginDTO;

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
	private LoginDTO loginDTO;

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

}
