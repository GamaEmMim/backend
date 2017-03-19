package br.com.ruavarejo.backend.email;

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
@Table(name = "email")
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "email", length = 90, unique = true, nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 20, nullable = false)
	private Status emailStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "origin", length = 20, nullable = false)
	private EmailOrigin emailOrigin;
	
	@Deprecated
	public Email(){
	}
	
	public Email(String email, EmailOrigin emailOrigin) {
		this.email = email;
		this.emailStatus = Status.ACTIVE;
		this.emailOrigin = emailOrigin;
	}
	
	public Email(String email, Status emailStatus, EmailOrigin emailOrigin) {
		this.email = email;
		this.emailStatus = emailStatus;
		this.emailOrigin = emailOrigin;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Status getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(Status emailStatus) {
		this.emailStatus = emailStatus;
	}

	public EmailOrigin getEmailOrigin() {
		return emailOrigin;
	}

	public void setEmailOrigin(EmailOrigin emailOrigin) {
		this.emailOrigin = emailOrigin;
	}
}
