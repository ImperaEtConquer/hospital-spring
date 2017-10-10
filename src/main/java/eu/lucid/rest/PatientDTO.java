package eu.lucid.rest;

import javax.validation.constraints.NotNull;

public class PatientDTO {

	private Long id;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String birthDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public static class Builder {
		private Long id;
		private String firstName;
		private String lastName;
		private String birthDate;

		public Builder id(Long id) {
			this.id = id;
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

		public PatientDTO build() {
			return new PatientDTO(this);
		}
	}

	private PatientDTO(Builder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.birthDate = builder.birthDate;
	}
}
