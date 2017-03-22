package br.com.ruavarejo.backend.contato;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.postmark.java.PostmarkClient;
import com.postmark.java.PostmarkException;
import com.postmark.java.PostmarkMessage;

import br.com.ruavarejo.backend.annotation.Post;
import br.com.ruavarejo.backend.email.EmailDelivery;

@RestController
public class ContatoController {
	@Autowired
	private EmailDelivery emailDelivery;
	
	@Post("/contact")
	public boolean contact(@Valid @RequestBody ContatoDTO contatoDTO){
		String message = "";
		
		message += "Nome: " + contatoDTO.getFullName() + "<br/>";
		message += "Empresa: " + contatoDTO.getCompany() + "<br/>";
		message += "Email: " + contatoDTO.getEmail() + "<br/>";
		message += "<br/><br/>Mensagem: " + contatoDTO.getMessage();
		
		PostmarkMessage postmarkRequest = new PostmarkMessage("contato@ruavarejo.com.br", 
																"contato@ruavarejo.com.br", 
																contatoDTO.getEmail(), 
																null, 
																("Contato - " + contatoDTO.getFullName()), 
																message, 
																true, 
																null);

		PostmarkClient client = new PostmarkClient("06d1d511-a055-4548-9615-8d060479d899");

		try {
		       client.sendMessage(postmarkRequest);
		} catch (PostmarkException pe) {
		       System.out.println("An error has occured : " + pe.getMessage());
		}
		
		//emailDelivery.send(message);
		
		return true;
	}

}
