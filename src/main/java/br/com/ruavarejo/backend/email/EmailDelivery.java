package br.com.ruavarejo.backend.email;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.ruavarejo.backend.annotation.WebComponent;

@WebComponent
public class EmailDelivery {
	public void send(MessageDTO messageDTO){
		EmailDTO emailDTO = new EmailDTO();
		
		emailDTO.setFrom("automail@ruavarejo.com.br");
		emailDTO.setTo("contato@ruavarejo.com.br");
		emailDTO.setSubject(messageDTO.getName() + messageDTO.getLastName() + "-Formulário de Contato");
		emailDTO.setReplyTo(messageDTO.getEmail());
		String message = "";
		message += "Olá! Segue os dados do formulário de contato<br/>";
		message += "Empresa: " + messageDTO.getCompany() + "<br/>";
		message += "Nome: " + messageDTO.getName() + " " + messageDTO.getLastName() + "<br/>";
		message += "E-mail de contato: " + messageDTO.getEmail() + "<br/>";
		message += "Mensagem: " + messageDTO.getMessage();
		emailDTO.setHtmlBody(message);
		
		Gson gson = new GsonBuilder().create();
		String jsonBody = gson.toJson(emailDTO);
	}
}
