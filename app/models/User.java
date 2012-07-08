package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = { "login"})})
public class User extends Model {
	private static final long serialVersionUID = -2800123837694720908L;

	@Id
	private Long id;
	
	@Required
	@NotNull
	private String login;
	
	@Required
	@NotNull
	private String passwordHash;
	
	@Column
	private String firstName;
	
	@Column
	private String secondName;
	
	@Column
	private String lastName;
	
	@Column
	private Integer icq;
	
	@Column
	private String jabber;
	
	@Email
	private String email;
	
	@ManyToOne
	private File photo;
	
	@Required
	@NotNull
	private Role role;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getIcq() {
		return icq;
	}

	public void setIcq(Integer icq) {
		this.icq = icq;
	}

	public String getJabber() {
		return jabber;
	}

	public void setJabber(String jabber) {
		this.jabber = jabber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}
}
