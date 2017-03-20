package br.com.ruavarejo.backend.contato;

import org.hibernate.validator.constraints.NotBlank;

public class ContatoDTO {
	@NotBlank
	private String name;
	@NotBlank
	private String lastName;
	private String company;
	@NotBlank
	private String email;
	@NotBlank
	private String message;
	
	@Deprecated
	public ContatoDTO(){
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
