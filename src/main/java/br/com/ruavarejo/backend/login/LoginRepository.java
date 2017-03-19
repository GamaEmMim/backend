package br.com.ruavarejo.backend.login;

import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Login.class, idClass = Long.class)
public interface LoginRepository {
	
	public Optional<Login> findByUsername(String username);

}
