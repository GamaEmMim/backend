package br.com.ruavarejo.backend.pesquisa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import br.com.ruavarejo.backend.annotation.WebComponent;
import br.com.ruavarejo.backend.cliente.Cliente;
import br.com.ruavarejo.backend.cliente.TipoCliente;
import br.com.ruavarejo.backend.domains.DomainService;

@WebComponent
public class PesquisaDTOToClienteConverter implements Converter<PesquisaDTO, Cliente>{

	@Autowired
	private DomainService domainService;
	
	@Override
	public Cliente convert(PesquisaDTO source) {
		Cliente cliente = new Cliente(source.getName(), 
										source.getLastName(), 
										source.getEmail(), 
										source.getCompany(), 
										source.getTipoComercio(), 
										source.getIp());
		if (domainService.isFreeEmailService(source.getEmail())){
			cliente.setTipoCliente(TipoCliente.B2C);
		}else{
			cliente.setTipoCliente(TipoCliente.B2B);
		}
		
		return cliente;
	}

}
