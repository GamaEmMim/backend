package br.com.ruavarejo.backend.cliente;

public class ClienteDTO {
	private String name;
	
	private String lastName;
	
	private String email;

	private TipoComercio tipoComercio;

	public ClienteDTO(String name, String lastName, String email, TipoComercio tipoComercio) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.tipoComercio = tipoComercio;
	}
	
	@Deprecated
	public ClienteDTO(){
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
	
	public TipoComercio getTipoComercio(){
		return tipoComercio;
	}
	
	public void setTipoComercio(TipoComercio tipoComercio){
		this.tipoComercio = tipoComercio;
	}
}
