package br.com.ruavarejo.backend.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Cliente.class, idClass = Long.class)
public interface ClienteRepository {
	
	public Cliente save(Cliente cliente);
	
	public Optional<Cliente> findByEmail(String email);
	
	public List<Cliente> findAll();
}
