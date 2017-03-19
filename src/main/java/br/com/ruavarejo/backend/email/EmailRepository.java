package br.com.ruavarejo.backend.email;

import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Email.class, idClass = Long.class)
public interface EmailRepository {
	
	Optional<Email> findByEmail(String email);

}
