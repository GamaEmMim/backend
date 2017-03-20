package br.com.ruavarejo.backend.email;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import br.com.ruavarejo.backend.annotation.WebComponent;

@WebComponent
public class EmailDelivery {
	public void send(String message){
		Client client = ClientBuilder.newClient();
		
		client.register(HttpAuthenticationFeature.basic("pubkey-593e5402ef59bf7d649798c0ca33e59a", 
														"key-91e5dfbee8a066054334867abd430a15"));
		
		WebTarget mgRoot = client.target("https://api.mailgun.net/v3");

        Form reqData = new Form();
        reqData.param("from", "RuaVarejo <contato@auto.ruavarejo.com.br>");
        reqData.param("to", "contato@auto.ruavarejo.com.br");
        reqData.param("subject", "Contato");
        reqData.param("text", message);

        mgRoot
            .path("/auto.ruavarejo.com.br/messages")
            .resolveTemplate("domain", "auto.ruavarejo.com.br")
            .request(MediaType.APPLICATION_FORM_URLENCODED)
            .buildPost(Entity.entity(reqData, MediaType.APPLICATION_FORM_URLENCODED))
            .invoke(ClientResponse.class);
	}
	
}
