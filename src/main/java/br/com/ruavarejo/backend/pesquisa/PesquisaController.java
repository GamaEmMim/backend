package br.com.ruavarejo.backend.pesquisa;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ruavarejo.backend.annotation.Post;
import br.com.ruavarejo.backend.cliente.Cliente;
import br.com.ruavarejo.backend.cliente.ClienteRepository;

@RestController
public class PesquisaController {
	@Autowired
	private PesquisaDTOToPesquisaConverter pesquisaConverter;
	
	@Autowired
	private PesquisaDTOToClienteConverter clienteConverter;
	
	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Post("/pesquisa")
	public boolean salvarPesquisa(HttpServletRequest request, @Valid @RequestBody PesquisaDTO pesquisaDTO){
		pesquisaDTO.setIp(request.getRemoteAddr());
		Pesquisa pesquisa = pesquisaConverter.convert(pesquisaDTO);
		pesquisaRepository.save(pesquisa);
		
		Cliente cliente = clienteConverter.convert(pesquisaDTO);
		
		try{
			clienteRepository.save(cliente);
		}catch(Exception e){
		}
		
		return true;
	}
}
