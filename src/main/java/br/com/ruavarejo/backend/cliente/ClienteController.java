package br.com.ruavarejo.backend.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ruavarejo.backend.annotation.Post;
import br.com.ruavarejo.backend.exceptions.EmailAlreadyInUseException;

@RestController
public class ClienteController {
	@Autowired
	private ClienteDTOToClienteConverter clienteConverter;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Post("/cliente")
	public boolean signIn(@Valid @RequestBody ClienteDTO clienteDTO){
		Cliente cliente = clienteConverter.convert(clienteDTO);
		if (clienteRepository.findByEmail(clienteDTO.getEmail()).isPresent()){
			throw new EmailAlreadyInUseException();
		}
		try{
			clienteRepository.save(cliente);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
