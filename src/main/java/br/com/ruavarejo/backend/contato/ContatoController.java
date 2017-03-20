package br.com.ruavarejo.backend.contato;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ruavarejo.backend.annotation.Post;
import br.com.ruavarejo.backend.email.EmailDelivery;

@RestController
public class ContatoController {
	@Autowired
	private EmailDelivery emailDelivery;
	
	@Post("/contact")
	public boolean contact(@Valid @RequestBody ContatoDTO contatoDTO){
		String message = "";
		
		message += "Nome: " + contatoDTO.getName() + contatoDTO.getLastName() + "<br/>";
		message += "Empresa: " + contatoDTO.getCompany() + "<br/>";
		message += "Email: " + contatoDTO.getEmail() + "<br/>";
		message += "<br/><br/>Mensagem: " + contatoDTO.getMessage();
		
		emailDelivery.send(message);
		
		return true;
	}

}
