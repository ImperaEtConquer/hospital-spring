package eu.lucid.rest;

import javax.validation.constraints.NotNull;

import eu.lucid.domain.Speciality;
import eu.lucid.domain.Staff;
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

	public StaffDTO() {

	}

	public StaffDTO(Staff staff) {
		this.staffId = staff.getId();
		this.firstName = staff.getFirstName();
		this.lastName = staff.getLastName();
	//	this.birthDate = DateService.DateToString(staff.getBirthDate());
		this.speciality = staff.getSpeciality().toString();
		this.loginDTO.setLogin(staff.getUser().getLogin());
		this.loginDTO.setPassword(staff.getUser().getPassword());
	}

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

	public Speciality specialityAsEnum() {
		return speciality.toUpperCase().equals("DOCTOR") ? Speciality.DOCTOR : Speciality.NURSE;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

}
