package br.com.ruavarejo.backend.admin;

import java.util.Date;

import br.com.ruavarejo.backend.enums.Gender;
import br.com.ruavarejo.backend.login.LoginModel;

public class AdminDTO extends LoginModel{
	private String name;
	
	private Gender gender;
	
	private Date birthDate;
	
	private String email;

	public AdminDTO() {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
