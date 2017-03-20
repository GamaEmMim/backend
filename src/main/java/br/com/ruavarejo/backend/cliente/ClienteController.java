package br.com.ruavarejo.backend.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ruavarejo.backend.annotation.Post;
import br.com.ruavarejo.backend.exceptions.EmailAlreadyInUseException;
import br.com.ruavarejo.backend.security.UserInfo;

@RestController
public class ClienteController {
	@Autowired
	private ClienteDTOToClienteConverter clienteConverter;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private UserInfo userInfo;
	
	@Post("/cliente")
	public Cliente signIn(@Valid @RequestBody ClienteDTO clienteDTO){
		clienteDTO.setIp(userInfo.getIpAddress());
		Cliente cliente = clienteConverter.convert(clienteDTO);
		if (clienteRepository.findByEmail(clienteDTO.getEmail()).isPresent()){
			throw new EmailAlreadyInUseException();
		}
		
		Cliente cli = clienteRepository.save(cliente);
		return cli;
	}

}
