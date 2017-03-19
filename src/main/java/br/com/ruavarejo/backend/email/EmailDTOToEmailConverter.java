package br.com.ruavarejo.backend.email;

import org.springframework.core.convert.converter.Converter;

import br.com.ruavarejo.backend.annotation.WebComponent;

@WebComponent
public class EmailDTOToEmailConverter implements Converter<EmailDTO, Email>{

	@Override
	public Email convert(EmailDTO source) {
		Email email = new Email(source.getEmail(), source.getEmailOrigin());
		return email;
	}

}
