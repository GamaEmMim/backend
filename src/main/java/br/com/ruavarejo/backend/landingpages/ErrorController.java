package br.com.ruavarejo.backend.landingpages;

import org.springframework.web.bind.annotation.RestController;

import br.com.ruavarejo.backend.annotation.Request;

@RestController
public class ErrorController {
	@Request("/error")
	public String errorPage(){
		return "Error while running the requested page";
	}
}
