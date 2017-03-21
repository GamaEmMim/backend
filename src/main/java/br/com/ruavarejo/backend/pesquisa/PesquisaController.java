package br.com.ruavarejo.backend.pesquisa;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ruavarejo.backend.annotation.Post;

@RestController
public class PesquisaController {
	@Autowired
	private PesquisaDTOToPesquisaConverter pesquisaConverter;
	
	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	@Post("/pesquisa")
	public boolean salvarPesquisa(HttpServletRequest request, @Valid @RequestBody PesquisaDTO pesquisaDTO){
		pesquisaDTO.setIp(request.getRemoteAddr());
		Pesquisa cliente = pesquisaConverter.convert(pesquisaDTO);
		pesquisaRepository.save(cliente);
		return true;
	}
}
