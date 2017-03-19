package br.com.ruavarejo.backend.admin;

import org.springframework.core.convert.converter.Converter;

import br.com.ruavarejo.backend.annotation.WebComponent;
import br.com.ruavarejo.backend.email.Email;
import br.com.ruavarejo.backend.email.EmailOrigin;
import br.com.ruavarejo.backend.login.Login;
import br.com.ruavarejo.backend.login.LoginType;

@WebComponent
public class AdminDTOToAdminConverter implements Converter<AdminDTO, Admin>{
	@Override
	public Admin convert(AdminDTO source) {
		Login login = new Login(source.getName(), source.getPassword(), LoginType.ADMINISTRATOR);
		Email email = new Email(source.getEmail(), EmailOrigin.ADMINISTRATOR);
		Admin admin = new Admin(source.getName(), source.getGender(), source.getBirthDate(), email, login);
		return admin;
	}
}
