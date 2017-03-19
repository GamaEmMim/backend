package br.com.ruavarejo.backend.admin;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ruavarejo.backend.annotation.WebComponent;
import br.com.ruavarejo.backend.email.EmailRepository;
import br.com.ruavarejo.backend.exceptions.EmailAlreadyInUseException;
import br.com.ruavarejo.backend.exceptions.UsernameAlreadyInUseException;
import br.com.ruavarejo.backend.login.LoginRepository;

@WebComponent
public class AdminService {
	@Autowired
	private EmailRepository emailRepository;
	@Autowired
	private LoginRepository loginRepository;
	
	public boolean isUserAvailable(AdminDTO adminDTO){
		if (emailRepository.findByEmail(adminDTO.getEmail()).isPresent()){
			throw new EmailAlreadyInUseException();
		}
		if (loginRepository.findByUsername(adminDTO.getUsername()).isPresent()){
			throw new UsernameAlreadyInUseException();
		}
		return true;
	}
}
