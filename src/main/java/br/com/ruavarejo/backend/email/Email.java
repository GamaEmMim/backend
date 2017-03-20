package br.com.ruavarejo.backend.email;

public class Email {
	
	private String name;
	private String email;
	
	public Email(String email){
		this.email = email;
	}
	
	public Email(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
