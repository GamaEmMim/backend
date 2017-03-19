package br.com.ruavarejo.backend.domains;

import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Domain.class, idClass = Long.class)
public interface DomainRepository {
	
	public Optional<Domain> findByDomain(String domain);

}
