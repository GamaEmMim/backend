package br.com.ruavarejo.backend.cliente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ruavarejo.backend.annotation.Get;
import br.com.ruavarejo.backend.annotation.Post;
import br.com.ruavarejo.backend.exceptions.EmailAlreadyInUseException;
import br.com.ruavarejo.backend.exceptions.IncorrectPasswordException;

@RestController
public class ClienteController {
	@Autowired
	private ClienteDTOToClienteConverter clienteConverter;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Post("/cliente")
	public boolean signIn(HttpServletRequest request, @Valid @RequestBody ClienteDTO clienteDTO){
		clienteDTO.setIp(request.getRemoteAddr());
		Cliente cliente = clienteConverter.convert(clienteDTO);
		if (clienteRepository.findByEmail(clienteDTO.getEmail()).isPresent()){
			throw new EmailAlreadyInUseException();
		}
		clienteRepository.save(cliente);
		return true;
	}
	
	@Get("/cliente/{password}")
	public List<Cliente> findAllCustomers(@PathVariable String password){
		if (!password.equals("09c63ba3efce13d2f9b586c2075db138")){
			throw new IncorrectPasswordException();
		}
		return clienteRepository.findAll();
	}

}
