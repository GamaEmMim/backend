package br.com.ruavarejo.backend.admin;

import static javax.persistence.CascadeType.ALL;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

import br.com.ruavarejo.backend.email.Email;
import br.com.ruavarejo.backend.enums.Gender;
import br.com.ruavarejo.backend.login.Login;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@OneToOne(cascade = ALL)
	@JoinColumn(name = "email_id", referencedColumnName = "id", unique = true, nullable = false)
	private Email email;
	
	@OneToOne(cascade = ALL)
	@JoinColumn(name = "login_id", referencedColumnName = "id", unique = true, nullable = false)
	private Login login;
	
	@Column(name = "created_at", nullable = false)
	private Calendar createdAt;
	
	public Admin(String name, Gender gender, Date birthDate, Email email, Login login) {
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.email = email;
		this.login = login;
		this.createdAt = Calendar.getInstance();
	}

	@Deprecated
	public Admin(){
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}
}
