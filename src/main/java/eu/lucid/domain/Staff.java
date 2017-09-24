package eu.lucid.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long staffId;

	private String firstName;

	private String lastName;

	private Date birthDate;

	@Enumerated(EnumType.STRING)
	private Speciality speciality;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<Assignment> assignedAssignments;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<Diagnosis> assignedDiagnosis;

	@OneToMany(mappedBy = "performer", cascade = CascadeType.ALL)
	private List<Assignment> performedAssignments;

	public Staff() {
	}

	public Long getId() {
		return staffId;
	}

	public void setId(Long id) {
		this.staffId = id;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Assignment> getAssignedAssignments() {
		return assignedAssignments;
	}

	public void setAssignedAssignments(List<Assignment> assignedAssignments) {
		this.assignedAssignments = assignedAssignments;
	}

	public List<Diagnosis> getAssignedDiagnosis() {
		return assignedDiagnosis;
	}

	public void setAssignedDiagnosis(List<Diagnosis> assignedDiagnosis) {
		this.assignedDiagnosis = assignedDiagnosis;
	}

	public List<Assignment> getPerformedAssignments() {
		return performedAssignments;
	}

	public void setPerformedAssignments(List<Assignment> performedAssignments) {
		this.performedAssignments = performedAssignments;
	}

	public static class Builder {
		private Long staffId;
		private String firstName;
		private String lastName;
		private Date birthDate;
		private Speciality speciality;
		private User user;
		private List<Assignment> assignedAssignments;
		private List<Diagnosis> assignedDiagnosis;
		private List<Assignment> performedAssignments;

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

		public Builder birthDate(Date birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Builder speciality(Speciality speciality) {
			this.speciality = speciality;
			return this;
		}

		public Builder user(User user) {
			this.user = user;
			return this;
		}

		public Builder assignedAssignments(List<Assignment> assignedAssignments) {
			this.assignedAssignments = assignedAssignments;
			return this;
		}

		public Builder assignedDiagnosis(List<Diagnosis> assignedDiagnosis) {
			this.assignedDiagnosis = assignedDiagnosis;
			return this;
		}

		public Builder performedAssignments(List<Assignment> performedAssignments) {
			this.performedAssignments = performedAssignments;
			return this;
		}

		public Staff build() {
			return new Staff(this);
		}
	}

	private Staff(Builder builder) {
		this.staffId = builder.staffId;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.birthDate = builder.birthDate;
		this.speciality = builder.speciality;
		this.user = builder.user;
		this.assignedAssignments = builder.assignedAssignments;
		this.assignedDiagnosis = builder.assignedDiagnosis;
		this.performedAssignments = builder.performedAssignments;
	}
}
