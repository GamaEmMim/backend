package br.com.ruavarejo.backend.user;

import org.springframework.core.convert.converter.Converter;

import br.com.ruavarejo.backend.login.Login;

public class UserSignUpDTOToUserConverter implements Converter<UserSignUpDTO, User>{

	@Override
	public User convert(UserSignUpDTO source) {
		Login login = new Login(source.getUsername(), source.getPassword());
		User user = new User(source.getName(), source.getBirthDate(), source.getGender(), login);
		return user;
	}

}
