package br.com.ruavarejo.backend.cliente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="creation_date", nullable = false)
	private Date creationDate;

	@NotBlank
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@NotBlank
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@NotBlank
	@Column(name="email", length = 100, nullable = false, unique = true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_comercio", length = 40, nullable = false)
	private TipoComercio tipoComercio;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_cliente", length = 40, nullable = false)
	private TipoCliente tipoCliente;

	public Cliente(String name, String lastName, String email, TipoComercio tipoComercio) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.tipoComercio = tipoComercio;
		this.creationDate = new Date();
		this.defineTipoCliente();
	}
	
	@Deprecated
	public Cliente(){
	}
	
	public TipoCliente defineTipoCliente(){
		TipoCliente result;
		if (getTipoComercio().equals(TipoComercio.OUTROS)){
			result = TipoCliente.LEAD_INVALIDO;
		}else{
			result = TipoCliente.LEAD_INVALIDO;
		}
		return result;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoComercio getTipoComercio() {
		return tipoComercio;
	}

	public void setTipoComercio(TipoComercio tipoComercio) {
		this.tipoComercio = tipoComercio;
	}
	
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setClienteType(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
}
