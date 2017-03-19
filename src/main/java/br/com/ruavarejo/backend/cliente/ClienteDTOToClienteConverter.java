package br.com.ruavarejo.backend.cliente;

import org.springframework.core.convert.converter.Converter;

public class ClienteDTOToClienteConverter implements Converter<ClienteDTO, Cliente>{

	@Override
	public Cliente convert(ClienteDTO source) {
		Cliente cliente = new Cliente(source.getName(), source.getLastName(), 
										source.getEmail(), source.getTipoComercio());
		return cliente;
	}

}
