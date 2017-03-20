package br.com.ruavarejo.backend.cliente;

import javax.servlet.http.HttpServletRequest;
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
	public Cliente signIn(HttpServletRequest request, @Valid @RequestBody ClienteDTO clienteDTO){
		clienteDTO.setIp(request.getRemoteAddr());
		Cliente cliente = clienteConverter.convert(clienteDTO);
		if (clienteRepository.findByEmail(clienteDTO.getEmail()).isPresent()){
			throw new EmailAlreadyInUseException();
		}
		
		Cliente cli = clienteRepository.save(cliente);
		return cli;
	}

}
