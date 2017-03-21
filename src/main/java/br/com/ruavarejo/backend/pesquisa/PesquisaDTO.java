package br.com.ruavarejo.backend.pesquisa;

import br.com.ruavarejo.backend.cliente.TipoComercio;

public class PesquisaDTO {
	private String ip;
	
	private String name;
	
	private String lastName;
	
	private TipoComercio tipoComercio;
	
	private String email;
	
	private String company;
	
	private boolean conheceVarejo;
	
	private int grauImportancia;
	
	private int rapidezInformacao;
	
	private String giroEstoque;
	
	private Confiabilidade metodologia;
	
	private String empresasConhecidas;
	
	private RelacaoVarejo relacaoVarejo;
	
	private Interesse possuiInteresse;

	public PesquisaDTO() {
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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

	public TipoComercio getTipoComercio() {
		return tipoComercio;
	}

	public void setTipoComercio(TipoComercio tipoComercio) {
		this.tipoComercio = tipoComercio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean isConheceVarejo() {
		return conheceVarejo;
	}

	public void setConheceVarejo(boolean conheceVarejo) {
		this.conheceVarejo = conheceVarejo;
	}

	public int getGrauImportancia() {
		return grauImportancia;
	}

	public void setGrauImportancia(int grauImportancia) {
		this.grauImportancia = grauImportancia;
	}

	public int getRapidezInformacao() {
		return rapidezInformacao;
	}

	public void setRapidezInformacao(int rapidezInformacao) {
		this.rapidezInformacao = rapidezInformacao;
	}

	public String getGiroEstoque() {
		return giroEstoque;
	}

	public void setGiroEstoque(String giroEstoque) {
		this.giroEstoque = giroEstoque;
	}

	public Confiabilidade getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(Confiabilidade metodologia) {
		this.metodologia = metodologia;
	}

	public String getEmpresasConhecidas() {
		return empresasConhecidas;
	}

	public void setEmpresasConhecidas(String empresasConhecidas) {
		this.empresasConhecidas = empresasConhecidas;
	}

	public RelacaoVarejo getRelacaoVarejo() {
		return relacaoVarejo;
	}

	public void setRelacaoVarejo(RelacaoVarejo relacaoVarejo) {
		this.relacaoVarejo = relacaoVarejo;
	}

	public Interesse getPossuiInteresse() {
		return possuiInteresse;
	}

	public void setPossuiInteresse(Interesse possuiInteresse) {
		this.possuiInteresse = possuiInteresse;
	}
}
