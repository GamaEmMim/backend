package br.com.ruavarejo.backend.domains;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ruavarejo.backend.annotation.WebComponent;

@WebComponent
public class DomainService {
	
	@Autowired
	private DomainRepository domainRepository;
	
	public boolean isFreeEmailService(String email){
		int atPos = email.lastIndexOf("@") + 1;
		String domain = email.substring(atPos);
		return domainRepository.findByDomain(domain).isPresent();
	}
}
