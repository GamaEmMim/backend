package br.com.ruavarejo.backend.user;

import java.util.Calendar;

import br.com.ruavarejo.backend.enums.Gender;
import br.com.ruavarejo.backend.login.Login;
import br.com.ruavarejo.backend.login.LoginModel;

public class UserSignUpDTO extends LoginModel{
	
	private String name;
	
	private Calendar birthDate;
	
	private Gender gender;
	
	private Login login;

	public UserSignUpDTO(String username, String password, String name, Calendar birthDate,
						Gender gender, Login login) {
		super(username, password);
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.login = login;
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
	
}
