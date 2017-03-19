package br.com.ruavarejo.backend.landingpages;

import org.springframework.web.bind.annotation.RestController;

import br.com.ruavarejo.backend.annotation.Get;

@RestController
public class HomeController {
	@Get("/")
	public String mainPage(){
		return "welcome!";
	}
}
