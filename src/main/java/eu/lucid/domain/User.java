package eu.lucid.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	private String login;

	private String password;

	private Date registeredAt;

	@OneToOne(mappedBy = "user")
	private Staff staff;

	public User() {
	}

	public Long getId() {
		return userId;
	}

	public void setId(Long id) {
		this.userId = id;
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

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public static class Builder {
		private Long userId;
		private String login;
		private String password;
		private Date registeredAt;
		private Staff staff;

		public Builder userId(Long userId) {
			this.userId = userId;
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

		public Builder registeredAt(Date registeredAt) {
			this.registeredAt = registeredAt;
			return this;
		}

		public Builder staff(Staff staff) {
			this.staff = staff;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	private User(Builder builder) {
		this.userId = builder.userId;
		this.login = builder.login;
		this.password = builder.password;
		this.registeredAt = builder.registeredAt;
		this.staff = builder.staff;
	}
}
