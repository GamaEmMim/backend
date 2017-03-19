package br.com.ruavarejo.backend.login;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.ruavarejo.backend.enums.Status;

@Entity
@Table(name = "login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "username", length = 20, unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", length = 100, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "login_type", length = 20, nullable = false)
	private LoginType loginType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "login_status", length = 20, nullable = false)
	private Status loginStatus;
	
	@Column(name = "created_at", nullable = false)
	private Calendar createdAt;
	
	@Deprecated
	public Login(){
	}
	
	public Login(String username, String password){
		this.username = username;
		this.password = password;
		this.loginType = LoginType.USER;
		this.loginStatus = Status.ACTIVE;
		this.createdAt = Calendar.getInstance();
	}
	
	public Login(String username, String password, LoginType loginType) {
		this.username = username;
		this.password = password;
		this.loginType = loginType;
		this.loginStatus = Status.ACTIVE;
		this.createdAt = Calendar.getInstance();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passsword) {
		this.password = passsword;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public Status getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Status loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}
}
