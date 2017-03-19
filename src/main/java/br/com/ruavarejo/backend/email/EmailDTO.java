package br.com.ruavarejo.backend.email;

import org.hibernate.validator.constraints.Email;

public class EmailDTO {
	@Email
	private String email;
	
	private EmailOrigin emailOrigin;

	public EmailDTO(String email, EmailOrigin emailOrigin) {
		this.email = email;
		this.emailOrigin = emailOrigin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmailOrigin getEmailOrigin() {
		return emailOrigin;
	}

	public void setEmailOrigin(EmailOrigin emailOrigin) {
		this.emailOrigin = emailOrigin;
	}
}
