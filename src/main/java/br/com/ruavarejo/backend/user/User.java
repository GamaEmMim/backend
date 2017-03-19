package br.com.ruavarejo.backend.user;

import static javax.persistence.CascadeType.ALL;

import java.util.Calendar;

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

import br.com.ruavarejo.backend.enums.Gender;
import br.com.ruavarejo.backend.login.Login;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "birth_date", nullable = false)
	private Calendar birthDate;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "gender", nullable = false)
	private Gender gender;
	
	@OneToOne(cascade = ALL)
	@JoinColumn(name = "login_id", referencedColumnName = "id", nullable = false)
	private Login login;
	
	@Column(name = "created_at", nullable = false)
	private Calendar createdAt;
	
	public User(String name, Calendar birthDate, Gender gender, Login login) {
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.login = login;
		this.createdAt = Calendar.getInstance();
	}

	@Deprecated
	public User(){
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

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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
