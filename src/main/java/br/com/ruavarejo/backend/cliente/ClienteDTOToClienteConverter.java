package br.com.ruavarejo.backend.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import br.com.ruavarejo.backend.annotation.WebComponent;
import br.com.ruavarejo.backend.domains.DomainService;

@WebComponent
public class ClienteDTOToClienteConverter implements Converter<ClienteDTO, Cliente>{
	
	@Autowired
	private DomainService domainService;

	@Override
	public Cliente convert(ClienteDTO source) {
		Cliente cliente = new Cliente(source.getName(), source.getLastName(), 
										source.getEmail(), source.getTipoComercio());
		/*if (source.getTipoComercio() == TipoComercio.OUTROS){
			cliente.setTipoCliente(TipoCliente.LEAD_INVALIDO);
			return cliente;
		}*/
		if (domainService.isFreeEmailService(source.getEmail())){
			cliente.setTipoCliente(TipoCliente.B2C);
		}else{
			cliente.setTipoCliente(TipoCliente.B2B);
		}
		return cliente;
	}

}
