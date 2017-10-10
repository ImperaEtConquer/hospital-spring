package eu.lucid.rest;

public class ProfileDTO {
	private Long staffId;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String speciality;

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

	public static class Builder {
		private Long staffId;
		private String firstName;
		private String lastName;
		private String birthDate;
		private String speciality;

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

		public ProfileDTO build() {
			return new ProfileDTO(this);
		}
	}

	private ProfileDTO(Builder builder) {
		this.staffId = builder.staffId;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.birthDate = builder.birthDate;
		this.speciality = builder.speciality;
	}
}
