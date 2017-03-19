package br.com.ruavarejo.backend.login;

import br.com.ruavarejo.backend.security.PasswordHasher;

public abstract class LoginModel {
	private String username;
	
	private String password;
	
	public LoginModel(){
	}
	
	public LoginModel(String username, String password){
		this.username = username;
		this.password = PasswordHasher.hashPassword(password);
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

	public void setPassword(String password) {
		this.password = password;
	}
}
