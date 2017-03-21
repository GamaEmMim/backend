package br.com.ruavarejo.backend.pesquisa;

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

import br.com.ruavarejo.backend.cliente.TipoComercio;

@Entity
@Table(name = "pesquisa")
public class Pesquisa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="creation_date", nullable = false)
	private Date creationDate;
	
	@Column(name="ip", nullable = false)
	private String ip;
	
	@NotBlank
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@NotBlank
	@Column(name="last_name", length = 100, nullable = false)
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_comercio", length = 40, nullable = false)
	private TipoComercio tipoComercio;
	
	@NotBlank
	@Column(name="email", length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(name="company", length = 100)
	private String company;
	
	@Column(name="conhece_varejo")
	private boolean conheceVarejo;
	
	@Column(name="grau_importancia")
	private int grauImportancia;
	
	@Column(name="rapidez_informacao")
	private int rapidezInformacao;
	
	@Column(name="giro_estoque")
	private String giroEstoque;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="metodologia_tradicional", length = 40, nullable = false)
	private Confiabilidade metodologia;
	
	@Column(name = "empresas_conhecidas")
	private String empresasConhecidas;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "relacao_varejo")
	private RelacaoVarejo relacaoVarejo;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "possui_interesse")
	private Interesse possuiInteresse;

	public Pesquisa() {
		this.creationDate = new Date();
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
