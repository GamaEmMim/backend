package br.com.ruavarejo.backend.admin;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Admin.class, idClass = Long.class)
public interface AdminRepository {
	
	public Admin save(Admin admin);

}
