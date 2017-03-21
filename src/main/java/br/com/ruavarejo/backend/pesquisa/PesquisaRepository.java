package br.com.ruavarejo.backend.pesquisa;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Pesquisa.class, idClass = Long.class)
public interface PesquisaRepository {
	public Pesquisa save(Pesquisa cliente);
}
